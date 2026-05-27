import 'package:controlefinanceiro/AppDB.dart';

class ItemFixo {
  int ID;
  String nome;
  bool pago = false;
  double valor;

  ItemFixo (int ID, String nome, double valor) {
    this.ID = ID;
    this.nome = nome;
    this.valor = valor;
  }

  void pagarItem () {
    this.pago = true;
  }
}

class Item {
  int ID;
  String nome;
  double valor;

  Item (int ID, String nome, double valor) {
    this.ID = ID;
    this.nome = nome;
    this.valor = valor;
  }


  String getNome () {
    return this.nome;
  }

  double getValor () {
    return this.valor;
  }

}

class Dia {
  int ID, dia;
  List<Item> itens = new List<Item>();

  Dia (int ID, int dia) {
    this.ID = ID;
    this.dia = dia;
  }

  void addItem(int ID, String nome, double valor) {
    itens.add(new Item(ID, nome, valor));
  }

  double removeItem (int id) {
    double valor;
    for (int i = 0; i < itens.length; i++) {
      if (this.itens.elementAt(i).ID == ID) {
        valor = this.itens.elementAt(i).valor;
        this.itens.removeAt(i);
        return valor;
      }
      else {
        return null;
      }
    }
    return null;
  }

  int getDia () {
    return this.dia;
  }

  double getDiaValores() {
    double valor = 0.0;
    for (int i = 0; i < itens.length; i ++) {
      valor += itens[i].valor;
    }
    return valor;
  }

  List<Item> getItens () {
    return this.itens;
  }

}

class Mes {
  int ID, mes, ano;
  bool anoBis = false, concluiu_mes = false;
  List<Dia> dias;

  Mes (int ID, int ano, int mes, bool anoBis) {
    this.ID = ID;
    this.mes = mes;
    this.ano = ano;
    this.anoBis = anoBis;

    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
      dias = new List<Dia>(31);
      for (int i = 0; i < 31; i++) {
        dias[i] = new Dia(null, i + 1);
      }
    }
    else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
      dias = new List<Dia>(30);
      for (int i = 0; i < 30; i++) {
        dias[i] = new Dia(null, i + 1);
      }
    }
    else {
      if (anoBis == true) {
        dias = new List<Dia>(29);
        for (int i = 0; i < 29; i++) {
          dias[i] = new Dia(null, i + 1);
        }
      }
      else {
        dias = new List<Dia>(28);
        for (int i = 0; i < 28; i++) {
          dias[i] = new Dia(null, i + 1);
        }
      }
    }
  }

  String getMesNome () {
    if (this.mes == 1) {
      return "Janeiro";
    }
    else if (this.mes == 2) {
      return "Fevereiro";
    }
    else if (this.mes == 3) {
      return "Março";
    }
    else if (this.mes == 4) {
      return "Abril";
    }
    else if (this.mes == 5) {
      return "Maio";
    }
    else if (this.mes == 6) {
      return "Junho";
    }
    else if (this.mes == 7) {
      return "Julho";
    }
    else if (this.mes == 8) {
      return "Agosto";
    }
    else if (this.mes == 9) {
      return "Setembro";
    }
    else if (this.mes == 10) {
      return "Outubro";
    }
    else if (this.mes == 11) {
      return "Novembro";
    }
    else if (this.mes == 12) {
      return "Dezembro";
    }
    return "";
  }

  int getMes () {
    return this.mes;
  }

  List<Dia> getDias() {
    return this.dias;
  }
}

class Ano {
  int ano;
  List<Mes> meses = new List<Mes>(12);

  Ano (int ano) {
    this.ano = ano;
    if ((this.ano % 4 == 0 && this.ano % 100 != 0) || this.ano % 400 == 0) {
      for (int i = 0; i < 12; i++) {
        meses[i] = new Mes(null, ano, i + 1, true);
      }
    }
    else {
      for (int i = 0; i < 12; i++) {
        meses[i] = new Mes(null, ano, i + 1, false);
      }
    }
  }

  int getAno () {
    return this.ano;
  }

  int getIDMes (int mesNum) {
    for (int i = 0; i < meses.length; i++) {
      if (meses[i].mes == mesNum) {
        return meses[i].ID;
      }
    }
    return null;
  }

  void setAno (int ano) {
    this.ano = ano;
  }

  List<Mes> getMeses () {
    return this.meses;
  }

  void setMeses (List meses) {
    this.meses = meses;
  }
}

class AppInfo {
  int ID, senha, dia_recebe, first;
  String nomeUser;
  double banco, meta, gastoDiario, ganho;
  bool ready = false;
  List<Ano> anos = new List<Ano>();
  List<ItemFixo> itensFixos = List<ItemFixo>();

  List<Ano> getAnos () {
    return this.anos;
  }

  int getID () {
    return this.ID;
  }

  void setID (int id) {
    this.ID = id;
  }

  int getSenha () {
    return this.senha;
  }

  void setSenha (int senha) {
    this.senha = senha;
  }

  String getNomeUser () {
    return this.nomeUser;
  }

  void setNomeUser (String nome) {
    this.nomeUser = nome;
  }

  double getBanco () {
    return this.banco;
  }

  void setBanco (double valor) {
    this.banco = valor;
  }

  double getMeta () {
    return this.meta;
  }

  void setMeta (double valor) {
    this.banco = valor;
  }

  List<ItemFixo> getItensFixos () {
    return this.itensFixos;
  }

  void addItemFixo (int ID, String nome, double valor) {
    this.itensFixos.add(new ItemFixo(ID, nome, valor));
  }

  double getGastoDiario () {
    return this.gastoDiario;
  }

  void setGastoDiario (double valor) {
    this.gastoDiario = valor;
  }

  Ano getAnoAtual () {
    if (anos.length == 0) {
      return null;
    }
    else {
      return this.anos.elementAt(anos.length -1);
    }
  }
}