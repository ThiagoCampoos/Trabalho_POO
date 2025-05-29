package service;
import model.Turma;
import javax.swing.JOptionPane;
import dao.TurmaDAO;
public class TurmaService {
    private static TurmaDAO turmaDAO = new TurmaDAO();

    public static void criarTurma(){
        Turma turma = new Turma(0, null, null, null, null, null);
        String nome = JOptionPane.showInputDialog("Nome da Turma:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome da turma não pode ser vazio ou cancelado.");
            return;
        }
        turma.setNome(nome);
        String periodo = JOptionPane.showInputDialog("Periodo (ex: 2025-1):");
        if (periodo == null || periodo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Período não pode ser vazio ou cancelado.");
            return;
        }
        turma.setPeriodo(periodo);
        turma.setStatus("Ativo");
        turmaDAO.criar(turma);
        JOptionPane.showMessageDialog(null, "Turma criada com ID:" + turma.getId());
    }
    
    public static void listarTurmas() {
        Turma[] turmas = turmaDAO.listarTodos();
        if (turmas.length == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma turma encontrada.");
            return;
        }

        StringBuilder sb = new StringBuilder("Turmas:\n");
        for (Turma turma : turmas) {
            sb.append(String.format("ID: %d, Nome: %s, Período: %s, Status: %s\n",
                turma.getId(), turma.getNome(), turma.getPeriodo(), turma.getStatus()));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public static void atualizarTurma() {
        String turmaIdStr = JOptionPane.showInputDialog("ID da turma a ser atualizada:");
        
        try {
            int turmaId = Integer.parseInt(turmaIdStr);
            Turma turma = turmaDAO.buscarPorId(turmaId);
            
            if (turma == null) {
                JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                return;
            }
            
            // Exibir dados atuais
            JOptionPane.showMessageDialog(null, 
                String.format("Dados atuais:\nID: %d\nNome: %s\nPeríodo: %s\nStatus: %s", 
                turma.getId(), turma.getNome(), turma.getPeriodo(), turma.getStatus()));
            
            // Solicitar novos dados
            String novoNome = JOptionPane.showInputDialog("Novo nome da turma (ou deixe em branco para manter):", turma.getNome());
            String novoPeriodo = JOptionPane.showInputDialog("Novo período (ou deixe em branco para manter):", turma.getPeriodo());
            String novoStatus = (String) JOptionPane.showInputDialog(null, "Novo status:", "Selecione", 
                JOptionPane.QUESTION_MESSAGE, null, 
                new String[]{"Ativo", "Inativo", "Concluído"}, 
                turma.getStatus());
            
            // Atualizar dados se fornecidos
            if (novoNome != null && !novoNome.trim().isEmpty()) {
                turma.setNome(novoNome);
            }
            
            if (novoPeriodo != null && !novoPeriodo.trim().isEmpty()) {
                turma.setPeriodo(novoPeriodo);
            }
            
            if (novoStatus != null) {
                turma.setStatus(novoStatus);
            }
            
            turmaDAO.atualizar(turma);
            JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void excluirTurma() {
        String turmaIdStr = JOptionPane.showInputDialog("ID da turma a ser excluída:");
        
        try {
            int turmaId = Integer.parseInt(turmaIdStr);
            Turma turma = turmaDAO.buscarPorId(turmaId);
            
            if (turma == null) {
                JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                return;
            }
            
            // Confirmar exclusão
            int confirmacao = JOptionPane.showConfirmDialog(
                null, 
                String.format("Tem certeza que deseja excluir a turma ID: %d, Nome: %s?", 
                turma.getId(), turma.getNome()),
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                turmaDAO.excluir(turmaId);
                JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}
