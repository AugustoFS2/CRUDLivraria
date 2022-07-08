package services;

import dao.ClienteDAO;
import dao.DAOFactory;
import model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aug
 */
public class ClienteServices {

    public void cadCliente(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarCliente(cVO);
    }

    public ArrayList<Cliente> getClientes() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.buscarClientes();
    }

    public boolean verCPF(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.verCPF(cpf);
    }

    public Cliente buscarClienteBD(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getByDocBD(cpf);
    }

    public void deletarClienteBD(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.deletarCliente(id);
    }

    public void atualizarClienteBD(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.atualizarCliente(cVO);
    }

    public String getNomeCliente(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getNomeCliente(id);
    }

    public Cliente getClienteById(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getClienteById(id);
    }
}
