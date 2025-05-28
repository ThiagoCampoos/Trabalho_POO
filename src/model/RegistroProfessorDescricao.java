package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class RegistroProfessorDescricao {
    private static int contador = 1;

    public RegistroProfessorDescricao(RegistroProfessor registro, Aluno aluno, String observacao) {
        this.id = contador;
        contador++;
        this.registro = registro;
        this.aluno = aluno;
        this.observacao = observacao;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.registro);
        hash = 17 * hash + Objects.hashCode(this.aluno);
        hash = 17 * hash + Objects.hashCode(this.observacao);
        hash = 17 * hash + Objects.hashCode(this.dataCriacao);
        hash = 17 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistroProfessorDescricao other = (RegistroProfessorDescricao) obj;
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "RegistroProfessorDescricao{" + "id=" + id + ", registro=" + registro + ", aluno=" + aluno
                + ", observacao=" + observacao + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao
                + '}';
    }
}