package model;

import java.time.LocalDateTime;
import java.util.Objects;


public class Escola {
    private static int contador = 1;

    public Escola(String nome, String cidade, String telefone) {
        this.id = contador;
        contador++;
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    private int id;
    private String nome;
    private String cidade;
    private String telefone;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        return "Escola [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", telefone=" + telefone + ", dataCriacao="
                + dataCriacao + ", dataModificacao=" + dataModificacao + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidade, dataCriacao, dataModificacao, id, nome, telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Escola other = (Escola) obj;
        return Objects.equals(cidade, other.cidade) && Objects.equals(dataCriacao, other.dataCriacao)
                && Objects.equals(dataModificacao, other.dataModificacao) && id == other.id
                && Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
    }
}   


