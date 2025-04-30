package model;
import java.time.LocalDateTime;

public class RegistroProfessorDescricao {
    private int id;
    private RegistroProfessor registro;
    private Aluno aluno;
    private String observacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RegistroProfessor getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroProfessor registro) {
        this.registro = registro;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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