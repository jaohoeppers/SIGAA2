package com.classes.DTO;

import java.util.Date;

public class Aula {

    int codigo;
    DisciplinaProfessor disciplinaProfessor;
    Date data;

    public Aula (DisciplinaProfessor disciplinaProfessor, Date data) {
        this.disciplinaProfessor = disciplinaProfessor;
        this.data = data;
    }

    public Aula (int codigo, DisciplinaProfessor disciplinaProfessor, Date data) {
        this.codigo = codigo;
        this.disciplinaProfessor = disciplinaProfessor;
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DisciplinaProfessor getDisciplinaProfessor() {
        return disciplinaProfessor;
    }

    public void setDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
        this.disciplinaProfessor = disciplinaProfessor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
