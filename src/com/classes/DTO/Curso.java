package com.classes.DTO;

public class Curso {

    int codigo;
    String nome;

    public Curso(String nome) {
        this.nome = nome;
//        this.alunos = alunos;
    }

    public Curso(int codigo, String nome) {
        this.nome = nome;
        this.codigo = codigo;
//        this.alunos = alunos;
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
