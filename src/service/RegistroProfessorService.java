package service;

import dao.AlunoDAO;
import dao.RegistroProfessorDAO;
import model.Aluno;
import model.RegistroProfessor;
import javax.swing.JOptionPane;

public class RegistroProfessorService {
    private static RegistroProfessorDAO registroDAO = new RegistroProfessorDAO();
    private static AlunoDAO alunoDAO = new AlunoDAO(); // Adicionar instância do AlunoDAO

    public static void criarRegistro() {
        RegistroProfessor registro = new RegistroProfessor();
        
        // Capturar ID do aluno
        String idAlunoStr = JOptionPane.showInputDialog("Digite o ID do aluno:");
        int idAluno = Integer.parseInt(idAlunoStr);
        Aluno aluno = alunoDAO.buscarPorId(idAluno); // Corrigir chamada do DAO
        
        registro.setAluno(aluno);
        registro.setObservacao(JOptionPane.showInputDialog("Digite a observação:"));
        registro.setDisciplina(JOptionPane.showInputDialog("Disciplina:"));
        registro.setPeriodo((String) JOptionPane.showInputDialog(null, 
            "Período:", "Selecione", JOptionPane.QUESTION_MESSAGE, null, 
            new String[]{"1º TRIMESTRE", "1º SEMESTRE", "2º BIMESTRE"}, 
            "1º TRIMESTRE"));
        
        registroDAO.criar(registro);
        JOptionPane.showMessageDialog(null, "Registro criado com ID: " + registro.getId());
    }

    public static void listarRegistros() {
        RegistroProfessor[] registros = registroDAO.listarTodos();
        StringBuilder lista = new StringBuilder("Registros de Professor:\n\n");
        for (RegistroProfessor registro : registros) {
            lista.append("ID: ").append(registro.getId())
                 .append("\nAluno: ").append(registro.getAluno().getNome())
                 .append("\nDisciplina: ").append(registro.getDisciplina())
                 .append("\nPeríodo: ").append(registro.getPeriodo())
                 .append("\nObservação: ").append(registro.getObservacao())
                 .append("\n\n");
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
            RegistroProfessor registro = registroDAO.buscarPorId(id);
            
            if (registro != null) {
                registroDAO.deletar(id);
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}