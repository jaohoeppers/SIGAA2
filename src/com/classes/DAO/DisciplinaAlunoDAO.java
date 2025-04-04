package com.classes.DAO;

import com.classes.BO.AlunoBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.ProfessorBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.DisciplinaAluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaAlunoDAO {

    final String NOMEDATABELA = "disciplina_aluno";
    final AlunoBO alunoBO = new AlunoBO();
    final DisciplinaBO disciplinaBO = new DisciplinaBO();

    public boolean inserir(DisciplinaAluno DisciplinaAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (status, id_aluno, id_disciplina) VALUES (?,?,?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, DisciplinaAluno.getStatus());
            ps.setInt(2, alunoBO.procurarPorNome(DisciplinaAluno.getAluno().getNome()).getCodigo());
            ps.setInt(3, disciplinaBO.procurarPorNome(DisciplinaAluno.getDisciplina().getNome()).getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//    public boolean alterarProfessor(DisciplinaAluno DisciplinaAluno, String nome) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE id = ?;";
//            assert conn != null:
//                    "Connection is null. Check your database connection settings in the application properties file.";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, nome);
//            ps.setInt(2, DisciplinaAluno.getCodigo());
//            ps.executeUpdate();
//            ps.close();
//            conn.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public boolean excluir(DisciplinaAluno DisciplinaAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, DisciplinaAluno.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public DisciplinaAluno procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DisciplinaAluno obj = new DisciplinaAluno(rs.getInt("id")
                        ,rs.getString("status")
                        ,alunoBO.procurarPorCodigo(rs.getInt("id_aluno"))
                        ,disciplinaBO.procurarPorCodigo(rs.getInt("id_disciplina")));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                System.out.println("Disciplina Aluno não encontrada");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public List<DisciplinaAluno> procurarPorIdAluno(int idAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_aluno = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAluno);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaAluno> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<DisciplinaAluno> procurarPorIdDisciplina(int idDisciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDisciplina);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaAluno> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<DisciplinaAluno> procurarPorStatus(String status) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE status = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaAluno> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean existeDisciplinaAluno(int idDisciplina, int idAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE (id_disciplina = ? AND id_aluno = ? );";
            assert conn != null :
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDisciplina);
            ps.setInt(2, idAluno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }
        return false;
    }
    public List<DisciplinaAluno> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<DisciplinaAluno> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<DisciplinaAluno> montarLista(ResultSet rs) {
        List<DisciplinaAluno> listObj = new ArrayList<DisciplinaAluno>();
        try {
            while (rs.next()) {
                DisciplinaAluno obj = new DisciplinaAluno(rs.getInt("id")
                        ,rs.getString("status")
                        ,alunoBO.procurarPorCodigo(rs.getInt("id_aluno"))
                        ,disciplinaBO.procurarPorCodigo(rs.getInt("id_disciplina")));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}