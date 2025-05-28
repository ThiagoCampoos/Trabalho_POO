package model;
import java.time.LocalDateTime;
import java.util.Objects;

public class AlunoTurma {
    private int id;
    private static int contador = 1;

    private Aluno aluno;
    private Turma turma;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public AlunoTurma(Aluno aluno, Turma turma) {
        this.id = contador;
        contador++;
        this.aluno = aluno;
        this.turma = turma;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

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

    @Override
    public String toString() {
        return "AlunoTurma [id=" + id + ", aluno=" + aluno + ", turma=" + turma + ", dataCriacao=" + dataCriacao
                + ", dataModificacao=" + dataModificacao + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.aluno);
        hash = 31 * hash + Objects.hashCode(this.turma);
        hash = 31 * hash + Objects.hashCode(this.dataCriacao);
        hash = 31 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AlunoTurma other = (AlunoTurma) obj;
        return Objects.equals(id, other.id) && Objects.equals(aluno, other.aluno) && Objects.equals(turma, other.turma)
                && Objects.equals(dataCriacao, other.dataCriacao)
                && Objects.equals(dataModificacao, other.dataModificacao);    
    }
    
}
