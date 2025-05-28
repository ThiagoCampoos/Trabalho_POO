package dao;
import java.util.Arrays;

import model.Aluno;
import model.AlunoTurma;
import model.Turma;
public class AlunoTurmaDAO {
    private AlunoTurma[] alunosTurmas = new AlunoTurma[1000];
    private int contador = 0;

    public AlunoTurmaDAO() {
        AlunoDAO alunoDAO = new AlunoDAO();
        TurmaDAO turmaDAO = new TurmaDAO();    
        
        // Adicionar os alunos às turmas
        
        // Aluno 1 (Lucas Ferreira) na Turma 1
        Aluno aluno1 = alunoDAO.buscarPorId(1);
        Turma turma1 = turmaDAO.buscarPorId(1);
        if (aluno1 != null && turma1 != null) {
            criar(new AlunoTurma(aluno1, turma1));
        }
        
        // Aluno 2 (João Silva) na Turma 1
        Aluno aluno2 = alunoDAO.buscarPorId(2);
        if (aluno2 != null && turma1 != null) {
            criar(new AlunoTurma(aluno2, turma1));
        }
        
        // Aluno 3 (Marisa Helena) na Turma 2
        Aluno aluno3 = alunoDAO.buscarPorId(3);
        Turma turma2 = turmaDAO.buscarPorId(2);
        if (aluno3 != null && turma2 != null) {
            criar(new AlunoTurma(aluno3, turma2));
        }
        
        // Aluno 4 (Thais Campos) na Turma 2
        Aluno aluno4 = alunoDAO.buscarPorId(4);
        if (aluno4 != null && turma2 != null) {
            criar(new AlunoTurma(aluno4, turma2));
        }
        
        // Aluno 5 (Thiago Campos) na Turma 1
        Aluno aluno5 = alunoDAO.buscarPorId(5);
        if (aluno5 != null && turma1 != null) {
            criar(new AlunoTurma(aluno5, turma1));
        }
    }
    public void criar(AlunoTurma alunoTurma) {
        if (contador < alunosTurmas.length) {
            alunoTurma.setId(contador + 1);
            alunoTurma.setDataCriacao(java.time.LocalDateTime.now());
            alunosTurmas[contador] = alunoTurma;
            contador++;
        } else {
            throw new RuntimeException("Capacidade máxima de alunos por turma atingida!");
        }
    }
    public AlunoTurma buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (alunosTurmas[i].getId() == id) {
                return alunosTurmas[i];
            }
        }
        return null; // Não encontrou
    }

    public void atualizar(AlunoTurma alunoTurmaAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (alunosTurmas[i].getId() == alunoTurmaAtualizado.getId()) {
                alunoTurmaAtualizado.setDataModificacao(java.time.LocalDateTime.now());
                alunosTurmas[i] = alunoTurmaAtualizado;
                break;
            }
        }
    }

    public AlunoTurma[] buscarPorTurma(int idTurma) {
        AlunoTurma[] resultado = new AlunoTurma[contador];
        int index = 0;
        for (int i = 0; i < contador; i++) {
            if (alunosTurmas[i] != null && alunosTurmas[i].getTurma().getId() == idTurma) {
                resultado[index++] = alunosTurmas[i];
            }
        }
        return Arrays.copyOf(resultado, index);
    }
    
    public AlunoTurma[] buscarTodos() {
        return Arrays.copyOf(alunosTurmas, contador);
    }
    
    public void excluir(int id) {
        for (int i = 0; i < contador; i++) {
            if (alunosTurmas[i].getId() == id) {
                // Move todos os elementos uma posição para trás
                for (int j = i; j < contador - 1; j++) {
                    alunosTurmas[j] = alunosTurmas[j + 1];
                }
                alunosTurmas[contador - 1] = null;
                contador--;
                break;
            }
        }
    }
}
