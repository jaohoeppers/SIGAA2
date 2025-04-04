package com.classes.DAO;

import com.classes.BO.DisciplinaBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.DisciplinaProfessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaProfessorDAO {

    final String NOMEDATABELA = "disciplina_professor";
    final ProfessorBO professorBO = new ProfessorBO();
    final DisciplinaBO disciplinaBO = new DisciplinaBO();

    public boolean inserir(DisciplinaProfessor DisciplinaProfessor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_professor , id_disciplina) VALUES (?,?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            var pro = professorBO.procurarPorNome(DisciplinaProfessor.getProfessor().getNome());
            ps.setInt(1, professorBO.procurarPorNome(DisciplinaProfessor.getProfessor().getNome()).getCodigo());
            var dis = disciplinaBO.procurarPorNome(DisciplinaProfessor.getDisciplina().getNome());
            ps.setInt(2, disciplinaBO.procurarPorNome(DisciplinaProfessor.getDisciplina().getNome()).getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//    public boolean alterarProfessor(DisciplinaProfessor DisciplinaProfessor, String nome) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE id = ?;";
//            assert conn != null:
//                    "Connection is null. Check your database connection settings in the application properties file.";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, nome);
//            ps.setInt(2, DisciplinaProfessor.getCodigo());
//            ps.executeUpdate();
//            ps.close();
//            conn.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public boolean excluir(DisciplinaProfessor DisciplinaProfessor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, DisciplinaProfessor.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public DisciplinaProfessor procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DisciplinaProfessor obj = new DisciplinaProfessor(rs.getInt(1)
                        ,professorBO.procurarPorCodigo(rs.getInt(2))
                        ,disciplinaBO.procurarPorCodigo(rs.getInt(3)));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                System.out.println("Disciplina Professor não encontrada");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public List<DisciplinaProfessor> procurarPorIdProfessor(int idProfessor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_professor = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProfessor);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaProfessor> listObj = montarLista(rs);
            conn.close();
            ps.close();
            rs.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<DisciplinaProfessor> procurarPorIdDisciplina(int idDisciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDisciplina);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaProfessor> listObj = montarLista(rs);
            conn.close();
            ps.close();
            rs.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public DisciplinaProfessor procurarPorIdDisciplinaIdProfessor(int idDisciplina, int idProfessor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE (id_disciplina = ? " + "AND id_professor = ? );";
            assert conn != null :
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDisciplina);
            ps.setInt(2, idProfessor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DisciplinaProfessor obj = new DisciplinaProfessor(rs.getInt(1)
                        ,professorBO.procurarPorCodigo(rs.getInt(2))
                        ,disciplinaBO.procurarPorCodigo(rs.getInt(3)));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                System.out.println("Disciplina Professor não encontrada");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean existeDisciplinaProfessor(int id_disciplina, int  idProfessor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE (id_disciplina = ? " + " AND " + "id_professor = ? );";
            assert conn != null :
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_disciplina);
            ps.setInt(2, idProfessor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                System.out.println("Professor ja tem essa disciplina cadastrada");
                return true;
            }
            ps.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }
        return false;
    }
    public boolean existe4ProfessorDisciplina(int id_disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina = ? ;";
            assert conn != null :
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_disciplina);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaProfessor> listObj = montarLista(rs);
            if (listObj.size() >= 4) {
                ps.close();
                rs.close();
                conn.close();
                System.out.println("Professor ja tem 4 disciplinas cadastradas");
                return true;
            }
            ps.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public List<DisciplinaProfessor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaProfessor> listObj = montarLista(rs);
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<DisciplinaProfessor> montarLista(ResultSet rs) {
        List<DisciplinaProfessor> listObj = new ArrayList<DisciplinaProfessor>();
        try {
            while (rs.next()) {
                DisciplinaProfessor obj = new DisciplinaProfessor(rs.getInt(1)
                        ,professorBO.procurarPorCodigo(rs.getInt(2))
                        ,disciplinaBO.procurarPorCodigo(rs.getInt(3)));
//                obj.setCodigo(rs.getInt(1));
//                obj.setDescricao(rs.getString(2));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}