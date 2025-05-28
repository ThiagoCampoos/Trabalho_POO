package service;

import javax.swing.JOptionPane;
import dao.CursoDAO;
import model.Curso;

public class CursoService {
    private static CursoDAO cursoDAO = new CursoDAO();

    public static void criarCurso() {
        Curso curso = new Curso(null, null, null);
        curso.setNome(JOptionPane.showInputDialog("Nome do Curso:"));
        curso.setSigla(JOptionPane.showInputDialog("Sigla do Curso:"));
        curso.setTipo(JOptionPane.showInputDialog("Tipo do Curso (superior/integrado/concomitante):"));
        
        cursoDAO.criar(curso);
        JOptionPane.showMessageDialog(null, "Curso criado com ID: " + curso.getId());
    }

    public static void listarCursos() {
        Curso[] cursos = cursoDAO.listarTodos();
        StringBuilder lista = new StringBuilder("Cursos Cadastrados:\n\n");
        for (Curso curso : cursos) {
            lista.append("ID: ").append(curso.getId())
                 .append(" - ").append(curso.getNome())
                 .append(" (").append(curso.getSigla()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public static void atualizarCurso() {
        String idStr = JOptionPane.showInputDialog("ID do Curso para atualizar:");
        try {
            int id = Integer.parseInt(idStr);
            Curso curso = cursoDAO.buscarPorId(id);
            if (curso != null) {
                curso.setNome(JOptionPane.showInputDialog("Novo nome:", curso.getNome()));
                curso.setSigla(JOptionPane.showInputDialog("Nova sigla:", curso.getSigla()));
                curso.setTipo(JOptionPane.showInputDialog("Novo tipo:", curso.getTipo()));
                cursoDAO.atualizar(curso);
                JOptionPane.showMessageDialog(null, "Curso atualizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Curso não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }

    public static void excluirCurso() {
        String idStr = JOptionPane.showInputDialog("ID do Curso para excluir:");
        try {
            int id = Integer.parseInt(idStr);
            cursoDAO.deletar(id);
            JOptionPane.showMessageDialog(null, "Curso excluído!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}