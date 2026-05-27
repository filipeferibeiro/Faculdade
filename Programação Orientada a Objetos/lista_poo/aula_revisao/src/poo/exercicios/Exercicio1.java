package poo.exercicios;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        double lado;
        Quadrado quadrado;

        Scanner sn = new Scanner(System.in);

        System.out.print("Informe o lado do quadrado: ");
        lado = sn.nextDouble();

        quadrado = new Quadrado(lado);

        quadrado.calcularArea();
        quadrado.calcularPerimetro();
        quadrado.imprimir();

    }
}
