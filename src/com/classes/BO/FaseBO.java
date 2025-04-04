package com.classes.BO;

import com.classes.DAO.FaseDAO;
import com.classes.DTO.Curso;
import com.classes.DTO.Fase;

import java.util.List;

public class FaseBO {

    public boolean inserir(Fase Fase){
        if (!existeFaseANDCurso(Fase.getNome(), Fase.getCurso())) {
            FaseDAO FaseDAO = new FaseDAO();
            return FaseDAO.inserir(Fase);
        }
        System.out.println("Cadastro ja existe");
        return false;
    }
    public boolean alterarNome(Fase Fase, String nome){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.alterarNome(Fase, nome);
    }
    public boolean excluir(Fase Fase){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.excluir(Fase);
    }
    public Fase procurarPorCodigo(int codigo){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.procurarPorCodigo(codigo);
    }
    public List<Fase> procurarPorNome(String nome){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.procurarPorNome(nome);
    }
    public List<Fase> procurarPorIdCurso(int id){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.procurarPorIdCurso(id);
    }
    public boolean existeFaseANDCurso(String nome, Curso curso){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.existeFaseANDCurso(nome, curso);
    }
    public List<Fase> pesquisarTodos(){
        FaseDAO FaseDAO = new FaseDAO();
        return FaseDAO.pesquisarTodos();
    }
}