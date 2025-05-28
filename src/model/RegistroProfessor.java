package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class RegistroProfessor {
   private static int contador = 1;

    public RegistroProfessor(int i, String string, String string2, String string3) {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    public RegistroProfessor(Professor professor, String disciplina, String periodo, Turma turma, String observacao, Aluno aluno) {
        this.id = contador;
        contador++;
        this.professor = professor;
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.turma = turma;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
        this.observacao = observacao;
        this.aluno = aluno;
    }

    public RegistroProfessor() {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    private int id;
    private Professor professor;
    private String disciplina;
    private String periodo;
    private Turma turma;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private String observacao;
    private Aluno aluno;  // Adicionando relacionamento com Aluno

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Pessoa getProfessor() {
       return professor;
    }
    public void setProfessor(Pessoa professor) {
       this.professor = (Professor) professor;
    }
    public String getDisciplina() {
       return disciplina;
    }
    public void setDisciplina(String disciplina) {
       this.disciplina = disciplina;
    }
    public String getPeriodo() {
       return periodo;
    }
    public void setPeriodo(String periodo) {
       this.periodo = periodo;
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
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "RegistroProfessor{" +
                "id=" + id +
                ", professor=" + professor +
                ", disciplina='" + disciplina + '\'' +
                ", periodo='" + periodo + '\'' +
                ", turma=" + turma +
                ", dataCriacao=" + dataCriacao +   
                ", dataModificacao=" + dataModificacao +
                ", observacao='" + observacao + '\'' +
                ", aluno=" + aluno +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroProfessor registroProfessor = (RegistroProfessor) o;
        return id == registroProfessor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    } 
}
