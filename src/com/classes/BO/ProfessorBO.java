package com.classes.BO;

import com.classes.DAO.ProfessorDAO;
import com.classes.DTO.Professor;

import java.util.List;

public class ProfessorBO {

    public boolean inserir(Professor Professor){
        if (!existeNome(Professor.getNome())) {
            ProfessorDAO ProfessorDAO = new ProfessorDAO();
            return ProfessorDAO.inserir(Professor);
        }
        System.out.println("Cadastro ja existe");
        return false;
    }
    public boolean alterarNome(Professor Professor, String nome){
        ProfessorDAO ProfessorDAO = new ProfessorDAO();
        return ProfessorDAO.alterarNome(Professor, nome);
    }
    public boolean excluir(Professor Professor){
        ProfessorDAO ProfessorDAO = new ProfessorDAO();
        return ProfessorDAO.excluir(Professor);
    }
    public Professor procurarPorCodigo(int codigo){
        ProfessorDAO ProfessorDAO = new ProfessorDAO();
        return ProfessorDAO.procurarPorCodigo(codigo);
    }
    public Professor procurarPorNome(String nome){
        ProfessorDAO ProfessorDAO = new ProfessorDAO();
        return ProfessorDAO.procurarPorNome(nome);
    }
    public boolean existeNome(String nome){
        ProfessorDAO ProfessorDAO = new ProfessorDAO();
        return ProfessorDAO.existeNome(nome);
    }
    public List<Professor> pesquisarTodos(){
        ProfessorDAO ProfessorDAO = new ProfessorDAO();
        return ProfessorDAO.pesquisarTodos();
    }
}