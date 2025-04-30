package model;
import java.time.LocalDateTime;
public class VidaAcademica {
    private int id;
    private String tipo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
