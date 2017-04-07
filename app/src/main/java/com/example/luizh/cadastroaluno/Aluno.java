package com.example.luizh.cadastroaluno;

/**
 * Created by luizh on 24/03/2017.
 */

public class Aluno {

    private Long codigo;
    private String nome;
    private String telefone;
    private String link;

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {this.telefone = telefone; }

    public String toString(){
        return "Code: " + codigo + "    Name: " + nome +  "     Phone: " + telefone;
    }

    public String getLink() {
        return link;
    }
}