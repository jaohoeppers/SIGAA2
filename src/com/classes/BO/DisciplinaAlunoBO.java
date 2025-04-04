package com.classes.BO;

import com.classes.DAO.DisciplinaAlunoDAO;
import com.classes.DTO.DisciplinaAluno;

import java.util.List;

public class DisciplinaAlunoBO {

    public boolean inserir(DisciplinaAluno DisciplinaAluno){
        if (!existeDisciplinaAluno(DisciplinaAluno.getDisciplina().getCodigo(), DisciplinaAluno.getAluno().getCodigo())) {
            DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
            return DisciplinaAlunoDAO.inserir(DisciplinaAluno);
        }
        System.out.println("Cadastro ja existe");
        return false;
    }
//    public boolean alterarNome(DisciplinaAluno DisciplinaAluno, String nome){
//        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
//        return DisciplinaAlunoDAO.alterarNome(DisciplinaAluno, nome);
//    }
    public boolean excluir(DisciplinaAluno DisciplinaAluno){
        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
        return DisciplinaAlunoDAO.excluir(DisciplinaAluno);
    }
    public DisciplinaAluno procurarPorCodigo(int codigo){
        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
        return DisciplinaAlunoDAO.procurarPorCodigo(codigo);
    }
    public List<DisciplinaAluno> procurarPorIdAluno(int idAluno){
        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
        return DisciplinaAlunoDAO.procurarPorIdAluno(idAluno);
    }
    public List<DisciplinaAluno> procurarPorIdDisciplina(int idDisciplina){
        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
        return DisciplinaAlunoDAO.procurarPorIdDisciplina(idDisciplina);
    }
    public boolean existeDisciplinaAluno(int idDisciplina, int idAluno){
        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
        return DisciplinaAlunoDAO.existeDisciplinaAluno(idDisciplina, idAluno);
    }
    public List<DisciplinaAluno> pesquisarTodos(){
        DisciplinaAlunoDAO DisciplinaAlunoDAO = new DisciplinaAlunoDAO();
        return DisciplinaAlunoDAO.pesquisarTodos();
    }
}