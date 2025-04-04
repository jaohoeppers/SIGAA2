package com.classes.BO;

import com.classes.DAO.AulaDAO;
import com.classes.DTO.Aula;

import java.util.Date;
import java.util.List;

public class AulaBO {

    public boolean inserir(Aula Aula){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.inserir(Aula);
    }
    public boolean alterarData(Aula Aula, Date data){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.alterarData(Aula,data);
    }
    public boolean excluir(Aula Aula){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.excluir(Aula);
    }
    public Aula procurarPorCodigo(int codigo){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.procurarPorCodigo(codigo);
    }
    public List<Aula> procurarPorIdDisciplinaProfessor(int codigo){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.procurarPorIdDisciplinaProfessor(codigo);
    }
    public List<Aula> procurarPorIdDisciplinaProfessorANDData(int codigo, Date data){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.procurarPorIdDisciplinaProfessorANDData(codigo, data);
    }
    public List<Aula> pesquisarTodos(){
        AulaDAO AulaDAO = new AulaDAO();
        return AulaDAO.pesquisarTodos();
    }
}