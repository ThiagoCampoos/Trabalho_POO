package model;
import java.time.LocalDateTime;
import java.util.Objects;

public class Curso {
    private static int contador = 1;

    public Curso(String nome, String sigla, String tipo) {
        this.id = contador;
        contador++;
        this.nome = nome;
        this.sigla = sigla;
        this.tipo = tipo;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    private int id;
    private String nome;
    private String sigla;
    private String tipo; 
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return Objects.hash(id + sigla + tipo + dataCriacao + dataModificacao + nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        return Objects.equals(id, other.id) && Objects.equals(sigla, other.sigla)
                && Objects.equals(tipo, other.tipo) && Objects.equals(dataCriacao, other.dataCriacao)
                && Objects.equals(dataModificacao, other.dataModificacao) && Objects.equals(nome, other.nome);
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", tipo=" + tipo + ", dataCriacao="
                + dataCriacao + ", dataModificacao=" + dataModificacao + "]";
    }
}
