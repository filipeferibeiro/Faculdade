package loja;

public class Loja {
    private int id;
    private String nome, motd;

    public Loja(int id, String nome, String motd) {
        this.id = id;
        this.nome = nome;
        this.motd = motd;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }
}
