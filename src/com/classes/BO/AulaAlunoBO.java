package com.classes.BO;

import com.classes.DAO.AulaAlunoDAO;
import com.classes.DTO.AulaAluno;

import java.util.Date;
import java.util.List;

public class AulaAlunoBO {

    public boolean inserir(AulaAluno AulaAluno){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.inserir(AulaAluno);
    }
    public boolean inserirAvaliacao(AulaAluno AulaAluno, Double nota){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.inserirAvaliacao(AulaAluno, nota);
    }
    public boolean alterarPresente(AulaAluno AulaAluno, boolean presente){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.alterarPresente(AulaAluno,presente);
    }
    public boolean excluir(AulaAluno AulaAluno){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.excluir(AulaAluno);
    }
    public AulaAluno procurarPorCodigo(int codigo){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.procurarPorCodigo(codigo);
    }
    public List<AulaAluno> procurarPorIdAluno(int codigo){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.procurarPorIdAluno(codigo);
    }
    public List<AulaAluno> procurarPorIdAula(int codigo){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.procurarPorIdAula(codigo);
    }
    public List<AulaAluno> pesquisarTodos(){
        AulaAlunoDAO AulaAlunoDAO = new AulaAlunoDAO();
        return AulaAlunoDAO.pesquisarTodos();
    }
}