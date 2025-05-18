package service;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void criarUsuario() {
        Usuario usuario = new Usuario();
        
        usuario.setPessoaId(Integer.parseInt(JOptionPane.showInputDialog("ID da Pessoa:")));
        usuario.setEscolaId(Integer.parseInt(JOptionPane.showInputDialog("ID da Escola:")));
        usuario.setTipo((String) JOptionPane.showInputDialog(null, "Tipo de usuário:", "Selecione", 
            JOptionPane.QUESTION_MESSAGE, null, new String[]{"Admin Geral", "Admin Escola", "Professor", "Funcionário"}, "Professor"));
        usuario.setDataCriacao(LocalDateTime.now());
        
        usuarioDAO.criar(usuario);
        JOptionPane.showMessageDialog(null, "Usuário criado ID: " + usuario.getId());
    }

    public static void vincularEscola() {
        String usuarioIdStr = JOptionPane.showInputDialog("ID do usuário:");
        String escolaIdStr = JOptionPane.showInputDialog("ID da nova escola:");
        
        try {
            Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(usuarioIdStr));
            if(usuario != null) {
                usuario.setEscolaId(Integer.parseInt(escolaIdStr));
                usuario.setDataModificacao(LocalDateTime.now());
                usuarioDAO.atualizar(usuario);
                JOptionPane.showMessageDialog(null, "Escola vinculada com sucesso!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void listarUsuariosPorEscola() {
        String escolaIdStr = JOptionPane.showInputDialog("ID da escola:");
        StringBuilder sb = new StringBuilder("Usuários da escola:\n\n");
        
        try {
            for (Usuario u : usuarioDAO.listarPorEscola(Integer.parseInt(escolaIdStr))) {
                sb.append(String.format("ID: %d | Pessoa: %d | Tipo: %s%n", u.getId(), u.getPessoaId(), u.getTipo()));
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void listarUsuarios() {
        StringBuilder sb = new StringBuilder("Lista de Usuários:\n\n");
        
        for (Usuario u : usuarioDAO.listarTodos()) {
            sb.append(String.format("ID: %d | Pessoa: %d | Tipo: %s%n", u.getId(), u.getPessoaId(), u.getTipo()));
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void editarUsuario() {
        String usuarioIdStr = JOptionPane.showInputDialog("ID do usuário a ser editado:");
        
        try {
            int usuarioId = Integer.parseInt(usuarioIdStr);
            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                return;
            }
            
            // Exibir dados atuais
            JOptionPane.showMessageDialog(null, 
                String.format("Dados atuais:\nID: %d\nPessoa ID: %d\nEscola ID: %d\nTipo: %s", 
                usuario.getId(), usuario.getPessoaId(), usuario.getEscolaId(), usuario.getTipo()));
            
            // Solicitar novos dados
            String novaPessoaIdStr = JOptionPane.showInputDialog("Novo ID da Pessoa (ou deixe em branco para manter):");
            String novaEscolaIdStr = JOptionPane.showInputDialog("Novo ID da Escola (ou deixe em branco para manter):");
            String novoTipo = (String) JOptionPane.showInputDialog(null, "Novo tipo de usuário:", "Selecione", 
                JOptionPane.QUESTION_MESSAGE, null, 
                new String[]{"Admin Geral", "Admin Escola", "Professor", "Funcionário"}, 
                usuario.getTipo());
            
            // Atualizar dados se fornecidos
            if (novaPessoaIdStr != null && !novaPessoaIdStr.trim().isEmpty()) {
                usuario.setPessoaId(Integer.parseInt(novaPessoaIdStr));
            }
            
            if (novaEscolaIdStr != null && !novaEscolaIdStr.trim().isEmpty()) {
                usuario.setEscolaId(Integer.parseInt(novaEscolaIdStr));
            }
            
            if (novoTipo != null) {
                usuario.setTipo(novoTipo);
            }
            
            usuario.setDataModificacao(LocalDateTime.now());
            usuarioDAO.atualizar(usuario);
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void excluirUsuario() {
        String usuarioIdStr = JOptionPane.showInputDialog("ID do usuário a ser excluído:");
        
        try {
            int usuarioId = Integer.parseInt(usuarioIdStr);
            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                return;
            }
            
            // Confirmar exclusão
            int confirmacao = JOptionPane.showConfirmDialog(
                null, 
                String.format("Tem certeza que deseja excluir o usuário ID: %d, Pessoa ID: %d?", 
                usuario.getId(), usuario.getPessoaId()),
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                usuarioDAO.excluir(usuarioId);
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    // Novos métodos para verificação de permissões
    public static boolean verificarPermissaoAdminGeral(int usuarioId) {
        try {
            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            return usuario != null && usuario.getTipo().equals("Admin Geral");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verificarPermissaoAdminEscola(int usuarioId) {
        try {
            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            return usuario != null && usuario.getTipo().equals("Admin Escola");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verificarPermissaoProfessor(int usuarioId) {
        try {
            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            return usuario != null && usuario.getTipo().equals("Professor");
        } catch (Exception e) {
            return false;
        }
    }
}