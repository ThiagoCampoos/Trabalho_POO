package service;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoService {
    private static AlunoDAO alunoDAO = new AlunoDAO();
    
    public static void criarAluno() {
        Aluno aluno = new Aluno();
        
        aluno.setNome(JOptionPane.showInputDialog("Digite o nome do aluno:"));
        aluno.setCpf(JOptionPane.showInputDialog("Digite o CPF do aluno:"));
        
        String dataNascStr = JOptionPane.showInputDialog("Digite a data de nascimento (dd/MM/yyyy):");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(dataNascStr, formatter);
            aluno.setNascimento(dataNasc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data inválida! Usando data atual.");
            aluno.setNascimento(LocalDate.now());
        }
        
        aluno.setTelefone(JOptionPane.showInputDialog("Digite o telefone do aluno:"));
        aluno.setEmail(JOptionPane.showInputDialog("Digite o email do aluno:"));
        
        alunoDAO.criar(aluno);
        
        JOptionPane.showMessageDialog(null, "Aluno cadastrado com ID: " + aluno.getId());
    }
    
    public static void listarAlunos() {
        // Na fase 1, vamos simular a listagem de alunos
        StringBuilder lista = new StringBuilder();
        lista.append("Lista de Alunos:\n\n");
        
        // Simulando cadastro 
        for (int i = 0; i < alunoDAO.getContador(); i++) {
            Aluno aluno = alunoDAO.buscarPorPosicao(i);
            if (aluno != null) {
                lista.append("ID: ").append(aluno.getId())
                     .append(" - Nome: ").append(aluno.getNome())
                     .append(" - CPF: ").append(aluno.getCpf())
                     .append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, lista.toString());
    }
    
    public static void buscarAluno() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do aluno:");
        try {
            int id = Integer.parseInt(idStr);
            Aluno aluno = alunoDAO.buscarPorId(id);
            
            if (aluno != null) {
                StringBuilder info = new StringBuilder();
                info.append("Informações do Aluno:\n\n")
                    .append("ID: ").append(aluno.getId()).append("\n")
                    .append("Nome: ").append(aluno.getNome()).append("\n")
                    .append("CPF: ").append(aluno.getCpf()).append("\n");
                
                if (aluno.getNascimento() != null) {
                    info.append("Data de Nascimento: ").append(aluno.getNascimento().format(
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
                }
                
                info.append("Telefone: ").append(aluno.getTelefone()).append("\n")
                    .append("Email: ").append(aluno.getEmail()).append("\n");
                
                JOptionPane.showMessageDialog(null, info.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void atualizarAluno() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do aluno:");
        try {
            int id = Integer.parseInt(idStr);
            Aluno aluno = alunoDAO.buscarPorId(id);
            
            if (aluno != null) {
                aluno.setNome(JOptionPane.showInputDialog("Novo nome:", aluno.getNome()));
                aluno.setCpf(JOptionPane.showInputDialog("Novo CPF:", aluno.getCpf()));
                aluno.setDataModificacao(LocalDateTime.now()); // Adicionar esta linha
                alunoDAO.atualizar(aluno);
                JOptionPane.showMessageDialog(null, "Aluno atualizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void excluirAluno() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do aluno:");
        try {
            int id = Integer.parseInt(idStr);
            Aluno aluno = alunoDAO.buscarPorId(id);
            
            if (aluno != null) {
                alunoDAO.excluir(id);
                JOptionPane.showMessageDialog(null, "Aluno excluído!");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void moverAlunosEntreTurmas() {
        try {
            int idTurmaOrigem = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma de Origem:"));
            int idTurmaDestino = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma de Destino:"));
            
            AlunoTurmaService.moverAlunosTurma();
            
            JOptionPane.showMessageDialog(null, "Alunos movidos com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}