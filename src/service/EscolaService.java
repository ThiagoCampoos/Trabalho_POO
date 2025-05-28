package service;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import dao.EscolaDAO;
import model.Escola;

public class EscolaService {
    private static EscolaDAO escolaDAO = new EscolaDAO();

    public static void criarEscola() {
        Escola escola = new Escola(null, null, null);
        escola.setNome(JOptionPane.showInputDialog("Nome da escola:"));
        escola.setCidade(JOptionPane.showInputDialog("Cidade:"));
        escola.setTelefone(JOptionPane.showInputDialog("Telefone:"));
        escola.setDataCriacao(LocalDateTime.now());
        escolaDAO.criar(escola);
        JOptionPane.showMessageDialog(null, "Escola criada ID: " + escola.getId());
    }

    public static void listarEscolas() {
        Escola[] escolas = escolaDAO.listarTodos();
        StringBuilder lista = new StringBuilder("Escolas Cadastradas:\n\n");
        for (Escola escola : escolas) {
            lista.append("ID: ").append(escola.getId())
                 .append(" - ").append(escola.getNome())
                 .append(" (").append(escola.getCidade()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public static void atualizarEscola() {
        String idStr = JOptionPane.showInputDialog("ID da escola:");
        try {
            Escola escola = escolaDAO.buscarPorId(Integer.parseInt(idStr));
            if(escola != null) {
                escola.setNome(JOptionPane.showInputDialog("Novo nome:", escola.getNome()));
                escola.setCidade(JOptionPane.showInputDialog("Nova cidade:", escola.getCidade()));
                escola.setTelefone(JOptionPane.showInputDialog("Novo telefone:", escola.getTelefone()));
                escola.setDataModificacao(LocalDateTime.now());
                escolaDAO.atualizar(escola);
                JOptionPane.showMessageDialog(null, "Escola atualizada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void excluirEscola() {
        String idStr = JOptionPane.showInputDialog("ID da escola para excluir:");
        try {
            int id = Integer.parseInt(idStr);
            Escola escola = escolaDAO.buscarPorId(id);
            if (escola != null) {
                int confirmacao = JOptionPane.showConfirmDialog(
                    null, 
                    "Tem certeza que deseja excluir a escola \"" + escola.getNome() + "\"?", 
                    "Confirmar Exclusão", 
                    JOptionPane.YES_NO_OPTION
                );
                 if (confirmacao == JOptionPane.YES_OPTION) {
                    escolaDAO.excluir(id);
                    JOptionPane.showMessageDialog(null, "Escola excluída com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escola não encontrada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}