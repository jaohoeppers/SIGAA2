package com.classes.DTO;

public class Disciplina {

    int codigo;
    String nome;
    Boolean ativa;
    Fase fase;

    public Disciplina(String nome, Boolean ativa, Fase fase) {
        this.nome = nome;
        this.ativa = ativa;
        this.fase = fase;
    }

    public Disciplina(int codigo, String nome, Boolean ativa, Fase fase) {
        this.codigo = codigo;
        this.nome = nome;
        this.ativa = ativa;
        this.fase = fase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
