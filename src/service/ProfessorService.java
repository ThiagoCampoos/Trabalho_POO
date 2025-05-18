package service;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.AlunoDAO;
import dao.VidaAcademicaDAO;
import model.Aluno;
import model.VidaAcademica;

public class ProfessorService {
    private static AlunoDAO alunoDAO = new AlunoDAO();
    private static VidaAcademicaDAO vidaAcademicaDAO = new VidaAcademicaDAO();
    
    public static void registrarAvaliacao() {
        String idAlunoStr = JOptionPane.showInputDialog("Digite o ID do aluno a ser avaliado:");
        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            Aluno aluno = alunoDAO.buscarPorId(idAluno);
            
            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                return;
            }
            
            String nomeProfessor = JOptionPane.showInputDialog("Digite o nome do professor:");
            String disciplina = JOptionPane.showInputDialog("Digite a disciplina:");
            String periodo = JOptionPane.showInputDialog("Digite o período (ex: 1º Trimestre 2024):");
            String observacao = JOptionPane.showInputDialog("Digite a observação sobre o aluno:");
            
            StringBuilder avaliacao = new StringBuilder();
            avaliacao.append("Avaliação registrada com sucesso!\n\n")
                     .append("Aluno: ").append(aluno.getNome()).append("\n")
                     .append("Professor: ").append(nomeProfessor).append("\n")
                     .append("Disciplina: ").append(disciplina).append("\n")
                     .append("Período: ").append(periodo).append("\n")
                     .append("Observação: ").append(observacao).append("\n");
            
            JOptionPane.showMessageDialog(null, avaliacao.toString());
            
            // Registrar como evento na vida acadêmica do aluno
            VidaAcademica evento = new VidaAcademica();
            evento.setTipo("Avaliação Professor");
            
            // Formatando a data atual para o formato dd/MM/yyyy
            LocalDate hoje = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataStr = hoje.format(formatter);
            
            evento.setDescricao(dataStr + "\n" +
                               "Professor " + nomeProfessor + "\n" +
                               "Disciplina: " + disciplina + " - " + periodo + "\n" +
                               observacao);
            
            // Salvando o evento na vida acadêmica
            vidaAcademicaDAO.criar(evento);
            JOptionPane.showMessageDialog(null, "Evento registrado na timeline do aluno.");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void exibirConselhoClasse() {
        String turma = JOptionPane.showInputDialog("Digite o nome da turma para o conselho de classe:");
        
      
        StringBuilder conselho = new StringBuilder();
        conselho.append("CONSELHO DE CLASSE - Turma: ").append(turma).append("\n\n");
        
        // Simulando alguns alunos e suas avaliações
        conselho.append("22/03/2024\n\n");
        conselho.append("CONSELHO de CLASSE\n\n");
        conselho.append("Professora Joana\n");
        conselho.append("Aluno Eduardo Augusto Silvestre não fez nada durante o trimestre. É um vagabundo.\n\n");
        
        conselho.append("Professor Carlos\n");
        conselho.append("Aluna Maria Silva tem se destacado em matemática, mas precisa melhorar em física.\n\n");
        
        conselho.append("Professor Roberto\n");
        conselho.append("Aluno João Pereira está com dificuldades em português, recomendo aulas de reforço.\n\n");
        
        JOptionPane.showMessageDialog(null, conselho.toString(), 
            "Conselho de Classe - " + turma, JOptionPane.INFORMATION_MESSAGE);
    }
}