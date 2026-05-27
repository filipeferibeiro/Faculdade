package poo.exercicios;

public class LampadaFluorescente extends Lampada {
    private double comprimento;

    LampadaFluorescente(boolean estado, double comprimento) {
    super(estado);
    this.comprimento = comprimento;
    }

    public double getComprimento() {
        return comprimento;
    }

}
