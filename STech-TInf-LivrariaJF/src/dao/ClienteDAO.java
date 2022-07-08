package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author aug
 */
public class ClienteDAO {

    public void cadastrarCliente(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "insert into cliente values (null, '" + cVO.getNomeCliente() + "', '" + cVO.getCpf() + "', '" + cVO.getCnpj() + "', '" + cVO.getEndereco() + "', '" + cVO.getTelefone();
            state.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Deu erro!.. xiiii \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public ArrayList<Cliente> buscarClientes() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "select * from cliente";

            ResultSet resSet = state.executeQuery(sql);
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (resSet.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(resSet.getInt("idCliente"));
                cli.setNomeCliente(resSet.getString("nomeCliente"));
                cli.setCpf(resSet.getString("cpf"));
                cli.setCnpj(resSet.getString("cnpj"));
                cli.setEndereco(resSet.getString("Endereco"));
                cli.setTelefone(resSet.getString("telefone"));
                clientes.add(cli);
            }
            return clientes;
        } catch (SQLException e) {
            throw new SQLException("Deu erro!.. xiiii \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public void atualizarCliente(Cliente cVO) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();

        try {
            String sql;
            sql = "update cliente set " + "nomeCliente = '" + cVO.getNomeCliente() + "', '" + cVO.getCpf() + "', '" + cVO.getCnpj() + "', '" + cVO.getEndereco() + "', '" + cVO.getTelefone();
            state.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Cliente. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public void deletarCliente(int id) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        try {
            String sql;
            sql = "Delete from cliente where idCliente = " + id;
            state.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Cliente. \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
    }

    public Cliente getByDocBD(String cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        Cliente cli = new Cliente();

        try {
            String sql;
            sql = "Select * from cliente where cpf = " + cpf;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                cli.setIdCliente(resSet.getInt("idCliente"));
                cli.setNomeCliente(resSet.getString("nomeCliente"));
                cli.setCpf(resSet.getString("cpf"));
                cli.setCnpj(resSet.getString("cnpj"));
                cli.setEndereco(resSet.getString("Endereco"));
                cli.setTelefone(resSet.getString("telefone"));
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhum cliente com este CPF D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return cli;
    }

    public Cliente getClienteById(int id) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        Cliente cli = new Cliente();

        try {
            String sql;
            sql = "select * from cliente where idCliente = " + id;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                //lado do java |x| lado do banco
                cli.setIdCliente(rs.getInt("idCliente"));
                cli.setNomeCliente(rs.getString("nomeCliente"));
                cli.setCpf(rs.getString("cpf"));
                cli.setCnpj(rs.getString("cnpj"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este id não existe. \n"
                    + e.getMessage());
        } finally {
            con.close();
            state.close();
        }

        return cli;
    }
    
    public String getNomeCliente(int id) throws SQLException {
        String nomeCliente = null;
        try {
            for (Cliente cli : buscarClientes()) {
                if (cli.getIdCliente() == id) {
                    nomeCliente = cli.getNomeCliente();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este id ñ existe! \n " + e.getMessage());
        }
        return nomeCliente;
    }
    
    public boolean verCNPJ(String cnpj) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        boolean verCNPJ = false;

        try {
            String sql;
            sql = "Select cpf from cliente where cpf = " + cnpj;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                verCNPJ = resSet.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhum cliente com este CNPJ D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return verCNPJ;
    }

    public boolean verCPF(String cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement state = con.createStatement();
        boolean verCPF = false;

        try {
            String sql;
            sql = "Select cpf from cliente where cpf = " + cpf;
            ResultSet resSet = state.executeQuery(sql);
            while (resSet.next()) {
                verCPF = resSet.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Nenhum cliente com este CPF D: \n" + e.getMessage());
        } finally {
            con.close();
            state.close();
        }
        return verCPF;
    }

}
