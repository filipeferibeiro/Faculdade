import 'dart:async';

import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/Home.dart';
import 'package:controlefinanceiro/HomePage.dart';
import 'package:flutter/material.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';
class LoadData extends StatefulWidget {
  @override
  LoadDataForm createState() => LoadDataForm();
}

class LoadDataForm extends State<LoadData> {
  AppDB db = new AppDB();

  var nomeControler = new TextEditingController();
  var diaPagamentoControler = new TextEditingController();
  var saldoControler = new MoneyMaskedTextController();
  var senhaControler = new TextEditingController();
  String mensagem = "";


  LoadDataForm () {
    db.initDb();
  }

  void terminado () {
    if (AppDB.info.first == 1) {
      showDialog(
          barrierDismissible: false,
          context: context,
          child: new AlertDialog(
            title: new Text("Configuração Inicial"),
            content: new Column(
              crossAxisAlignment:
              CrossAxisAlignment.start,
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                TextField (
                  decoration: new InputDecoration(
                      fillColor: Colors.white,
                      filled: true,
                      labelText: "Seu Nome",
                      border: new OutlineInputBorder(
                        borderRadius: new BorderRadius.circular(13.0),
                      )
                  ),
                  maxLength: 40,
                  controller: nomeControler,
                ),
                Padding(padding: new EdgeInsets.only(top: 4.0)),
                TextField (
                  decoration: new InputDecoration(
                      fillColor: Colors.white,
                      filled: true,
                      labelText: "Saldo Atual",
                      border: new OutlineInputBorder(
                        borderRadius: new BorderRadius.circular(13.0),
                      )
                  ),
                  keyboardType: TextInputType.number,
                  controller: saldoControler,
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
              ],
            ),
            actions: <Widget>[
              new Row(
                children: <Widget>[
                  new FlatButton(
                      onPressed: () {
                        setState(() {
                          if (diaPagamentoControler.text == "") {
                            diaPagamentoControler.text = "1";
                          }
                          if (int.parse(diaPagamentoControler.text) > 31 || int.parse(diaPagamentoControler.text) < 1) {
                            mensagem = "Dia de pagamento inválido.";
                            erroDialog();
                          }
                          else {
                            db.notFirst(saldoControler.numberValue, int.parse(diaPagamentoControler.text), nomeControler.text);
                            Navigator.pop(context);
                            Navigator.pushReplacement(context, new MaterialPageRoute(builder: (BuildContext context) => new HomePage(db)));
                          }
                        });
                      },
                      child: new Text("Ok")),
                ],
              ),
            ],
          ));
    }
    else {
      if (AppDB.info.senha != null) {
        showDialog(
            barrierDismissible: false,
            context: context,
            child: new AlertDialog(
              title: new Text("Informe sua senha"),
              content: new Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisSize: MainAxisSize.min,
                children: <Widget>[
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
                ],
              ),
              actions: <Widget>[
                new Row(
                  children: <Widget>[
                    new FlatButton(
                        onPressed: () {
                          setState(() {
                            if (senhaControler.text == AppDB.info.senha.toString()) {
                              Navigator.pushReplacement(context, new MaterialPageRoute(builder: (BuildContext context) => new HomePage(db)));
                            }
                            else {
                              mensagem = "Senha Incorreta.";
                              senhaControler.text = "";
                              erroDialog();
                            }
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
        Navigator.pushReplacement(context, new MaterialPageRoute(builder: (BuildContext context) => new HomePage(db)));
      }
    }
  }

  void erroDialog () {
    showDialog(
        context: context,
        child: new AlertDialog(
          title: new Text("Algo deu errado"),
          content: new Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            mainAxisSize: MainAxisSize.min,
            children: <Widget>[
              new Text(mensagem, style: TextStyle(color: Colors.red, fontWeight: FontWeight.bold)),
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
        ));
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    db.setup(this);

    /*Timer(Duration(seconds: 5), () {
      if (AppDB.info.first == 1) {
        showDialog(
          barrierDismissible: false,
            context: context,
            child: new AlertDialog(
              title: new Text("Configuração Inicial"),
              content: new Column(
                crossAxisAlignment:
                CrossAxisAlignment.start,
                mainAxisSize: MainAxisSize.min,
                children: <Widget>[
                  TextField (
                    decoration: new InputDecoration(
                        fillColor: Colors.white,
                        filled: true,
                        labelText: "Seu Nome",
                        border: new OutlineInputBorder(
                          borderRadius: new BorderRadius.circular(13.0),
                        )
                    ),
                    maxLength: 40,
                    controller: nomeControler,
                  ),
                  Padding(padding: new EdgeInsets.only(top: 4.0)),
                  TextField (
                    decoration: new InputDecoration(
                        fillColor: Colors.white,
                        filled: true,
                        labelText: "Saldo Atual",
                        border: new OutlineInputBorder(
                          borderRadius: new BorderRadius.circular(13.0),
                        )
                    ),
                    keyboardType: TextInputType.number,
                    controller: saldoControler,
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
                ],
              ),
              actions: <Widget>[
                new Row(
                  children: <Widget>[
                    new FlatButton(
                        onPressed: () {
                          setState(() {
                            if (diaPagamentoControler.text == "") {
                              diaPagamentoControler.text = "1";
                            }
                            if (int.parse(diaPagamentoControler.text) > 31 || int.parse(diaPagamentoControler.text) < 1) {
                              mensagem = "Dia de pagamento inválido.";
                              erroDialog();
                            }
                            else {
                              db.notFirst(saldoControler.numberValue, int.parse(diaPagamentoControler.text), nomeControler.text);
                              Navigator.pop(context);
                              Navigator.pushReplacement(context, new MaterialPageRoute(builder: (BuildContext context) => new HomePage(db)));
                            }
                          });
                        },
                        child: new Text("Ok")),
                  ],
                ),
              ],
            ));
      }
      else {
        if (AppDB.info.senha != null) {
          showDialog(
            barrierDismissible: false,
              context: context,
              child: new AlertDialog(
                title: new Text("Informe sua senha"),
                content: new Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisSize: MainAxisSize.min,
                  children: <Widget>[
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
                  ],
                ),
                actions: <Widget>[
                  new Row(
                    children: <Widget>[
                      new FlatButton(
                          onPressed: () {
                            setState(() {
                              if (senhaControler.text == AppDB.info.senha.toString()) {
                                Navigator.pushReplacement(context, new MaterialPageRoute(builder: (BuildContext context) => new HomePage(db)));
                              }
                              else {
                                mensagem = "Senha Incorreta.";
                                senhaControler.text = "";
                                erroDialog();
                              }
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
          Navigator.pushReplacement(context, new MaterialPageRoute(builder: (BuildContext context) => new HomePage(db)));
        }
      }
    });*/
  }
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: Stack(
        fit: StackFit.expand,
        children: <Widget>[
          new Container(
            decoration: BoxDecoration(color: PrimaryColor),
          ),
          new Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              Expanded(
                  flex: 2,
                  child: Container(
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: <Widget>[
                        CircleAvatar(
                          backgroundColor: Colors.white,
                          radius: 50.0,
                          child: Icon(Icons.attach_money, color: Colors.yellow, size: 50.0),
                        ),
                        Padding(
                          padding: EdgeInsets.only(top: 10.0),
                        ),
                        Text("Controle Financeiro", style: TextStyle(color: Colors.white, fontSize: 24.0, fontWeight: FontWeight.bold))
                      ],
                    ),
                  )),
              Expanded(
                flex: 1,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      CircularProgressIndicator(),
                      Padding(
                        padding: EdgeInsets.only(top: 20.0),
                      ),
                      Text("Carregando...", style: TextStyle(color: Colors.white, fontSize: 18.0, fontWeight: FontWeight.bold))
                    ],
                  ),
              )
            ],
          ),
        ],
      ),
    );
  }

}