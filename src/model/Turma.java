package model;
import java.time.LocalDateTime;
public class Turma {
    private int id;
    private String nome;
    // Adicionei os relacionamentos com Escola e Curso
    private Escola escola;
    private Curso curso;
    private String periodo;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    // Getters e Setters
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }    
    public Escola getEscola() {
        return escola;
    }

}
