import javax.swing.JOptionPane;
import service.MenuAdm;


public class App {
    public static void main(String[] args) throws Exception {
        // Tela de boas-vindas
        JOptionPane.showMessageDialog(null, "Bem-vindo Eduardo, deus nos ajude (amem)! login 123 senha 123 " );
        MenuAdm.exibirMenu();
    }
}
