import 'dart:async';
import 'dart:io';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/LoadData.dart';
import 'package:path_provider/path_provider.dart';
import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

class AppDB {
  static final AppDB _instance = new AppDB._internal();
  factory AppDB() => _instance;
  static Database _db;
  LoadDataForm loadData;
  static AppInfo info = new AppInfo();

  Future<Database> get db async {
    if (_db != null) {
      return _db;
    }
    _db = await initDb();
    return _db;
  }

  AppDB._internal();

  Future<Database> initDb() async {
    Directory documentDirectory = await getApplicationDocumentsDirectory();
    String path = join(documentDirectory.path, "controle.db");
    var myDb = await openDatabase(path, version: 1, onCreate: _onCreate);
    print(myDb.toString() + "\n");

    return myDb;
  }

  void stateStatus() async {
    while (AppDB.info.ready == false) {}
  }

  void _onCreate(Database db, int version) async {
    await db.execute('''CREATE TABLE info_principais (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            senha integer DEFAULT null,
            nome_user VARCHAR(40),
            dia_recebe INTEGER,
            banco double precision,
            meta double precision,
            gasto_diario double precision,
            ganho double precision,
            first BIT)''');
    await db.execute('''CREATE TABLE item_fixo (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nome VARCHAR(30),
            valor double precision,
            id_info INTEGER,
            FOREIGN KEY (id_info) REFERENCES info_principais (id))''');
    await db.execute('''CREATE TABLE ano (
            ano INTEGER PRIMARY KEY,
            id_info INTEGER,
            FOREIGN KEY (id_info) REFERENCES info_principais(id))''');
    await db.execute('''CREATE TABLE mes (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            mes INTEGER,
            ano INTEGER,
            FOREIGN KEY (ano) REFERENCES ano (ano))''');
    await db.execute('''CREATE TABLE mes_atual_info (
            id_info INTEGER,
            id_mes INTEGER,
            recebido_pagamento BOOLEAN,
            FOREIGN KEY (id_info) REFERENCES info_principais (id),
            FOREIGN KEY (id_mes) REFERENCES mes (id))''');
    await db.execute('''CREATE TABLE dia (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            dia INTEGER,
            mes_id INTEGER,
            FOREIGN KEY (mes_id) REFERENCES mes (id))''');
    await db.execute('''CREATE TABLE item (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            valor double precision,
            nome VARCHAR(30),
            dia_id INTEGER,
            FOREIGN KEY (dia_id) REFERENCES dia (id))''');

    var quant = await db.rawQuery("SELECT * FROM info_principais");
    if (quant.length == 0) {
      int res = await db.rawInsert(
          "INSERT INTO info_principais (senha, nome_user, banco, meta, gasto_diario, ganho, dia_recebe, first) VALUES (null, 'Seu Nome', 0.0, 0.0, 0.0, 0.0, 1, ?)", [1]);
      info.senha = null;
      info.nomeUser = 'Seu Nome';
      info.banco = 0.0;
      info.meta = 0.0;
      info.gastoDiario = 0.0;
      info.dia_recebe = 1;
      info.ganho = 0.0;
      info.ID = res;
      info.first = 1;
    }
    print("Tables created!");
  }

