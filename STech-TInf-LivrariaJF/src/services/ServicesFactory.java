package services;

/**
 *
 * @author aug
 */
public class ServicesFactory {
    private static ClienteServices cliServs = new ClienteServices();

    public static ClienteServices getClienteServices() {
        return cliServs;
    }

    private static EditoraServices eServs = new EditoraServices();

    public static EditoraServices getEditoraServices() {
        return eServs;
    }
    
    private static LivroServices lServs = new LivroServices();
    
    public static LivroServices getLivroServices() {
        return lServs;
    }
}