package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Aluno {
    private int id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String email;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Aluno() {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    public Aluno(String cpf, String nome, LocalDate nascimento, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.email = email;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    
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
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.nascimento);
        hash = 79 * hash + Objects.hashCode(this.telefone);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.dataCriacao);
        hash = 79 * hash + Objects.hashCode(this.dataModificacao);   
        return hash;
    }
}
