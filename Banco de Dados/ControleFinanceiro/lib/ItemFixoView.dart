import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';

class ItemFixoView extends StatefulWidget {
  AppDB db;
  List<ItemFixo> itensFixos;
  Dia dia;

  ItemFixoView (AppDB db, List<ItemFixo> itensFixos, Dia dia) {
    this.db = db;
    this.itensFixos = itensFixos;
    this.dia = dia;
  }

  _ItemFixoView createState() => _ItemFixoView(db, itensFixos, dia);
}

class _ItemFixoView extends State<ItemFixoView> {
  AppDB db;
  List<ItemFixo> itensFixos;
  Dia dia;


  var nomeEditController = TextEditingController();
  var confirmacaoController = MoneyMaskedTextController();
  var valorEditController = MoneyMaskedTextController();

  _ItemFixoView (AppDB db, List<ItemFixo> itensFixos, Dia dia) {
    this.db = db;
    this.itensFixos = itensFixos;
    this.dia = dia;
  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new ListView.builder(
        itemCount: itensFixos.length,
        itemBuilder: (BuildContext context, int index) {
          return new Card(
              color: PrimaryColorLight,
              child: new Padding(
                padding: new EdgeInsets.only(left: 6.0),
                child: new Row(
                  children: <Widget>[
                    new Flexible(
                        child: new Text("${itensFixos.elementAt(index).nome}",style: TextStyle(color: Colors.white, fontSize: 19.0),),
                        fit: FlexFit.tight),
                    new Text("R\$ ${itensFixos.elementAt(index).valor.toStringAsFixed(2)}",style: TextStyle(color: Colors.white, fontSize: 19.0)),
                    new Column(
                        crossAxisAlignment: CrossAxisAlignment.end,
                        mainAxisSize: MainAxisSize.min,
                        children: <Widget>[
                          IconButton(
                              icon: new Icon(Icons.edit),
                              color: Colors.white,
                              onPressed: () {
                                setState(() {
                                  nomeEditController.text = itensFixos.elementAt(index).nome;
                                  valorEditController.updateValue(itensFixos.elementAt(index).valor);
                                  showDialog(
                                      barrierDismissible: false,
                                      context: context,
                                      child: new AlertDialog(
                                        title: new Text("Editar - " + itensFixos.elementAt(index).nome),
                                        content: new Column(
                                          crossAxisAlignment: CrossAxisAlignment.start,
                                          mainAxisSize: MainAxisSize.min,
                                          children: <Widget>[
                                            TextField (
                                              decoration: new InputDecoration(
                                                  fillColor: Colors.white,
                                                  filled: true,
                                                  labelText: "Nome",
                                                  border: new OutlineInputBorder(
                                                    borderRadius: new BorderRadius.circular(13.0),
                                                  )
                                              ),
                                              maxLength: 30,
                                              keyboardType: TextInputType.number,
                                              controller: nomeEditController,
                                            ),
                                            Padding(padding: new EdgeInsets.only(top: 8.0)),
                                            TextField (
                                              decoration: new InputDecoration(
                                                  fillColor: Colors.white,
                                                  filled: true,
                                                  labelText: "Valor",
                                                  border: new OutlineInputBorder(
                                                    borderRadius: new BorderRadius.circular(13.0),
                                                  )
                                              ),
                                              keyboardType: TextInputType.number,
                                              controller: valorEditController,
                                            ),
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
                                                  child: new Text("Cancelar")),
                                              new FlatButton(
                                                  onPressed: () {
                                                    setState(() {
                                                      itensFixos.elementAt(index).nome = nomeEditController.text;
                                                      itensFixos.elementAt(index).valor = valorEditController.numberValue;
                                                      db.editItemFixo(itensFixos.elementAt(index).ID, nomeEditController.text, valorEditController.numberValue);
                                                      Navigator.pop(context);
                                                    });
                                                  },
                                                  child: new Text("Editar")),
                                            ],
                                          ),
                                        ],
                                      ));
                                });
                              })
                        ]),
                    new Column(
                        crossAxisAlignment: CrossAxisAlignment.end,
                        mainAxisSize: MainAxisSize.min,
                        children: <Widget>[
                          IconButton(
                              icon: new Icon(Icons.delete),
                              color: Colors.red,
                              onPressed: () {
                                setState(() {
                                  showDialog(
                                      context: context,
                                      child: new AlertDialog(
                                        title: new Text("Deseja remover?"),
                                        content: new Column(
                                          crossAxisAlignment: CrossAxisAlignment.start,
                                          mainAxisSize: MainAxisSize.min,
                                          children: <Widget>[
                                            new Text("${itensFixos.elementAt(index).nome}"),
                                            new Text("R\$ ${itensFixos.elementAt(index).valor.toStringAsFixed(2)}")
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
                                                  child: new Text("Não")),
                                              new FlatButton(
                                                  onPressed: () {
                                                    setState(() {
                                                      int id = itensFixos.elementAt(index).ID;
                                                      db.removeItemFixo(id);
                                                      itensFixos.removeAt(index);
                                                      Navigator.pop(context);
                                                    });
                                                  },
                                                  child: new Text("Sim"))
                                            ],
                                          ),
                                        ],
                                      ));
                                });
                              })
                        ]),
                    new Column(
                        crossAxisAlignment: CrossAxisAlignment.end,
                        mainAxisSize: MainAxisSize.min,
                        children: <Widget>[
                          IconButton(
                              icon: new Icon(Icons.done),
                              color: Colors.lightGreenAccent,
                              onPressed: () {
                                setState(() {
                                  confirmacaoController.updateValue(itensFixos.elementAt(index).valor);
                                  showDialog(
                                    barrierDismissible: false,
                                      context: context,
                                      child: new AlertDialog(
                                        title: new Text("Confirmação do valor"),
                                        content: new Column(
                                          crossAxisAlignment: CrossAxisAlignment.start,
                                          mainAxisSize: MainAxisSize.min,
                                          children: <Widget>[
                                            Text("Valor informado: R\$ ${itensFixos.elementAt(index).valor.toStringAsFixed(2)}"),
                                            Padding(padding: new EdgeInsets.only(top: 8.0)),
                                            TextField (
                                              decoration: new InputDecoration(
                                                  fillColor: Colors.white,
                                                  filled: true,
                                                  labelText: "Valor real",
                                                  border: new OutlineInputBorder(
                                                    borderRadius: new BorderRadius.circular(13.0),
                                                  )
                                              ),
                                              keyboardType: TextInputType.number,
                                              controller: confirmacaoController,
                                            ),
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
                                                  child: new Text("Cancelar")),
                                              new FlatButton(
                                                  onPressed: () {
                                                    setState(() {
                                                      AppDB.info.banco -= confirmacaoController.numberValue;
                                                      dia.getItens().add(new Item(
                                                          null,
                                                          itensFixos.elementAt(index).nome,
                                                          confirmacaoController.numberValue));
                                                      db.addItem(dia.ID, confirmacaoController.numberValue,
                                                          itensFixos.elementAt(index).nome, dia.getItens().last);
                                                      Navigator.pop(context);
                                                    });
                                                  },
                                                  child: new Text("Pagar")),
                                            ],
                                          ),
                                        ],
                                      ));
                                });
                              })
                        ]),
                  ],
                ),));
        },
      ),
    );
  }
}