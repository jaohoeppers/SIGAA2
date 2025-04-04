package com.classes.DTO;

public class Aluno {

    int codigo;
    String nome;
    String matricula;
    String numeroTelefone;
    String email;
    Curso curso;
    AulaAluno[] aulas;

    public Aluno(String nome, String matricula, String numeroTelefone, String email, Curso curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
//        this.disciplinas = disciplinas;
        this.curso = curso;
//        this.aulas = aulas;
    }

    public Aluno(int codigo, String nome, String matricula, String numeroTelefone, String email, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.matricula = matricula;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
//        this.disciplinas = disciplinas;
        this.curso = curso;
//        this.aulas = aulas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefone() { return numeroTelefone; }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AulaAluno[] getAulas() {
        return aulas;
    }

    public void setAulas(AulaAluno[] aulas) {
        this.aulas = aulas;
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
