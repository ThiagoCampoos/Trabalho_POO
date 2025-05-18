package service;

import javax.swing.JOptionPane;

import dao.PessoaDAO;
import dao.UsuarioDAO;
import model.Pessoa;
import model.Usuario;

public class LoginService {
    private static Pessoa usuarioLogado;

    public static Pessoa autenticar(String login, String senha) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO(); // Adicionado UsuarioDAO

        for (Pessoa pessoa : pessoaDAO.listarTodos()) {
            if (pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                usuarioLogado = pessoa; // Pessoa básica encontrada

                // Buscar o tipo de usuário a partir da tabela Usuario
                // Uma pessoa pode ter múltiplos papéis em diferentes escolas.
                Usuario[] vinculosUsuario = usuarioDAO.listarTodos(); // Idealmente, um método buscarPorPessoaId(pessoa.getId())
                String tipoUsuarioPrincipal = null;

                for (Usuario vinculo : vinculosUsuario) {
                    if (vinculo.getPessoaId() == pessoa.getId()) {
                        // Lógica para determinar o tipo principal se houver múltiplos.
                        // Se o usuário for ADMIN, este deve prevalecer.
                        if ("ADMIN".equals(vinculo.getTipo())) {
                            tipoUsuarioPrincipal = vinculo.getTipo();
                            break; // ADMIN tem prioridade máxima
                        }
                        if (tipoUsuarioPrincipal == null || "ADMIN_ESCOLA".equals(vinculo.getTipo())){
                            tipoUsuarioPrincipal = vinculo.getTipo(); // ADMIN_ESCOLA tem prioridade sobre outros
                        } else if (tipoUsuarioPrincipal == null) {
                            tipoUsuarioPrincipal = vinculo.getTipo();
                        }
                    }
                }

                if (tipoUsuarioPrincipal != null) {
                    usuarioLogado.setTipo(tipoUsuarioPrincipal);
                } else {
                    // Se não houver tipo de usuário, definir como "FUNCIONARIO"
                    if (pessoa.getTipo() == null) { // Se o tipo não foi pré-definido (ex: admin inicial)
                        // Definir um tipo padrão ou negar o acesso
                        if (!"ADMIN".equals(pessoa.getTipo())) {
                           pessoa.setTipo("FUNCIONARIO"); // Fallback genérico
                        }
                    }
                }
                return usuarioLogado;
            }
        }
        return null;
    }

    public static Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public static boolean fazerLogin() {
        String login = JOptionPane.showInputDialog("Digite seu login:");
        String senha = JOptionPane.showInputDialog("Digite sua senha:");
        
        Pessoa usuario = autenticar(login, senha);
        if(usuario != null) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
            return false;
        }
    }
}
