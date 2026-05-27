package loja;

public class Produto {
    private int id, id_loja, estoque;
    private String nome;
    private double valor;

    public Produto(int id, int id_loja, int estoque, String nome, double valor) {
        this.id = id;
        this.id_loja = id_loja;
        this.estoque = estoque;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public int getId_loja() {
        return id_loja;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}