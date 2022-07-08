package services;

import dao.DAOFactory;
import dao.EditoraDAO;
import model.Editora;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aug
 */
public class EditoraServices {

    public void cadEditora(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }

    public ArrayList<Editora> getEditoras() throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.buscarEditoras();
    }

    public boolean verGerente(String gerente) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.verGerente(gerente);
    }

    public Editora buscarEditoraBD(String gerente) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getByGerenteBD(gerente);
    }

    public void deletarEditoraBD(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.deletarEditora(id);
    }

    public void atualizarEditoraBD(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.atualizarEditora(eVO);
    }

    public String getNomeEditora(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getNomeEditora(id);
    }

    public Editora getEditoraById(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getEditoraById(id);
    }
}
