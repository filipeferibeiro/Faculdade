package poo.exercicios;

import java.util.Scanner;

public class Exercicio11e12 {
    public static void main(String[] args) {
        int dia, mes, ano;
        boolean valida;
        Scanner sn = new Scanner(System.in);

        System.out.print("Insira o dia: ");
        dia = sn.nextInt();
        System.out.print("Insira o mes: ");
        mes = sn.nextInt();
        System.out.print("Insira o ano: ");
        ano = sn.nextInt();

        if (mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11 && dia <= 31 && dia > 0 && mes > 0 && mes <= 12) {
            valida = true;
        }
        else if (mes != 2 && mes != 1 && mes != 3 && mes != 5 && mes != 7 && mes != 8 && mes != 10 && mes != 12 && dia <= 30 && dia > 0  && mes > 0 && mes <= 12) {
            valida = true;
        }
        else if (mes == 2 && ano % 4 == 0 && dia <= 29 && dia > 0) {
            valida = true;
        }
        else if (mes == 2 && ano % 4 != 0 && dia <= 28 && dia > 0) {
            valida = true;
        }
        else {
            valida = false;
            System.out.println("Data inválida!!!");
        }

        if (valida) {
            Data data = new Data(dia, mes, ano);
            Data data2 = new Data(22,04,1845);
            System.out.println("A data " + data.getDia() + "/" + data.getMes() + "/" + data.getAno() +
                    " vem antes da data " + data2.getDia() + "/" + data2.getMes() + "/" + data2.getAno() + ": " + data.vemAntes(data2));
        }



    }
}
