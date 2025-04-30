package model;
import java.time.LocalDateTime;

public class AlunoTurma {
    private int id;
    private Aluno aluno;
    private Turma turma;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public int getId() {
       return id; 
    }
    public void setId(int id) {
       this.id = id; 
    }
    public Aluno getAluno() {
       return aluno; 
    }
    public void setAluno(Aluno aluno) {
       this.aluno = aluno; 
    }
    public Turma getTurma() {
       return turma;
    }
    public void setTurma(Turma turma) {
       this.turma = turma;
    }
    public LocalDateTime getDataCriacao() {
       return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
       this.dataCriacao = dataCriacao;
    }
    public LocalDateTime getDataModificacao() {
       return dataModificacao;
    }
    public void setDataModificacao(LocalDateTime dataModificacao) {
       this.dataModificacao = dataModificacao; 
    }
    
}
