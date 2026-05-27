import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';

class DinheiroPage extends StatefulWidget {
  AppDB db;

  DinheiroPage (AppDB db) {
    this.db = db;
  }
  _DinheiroPage createState() => _DinheiroPage(db);
}

class _DinheiroPage extends State<DinheiroPage> {
  AppDB db;
  var dinheiroControler = new MoneyMaskedTextController();

  _DinheiroPage (AppDB db) {
    this.db = db;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
        color: BackgroundColor,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          mainAxisSize: MainAxisSize.max,
          children: <Widget>[
            Padding(
              padding: EdgeInsets.all(6.0),
              child: Card(
                  child: Padding(
                    padding: EdgeInsets.all(10.0),
                    child: Column(
                      children: <Widget>[
                        TextField(
                          decoration: new InputDecoration(
                              fillColor: Colors.white,
                              filled: true,
                              labelText: "Valor",
                              border: new OutlineInputBorder(
                                borderRadius: new BorderRadius.circular(13.0),
                              )
                          ),
                          controller: dinheiroControler,
                          keyboardType: TextInputType.number,
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
                                    Icon(Icons.attach_money, color: Colors.white),
                                    Padding(padding: EdgeInsets.only(left: 4.0)),
                                    Text("Adicionar", style: TextStyle(color: Colors.white, fontSize: 20.0))
                                  ],
                                ),
                                shape: BeveledRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(6.0))),
                                padding: EdgeInsets.only(left: 20.0, right: 20.0, top: 10.0, bottom: 10.0),
                                onPressed: () {
                                  setState(() {
                                    AppDB.info.banco += dinheiroControler.numberValue;
                                    db.addDinheiro();
                                    dinheiroControler.updateValue(0.0);
                                    Navigator.pop(context);
                                  });
                                }
                            )
                          ],
                        ),
                      ],
                    ))
              ))
          ],
        ),
    );
  }

}