import 'package:flutter/material.dart';

class ViewPage extends StatefulWidget {
  StatefulWidget page;
  String titulo;

  ViewPage (StatefulWidget page, String titulo) {
    this.page = page;
    this.titulo = titulo;
  }

  _ViewPage createState() => _ViewPage(page, titulo);
}

class _ViewPage extends State<ViewPage> {
  StatefulWidget page;
  String titulo;

  _ViewPage (StatefulWidget page, String titulo) {
    this.page = page;
    this.titulo = titulo;
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: new AppBar(
        leading: new IconButton(
            icon: Icon(Icons.arrow_back),
            onPressed: () {
              Navigator.pop(context);
            }),
        title: new Text(titulo)
      ),
      body: Container(
        child: page,
      ),
    );
  }

}