package service;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import dao.PeriodoLetivoDAO;
import dao.RegistroProfessorDAO;
import model.PeriodoLetivo;
import model.RegistroProfessor;

public class PeriodoLetivoService {
    private static PeriodoLetivoDAO periodoDAO = new PeriodoLetivoDAO();
    private static RegistroProfessorDAO registroDAO = new RegistroProfessorDAO();

    public static void registrarPeriodoLetivo() {
        PeriodoLetivo periodo = new PeriodoLetivo();
        
        periodo.setTipo(JOptionPane.showInputDialog("Tipo do período (Bimestre/Trimestre/Semestre/Ano):"));
        periodo.setDescricao(JOptionPane.showInputDialog("Descrição do período:"));
        
        // Captura datas (implementar conversão de string para LocalDateTime)
        periodo.setDataInicio(LocalDateTime.now()); // Implementar captura real
        periodo.setDataFim(LocalDateTime.now());    // Implementar captura real
        
        periodoDAO.criar(periodo);
        JOptionPane.showMessageDialog(null, "Período registrado com ID: " + periodo.getId());
    }


    public static void listarPeriodosLetivos() {
        PeriodoLetivo[] periodos = periodoDAO.listarTodos();
        StringBuilder lista = new StringBuilder("Períodos Letivos:\n\n");
        
        for (PeriodoLetivo periodo : periodos) {
            if (periodo != null) {
                lista.append("ID: ").append(periodo.getId())
                     .append("\nTipo: ").append(periodo.getTipo())
                     .append("\nDescrição: ").append(periodo.getDescricao())
                     .append("\nInício: ").append(periodo.getDataInicio())
                     .append("\nFim: ").append(periodo.getDataFim())
                     .append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }
    
    // r métodos de atualização e exclusão

    public static void atualizarPeriodoLetivo() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do período letivo para atualizar:");
        try {
            int id = Integer.parseInt(idStr);
            PeriodoLetivo periodo = periodoDAO.buscarPorId(id);
            
            if (periodo != null) {
                periodo.setTipo(JOptionPane.showInputDialog("Novo tipo:", periodo.getTipo()));
                periodo.setDescricao(JOptionPane.showInputDialog("Nova descrição:", periodo.getDescricao()));
                
                // Mantendo as datas originais - implementar captura se necessário
                periodoDAO.atualizar(periodo);
                JOptionPane.showMessageDialog(null, "Período letivo atualizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Período não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void excluirPeriodoLetivo() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do período letivo para excluir:");
        try {
            int id = Integer.parseInt(idStr);
            PeriodoLetivo periodo = periodoDAO.buscarPorId(id);
            
            if (periodo != null) {
                periodoDAO.deletar(id);
                JOptionPane.showMessageDialog(null, "Período letivo excluído!");
            } else {
                JOptionPane.showMessageDialog(null, "Período não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void listarRegistros() {
        RegistroProfessor[] registros = registroDAO.listarTodos();
        StringBuilder lista = new StringBuilder("Registros de Professor:\n\n");
        for (RegistroProfessor registro : registros) {
            lista.append("ID: ").append(registro.getId())
                 .append(" - Disciplina: ").append(registro.getDisciplina())
                 .append(" - Período: ").append(registro.getPeriodo())
                 .append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }
    
    public static void atualizarRegistro() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do registro para atualizar:");
        try {
            int id = Integer.parseInt(idStr);
            RegistroProfessor registro = registroDAO.buscarPorId(id);
            
            if (registro != null) {
                registro.setDisciplina(JOptionPane.showInputDialog("Nova disciplina:", registro.getDisciplina()));
                registro.setPeriodo((String) JOptionPane.showInputDialog(null, 
                    "Novo período:", "Atualizar", JOptionPane.QUESTION_MESSAGE, null, 
                    new String[]{"1º TRIMESTRE", "1º SEMESTRE", "2º BIMESTRE"}, 
                    registro.getPeriodo()));
                
                registroDAO.atualizar(registro);
                JOptionPane.showMessageDialog(null, "Registro atualizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void excluirRegistro() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do registro para excluir:");
        try {
            int id = Integer.parseInt(idStr);
            registroDAO.deletar(id);
            JOptionPane.showMessageDialog(null, "Registro excluído!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}