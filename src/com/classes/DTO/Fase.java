package com.classes.DTO;

public class Fase {

    int codigo;
    String nome;
    Curso curso;

    public Fase(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public Fase(int codigo, String nome, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
