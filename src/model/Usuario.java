package model;
import java.time.LocalDateTime;

public class Usuario {
    private int id;
    private Pessoa pessoa;
    private int escolaId;
    private Escola escola;
    private String tipo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    // Novo campo e métodos de acesso
    private int pessoaId;
    
    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getEscolaId() {
        return escolaId;
    }
    public void setEscolaId(int escolaId) {
        this.escolaId = escolaId;
    }
    
    public Escola getEscola() {
        return escola;
    }
    public void setEscola(Escola escola) {
        this.escola = escola;
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
    
    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }
}
