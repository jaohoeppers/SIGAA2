package com.classes.DAO;

import com.classes.BO.DisciplinaProfessorBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Aula;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {

    final String NOMEDATABELA = "aula";
    final DisciplinaProfessorBO disciplinaProfessorBO = new DisciplinaProfessorBO();

    public boolean inserir(Aula Aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (id_disciplina_professor, data) VALUES (?,?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Aula.getDisciplinaProfessor().getCodigo());
            ps.setDate(2, new java.sql.Date(Aula.getData().getTime()));
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarData(Aula Aula, java.util.Date data) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET data = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(Aula.getData().getTime()));
            ps.setInt(2, Aula.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(Aula Aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Aula.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public Aula procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aula obj = new Aula(rs.getInt("id")
                        ,disciplinaProfessorBO.procurarPorCodigo(rs.getInt("id_disciplina_professor"))
                        , rs.getDate("data"));
//                obj.setCodigo(rs.getInt(1));
//                obj.setDescricao(rs.getString(2));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                System.out.println("Aula não encontrada");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public List<Aula> procurarPorIdDisciplinaProfessor(int id) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_disciplina_professor = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Aula> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Aula> procurarPorIdDisciplinaProfessorANDData(int id, java.util.Date data) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE (id_disciplina_professor = ? AND data = ? );";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, new java.sql.Date(data.getTime()));
            ResultSet rs = ps.executeQuery();
            List<Aula> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
//    public boolean existeNome(String nome) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
//            assert conn != null :
//                    "Connection is null. Check your database connection settings in the application properties file.";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, nome);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                ps.close();
//                rs.close();
//                conn.close();
//                return true;
//            }
//        } catch (Exception e) {
//           e.printStackTrace();
//            return false;
//        }
//        return false;
//    }
    public List<Aula> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aula> listObj = montarLista(rs);
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Aula> montarLista(ResultSet rs) {
        List<Aula> listObj = new ArrayList<Aula>();
        try {
            while (rs.next()) {
                Aula obj = new Aula(rs.getInt("id")
                        ,disciplinaProfessorBO.procurarPorCodigo(rs.getInt("id_disciplina_professor"))
                        , rs.getDate("data"));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}