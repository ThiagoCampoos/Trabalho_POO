package dao;
import model.Aluno;
import java.time.LocalDateTime;


public class AlunoDAO {
    private Aluno[] alunos = new Aluno[1000];
    public AlunoDAO() {
        criar(new Aluno("15561656798", "João Silva", java.time.LocalDate.of(2000, 1, 15), "(11) 99999-0008", "jao.silva@email.com"));
        criar(new Aluno("12345678901", "Maria Souza", java.time.LocalDate.of(2001, 2, 20), "(11) 99999-0009", "marina.souza@email.com"));
        criar(new Aluno("12345678902", "Pedro Oliveira", java.time.LocalDate.of(2002, 3, 25), "(11) 99999-0010", "pedro.oliveira@email.com"));
        criar(new Aluno("12345678903", "Lucia Santos", java.time.LocalDate.of(2023, 4, 30), "(11) 99999-0011", "lucia.santos@email.com"));
        criar(new Aluno("12345678904", "Ricardo Lima", java.time.LocalDate.of(2004, 5, 5), "(11) 99999-0012", "ricardo.lima@email.com"));

    }
    public Aluno buscarPorPosicao(int index) {
        if (index >= 0 && index < contador) {
            return alunos[index];
        }
        return null;
    }
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
