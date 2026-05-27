package poo.exercicios;

public class Exercicio13e14 {
    public static void main(String[] args) {
        Lampada lampada = new Lampada(true);
        LampadaFluorescente lampF = new LampadaFluorescente(false, 22.7);

        System.out.println("Estado Lampada Normal: " + lampada.getEstado());
        System.out.println("Estado Lampada Fluorescente: " + lampF.getEstado());
        System.out.println("Comprimento Lampada Fluorescente: " + lampF.getComprimento());

        teste ts = new teste();
        System.out.println(ts.maior());
    }

}
