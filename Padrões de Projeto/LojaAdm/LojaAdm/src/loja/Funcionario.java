package loja;

public class Funcionario {
    private int id, id_loja;
    private String nome, login, senha, email, nivelAcesso;
    
    public Funcionario(int id, String nome, String login, String senha, String email, String nivelAcesso, int id_loja) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
        this.id_loja = id_loja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    
}
