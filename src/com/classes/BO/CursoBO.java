package com.classes.BO;

import com.classes.DAO.CursoDAO;
import com.classes.DTO.Curso;

import java.util.List;

public class CursoBO {

    public boolean inserir(Curso Curso){
        if (!existeNome(Curso.getNome())) {
            CursoDAO CursoDAO = new CursoDAO();
            return CursoDAO.inserir(Curso);
        }
        System.out.println("Cadastro ja existe");
        return false;
    }
    public boolean alterarNome(Curso Curso, String nome){
        CursoDAO CursoDAO = new CursoDAO();
        return CursoDAO.alterarNome(Curso,nome);
    }
    public boolean excluir(Curso Curso){
        CursoDAO CursoDAO = new CursoDAO();
        return CursoDAO.excluir(Curso);
    }
    public Curso procurarPorCodigo(int codigo){
        CursoDAO CursoDAO = new CursoDAO();
        return CursoDAO.procurarPorCodigo(codigo);
    }
    public Curso procurarPorNome(String nome){
        CursoDAO CursoDAO = new CursoDAO();
        return CursoDAO.procurarPorNome(nome);
    }
    public boolean existeNome(String nome){
        CursoDAO CursoDAO = new CursoDAO();
        return CursoDAO.existeNome(nome);
    }
    public List<Curso> pesquisarTodos(){
        CursoDAO CursoDAO = new CursoDAO();
        return CursoDAO.pesquisarTodos();
    }
}