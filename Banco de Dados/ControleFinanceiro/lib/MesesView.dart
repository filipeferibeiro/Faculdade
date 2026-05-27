import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/DiasView.dart';
import 'package:controlefinanceiro/ViewPage.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';

class MesesView extends StatefulWidget {
  List<Mes> meses;
  int mesAtual;
  AppDB db;

  MesesView (List<Mes> meses, int mesAtual, AppDB db) {
    this.meses = meses;
    this.mesAtual = mesAtual;
    this.db = db;
  }

  @override
  MesesViewForm createState() => MesesViewForm(meses, mesAtual, db);
}

class MesesViewForm extends State<MesesView> {
  List<Mes> meses;
  int mesAtual;
  AppDB db;

  MesesViewForm (List<Mes> meses, int mesAtual, AppDB db) {
    this.meses = meses;
    this.mesAtual = mesAtual;
    this.db = db;
  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new ListView.builder(
        itemCount: mesAtual,
        itemBuilder: (BuildContext context, int index) {
          return new Card(
              color: PrimaryColorLight,
              child: new Padding(
                  padding: new EdgeInsets.only(left: 7.0),
                  child: new Row(
                    children: <Widget>[
                      new Flexible(
                          child: new Text("${meses.elementAt(index).getMesNome()}",style: TextStyle(color: Colors.white, fontSize: 19.0)),
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
                                    Navigator.of(context).push(new MaterialPageRoute(builder: (context) => new ViewPage(DiasView(meses.elementAt(index).getDias(), meses.elementAt(index).getDias().length, db), "Dias de " + meses.elementAt(index).getMesNome())));
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