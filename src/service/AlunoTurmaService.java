package service;
import javax.swing.JOptionPane;
import dao.AlunoTurmaDAO;
import model.AlunoTurma;
import dao.TurmaDAO;
import model.Turma;

public class AlunoTurmaService {
    private static AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();

    public static void moverAlunosTurma() {
        try {
            int idTurmaOrigem = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma de Origem:"));
            int idTurmaDestino = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma de Destino:"));
            
            AlunoTurma[] vinculados = alunoTurmaDAO.buscarPorTurma(idTurmaOrigem);
            
            if(vinculados.length == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado na turma de origem!");
                return;
            }
            
            TurmaDAO turmaDAO = new TurmaDAO(); // Instanciar DAO
            Turma turmaDestino = turmaDAO.buscarPorId(idTurmaDestino);
            
            if(turmaDestino == null) {
                JOptionPane.showMessageDialog(null, "Turma destino não encontrada!");
                return; // Sai mais cedo do método
            }
            
            for(AlunoTurma vinculo : vinculados) {
                vinculo.setTurma(turmaDestino);
                alunoTurmaDAO.atualizar(vinculo);
            }
            
            JOptionPane.showMessageDialog(null, vinculados.length + " alunos movidos com sucesso!");
        } 
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    public static void criarTurma() {
        try {
            int idAluno = Integer.parseInt(JOptionPane.showInputDialog("ID do Aluno:"));
            int idTurma = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma:"));
            AlunoTurma vinculo = new AlunoTurma();
            alunoTurmaDAO.criar(vinculo);
            JOptionPane.showMessageDialog(null, "Aluno vinculado à turma com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "IDs inválidos!");
        }
    }

    public static void listarTurmas() {
        AlunoTurma[] vinculados = alunoTurmaDAO.buscarTodos();
        StringBuilder sb = new StringBuilder("Todos os vínculos:\n");
        for (AlunoTurma v : vinculados) {
            sb.append("Aluno ID: ").append(v.getAluno().getId())
              .append(" - Turma ID: ").append(v.getTurma().getId()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void atualizarTurma() {
        try {
            int idVinculo = Integer.parseInt(JOptionPane.showInputDialog("ID do Vínculo:"));
            AlunoTurma vinculo = alunoTurmaDAO.buscarPorId(idVinculo);
            if (vinculo != null) {
                int novaTurma = Integer.parseInt(JOptionPane.showInputDialog("Novo ID da Turma:"));
                vinculo.setTurma(new TurmaDAO().buscarPorId(novaTurma));
                alunoTurmaDAO.atualizar(vinculo);
                JOptionPane.showMessageDialog(null, "Vínculo atualizado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void excluirTurma() {
        try {
            int idVinculo = Integer.parseInt(JOptionPane.showInputDialog("ID do Vínculo:"));
            alunoTurmaDAO.excluir(idVinculo);
            JOptionPane.showMessageDialog(null, "Vínculo removido!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}