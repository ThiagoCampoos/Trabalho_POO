package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {
    private int id;
    private static int serial = 0;
    private String nome;
    protected static LocalDate nascimento;
    private String telefone;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    protected LocalDateTime dataModificacao;
    private String tipo; 

    public Pessoa(String nome, LocalDate nascimento, String telefone, String login, String senha, String tipo) {
        this.id = ++Pessoa.serial;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;   
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }


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

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone; 
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login; 
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", telefone=" + telefone
                + ", login=" + login + ", senha=" + senha + ", dataCriacao=" + dataCriacao + ", dataModificacao="
                + dataModificacao + ", tipo=" + tipo + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id + login + senha + tipo + dataCriacao + dataModificacao + nome + nascimento + telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(id, other.id) && Objects.equals(login, other.login)
                && Objects.equals(senha, other.senha) && Objects.equals(tipo, other.tipo)
                && Objects.equals(dataCriacao, other.dataCriacao)
                && Objects.equals(dataModificacao, other.dataModificacao) && Objects.equals(nome, other.nome);
    }
}

