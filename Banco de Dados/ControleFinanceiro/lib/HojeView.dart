import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';

class HojeView extends StatefulWidget {
  List<Item> itens;
  AppDB db;

  HojeView (List<Item> itens, AppDB db) {
    this.itens = itens;
    this.db = db;
  }

  @override
  HojeViewForm createState() => HojeViewForm(itens, db);
}

class HojeViewForm extends State<HojeView> {
  List<Item> itens;
  AppDB db;

  HojeViewForm (List<Item> itens, AppDB db) {
    this.itens = itens;
    this.db = db;
  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new ListView.builder(
        itemCount: itens.length,
        itemBuilder: (BuildContext context, int index) {
          return new Card(
            color: PrimaryColorLight,
            child: new Padding(
              padding: new EdgeInsets.only(left: 6.0),
              child: new Row(
                children: <Widget>[
                  new Flexible(
                    child: new Text("${itens.elementAt(index).getNome()}",style: TextStyle(color: Colors.white, fontSize: 19.0),),
                    fit: FlexFit.tight),
                  new Text("R\$ ${itens.elementAt(index).getValor().toStringAsFixed(2)}",style: TextStyle(color: Colors.white, fontSize: 19.0)),
                  
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
                                          new Text("${itens.elementAt(index).getNome()}"),
                                          new Text("R\$ ${itens.elementAt(index).getValor().toStringAsFixed(2)}")
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
                                                    AppDB.info.banco += itens.elementAt(index).valor;
                                                    int id = itens.elementAt(index).ID;
                                                    db.removeItem(id);
                                                    itens.removeAt(index);
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
                      ])
                ],
              ),));
        },
      ),
    );
  }
}
