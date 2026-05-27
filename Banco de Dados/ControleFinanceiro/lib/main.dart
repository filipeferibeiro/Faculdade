import 'package:controlefinanceiro/AppInfo.dart';
import 'package:controlefinanceiro/LoadData.dart';
import 'package:flutter/material.dart';
import 'package:controlefinanceiro/colors.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  AppInfo appInfo = new AppInfo();

  // This widget is the root of your application
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Controle Financeiro',
      debugShowCheckedModeBanner: false,
      theme: new ThemeData(
        primaryColor: PrimaryColor,
        primaryColorDark: PrimaryColorDark,
        primaryColorLight: PrimaryColorLight,
        textSelectionColor: TextColor,
        accentColorBrightness: Brightness.dark,
      ),
      home: new LoadData(),
    );
  }
}