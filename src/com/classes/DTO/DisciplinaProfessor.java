package com.classes.DTO;

import com.classes.XML.Professor;

public class DisciplinaProfessor {

    int codigo;
    com.classes.XML.Professor professor;
    Disciplina disciplina;

    public DisciplinaProfessor(com.classes.XML.Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public DisciplinaProfessor(int codigo, com.classes.XML.Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public com.classes.XML.Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
