package dao;
import java.util.Arrays;

import model.AlunoTurma;
public class AlunoTurmaDAO {
    private AlunoTurma[] alunosTurmas = new AlunoTurma[1000];
    private int contador = 0;
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
