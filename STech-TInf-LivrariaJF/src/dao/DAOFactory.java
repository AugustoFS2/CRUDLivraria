package dao;

/**
 *
 * @author aug
 */
public class DAOFactory {
    public static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static ClienteDAO getClienteDAO() {
        return clienteDAO;
    }
    
    private static EditoraDAO editoraDAO = new EditoraDAO();
    
    public static EditoraDAO getEditoraDAO() {
        return editoraDAO;
    }
    
    private static LivroDAO livroDAO = new LivroDAO();
    
    public static LivroDAO getLivroDAO() {
        return livroDAO;
    }
}
