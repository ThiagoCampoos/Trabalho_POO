import javax.swing.JOptionPane;
import service.MenuAdm;


public class App {
    public static void main(String[] args) throws Exception {
        // Tela de boas-vindas
        JOptionPane.showMessageDialog(null, "Bem-vindo Eduardo, deus nos ajude (amem)!" );

        // Exibir menu de opções
        MenuAdm menu = new MenuAdm();
        menu.exibirMenu();
    }
}
/*
 * // Administrador Geral
        criar(new Pessoa("Admin Geral", LocalDate.of(1980, 1, 1), "(11) 99999-0001", "admin", "123", "ADMIN"));
        
        // Administrador de Escola
        criar(new Pessoa("Admin Escola", LocalDate.of(1985, 2, 15), "(11) 99999-0002", "adminescola", "123", "ADMIN_ESCOLA"));
        
        // Professores (2)
        criar(new Pessoa("Carlos Oliveira", LocalDate.of(1975, 5, 20), "(11) 99999-0003", "carlos", "p1", "PROFESSOR"));
        criar(new Pessoa("Maria Santos", LocalDate.of(1980, 8, 10), "(11) 99999-0004", "maria", "p2", "PROFESSOR"));
        
        // Funcionários (3)
        criar(new Pessoa("Roberto Silva", LocalDate.of(1990, 3, 25), "(11) 99999-0005", "roberto", "f1", "FUNCIONARIO"));
        criar(new Pessoa("Ana Pereira", LocalDate.of(1988, 7, 12), "(11) 99999-0006", "ana", "f2", "FUNCIONARIO"));
        criar(new Pessoa("Paulo Souza", LocalDate.of(1992, 11, 5), "(11) 99999-0007", "paulo", "f3", "FUNCIONARIO"));
        
        // Alunos (5)
        criar(new Pessoa("João Silva", LocalDate.of(2000, 1, 15), "(11) 99999-0008", "joao", "a1", "ALUNO"));
        criar(new Pessoa("Maria Souza", LocalDate.of(2001, 2, 20), "(11) 99999-0009", "maria", "a2", "ALUNO"));
        criar(new Pessoa("Pedro Oliveira", LocalDate.of(2002, 3, 25), "(11) 99999-0010", "pedro", "a3", "ALUNO"));
        criar(new Pessoa("Lucia Santos", LocalDate.of(2003, 4, 30), "(11) 99999-0011", "lucia", "a4", "ALUNO"));
        criar(new Pessoa("Ricardo Lima", LocalDate.of(2004, 5, 5), "(11) 99999-0012", "ricardo", "a5", "ALUNO"));
 */