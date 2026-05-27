package Pk_PDR;

import java.io.Serializable;

public class Projeto implements Serializable{
    private String nome;
    int commits = 0, linhas = 0, pontuacao;

    public Projeto(String nome) {
        this.nome = nome;
    }

    public int getCommits() {
        return commits;
    }

    public void setCommits(int commits) {
        this.commits = commits;
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao() {
        this.pontuacao = (this.linhas/10) + (this.commits*2);
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
}
