package com.classes.BO;

import com.classes.DAO.AlunoDAO;
import com.classes.DTO.Aluno;

import java.util.List;

public class AlunoBO {

    public boolean inserir(Aluno aluno){
        if (!existe(aluno)) {
            AlunoDAO alunoDAO = new AlunoDAO();
            return alunoDAO.inserir(aluno);
        }
        System.out.println("Cadastro ja existe");
        return false;
    }
    public boolean alterarNome(Aluno aluno, String nome){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.alterarNome(aluno, nome);
    }
    public boolean excluir(Aluno aluno){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.excluir(aluno);
    }
    public Aluno procurarPorCodigo(int codigo){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.procurarPorCodigo(codigo);
    }
    public Aluno procurarPorNome(String nome){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.procurarPorNome(nome);
    }
    public boolean existe(Aluno aluno){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.existe(aluno);
    }
    public List<Aluno> pesquisarTodos(){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.pesquisarTodos();
    }
}