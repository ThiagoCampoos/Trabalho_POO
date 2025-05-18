package dao;
import java.time.LocalDateTime;
import model.Turma;

public class TurmaDAO {
    private Turma[] turmas = new Turma[100];
    private int contador = 0;

    public void criar(Turma turma) {
        turma.setId(contador + 1);
        turma.setDataCriacao(LocalDateTime.now());
        turma.setDataModificacao(LocalDateTime.now());  // Adicionado data modificação
        turmas[contador] = turma;
        contador++;
    }

    public Turma buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    public void atualizar(Turma turmaAtualizada) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i].getId() == turmaAtualizada.getId()) {
                turmaAtualizada.setDataModificacao(LocalDateTime.now());
                turmas[i] = turmaAtualizada;
                break;
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i].getId() == id) {
                turmas[i] = null;
                for (int j = i; j < contador - 1; j++) {
                    turmas[j] = turmas[j + 1];
                }
                contador--;
                break;
            }
        }
    }

    public Turma[] listarTodos() {
        Turma[] lista = new Turma[contador];
        System.arraycopy(turmas, 0, lista, 0, contador);
        return lista;
    }

    public void excluir(int turmaId) {
        for (int i = 0; i < contador; i++) {
            if (turmas[i].getId() == turmaId) {
                turmas[i] = null;
                for (int j = i; j < contador - 1; j++) {
                    turmas[j] = turmas[j + 1];
                }
                contador--;
                break;
            }
        }
    }
}
