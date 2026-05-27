import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';

class ConfigPage extends StatefulWidget {
  AppInfo info;
  AppDB db;

  ConfigPage (AppInfo info, AppDB db) {
    this.info = info;
    this.db = db;
  }

  _ConfigPage createState() => _ConfigPage(info, db);
}

class _ConfigPage extends State<ConfigPage> {
  AppInfo info;
  AppDB db;

  var nomeControler = new TextEditingController();
  var senhaControler = new TextEditingController();
  var diaPagamentoControler = new TextEditingController();
  var ganhoControler = new MoneyMaskedTextController();
  var metaControler = new MoneyMaskedTextController();

  _ConfigPage (AppInfo info, AppDB db) {
    this.info = info;
    this.db = db;

    this.nomeControler.text = info.nomeUser;
    if (info.senha != null) {
      senhaControler.text = info.senha.toString();
    }
    this.ganhoControler.updateValue(info.ganho);
    this.metaControler.updateValue(info.meta);
    this.diaPagamentoControler.text = info.dia_recebe.toString();
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
        appBar: new AppBar(
          leading: new IconButton(
              icon: Icon(Icons.arrow_back),
              onPressed: () {
                Navigator.pop(context);
              }),
          title: new Text("Configurações"),
        ),
        body: new Container(
            decoration: new BoxDecoration(color: BackgroundColor),
            child: ListView(
              children: <Widget>[
                Padding(
                    padding: new EdgeInsets.only(top: 8.0, left: 6.0, right: 6.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      mainAxisSize: MainAxisSize.max,
                      children: <Widget>[
                        Card(
                          child: Padding(
                              padding: EdgeInsets.all(10.0),
                              child: Column(
                                children: <Widget>[
                                  TextField(
                                    decoration: new InputDecoration(
                                        fillColor: Colors.white,
                                        filled: true,
                                        labelText: "Nome",
                                        border: new OutlineInputBorder(
                                          borderRadius: new BorderRadius.circular(13.0),
                                        )
                                    ),
                                    controller: nomeControler,
                                    maxLength: 40,
                                  ),
                                  Padding(padding: new EdgeInsets.only(top: 4.0)),
                                  TextField(
                                    decoration: new InputDecoration(
                                        fillColor: Colors.white,
                                        filled: true,
                                        labelText: "Senha",
                                        border: new OutlineInputBorder(
                                          borderRadius: new BorderRadius.circular(13.0),
                                        )
                                    ),
                                    keyboardType: TextInputType.number,
                                    maxLength: 4,
                                    controller: senhaControler,
                                  ),
                                  Padding(padding: new EdgeInsets.only(top: 4.0)),
                                  TextField (
                                    decoration: new InputDecoration(
                                        fillColor: Colors.white,
                                        filled: true,
                                        labelText: "Ganho Mensal",
                                        border: new OutlineInputBorder(
                                          borderRadius: new BorderRadius.circular(13.0),
                                        )
                                    ),
                                    keyboardType: TextInputType.number,
                                    controller: ganhoControler,
                                  ),
                                  Padding(padding: new EdgeInsets.only(top: 4.0)),
                                  TextField (
                                    decoration: new InputDecoration(
                                        fillColor: Colors.white,
                                        filled: true,
                                        labelText: "Meta de Economia",
                                        border: new OutlineInputBorder(
                                          borderRadius: new BorderRadius.circular(13.0),
                                        )
                                    ),
                                    keyboardType: TextInputType.number,
                                    controller: metaControler,
                                  ),
                                  Padding(padding: new EdgeInsets.only(top: 4.0)),
                                  TextField (
                                    decoration: new InputDecoration(
                                        fillColor: Colors.white,
                                        filled: true,
                                        labelText: "Dia do Pagamento",
                                        border: new OutlineInputBorder(
                                          borderRadius: new BorderRadius.circular(13.0),
                                        )
                                    ),
                                    keyboardType: TextInputType.number,
                                    maxLength: 2,
                                    controller: diaPagamentoControler,
                                  ),
                                  Padding(
                                    padding: EdgeInsets.only(top: 25.0),
                                    child: Row (
                                        crossAxisAlignment: CrossAxisAlignment.end,
                                        mainAxisSize: MainAxisSize.max,
                                        children: <Widget>[
                                          Flexible(
                                            child: Row(
                                              mainAxisSize: MainAxisSize.max,
                                            ),
                                          ),
                                          RaisedButton(
                                            color: PrimaryColor,
                                            child: Row(
                                              children: <Widget>[
                                                Icon(Icons.save, color: Colors.white),
                                                Padding(padding: EdgeInsets.only(left: 6.0)),
                                                Text("Salvar", style: TextStyle(color: Colors.white, fontSize: 20.0))
                                              ],
                                            ),
                                            shape: BeveledRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(6.0))),
                                            padding: EdgeInsets.only(left: 30.0, right: 30.0, top: 10.0, bottom: 10.0),
                                              onPressed: () {
                                                setState(() {
                                                  if (senhaControler.text.length > 0 && senhaControler.text.length != 4) {
                                                    showDialog(
                                                        context: context,
                                                        child: new AlertDialog(
                                                          title: new Text("Alerta!"),
                                                          content: new Column(
                                                            crossAxisAlignment: CrossAxisAlignment.start,
                                                            mainAxisSize: MainAxisSize.min,
                                                            children: <Widget>[
                                                              new Text("Sua senha deve ter 4 dígitos."),
                                                            ],
                                                          ),
                                                          actions: <Widget>[
                                                            new Row(
                                                              children: <Widget>[
                                                                new FlatButton(
                                                                    onPressed: () {
                                                                      setState(() {
                                                                        Navigator.pop(context);
                                                                      });
                                                                    },
                                                                    child: new Text("Ok")),
                                                              ],
                                                            ),
                                                          ],
                                                        )
                                                    );
                                                  }
                                                  else if (metaControler.numberValue > ganhoControler.numberValue) {
                                                    showDialog(
                                                        context: context,
                                                        child: new AlertDialog(
                                                          title: new Text("Alerta!"),
                                                          content: new Column(
                                                            crossAxisAlignment: CrossAxisAlignment.start,
                                                            mainAxisSize: MainAxisSize.min,
                                                            children: <Widget>[
                                                              new Text("O valor de sua meta não pode ser maior que o valor que você ganha."),
                                                            ],
                                                          ),
                                                          actions: <Widget>[
                                                            new Row(
                                                              children: <Widget>[
                                                                new FlatButton(
                                                                    onPressed: () {
                                                                      setState(() {
                                                                        Navigator.pop(context);
                                                                      });
                                                                    },
                                                                    child: new Text("Ok")),
                                                              ],
                                                            ),
                                                          ],
                                                        )
                                                    );
                                                  }
                                                  else if (int.parse(diaPagamentoControler.text) > 31) {
                                                    showDialog(
                                                        context: context,
                                                        child: new AlertDialog(
                                                          title: new Text("Alerta!"),
                                                          content: new Column(
                                                            crossAxisAlignment: CrossAxisAlignment.start,
                                                            mainAxisSize: MainAxisSize.min,
                                                            children: <Widget>[
                                                              new Text("Você não inseriu um dia do pagamento válido!"),
                                                            ],
                                                          ),
                                                          actions: <Widget>[
                                                            new Row(
                                                              children: <Widget>[
                                                                new FlatButton(
                                                                    onPressed: () {
                                                                      setState(() {
                                                                        Navigator.pop(context);
                                                                      });
                                                                    },
                                                                    child: new Text("Ok")),
                                                              ],
                                                            ),
                                                          ],
                                                        )
                                                    );
                                                  }
                                                  else {
                                                    if (senhaControler.text.length == 0) {
                                                      info.nomeUser = nomeControler.text;
                                                      info.senha = null;
                                                      info.ganho = ganhoControler.numberValue;
                                                      info.meta = metaControler.numberValue;
                                                      info.gastoDiario = (ganhoControler.numberValue - metaControler.numberValue) / 30;
                                                      info.dia_recebe = int.parse(diaPagamentoControler.text);
                                                      db.editInfo(info.ID, nomeControler.text, null, ganhoControler.numberValue, metaControler.numberValue, (ganhoControler.numberValue - metaControler.numberValue) / 30, int.parse(diaPagamentoControler.text));
                                                      showDialog(
                                                          context: context,
                                                          child: new AlertDialog(
                                                            title: new Text("Salvo!"),
                                                            content: new Column(
                                                              crossAxisAlignment: CrossAxisAlignment.start,
                                                              mainAxisSize: MainAxisSize.min,
                                                              children: <Widget>[
                                                                new Text("Salvo com sucesso."),
                                                              ],
                                                            ),
                                                            actions: <Widget>[
                                                              new Row(
                                                                children: <Widget>[
                                                                  new FlatButton(
                                                                      onPressed: () {
                                                                        setState(() {
                                                                          Navigator.pop(context);
                                                                          Navigator.pop(context);
                                                                        });
                                                                      },
                                                                      child: new Text("Ok")),
                                                                ],
                                                              ),
                                                            ],
                                                          )
                                                      );
                                                      //Navigator.pop(context);
                                                    }
                                                    else {
                                                      info.nomeUser = nomeControler.text;
                                                      info.senha = int.parse(senhaControler.text);
                                                      info.ganho = ganhoControler.numberValue;
                                                      info.meta = metaControler.numberValue;
                                                      info.gastoDiario = (ganhoControler.numberValue - metaControler.numberValue) / 30;
                                                      info.dia_recebe = int.parse(diaPagamentoControler.text);
                                                      db.editInfo(info.ID, nomeControler.text, int.parse(senhaControler.text), ganhoControler.numberValue, metaControler.numberValue, (ganhoControler.numberValue - metaControler.numberValue) / 30, int.parse(diaPagamentoControler.text));
                                                      showDialog(
                                                          context: context,
                                                          child: new AlertDialog(
                                                            title: new Text("Salvo!"),
                                                            content: new Column(
                                                              crossAxisAlignment: CrossAxisAlignment.start,
                                                              mainAxisSize: MainAxisSize.min,
                                                              children: <Widget>[
                                                                new Text("Salvo com sucesso."),
                                                              ],
                                                            ),
                                                            actions: <Widget>[
                                                              new Row(
                                                                children: <Widget>[
                                                                  new FlatButton(
                                                                      onPressed: () {
                                                                        setState(() {
                                                                          Navigator.pop(context);
                                                                          Navigator.pop(context);
                                                                        });
                                                                      },
                                                                      child: new Text("Ok")),
                                                                ],
                                                              ),
                                                            ],
                                                          )
                                                      );
                                                      //Navigator.pop(context);
                                                    }
                                                  }

                                                });
                                              }),
                                        ],
                                      ),

                                  ),
                                ],
                              )),
                        ),
                      ],
                    )
                )
              ],
            )
        ),

    );
  }
}
