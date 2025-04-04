package com.classes.DTO;

public class DisciplinaAluno {

    int codigo;
    Disciplina disciplina;
    String status;
    Aluno aluno;

    public DisciplinaAluno(String status, Aluno aluno, Disciplina disciplina) {
        this.disciplina = disciplina;
        this.status = status;
        this.aluno = aluno;
    }

    public DisciplinaAluno(int codigo, String status, Aluno aluno, Disciplina disciplina) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.status = status;
        this.aluno = aluno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
