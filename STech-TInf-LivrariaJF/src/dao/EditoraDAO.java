package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author aug
 */
public class EditoraDAO {

    public void cadastrarEditora(Editora eVO) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "insert into editora values (null, '" + eVO.getNomeEditora() + "', '" + eVO.getEndereco() + "', '" + eVO.getTelefone() + "', '" + eVO.getGerente() + "' ";
            state.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Deu erro!.. xiiii \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public ArrayList<Editora> buscarEditoras() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "select * from editora";

            ResultSet resSet = state.executeQuery(sql);
            ArrayList<Editora> editoras = new ArrayList<>();
            while (resSet.next()) {
                Editora ed = new Editora();
                ed.setIdEditora(resSet.getInt("idEditora"));
                ed.setNomeEditora(resSet.getString("nomeEdit"));
                ed.setEndereco(resSet.getString("Endereco"));
                ed.setTelefone(resSet.getString("telefone"));
                ed.setGerente(resSet.getString("Gerente"));
                editoras.add(ed);
            }
            return editoras;
        } catch (SQLException e) {
            throw new SQLException("Deu erro!.. xiiii \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public void deletarEditora(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        try {
            String sql;
            sql = "delete from editora where idEditora = " + id;
            state.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Editora. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public void atualizarEditora(Editora eVO) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "update editora set " + "nomeEditora = '" + eVO.getNomeEditora() + "', '" + eVO.getEndereco() + "', '" + eVO.getTelefone() + "', '" + eVO.getGerente();
            state.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Editora. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public String getNomeEditora(int id) throws SQLException {
        String nomeEdit = null;
        try {
            for (Editora edit : buscarEditoras()) {
                if (edit.getIdEditora() == id) {
                    nomeEdit = edit.getNomeEditora();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este id ñ existe! \n " + e.getMessage());
        }
        return nomeEdit;
    }

    public Editora getEditoraById(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        Editora ed = new Editora();

        try {
            String sql;
            sql = "select * from editora where idEditora = " + id;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                ed.setIdEditora(resSet.getInt("idEditora"));
                ed.setNomeEditora(resSet.getString("nomeEdit"));
                ed.setEndereco(resSet.getString("endereco"));
                ed.setTelefone(resSet.getString("telefone"));
                ed.setGerente(resSet.getString("gerente"));
            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este id não existe. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }

        return ed;
    }
    
    public boolean verGerente(String gerente) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        boolean verGerente = false;

        try {
            String sql;
            sql = "select gerente from editora where gerente = " + gerente;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                verGerente = resSet.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhuma editora com este gerente D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return verGerente;
    }
    
    public Editora getByGerenteBD(String gerente) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        Editora ed = new Editora();

        try {
            String sql;
            sql = "select * from editora where gerente = " + gerente;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                ed.setIdEditora(resSet.getInt("idEditora"));
                ed.setNomeEditora(resSet.getString("nomeEditora"));
                ed.setEndereco(resSet.getString("endereco"));
                ed.setTelefone(resSet.getString("telefone"));
                ed.setGerente(resSet.getString("gerente"));
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhuma editora com este gerente D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return ed;
    }
}
