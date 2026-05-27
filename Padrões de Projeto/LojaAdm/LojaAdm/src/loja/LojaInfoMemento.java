package loja;

public class LojaInfoMemento {
    private String nome, motd;

    public LojaInfoMemento(String nome, String motd) {
        this.nome = nome;
        this.motd = motd;
    }

    public String getNome() {
        return nome;
    }

    public String getMotd() {
        return motd;
    }    
}
