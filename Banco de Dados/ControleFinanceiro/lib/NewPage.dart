import 'package:controlefinanceiro/AppDB.dart';
import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/DinheiroPage.dart';
import 'package:controlefinanceiro/HomePage.dart';
import 'package:controlefinanceiro/ItemFixoPage.dart';
import 'package:controlefinanceiro/ItemPage.dart';
import 'package:controlefinanceiro/colors.dart';
import 'package:flutter/material.dart';

class NewPage extends StatefulWidget {
  AppDB db;
  Dia dia;
  List<ItemFixo> itensFixos;

  NewPage (AppDB db, Dia dia, List<ItemFixo> itensFixos) {
    this.db = db;
    this.dia = dia;
    this.itensFixos = itensFixos;
  }

  @override
  NewPageForm createState() => NewPageForm(db, dia, itensFixos);
}

class NewPageForm extends State<NewPage> with SingleTickerProviderStateMixin{
  int radioValue = 1;
  TabController _tabContr;
  AppDB db;
  Dia dia;
  List<ItemFixo> itensFixos;

  NewPageForm (AppDB db, Dia dia, List<ItemFixo> itensFixos) {
    this.db = db;
    this.dia = dia;
    this.itensFixos = itensFixos;
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _tabContr = new TabController(length: 3, vsync: this, initialIndex: 0);
  }
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        leading: new IconButton(
          icon: Icon(Icons.arrow_back),
          onPressed: () {
            Navigator.pop(context);
          }),
        title: new Text("Novo"),
        bottom: new TabBar(
            controller: _tabContr,
            tabs:<Tab>[
              new Tab(text: "Item", icon: Icon(Icons.payment)),
              new Tab(text: "Item Fixo", icon: Icon(Icons.done)),
              new Tab(text: "Dinheiro", icon: Icon(Icons.attach_money)),
            ]),
    ),
      body: new TabBarView(
          controller: _tabContr,
          children: <Widget> [
            new ItemPage(db, dia),
            new ItemFixoPage(db, itensFixos),
            new DinheiroPage(db)
          ])
    );
  }
}
