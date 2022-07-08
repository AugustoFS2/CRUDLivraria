package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aug
 */
public class Conexao {
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String user = "livraria";
    private static String pass = "";
    
    public static Connection getConexao() throws SQLException{
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e){
            throw new SQLException("Erro ao conectar! D: \n" + e.getMessage());
        }
        return con;
    }
}