package model;

import java.time.LocalDateTime;

public class RegistroProfessor {
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

    
}