  void setup(LoadDataForm loadData) async {
    this.loadData = loadData;
    var dbClient = await db;
    var idinfo;
    //Adiciona as Informações principais.
    var info = await dbClient.rawQuery("SELECT * FROM info_principais");
    for (var item in info) {
      AppDB.info.senha = item['senha'];
      AppDB.info.nomeUser = item['nome_user'];
      AppDB.info.banco = item['banco'];
      AppDB.info.meta = item['meta'];
      AppDB.info.gastoDiario = item['gasto_diario'];
      AppDB.info.dia_recebe = item['dia_recebe'];
      AppDB.info.ganho = item['ganho'];
      AppDB.info.ID = item['id'];
      AppDB.info.first = item['first'];
      idinfo = item['id'];
    }
    //Adiciona os Anos
    var anosList = await dbClient.rawQuery("SELECT * FROM ano");
    var checkNovoAno = await dbClient
        .rawQuery("SELECT ano FROM ano WHERE ano=?", [DateTime.now().year]);
    var mes_atualdb = await dbClient.rawQuery("SELECT * FROM mes_atual_info");
    if (anosList.length == 0) {
      //Novo Ano
      //Ano
      await addAno(new DateTime.now().year, idinfo);
      print("OK");
      AppDB.info.getAnos().add(new Ano(new DateTime.now().year));
      print("OK");
      //Mês
      for (int i = 0;
          i <
              AppDB.info
                  .getAnos()
                  .elementAt(AppDB.info.getAnos().length - 1)
                  .getMeses()
                  .length;
          i++) {
        int idMes = await addMes(
            AppDB.info
                .getAnos()
                .elementAt(AppDB.info.getAnos().length - 1)
                .getMeses()
                .elementAt(i)
                .ano,
            AppDB.info
                .getAnos()
                .elementAt(AppDB.info.getAnos().length - 1)
                .getMeses()
                .elementAt(i)
                .mes);
        AppDB.info
            .getAnos()
            .elementAt(AppDB.info.getAnos().length - 1)
            .getMeses()
            .elementAt(i)
            .ID = idMes;
        //Dia
        for (int j = 0;
            j <
                AppDB.info
                    .getAnos()
                    .elementAt(AppDB.info.getAnos().length - 1)
                    .getMeses()
                    .elementAt(i)
                    .getDias()
                    .length;
            j++) {
          int idDia = await addDia(
              idMes,
              AppDB.info
                  .getAnos()
                  .elementAt(AppDB.info.getAnos().length - 1)
                  .getMeses()
                  .elementAt(i)
                  .getDias()
                  .elementAt(j)
                  .dia);
          AppDB.info
              .getAnos()
              .elementAt(AppDB.info.getAnos().length - 1)
              .getMeses()
              .elementAt(i)
              .getDias()
              .elementAt(j)
              .ID = idDia;
        }
      }
      print("Novo ano adicionado com sucesso!");
    } else {
      //Ano já existe
      //Add ano
      for (var item in anosList) {
        AppDB.info.getAnos().add(new Ano(item['ano']));
      }
      //Add Meses
      for (int i = 0; i < AppDB.info.getAnos().length; i++) {
        var mesesList = await dbClient.rawQuery("SELECT * FROM mes WHERE ano=?",
            [AppDB.info.getAnos().elementAt(i).getAno()]);
        for (var mesL in mesesList) {
          AppDB.info
              .getAnos()
              .elementAt(i)
              .getMeses()
              .elementAt(mesL['mes'] - 1)
              .ID = mesL['id'];
          AppDB.info
              .getAnos()
              .elementAt(i)
              .getMeses()
              .elementAt(mesL['mes'] - 1)
              .ano = mesL['ano'];
          var diasList = await dbClient
              .rawQuery("SELECT * FROM dia WHERE mes_id=?", [mesL['id']]);
          //Add Dias
          for (var diaL in diasList) {
            AppDB.info
                .getAnos()
                .elementAt(i)
                .getMeses()
                .elementAt(mesL['mes'] - 1)
                .getDias()
                .elementAt(diaL['dia'] - 1)
                .ID = diaL['id'];
            var itensList = await dbClient
                .rawQuery("SELECT * FROM item WHERE dia_id=?", [diaL['id']]);
            //Add Itens
            for (var itemL in itensList) {
              print(itemL['id']);
              AppDB.info
                  .getAnos()
                  .elementAt(i)
                  .getMeses()
                  .elementAt(mesL['mes'] - 1)
                  .getDias()
                  .elementAt(diaL['dia'] - 1)
                  .addItem(itemL['id'], itemL['nome'], itemL['valor']);
            }
          }
        }
      }
      if (checkNovoAno.length == 0) {
        await addAno(new DateTime.now().year, idinfo);
        AppDB.info.getAnos().add(new Ano(new DateTime.now().year));
        //Mês
        for (int i = 0;
            i <
                AppDB.info
                    .getAnos()
                    .elementAt(AppDB.info.getAnos().length - 1)
                    .getMeses()
                    .length;
            i++) {
          int idMes = await addMes(
              AppDB.info
                  .getAnos()
                  .elementAt(AppDB.info.getAnos().length - 1)
                  .getMeses()
                  .elementAt(i)
                  .ano,
              AppDB.info
                  .getAnos()
                  .elementAt(AppDB.info.getAnos().length - 1)
                  .getMeses()
                  .elementAt(i)
                  .mes);
          AppDB.info
              .getAnos()
              .elementAt(AppDB.info.getAnos().length - 1)
              .getMeses()
              .elementAt(i)
              .ID = idMes;
          //Dia
          for (int j = 0;
              j <
                  AppDB.info
                      .getAnos()
                      .elementAt(AppDB.info.getAnos().length - 1)
                      .getMeses()
                      .elementAt(i)
                      .getDias()
                      .length;
              j++) {
            int idDia = await addDia(
                idMes,
                AppDB.info
                    .getAnos()
                    .elementAt(AppDB.info.getAnos().length - 1)
                    .getMeses()
                    .elementAt(i)
                    .getDias()
                    .elementAt(j)
                    .dia);
            AppDB.info
                .getAnos()
                .elementAt(AppDB.info.getAnos().length - 1)
                .getMeses()
                .elementAt(i)
                .getDias()
                .elementAt(j)
                .ID = idDia;
          }
        }
      }
    }
    //Add Itens Fixos
    var itensFixosList = await dbClient.rawQuery("SELECT * FROM item_fixo");
    for (var item in itensFixosList) {
      AppDB.info.itensFixos
          .add(new ItemFixo(item['id'], item['nome'], item['valor']));
    }

    if (mes_atualdb.length == 0) {
      await dbClient.rawInsert(
          "INSERT INTO mes_atual_info (id_info, id_mes, recebido_pagamento) VALUES (?, ?, ?)",
          [
            AppDB.info.ID,
            AppDB.info.anos.last.getIDMes(DateTime.now().month),
            false
          ]);
      print("Mes atual add");
    }
    mes_atualdb = await dbClient.rawQuery("SELECT * FROM mes_atual_info");
    for (var itemMes in mes_atualdb) {
      int recebido = itemMes['recebido_pagamento'];
      int idm = itemMes['id_mes'];

      if (recebido == 0) {
        if (DateTime.now().day >= AppDB.info.dia_recebe) {
          AppDB.info.banco += AppDB.info.ganho;
          await dbClient.rawUpdate(
              "UPDATE mes_atual_info SET recebido_pagamento = ? WHERE id_mes = ?",
              [true, AppDB.info.anos.last.getIDMes(DateTime.now().month)]);
          await dbClient.rawUpdate(
              "UPDATE info_principais SET banco = ?", [AppDB.info.banco]);
          print("Added.");
        }
      }
      if (idm != AppDB.info.anos.last.getIDMes(DateTime.now().month)) {
        if (DateTime.now().day >= AppDB.info.dia_recebe) {
          AppDB.info.banco += AppDB.info.ganho;
          await dbClient.rawUpdate(
              "UPDATE mes_atual_info SET recebido_pagamento = ?, id_mes = ?",
              [true, AppDB.info.anos.last.getIDMes(DateTime.now().month)]);
          await dbClient.rawUpdate(
              "UPDATE info_principais SET banco = ?", [AppDB.info.banco]);
          print("Added.");
        } else {
          await dbClient.rawUpdate(
              "UPDATE mes_atual_info SET recebido_pagamento = ?, id_mes = ?",
              [false, AppDB.info.anos.last.getIDMes(DateTime.now().month)]);
        }
      }
    }
    AppDB.info.ready = true;
    loadData.terminado();
  }

