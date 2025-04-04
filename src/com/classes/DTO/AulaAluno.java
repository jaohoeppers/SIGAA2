package com.classes.DTO;

public class AulaAluno {

    int codigo;
    Aula aula;
    Aluno aluno;
    Boolean presente;

    public AulaAluno(Aula aula, Aluno aluno, Boolean presente) {
        this.aula = aula;
        this.aluno = aluno;
        this.presente = presente;
    }

    public AulaAluno(int codigo, Aula aula, Aluno aluno, Boolean presente) {
        this.codigo = codigo;
        this.aula = aula;
        this.aluno = aluno;
        this.presente = presente;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
