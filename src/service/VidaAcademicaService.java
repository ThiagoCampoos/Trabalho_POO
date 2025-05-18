package service;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.AlunoDAO;
import dao.VidaAcademicaDAO;
import model.Aluno;
import model.VidaAcademica;

public class VidaAcademicaService {
    private static AlunoDAO alunoDAO = new AlunoDAO();
    private static VidaAcademicaDAO vidaAcademicaDAO = new VidaAcademicaDAO();
    
    public static void registrarEvento() {
        String idAlunoStr = JOptionPane.showInputDialog("Digite o ID do aluno:");
        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            Aluno aluno = alunoDAO.buscarPorId(idAluno);
            
            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                return;
            }
            
            String[] tiposEvento = {"mérito", "advertência", "CONSELHO de CLASSE"};
            String tipo = (String) JOptionPane.showInputDialog(null, 
                "Selecione o tipo de evento:", 
                "Tipo de Evento", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                tiposEvento, 
                tiposEvento[0]);
            
            // Adicionar tratamento de data
            String dataStr = JOptionPane.showInputDialog("Digite a data do evento (dd/MM/yyyy):");
            VidaAcademica evento = new VidaAcademica();
            evento.setAlunoId(idAluno); // Vincular ao aluno
            
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataEvento = LocalDate.parse(dataStr, formatter);
                evento.setDataEvento(dataEvento);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data inválida! Usando data atual.");
                evento.setDataEvento(LocalDate.now());
            }
            
            String descricao = JOptionPane.showInputDialog("Digite a descrição do evento:");
            String professor = JOptionPane.showInputDialog("Digite o nome do professor responsável:");
            
            evento.setTipo(tipo);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = evento.getDataEvento().format(formatter);
            evento.setDescricao("Data: " + formattedDate + "\nEvento: " + tipo + "\n" + 
                         (professor != null && !professor.isEmpty() ? "Professor " + professor + "\n" : "") + 
                         descricao);
            
            vidaAcademicaDAO.criar(evento);
            
            JOptionPane.showMessageDialog(null, "Evento registrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
    
    public static void visualizarTimelineAluno() {
        String idAlunoStr = JOptionPane.showInputDialog("Digite o ID do aluno:");
        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            Aluno aluno = alunoDAO.buscarPorId(idAluno);
            
            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                return;
            }
            
            // Buscar eventos específicos do aluno
            VidaAcademica[] eventos = vidaAcademicaDAO.listarPorAlunoId(idAluno);
            
            if (eventos.length == 0) {
                JOptionPane.showMessageDialog(null, "Não há eventos registrados para este aluno.");
                return;
            }
            
            StringBuilder timeline = new StringBuilder();
            timeline.append(aluno.getNome() + "\n\n");
            
            if (eventos.length > 0) {
                // Usar os eventos cadastrados
                for (VidaAcademica evento : eventos) {
                    if (evento != null) {
                        timeline.append(evento.getDescricao() + "\n\n");
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, timeline.toString(), 
                "Timeline de " + aluno.getNome(), JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void atualizarEvento() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do evento para atualizar:");
        try {
            int id = Integer.parseInt(idStr);
            VidaAcademica evento = vidaAcademicaDAO.buscarPorId(id);
            
            if (evento != null) {
                evento.setTipo(JOptionPane.showInputDialog("Novo tipo:", evento.getTipo()));
                evento.setDescricao(JOptionPane.showInputDialog("Nova descrição:", evento.getDescricao()));
                evento.setDataModificacao(LocalDateTime.now());
                
                vidaAcademicaDAO.atualizar(evento);
                JOptionPane.showMessageDialog(null, "Evento atualizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Evento não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void excluirEvento() {
        String idStr = JOptionPane.showInputDialog("Digite o ID do evento para excluir:");
        try {
            int id = Integer.parseInt(idStr);
            vidaAcademicaDAO.deletar(id);
            JOptionPane.showMessageDialog(null, "Evento excluído!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}