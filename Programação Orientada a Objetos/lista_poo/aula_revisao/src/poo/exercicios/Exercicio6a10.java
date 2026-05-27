package poo.exercicios;

public class Exercicio6a10 {
    public static void main(String[] args) {
        Televisor televisor = new Televisor(2, 25,false,5,30);

        televisor.imprimir();

        televisor.canalAbaixo();
        televisor.imprimir();
        televisor.canalAbaixo();
        televisor.imprimir();

        televisor.canalAcima();
        televisor.imprimir();
        televisor.canalAcima();
        televisor.imprimir();
    }
}
