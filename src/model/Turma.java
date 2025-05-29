package model;
import java.time.LocalDateTime;
import java.util.Objects;
public class Turma {
    private int id;
    private int contador = 0;

    public Turma(int id, String nome, Curso curso, Escola escola, String periodo, String status) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.escola = escola;
        this.periodo = periodo;
        this.status = status;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

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

    @Override
    public String toString() {
        return "Turma [id=" + id + ", nome=" + nome + ", curso=" + curso + ", escola=" + escola + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id + nome + curso + escola + periodo + status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Turma other = (Turma) obj;
        return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(curso, other.curso)
                && Objects.equals(escola, other.escola) && Objects.equals(periodo, other.periodo)
                && Objects.equals(status, other.status);
    }

}
