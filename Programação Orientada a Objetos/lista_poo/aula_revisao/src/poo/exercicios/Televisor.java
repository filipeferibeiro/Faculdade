package poo.exercicios;

public class Televisor {
    private boolean ligado;
    private int canal, volume, numeroCanais, volumeMaximo;

    Televisor (int canal, int volume, boolean ligado, int numeroCanais, int volumeMaximo) {
        this.canal = canal;
        this.volume = volume;
        this.ligado = ligado;
        this.numeroCanais = numeroCanais;
        this.volumeMaximo = volumeMaximo;
    }

    public void imprimir () {
        System.out.println("Canal: " + this.canal + "\nVolume: " + this. volume + "\nLigado: " + this.ligado + "\nNumero de Canais: " +
        this.numeroCanais + "\nVolume Máximo: " + this.volumeMaximo);
    }

    public void ligar () {
        this.ligado = true;
    }

    public void desligar () {
        this.ligado = false;
    }

    public void canalAcima () {
        if (this.canal == this.numeroCanais) {
            this.canal = 1;
        }
        else {
            this.canal += 1;
        }
    }

    public void canalAbaixo () {
        if (this.canal == 1) {
            this.canal = this.numeroCanais;
        }
        else {
            this.canal -= 1;
        }
    }
}
