package com.classes.DAO;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Curso;
import com.classes.DTO.Fase;
import com.classes.BO.CursoBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FaseDAO {

    final String NOMEDATABELA = "fase";
    final CursoBO cursoBO = new CursoBO();

    public boolean inserir(Fase Fase) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome, id_curso) VALUES (?,?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Fase.getNome());
            ps.setInt(2, cursoBO.procurarPorNome(Fase.getCurso().getNome()).getCodigo() );
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarNome(Fase Fase, String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, Fase.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(Fase Fase) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Fase.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public Fase procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Fase obj = new Fase(rs.getInt(1),rs.getString(2), cursoBO.procurarPorCodigo(rs.getInt(3)));
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
                System.out.println("Fase não encontrada");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public List<Fase> procurarPorNome(String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            List<Fase> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Fase> procurarPorIdCurso(int id) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_curso = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Fase> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean existeFaseANDCurso(String nome, Curso curso) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE (nome = ? AND id_curso = ?) ;);";
            assert conn != null :
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, cursoBO.procurarPorCodigo(curso.getCodigo()).getCodigo() );
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
    public List<Fase> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Fase> listObj = montarLista(rs);
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Fase> montarLista(ResultSet rs) {
        List<Fase> listObj = new ArrayList<Fase>();
        try {
            while (rs.next()) {
                Fase obj = new Fase(rs.getInt("id")
                        ,rs.getString("nome")
                        , cursoBO.procurarPorCodigo(rs.getInt("id_curso")));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}