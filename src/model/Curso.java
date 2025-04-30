package model;
import java.time.LocalDateTime;
public class Curso {
    private int id;
    private String nome;
    private String sigla;
    private String tipo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

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
    
}
