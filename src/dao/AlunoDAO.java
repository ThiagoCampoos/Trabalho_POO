package dao;
import model.Aluno;
import java.time.LocalDateTime;
public class AlunoDAO {
    public Aluno buscarPorPosicao(int index) {
        if (index >= 0 && index < contador) {
            return alunos[index];
        }
        return null;
    }
    private Aluno[] alunos = new Aluno[1000];
    private int contador = 0;
    public int getContador() {
        return contador;
    }
    private int proximoId = 1;

    public int getProximoId() {
        return proximoId;
    }
    public void criar(Aluno aluno) {
        aluno.setId(proximoId++);
        aluno.setDataCriacao(java.time.LocalDateTime.now());
        aluno.setDataModificacao(java.time.LocalDateTime.now());
        alunos[contador] = aluno;
        contador++;
    }
    public Aluno buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i] != null && alunos[i].getId() == id) {
                return alunos[i];
            }
        }
        return null; // Não encontrou
    }

    public void atualizar(Aluno alunoAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i].getId() == alunoAtualizado.getId()) {
                alunoAtualizado.setDataModificacao(LocalDateTime.now());
                alunos[i] = alunoAtualizado;
                break;
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i] != null && alunos[i].getId() == id) {
                alunos[i] = null;
                for (int j = i; j < contador - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                contador--;
                break;
            }
        }
    }
    
    public Aluno[] listarTodos() {
        Aluno[] resultado = new Aluno[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = alunos[i];
        }
        return resultado;
    }
}
