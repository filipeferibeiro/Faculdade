import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/MesesView.dart';
import 'package:controlefinanceiro/ViewPage.dart';
import 'package:flutter/material.dart';
import 'colors.dart';

class AnosView extends StatefulWidget {
  List<Ano> anos;
  AppDB db;
  AnosView (List<Ano> anos, AppDB db) {
    this.anos = anos;
    this.db = db;
  }

  @override
  AnosViewForm createState() => AnosViewForm(this.anos, db);
}

class AnosViewForm extends State<AnosView> {
  var dataDia = new DateTime.now();
  List<Ano> anos;
  AppDB db;

  AnosViewForm (List<Ano> anos, AppDB db) {
    this.anos = anos;
    this.db = db;
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    //setup();

  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      child: new ListView.builder(
        itemCount: anos.length,
        itemBuilder: (BuildContext context, int index) {
          return new Card(
            color: PrimaryColorLight,
            child: new Padding(
              padding: new EdgeInsets.only(left: 7.0),
              child: new Row(
                children: <Widget>[
                  new Flexible(
                    child: new Text("${anos.elementAt(index).getAno()}",style: TextStyle(color: Colors.white, fontSize: 19.0)),
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
                                Navigator.of(context).push(new MaterialPageRoute(builder: (context) => new ViewPage(MesesView(anos.elementAt(index).getMeses(), anos.elementAt(index).getMeses().length, db), "Meses de " + anos.elementAt(index).ano.toString())));
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