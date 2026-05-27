import 'package:flutter/material.dart';
import 'package:flutter_masked_text/flutter_masked_text.dart';
import 'package:percent_indicator/linear_percent_indicator.dart';
import 'colors.dart';

class Home extends StatefulWidget {
  @override
  _Home createState() => new _Home();
}

class _Home extends State<Home> with SingleTickerProviderStateMixin {
  var _quickItemValue = new MoneyMaskedTextController();
  TabController _tabControler;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    _tabControler = new TabController(length: 4, vsync: this, initialIndex: 0);
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(
        backgroundColor: BackgroundColor,
        elevation: 0.0,
        title: Text("Controle Financeiro", textAlign: TextAlign.left),
        actions: <Widget>[
          new IconButton(
            icon: Icon(Icons.add),
            highlightColor: Colors.white,
            splashColor: Colors.white,
            color: Colors.white,
            disabledColor: Colors.white,
            onPressed: null,
          ),
          new IconButton(
            icon: Icon(Icons.assessment),
            highlightColor: Colors.white,
            splashColor: Colors.white,
            color: Colors.white,
            disabledColor: Colors.white,
            onPressed: null,
          ),
          new IconButton(
            icon: Icon(Icons.settings),
            highlightColor: Colors.white,
            splashColor: Colors.white,
            color: Colors.white,
            disabledColor: Colors.white,
            onPressed: null,
          )
        ],
      ),
      body: new Container(
        padding: EdgeInsets.all(0.0),
        color: BackgroundColor,
        child: new Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          mainAxisSize: MainAxisSize.max,
          children: <Widget>[
            new Expanded(
              child: new ListView(
                children: <Widget>[
                  new Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      new Padding(padding: EdgeInsets.only(left: 6.0)),
                      new Expanded(
                        child: new Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <Widget>[
                            new Text("SALDO", style: TextStyle(fontSize: 12.0, color: TextColor)),
                            new Text("R\$800,50", style: TextStyle(fontSize: 30.0, color: TextColor)),
                            new Text("FILIPE FERNANDES RIBEIRO", style: TextStyle(fontSize: 12.0, color: TextColor)),
                          ],
                        )
                      ),
                      new Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        mainAxisAlignment: MainAxisAlignment.start,
                        children: <Widget>[
                          new Padding(
                            padding: EdgeInsets.only(left: 28.0),
                            child: new Text("ITEM RÁPIDO", style: TextStyle(fontSize: 12.0, color: TextColor), textAlign: TextAlign.left),
                          ),
                          new Container(
                            alignment: Alignment.centerRight,
                            width: 275.0,
                            child: new Card(
                              //Adição rápida
                                shape: new RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(50.0)
                                ),
                                color: CardColor,
                                child: new Padding(
                                  padding: new EdgeInsets.only(left: 9.0),
                                  child: new Row(
                                    children: <Widget>[
                                      new Text("R\$", style: TextStyle(fontSize: 18.0, color: TextColor)),
                                      new Padding(padding: new EdgeInsets.only(right: 2.0)),
                                      new Flexible(
                                          child: new TextField(
                                              keyboardType: TextInputType.number,
                                              controller: _quickItemValue,
                                              style: TextStyle(fontSize: 18.0, color: TextColor),
                                              decoration: new InputDecoration(
                                                  border: InputBorder.none))),
                                      new Column(
                                        crossAxisAlignment: CrossAxisAlignment.end,
                                        mainAxisSize: MainAxisSize.min,
                                        children: <Widget>[
                                          IconButton(
                                              icon: new Icon(Icons.add),
                                              highlightColor: TextColor,
                                              splashColor: TextColor,
                                              color: TextColor,
                                              disabledColor: TextColor,
                                              onPressed: null)
                                        ],
                                      ),
                                    ],
                                  ),
                                )),
                          ),
                        ],
                      ),
                      new Padding(padding: EdgeInsets.only(right: 6.0, top: 2.0))
                    ],
                  ),
                  new Padding(
                      padding: EdgeInsets.only(top: 20.0, left: 2.0, right: 2.0, bottom: 10.0),
                      child: new Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        mainAxisSize: MainAxisSize.min,
                        children: <Widget>[
                          new Padding(
                            padding: EdgeInsets.only(left: 10.0),
                            child: new Text("META DIÁRIA", style: TextStyle(color: TextColor)),
                          ),
                          new LinearPercentIndicator(
                            width: MediaQuery.of(context).size.width -4,
                            backgroundColor: Colors.white,
                            progressColor: ProgressMeta,
                            percent: 0.3,
                          ),
                          new Padding(
                            padding: EdgeInsets.only(right: 8.0),
                            child: new Text("R\$0,00 / R\$0,00", style: TextStyle(color: TextColor, fontSize: 15.0), textAlign: TextAlign.right),
                          )
                        ],
                      )),
                ],
              ),
            ),
          ],
        )
      )
    );
  }
}