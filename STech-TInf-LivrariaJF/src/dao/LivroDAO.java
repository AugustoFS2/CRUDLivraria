package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author aug
 */
public class LivroDAO {

    public void cadastrarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "insert into livro values (null, '" + lVO.getTitulo() + "', '" + lVO.getAutor() + "', '" + lVO.getAssunto() + "', '" + lVO.getIsbn() + "', " + lVO.getEstoque() + ", " + lVO.getPreco() + ", " + lVO.getIdEditora();
            state.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Deu erro!.. xiiii \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public ArrayList<Livro> buscarLivros() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "select * from livro";

            ResultSet resSet = state.executeQuery(sql);
            ArrayList<Livro> livros = new ArrayList<>();
            while (resSet.next()) {
                Livro l = new Livro();
                l.setIdLivro(resSet.getInt("idLivro"));
                l.setTitulo(resSet.getString("titulo"));
                l.setTitulo(resSet.getString("autor"));
                l.setAssunto(resSet.getString("assunto"));
                l.setIsbn(resSet.getString("Isbn"));
                l.setEstoque(resSet.getInt("estoque"));
                l.setPreco(resSet.getFloat("preco"));
                l.setIdEditora(resSet.getInt("idEditora"));
                livros.add(l);
            }
            return livros;
        } catch (SQLException e) {
            throw new SQLException("Deu erro!.. xiiii \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public boolean verIsbn(String isbn) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        boolean verISBN = false;

        try {
            String sql;
            sql = "Select isbn from livro where isbn = " + isbn;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                verISBN = resSet.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhum livro com este isbn D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return verISBN;
    }

    public Livro getByIsbnBD(String isbn) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        Livro l = new Livro();

        try {
            String sql;
            sql = "Select * from livro where isbn = " + isbn;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                l.setIdLivro(resSet.getInt("idLivro"));
                l.setTitulo(resSet.getString("titulo"));
                l.setTitulo(resSet.getString("autor"));
                l.setAssunto(resSet.getString("assunto"));
                l.setIsbn(resSet.getString("Isbn"));
                l.setEstoque(resSet.getInt("estoque"));
                l.setPreco(resSet.getFloat("preco"));
                l.setIdEditora(resSet.getInt("idEditora"));
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhum livro com este ISBN D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return l;
    }

    public void deletarLivro(int id) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        try {
            String sql;
            sql = "delete from pessoa where idLivro = " + id;
            state.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Livro. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public void atualizarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "update livro set " + "titulo = '" + lVO.getTitulo() + "', '" + lVO.getAutor() + "', '" + lVO.getAssunto() + "', '" + lVO.getIsbn() + "', " + lVO.getEstoque() + ", " + lVO.getPreco() + " " + "where idEditora = " + lVO.getIdEditora();
            state.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Pessoa. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public String getTitulo(int id) throws SQLException {
        String titulo = null;
        try {
            for (Livro liv : buscarLivros()) {
                if (liv.getIdLivro() == id) {
                    titulo = liv.getTitulo();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Livro com este id ñ existe! \n " + e.getMessage());
        }
        return titulo;
    }

    public Livro getLivroById(int id) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        Livro l = new Livro();

        try {
            String sql;
            sql = "select * from pessoa where idPessoa = " + id;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                //lado do java |x| lado do banco
                l.setIdLivro(resSet.getInt("idLivro"));
                l.setTitulo(resSet.getString("titulo"));
                l.setTitulo(resSet.getString("autor"));
                l.setAssunto(resSet.getString("assunto"));
                l.setIsbn(resSet.getString("Isbn"));
                l.setEstoque(resSet.getInt("estoque"));
                l.setPreco(resSet.getFloat("preco"));
                l.setIdEditora(resSet.getInt("idEditora"));
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este id não existe. \n"
                    + e.getMessage());
        } finally {
            con.close();
            state.close();
        }

        return l;
    }
}
