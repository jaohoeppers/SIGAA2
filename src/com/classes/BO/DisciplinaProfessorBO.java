package com.classes.BO;

import com.classes.DAO.DisciplinaProfessorDAO;
import com.classes.DTO.DisciplinaProfessor;

import java.util.List;

public class DisciplinaProfessorBO {

    public boolean inserir(DisciplinaProfessor DisciplinaProfessor){
        if (!existeDisciplinaProfessor(DisciplinaProfessor.getDisciplina().getCodigo(), DisciplinaProfessor.getProfessor().getCodigo())
            && !existe4ProfessorDisciplina(DisciplinaProfessor.getDisciplina().getCodigo())) {
            DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
            return DisciplinaProfessorDAO.inserir(DisciplinaProfessor);
        }
        return false;
    }
//    public boolean alterarNome(DisciplinaProfessor DisciplinaProfessor, String nome){
//        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
//        return DisciplinaProfessorDAO.alterarNome(DisciplinaProfessor, nome);
//    }
    public boolean excluir(DisciplinaProfessor DisciplinaProfessor){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.excluir(DisciplinaProfessor);
    }
    public DisciplinaProfessor procurarPorCodigo(int codigo){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.procurarPorCodigo(codigo);
    }
    public List<DisciplinaProfessor> procurarPorIdDisciplina(int codigo){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.procurarPorIdDisciplina(codigo);
    }
    public List<DisciplinaProfessor> procurarPorIdProfessor(int codigo){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.procurarPorIdProfessor(codigo);
    }
//    public DisciplinaProfessor procurarPorNome(String nome){
//        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
//        return DisciplinaProfessorDAO.procurarPorNome(nome);
//    }
    public DisciplinaProfessor procurarPorIdDisciplinaIdProfessor(int idDisciplina, int idProfessor){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.procurarPorIdDisciplinaIdProfessor(idDisciplina, idProfessor);
    }
    public boolean existeDisciplinaProfessor(int idDisciplina, int idProfessor){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.existeDisciplinaProfessor(idDisciplina, idProfessor);
    }
    public boolean existe4ProfessorDisciplina(int idDisciplina){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.existe4ProfessorDisciplina(idDisciplina);
    }
    public List<DisciplinaProfessor> pesquisarTodos(){
        DisciplinaProfessorDAO DisciplinaProfessorDAO = new DisciplinaProfessorDAO();
        return DisciplinaProfessorDAO.pesquisarTodos();
    }
}