  AppInfo getInfo() {
    return info;
  }

  Future<int> addAno(int ano, int id_info) async {
    var dbClient = await db;

    try {
      int res = await dbClient.rawInsert(
          "INSERT INTO ano (ano, id_info) VALUES (?, ?)", [ano, id_info]);
      print("Ano added $res" +
          (dbClient.rawQuery("SELECT * FROM ano")).toString());
      return res;
    } catch (e) {
      int res = await addAno(ano, id_info);
      return res;
    }
  }

  Future<int> addMes(int ano, int mes) async {
    var dbClient = await db;
    int res = await dbClient
        .rawInsert("INSERT INTO mes (mes, ano) VALUES (?, ?)", [mes, ano]);
    return res;
  }

  Future<int> addDia(int mesID, int dia) async {
    var dbClient = await db;
    int res = await dbClient
        .rawInsert("INSERT INTO dia (mes_id, dia) VALUES (?, ?)", [mesID, dia]);
    return res;
  }

  Future<int> notFirst (double saldo, int dia, String nome) async {
    var dbClient = await db;
    int res = await dbClient.rawUpdate("UPDATE info_principais SET first = ?, banco = ?, dia_recebe = ?, nome_user = ?", [0, saldo, dia, nome]);
    if (DateTime.now().day >= dia) {
      await dbClient.rawUpdate("UPDATE mes_atual_info SET recebido_pagamento = ?", [true]);
    }
    AppDB.info.banco = saldo;
    AppDB.info.dia_recebe = dia;
    AppDB.info.nomeUser = nome;
    return res;
  }

