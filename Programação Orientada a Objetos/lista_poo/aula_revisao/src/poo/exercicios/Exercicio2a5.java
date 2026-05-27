package poo.exercicios;

public class Exercicio2a5 {
    public static void main(String[] args) {
        Eletrodomestico eletrodomestico = new Eletrodomestico("Samsung", "Lavadora", 220, false);

        System.out.println("Ligar");
        eletrodomestico.ligar();
        eletrodomestico.imprimir();

        System.out.println("\nDesligar");
        eletrodomestico.desligar();
        eletrodomestico.imprimir();


    }
}
