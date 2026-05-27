import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/ConfigPage.dart';
import 'package:controlefinanceiro/Home.dart';
import 'package:controlefinanceiro/ItemFixoPage.dart';
import 'package:controlefinanceiro/ItemFixoView.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';
import 'package:controlefinanceiro/AnosView.dart';
import 'package:controlefinanceiro/DiasView.dart';
import 'package:controlefinanceiro/HojeView.dart';
import 'package:controlefinanceiro/MesesView.dart';
import 'package:controlefinanceiro/NewPage.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';

class HomePage extends StatefulWidget {
  AppDB db;
  HomePage(AppDB db) {
    this.db = db;
  }

  @override
  _HomePageState createState() => new _HomePageState(db);
}

class _HomePageState extends State<HomePage>
    with SingleTickerProviderStateMixin {
  AppInfo general;
  AppDB db;

  _HomePageState(AppDB db) {
    this.db = db;
    this.general = db.getInfo();
  }

  var controlerCurrency =
      new MoneyMaskedTextController(); // Formata um campo de texto para do tipo dinheiro.
  var dataDia = new DateTime.now();

  void AddInfo() {
    if (general.getAnos().length == 0) {
      general.getAnos().add(new Ano(dataDia.year));
    }
  }

  TabController _tabControler; // Cria o controlador de abas

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    _tabControler = new TabController(length: 4, vsync: this, initialIndex: 0);
  }

  double quantoGasta() {
    double quant = 0.0;
    if (general.meta == 0.0) {
      quant = 0.0;
    }
    else {
      quant = general.gastoDiario -
          general
              .getAnos()
              .elementAt(
              general.getAnos().length - 1)
              .getMeses()
              .elementAt(dataDia.month - 1)
              .getDias()
              .elementAt(dataDia.day - 1)
              .getDiaValores();
    }

    return quant;
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.refresh),
            onPressed: () {
              setState(() {

              });
            },
          ),
          IconButton(
            icon: Icon(Icons.add_to_home_screen),
            onPressed: () {
              setState(() {
                Navigator.of(context).push(new MaterialPageRoute(
                    builder: (context) => new Home()));
              });
            },
          )
        ],
        leading: new IconButton(
            icon: new Icon(Icons.settings),
            highlightColor: Colors.white,
            splashColor: Colors.white,
            color: Colors.white,
            disabledColor: Colors.white,
            onPressed: () {
              setState(() {
                Navigator.of(context).push(new MaterialPageRoute(
                    builder: (context) => new ConfigPage(general, db)));
              });
            }),
        title: new Text("Controle Financeiro"),
      ),
      body: new Container(
        padding:
            new EdgeInsets.only(top: 6.0, left: 4.0, right: 4.0, bottom: 6.0),
        decoration: new BoxDecoration(color: BackgroundColor),
        child: new ListView(
          children: <Widget>[
            new Column(
              children: <Widget>[
                new Card(
                    //Adição rápida
                    child: new Padding(
                  padding: new EdgeInsets.only(left: 7.0),
                  child: new Row(
                    children: <Widget>[
                      new Text("R\$", style: TextStyle(fontSize: 18.0)),
                      new Padding(padding: new EdgeInsets.only(right: 2.0)),
                      new Flexible(
                          child: new TextField(
                              keyboardType: TextInputType.number,
                              controller: controlerCurrency,
                              decoration: new InputDecoration(
                                  border: InputBorder.none))),
                      new Column(
                        crossAxisAlignment: CrossAxisAlignment.end,
                        mainAxisSize: MainAxisSize.min,
                        children: <Widget>[
                          IconButton(
                              icon: new Icon(Icons.add),
                              highlightColor: Colors.black,
                              splashColor: Colors.black,
                              color: Colors.black,
                              disabledColor: Colors.black,
                              onPressed: () {
                                setState(() {
                                  try {
                                    if (controlerCurrency.text != "0,00" &&
                                        controlerCurrency.numberValue <=
                                            general.banco) {
                                      general
                                          .getAnos()
                                          .elementAt(
                                              general.getAnos().length - 1)
                                          .getMeses()
                                          .elementAt(dataDia.month - 1)
                                          .getDias()
                                          .elementAt(dataDia.day - 1)
                                          .getItens()
                                          .add(new Item(
                                              null,
                                              "Adicionado Rápido",
                                              controlerCurrency.numberValue));
                                      general.banco -=
                                          controlerCurrency.numberValue;
                                      db.addItem(
                                          general
                                              .getAnos()
                                              .elementAt(
                                                  general.getAnos().length - 1)
                                              .getMeses()
                                              .elementAt(dataDia.month - 1)
                                              .getDias()
                                              .elementAt(dataDia.day - 1)
                                              .ID,
                                          controlerCurrency.numberValue,
                                          "Adicionado Rápido",
                                          general
                                              .getAnos()
                                              .elementAt(
                                                  general.getAnos().length - 1)
                                              .getMeses()
                                              .elementAt(dataDia.month - 1)
                                              .getDias()
                                              .elementAt(dataDia.day - 1)
                                              .getItens()
                                              .last);

                                      controlerCurrency.text = '0,00';
                                    } else {
                                      showDialog(
                                          context: context,
                                          child: new AlertDialog(
                                            title: new Text("Alerta!"),
                                            content: new Column(
                                              crossAxisAlignment:
                                                  CrossAxisAlignment.start,
                                              mainAxisSize: MainAxisSize.min,
                                              children: <Widget>[
                                                new Text(
                                                    "Você não está informando um valor válido."),
                                              ],
                                            ),
                                            actions: <Widget>[
                                              new Row(
                                                children: <Widget>[
                                                  new FlatButton(
                                                      onPressed: () {
                                                        setState(() {
                                                          Navigator
                                                              .pop(context);
                                                        });
                                                      },
                                                      child: new Text("Ok")),
                                                ],
                                              ),
                                            ],
                                          ));
                                    }
                                  } catch (e) {
                                    print("Não foi possível adicionar");
                                  }

                                  //
                                  //item.valor += controlerCurrency.numberValue;

                                  //db.addInfo(new Info(senha: null, nomeUser: null, banco: 55.62, meta: 1000.0, gastoDiario: 20.39));
                                  //db.addDefautInfo();
                                });
                              })
                        ],
                      ),
                    ],
                  ),
                )),
                new Card(
                    //Informações básicas
                    child: new Container(
                  padding: new EdgeInsets.only(
                      top: 4.0, left: 6.0, bottom: 4.0, right: 6.0),
                  child: new Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    mainAxisSize: MainAxisSize.min,
                    children: <Widget>[
                      Text(this.general.nomeUser,
                          style: const TextStyle(
                              fontSize: 18.0,
                              height: 1.0,
                              fontWeight: FontWeight.bold),
                          textAlign: TextAlign.right),
                      Text('Seu Saldo: R\$' + general.banco.toStringAsFixed(2),
                          style: const TextStyle(fontSize: 18.0, height: 1.0)),
                      Text(
                          'Meta de Economia: R\$' +
                              general.meta.toStringAsFixed(2),
                          style: const TextStyle(fontSize: 18.0, height: 1.0)),
                      Text(
                          'Você pode gastar por dia: R\$' +
                              (quantoGasta().toStringAsFixed(2)),
                          style: const TextStyle(fontSize: 18.0, height: 1.0)),
                    ],
                  ),
                )),
                new Card(
                    //Itens Fixos
                    child: new Container(
                  padding: new EdgeInsets.only(top: 4.0),
                  child: new Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    mainAxisSize: MainAxisSize.min,
                    children: <Widget>[
                      Padding(
                          padding: EdgeInsets.only(left: 5.0),
                          child: Text(
                            "Itens Fixos",
                            style: const TextStyle(
                                fontSize: 14.5,
                                height: 1.0,
                                fontWeight: FontWeight.bold),
                          )),
                      Container(
                        height: 170.0,
                        child: ItemFixoView(
                            db,
                            general.itensFixos,
                            general
                                .getAnos()
                                .elementAt(general.getAnos().length - 1)
                                .getMeses()
                                .elementAt(dataDia.month - 1)
                                .getDias()
                                .elementAt(dataDia.day - 1)),
                      )
                    ],
                  ),
                )),
                new Card(
                    //Lista de dias-meses-anos
                    child: new Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  mainAxisSize: MainAxisSize.min,
                  children: <Widget>[
                    new TabBar(
                      controller: _tabControler,
                      indicatorColor: Colors.black,
                      labelColor: Colors.black,
                      tabs: <Widget>[
                        new Tab(
                            text: dataDia.day.toString().padLeft(2, '0') +
                                "/" +
                                dataDia.month.toString().padLeft(2, '0') +
                                "/" +
                                dataDia.year.toString()),
                        new Tab(text: "Dias"),
                        new Tab(text: "Mêses"),
                        new Tab(text: "Anos"),
                      ],
                    ),
                    new Container(
                      height: 360.0,
                      child: new TabBarView(
                        controller: _tabControler,
                        children: <Widget>[
                          new HojeView(
                              general
                                  .getAnos()
                                  .elementAt(general.getAnos().length - 1)
                                  .getMeses()
                                  .elementAt(dataDia.month - 1)
                                  .getDias()
                                  .elementAt(dataDia.day - 1)
                                  .getItens(),
                              db),
                          new DiasView(
                              general
                                  .getAnos()
                                  .elementAt(general.getAnos().length - 1)
                                  .getMeses()
                                  .elementAt(dataDia.month - 1)
                                  .getDias(),
                              dataDia.day, db),
                          new MesesView(
                              general
                                  .getAnos()
                                  .elementAt(general.getAnos().length - 1)
                                  .getMeses(),
                              dataDia.month, db),
                          new AnosView(general.getAnos(), db),
                        ],
                      ),
                    )
                  ],
                )),
              ],
            ),
          ],
        ),
      ),

      floatingActionButton: new FloatingActionButton(
        onPressed: () {
          Navigator.of(context).push(new MaterialPageRoute(
              builder: (context) => new NewPage(
                  db,
                  general
                      .getAnos()
                      .elementAt(general.getAnos().length - 1)
                      .getMeses()
                      .elementAt(dataDia.month - 1)
                      .getDias()
                      .elementAt(dataDia.day - 1),
                  general.itensFixos)));
          //Navigator.push(context, new MaterialPageRoute(builder: (context) => new NewPage()));
        },
        tooltip: 'Increment',
        child: new Icon(Icons.add),
        backgroundColor: PrimaryColor,
      ), // This trailing comma mak
    );
  }
}
