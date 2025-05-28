package service;

import dao.RegistroProfessorDAO;
import dao.RegistroProfessorDescricaoDAO;
import model.RegistroProfessor;
import model.RegistroProfessorDescricao;
import javax.swing.JOptionPane;
import java.util.List;

public class RegistroProfessorDescricaoService {
    private static RegistroProfessorDescricaoDAO descricaoDAO = new RegistroProfessorDescricaoDAO();
    private static RegistroProfessorDAO registroDAO = new RegistroProfessorDAO(); // Para buscar o registro pai

    public static void criarDescricao() {
        String idRegistroStr = JOptionPane.showInputDialog("Digite o ID do Registro de Professor ao qual esta descrição pertence:");
        try {
            int idRegistro = Integer.parseInt(idRegistroStr);
            RegistroProfessor registro = registroDAO.buscarPorId(idRegistro);

            if (registro == null) {
                JOptionPane.showMessageDialog(null, "Registro de Professor não encontrado com o ID: " + idRegistro);
                return;
            }

            RegistroProfessorDescricao descricao = new RegistroProfessorDescricao(registro, null, idRegistroStr);
            descricao.setRegistro(registro); // Associa a descrição ao registro pai
            descricao.setObservacao(JOptionPane.showInputDialog("Digite a descrição:"));

            descricaoDAO.criar(descricao);
            JOptionPane.showMessageDialog(null, "Descrição criada com ID: " + descricao.getId());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do Registro de Professor inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar descrição: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listarDescricoesPorRegistro() {
        String idRegistroStr = JOptionPane.showInputDialog("Digite o ID do Registro de Professor para listar suas descrições:");
        try {
            int idRegistro = Integer.parseInt(idRegistroStr);
            List<RegistroProfessorDescricao> descricoes = descricaoDAO.buscarPorRegistroProfessorId(idRegistro);

            if (descricoes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma descrição encontrada para o Registro de Professor com ID: " + idRegistro);
                return;
            }

            StringBuilder lista = new StringBuilder("Descrições do Registro ID: " + idRegistro + "\n\n");
            for (RegistroProfessorDescricao desc : descricoes) {
                lista.append("ID Descrição: ").append(desc.getId())
                     .append("\nDescrição: ").append(desc.getObservacao())
                     // Adicionar mais campos se houver
                     .append("\nData Criação: ").append(desc.getDataCriacao())
                     .append("\nData Modificação: ").append(desc.getDataModificacao())
                     .append("\n---------------------\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do Registro de Professor inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar descrições: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void atualizarDescricao() {
        String idDescricaoStr = JOptionPane.showInputDialog("Digite o ID da Descrição para atualizar:");
        try {
            int idDescricao = Integer.parseInt(idDescricaoStr);
            RegistroProfessorDescricao descricao = descricaoDAO.buscarPorId(idDescricao);

            if (descricao == null) {
                JOptionPane.showMessageDialog(null, "Descrição não encontrada com o ID: " + idDescricao);
                return;
            }

            // Exemplo de atualização, adicione mais campos conforme necessário
            String novaObservacaoTexto = JOptionPane.showInputDialog("Nova descrição:", descricao.getObservacao());
            if (novaObservacaoTexto != null && !novaObservacaoTexto.trim().isEmpty()) {
                descricao.setObservacao(novaObservacaoTexto);
            }

            descricaoDAO.atualizar(descricao);
            JOptionPane.showMessageDialog(null, "Descrição atualizada com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID da Descrição inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar descrição: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void excluirDescricao() {
        String idDescricaoStr = JOptionPane.showInputDialog("Digite o ID da Descrição para excluir:");
        try {
            int idDescricao = Integer.parseInt(idDescricaoStr);
            RegistroProfessorDescricao descricao = descricaoDAO.buscarPorId(idDescricao);

            if (descricao == null) {
                JOptionPane.showMessageDialog(null, "Descrição não encontrada com o ID: " + idDescricao);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza que deseja excluir a descrição ID: " + idDescricao + "?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                descricaoDAO.deletar(idDescricao);
                JOptionPane.showMessageDialog(null, "Descrição excluída com sucesso!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID da Descrição inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir descrição: " + e.getMessage());
            e.printStackTrace();
        }
    }
}