package poo.exercicios;

public class Eletrodomestico {
    private boolean ligado;
    private String marca, tipo;
    private int voltagem;

    Eletrodomestico(String marca, String tipo, int voltagem, boolean ligado) {
        this.marca = marca;
        this.tipo = tipo;
        this.voltagem = voltagem;
        this.ligado = ligado;
    }

    public void imprimir () {
        System.out.println("Marca: " + this.marca + "\nTipo: " + this.tipo + "\nVoltagem: " + this.voltagem + "v\nLigado: " + this.ligado);
    }

    public void ligar () {
        this.ligado = true;
    }

    public void desligar () {
        this.ligado = false;
    }
}
