package model;
import java.time.LocalDateTime;
public class Turma {
    private int id;
    private Curso curso;
    private Escola escola;
    private String periodo;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Escola getEscola() {
        return escola;
    }
    public void setEscola(Escola escola) {
        this.escola = escola;
    }

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
    
}
