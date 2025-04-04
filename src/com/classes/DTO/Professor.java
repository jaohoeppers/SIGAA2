package com.classes.DTO;

public class Professor {

    int codigo;
    String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor( int codigo,String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
