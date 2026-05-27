package poo.exercicios;

public class Quadrado {
    private double lado, area, perimetro;

    Quadrado (double lado) {
        this.lado = lado;
    }

    public void calcularArea () {
        this.area = this.lado * this.lado;
    }

    public void calcularPerimetro () {
        this.perimetro = 4 * this.lado;
    }

    public void imprimir () {
        System.out.printf("Lado: " + this.lado + "\nÁrea: " + this.area + "\nPerímetro: " + this.perimetro);
    }
}
