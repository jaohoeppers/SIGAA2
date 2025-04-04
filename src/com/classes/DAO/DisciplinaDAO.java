package com.classes.DAO;

import com.classes.BO.FaseBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    final String NOMEDATABELA = "disciplina";
    final FaseBO faseBO = new FaseBO();

    public boolean inserir(Disciplina Disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome, ativa, id_fase) VALUES (?,?,?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Disciplina.getNome());
            ps.setBoolean(2, Disciplina.getAtiva());
            ps.setInt(3, Disciplina.getFase().getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarNome(Disciplina Disciplina, String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, Disciplina.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(Disciplina Disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET ativa = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, Disciplina.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public Disciplina procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Disciplina obj = new Disciplina(rs.getInt("id"),rs.getString("nome"),rs.getBoolean("ativa"),faseBO.procurarPorCodigo(rs.getInt("id_fase")));
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
                System.out.println("Disciplina não encontrada");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public Disciplina procurarPorNome(String nome) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Disciplina obj = new Disciplina(rs.getInt("id"),rs.getString("nome"),rs.getBoolean("ativa"),faseBO.procurarPorCodigo(rs.getInt("id_fase")));
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
                System.out.println("Disciplina não encontrada");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List<Disciplina> procurarPorIdFase(int id) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_fase = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Disciplina> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
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
    public List<Disciplina> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Disciplina> listObj = montarLista(rs);
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Disciplina> montarLista(ResultSet rs) {
        List<Disciplina> listObj = new ArrayList<Disciplina>();
        try {
            while (rs.next()) {
                Disciplina obj = new Disciplina(rs.getInt("id")
                        ,rs.getString("nome")
                        ,rs.getBoolean("ativa")
                        ,faseBO.procurarPorCodigo(rs.getInt("id_fase")));

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