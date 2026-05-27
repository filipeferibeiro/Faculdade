import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';
import 'package:controlefinanceiro/ViewPage.dart';
import 'package:controlefinanceiro/HojeView.dart';

class DiasView extends StatefulWidget {
  int diaAtual;
  List<Dia> dias;
  AppDB db;

  DiasView (List<Dia> dias, int diaAtual, AppDB db) {
    this.dias = dias;
    this.diaAtual = diaAtual;
    this.db = db;
  }

  @override
  DiasViewForm createState() => DiasViewForm(dias, diaAtual, db);
}

class DiasViewForm extends State<DiasView> {
  int diaAtual;
  List<Dia> dias;
  AppDB db;

  DiasViewForm (List<Dia> dias, int diaAtual, AppDB db) {
    this.dias = dias;
    this.diaAtual = diaAtual;
    this.db = db;
  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new ListView.builder(
        itemCount: diaAtual,
        itemBuilder: (BuildContext context, int index) {
          return new Card(
              color: PrimaryColorLight,
              child: new Padding(
                  padding: new EdgeInsets.only(left: 7.0),
                  child: new Row(
                    children: <Widget>[
                      new Flexible(
                          child: Text("${dias.elementAt(index).getDia().toString().padLeft(2, '0')}",style: TextStyle(color: Colors.white, fontSize: 19.0)),
                          fit: FlexFit.tight),
                      new Column(
                          crossAxisAlignment: CrossAxisAlignment.end,
                          mainAxisSize: MainAxisSize.min,
                          children: <Widget>[
                            IconButton(
                                icon: new Icon(Icons.chevron_right),
                                color: Colors.white,
                                onPressed: () {
                                  setState(() {
                                    Navigator.of(context).push(new MaterialPageRoute(builder: (context) => new ViewPage(new HojeView(dias.elementAt(index).getItens(), db), "Itens do dia " + dias.elementAt(index).dia.toString().padLeft(2, '0'))));
                                  });
                                })
                          ]),
                    ],
                  )));
        },
      ),
    );
  }
}