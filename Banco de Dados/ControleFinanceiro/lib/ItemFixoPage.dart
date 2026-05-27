import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';

class ItemFixoPage extends StatefulWidget {
  AppDB db;
  List<ItemFixo> itensFixos;

  ItemFixoPage (AppDB db, List<ItemFixo> itensFixos) {
    this.db = db;
    this.itensFixos = itensFixos;
  }

  _ItemFixoPage createState() => _ItemFixoPage(db, itensFixos);
}

class _ItemFixoPage extends State<ItemFixoPage> {
  AppDB db;
  List<ItemFixo> itensFixos;
  var valorControler = new MoneyMaskedTextController();
  var nomeControler = new TextEditingController();

  _ItemFixoPage (AppDB db, List<ItemFixo> itensFixos) {
    this.db = db;
    this.itensFixos = itensFixos;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
        color: BackgroundColor,
        child: Padding(
          padding: EdgeInsets.all(6.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            mainAxisSize: MainAxisSize.max,
            children: <Widget>[
              Card(
                  child: Padding(
                padding: EdgeInsets.all(10.0),
                child: Column(children: <Widget>[
                  TextField(
                    decoration: new InputDecoration(
                        fillColor: Colors.white,
                        filled: true,
                        labelText: "Nome",
                        border: new OutlineInputBorder(
                          borderRadius: new BorderRadius.circular(13.0),
                        )),
                    maxLength: 30,
                    controller: nomeControler,
                  ),
                  Padding(padding: EdgeInsets.only(top: 4.0)),
                  TextField(
                    decoration: new InputDecoration(
                        fillColor: Colors.white,
                        filled: true,
                        labelText: "Valor",
                        border: new OutlineInputBorder(
                          borderRadius: new BorderRadius.circular(13.0),
                        )),
                    keyboardType: TextInputType.number,
                    controller: valorControler,
                  ),
                  Padding(padding: EdgeInsets.only(top: 25.0)),
                  Row(
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
                              Icon(Icons.done, color: Colors.white),
                              Padding(padding: EdgeInsets.only(left: 4.0)),
                              Text("Adicionar",
                                  style: TextStyle(
                                      color: Colors.white, fontSize: 20.0))
                            ],
                          ),
                          shape: BeveledRectangleBorder(
                              borderRadius:
                                  BorderRadius.all(Radius.circular(6.0))),
                          padding: EdgeInsets.only(
                              left: 20.0, right: 20.0, top: 10.0, bottom: 10.0),
                          onPressed: () {
                            setState(() {
                              try {
                                if (valorControler.text != "0,00") {
                                  itensFixos.add(new ItemFixo(
                                      null,
                                      nomeControler.text,
                                      valorControler.numberValue));
                                  db.addItemFixo(nomeControler.text, valorControler.numberValue,
                                       itensFixos.last, db.getInfo().ID);

                                  valorControler.text = '0,00';
                                  nomeControler.text = '';
                                  Navigator.pop(context);
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
                                                      Navigator.pop(context);
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
                            });
                          })
                    ],
                  ),
                ]),
              ))
            ],
          ),
        ));
  }
}
