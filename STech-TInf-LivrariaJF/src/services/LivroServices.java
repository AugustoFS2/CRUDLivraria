package services;

import dao.DAOFactory;
import dao.LivroDAO;
import model.Livro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aug
 */
public class LivroServices {

    public void cadLivro(Livro lVO) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.cadastrarLivro(lVO);
    }

    public ArrayList<Livro> getLivros() throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.buscarLivros();
    }

    public boolean verIsbn(String isbn) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.verIsbn(isbn);
    }

    public Livro buscarLivroBD(String isbn) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getByIsbnBD(isbn);
    }

    public void deletarLivroBD(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.deletarLivro(id);
    }

    public void atualizarLivroBD(Livro lVO) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.atualizarLivro(lVO);
    }

    public String getTitulo(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getTitulo(id);
    }

    public Livro getLivroById(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getLivroById(id);
    }
}