  Future<int> addItem(int diaID, double valor, String nome, Item item) async {
    var dbClient = await db;
    int res = await dbClient.rawInsert(
        "INSERT INTO item (dia_id, valor, nome) VALUES (?, ?, ?)",
        [diaID, valor, nome]);
    item.ID = res;
    await dbClient.rawUpdate("UPDATE info_principais SET banco = ?", [AppDB.info.banco]);
    return res;
  }

  Future<int> addDinheiro () async {
    var dbClient = await db;
    int res = await dbClient.rawUpdate("UPDATE info_principais SET banco = ?", [AppDB.info.banco]);
    return res;
  }

  Future<int> addItemFixo(
      String nome, double valor, ItemFixo itemFixo, int id_info) async {
    var dbClient = await db;
    int res = await dbClient.rawInsert(
        "INSERT INTO item_fixo (nome, valor, id_info) VALUES (?, ?, ?)",
        [nome, valor, id_info]);
    itemFixo.ID = res;
    return res;
  }

  Future<int> removeItemFixo(int itemID) async {
    var dbClient = await db;
    int res =
        await dbClient.rawDelete("DELETE FROM item_fixo WHERE id=?", [itemID]);
    print(itemID.toString() + " " + res.toString());
    return res;
  }

  Future<int> editItemFixo (int itemID, String nome, double valor) async {
    var dbClient = await db;
    int res = await dbClient.rawUpdate("UPDATE item_fixo SET nome = ?, valor = ? WHERE id = ?", [nome, valor, itemID]);
    return res;
  }

  Future<int> removeItem(int itemID) async {
    var dbClient = await db;
    int res = await dbClient.rawDelete("DELETE FROM item WHERE id=?", [itemID]);
    await dbClient.rawUpdate("UPDATE info_principais SET banco = ?", [AppDB.info.banco]);
    return res;
  }

  Future<int> editInfo(int id, String nome, int senha, double ganho,
      double meta, double gasto, int dia_recebe) async {
    var dbClient = await db;
    int res = await dbClient.rawUpdate(
        "UPDATE info_principais SET nome_user = ?, senha = ?, ganho = ?, meta = ?, gasto_diario = ?, dia_recebe = ? WHERE id = ?",
        [nome, senha, ganho, meta, gasto, dia_recebe, id]);
    return res;
  }

  Future<List<Map<String, dynamic>>> getAnos() async {
    var dbClient = await db;
    var res = await dbClient.rawQuery("SELECT * FROM ano");

    return res;
  }

  Future closeDB() async {
    var dbClient = await db;
    dbClient.close();
  }
}
