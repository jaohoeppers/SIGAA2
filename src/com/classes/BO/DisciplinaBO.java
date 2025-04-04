package com.classes.BO;

import com.classes.DAO.DisciplinaDAO;
import com.classes.DTO.Disciplina;

import java.util.List;

public class DisciplinaBO {

    public boolean inserir(Disciplina Disciplina){
        if (!existeNome(Disciplina.getNome())) {
            DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
            return DisciplinaDAO.inserir(Disciplina);
        }
        System.out.println("Cadastro ja existe");
        return false;
    }
    public boolean alterarNome(Disciplina disciplina, String nome){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.alterarNome(disciplina, nome);
    }
    public boolean excluir(Disciplina Disciplina){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.excluir(Disciplina);
    }
    public Disciplina procurarPorCodigo(int codigo){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.procurarPorCodigo(codigo);
    }
    public Disciplina procurarPorNome(String nome){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.procurarPorNome(nome);
    }
    public List<Disciplina> procurarPorIdFase(int id){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.procurarPorIdFase(id);
    }
    public boolean existeNome(String nome){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.existeNome(nome);
    }
    public List<Disciplina> pesquisarTodos(){
        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();
        return DisciplinaDAO.pesquisarTodos();
    }
}