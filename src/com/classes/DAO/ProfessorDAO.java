package com.classes.DAO;

import com.classes.BO.CursoBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    final String NOMEDATABELA = "professor";

    public boolean inserir(Professor Professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome) VALUES (?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Professor.getNome());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarNome(Professor Professor, String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, Professor.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(Professor Professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Professor.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public Professor procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor obj = new Professor(rs.getInt(1),rs.getString(2));
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
                System.out.println("Professor não encontrado");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public Professor procurarPorNome(String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor obj = new Professor(rs.getInt(1),rs.getString(2));
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
                System.out.println("Professor não encontrado");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public boolean existeNome(String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            assert conn != null :
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
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
    public List<Professor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Professor> listObj = montarLista(rs);
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Professor> montarLista(ResultSet rs) {
        List<Professor> listObj = new ArrayList<Professor>();
        try {
            while (rs.next()) {
                Professor obj = new Professor(rs.getInt("id")
                        ,rs.getString("nome"));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}