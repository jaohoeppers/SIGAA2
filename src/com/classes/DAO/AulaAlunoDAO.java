package com.classes.DAO;

import com.classes.BO.AlunoBO;
import com.classes.BO.AulaBO;
import com.classes.BO.DisciplinaProfessorBO;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Aula;
import com.classes.DTO.AulaAluno;
import com.classes.DTO.AulaAluno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AulaAlunoDAO {

    final String NOMEDATABELA = "aula_aluno";
    final AulaBO aulaBO = new AulaBO();
    final AlunoBO alunoBO = new AlunoBO();

    public boolean inserir(AulaAluno AulaAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (presente, id_aula, id_aluno) VALUES (?,?,?);";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, AulaAluno.getPresente());
            ps.setInt(2, AulaAluno.getAula().getCodigo());
            ps.setInt(3, AulaAluno.getAluno().getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean inserirAvaliacao(AulaAluno AulaAluno, double nota) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET avaliacao = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, AulaAluno.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarPresente(AulaAluno AulaAluno, Boolean presente) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET presente = ? WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, presente);
            ps.setInt(2, AulaAluno.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(AulaAluno AulaAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, AulaAluno.getCodigo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public AulaAluno procurarPorCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AulaAluno obj = new AulaAluno(rs.getInt("id")
                        ,aulaBO.procurarPorCodigo(rs.getInt("id_aula"))
                        ,alunoBO.procurarPorCodigo(rs.getInt("id_aluno"))
                        , rs.getBoolean("presente")
                        , rs.getDouble("avaliacao"));
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
                System.out.println("Registro não encontrado");
                return null;
            }
        } catch (Exception e) {
        	 e.printStackTrace();
             return null;
        }
    }
    public List<AulaAluno> procurarPorIdAluno(int id) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_aluno = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<AulaAluno> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public List<AulaAluno> procurarPorIdAula(int id) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id_aula = ?;";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<AulaAluno> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    public AulaAluno procurarPorIdAulaIdAluno(int idAula, int idAluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE (id_aula = ? AND id_aluno = ? );";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAula);
            ps.setInt(2, idAluno);
            ResultSet rs = ps.executeQuery();
            AulaAluno obj = new AulaAluno(rs.getInt("id")
                    , aulaBO.procurarPorCodigo(rs.getInt("id_aula"))
                    , alunoBO.procurarPorCodigo(rs.getInt("id_aluno"))
                    , rs.getBoolean("presente")
                    , rs.getDouble("avaliacao"));
            ps.close();
            rs.close();
            conn.close();
            return obj;
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
    public List<AulaAluno> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            assert conn != null:
                    "Connection is null. Check your database connection settings in the application properties file.";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<AulaAluno> listObj = montarLista(rs);
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AulaAluno> montarLista(ResultSet rs) {
        List<AulaAluno> listObj = new ArrayList<AulaAluno>();
        try {
            while (rs.next()) {
                AulaAluno obj = new AulaAluno(rs.getInt("id")
                        ,aulaBO.procurarPorCodigo(rs.getInt("id_aula"))
                        ,alunoBO.procurarPorCodigo(rs.getInt("id_aluno"))
                        , rs.getBoolean("presente")
                        , rs.getDouble("avaliacao"));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}