package dao;

import java.time.LocalDateTime;
import model.Pessoa;

public class PessoaDAO {
    private Pessoa[] pessoas = new Pessoa[1000];
    private int contador = 0;
    
    public PessoaDAO() {
        // Adiciona um usuário Adim para acesso ao sistema
        if (contador == 0) {
            Pessoa admin = new Pessoa();
            admin.setNome("Adm");
            admin.setLogin("123");
            admin.setSenha("123");
            admin.setTipo("ADMIN"); // Definir o tipo do administrador como ADMIN
            criar(admin);
        }
    }

    public void criar(Pessoa pessoa) {
        pessoa.setId(contador + 1);
        pessoa.setDataCriacao(LocalDateTime.now());
        pessoa.setDataModificacao(LocalDateTime.now());
        
        // Novo campo tipo de usuário
        if(pessoa.getTipo() == null) {
            pessoa.setTipo("FUNCIONARIO"); // Tipo padrão para novos usuários
        }
        
        pessoas[contador] = pessoa;
        contador++;
    }

    public Pessoa buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public void atualizar(Pessoa pessoaAtualizada) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getId() == pessoaAtualizada.getId()) {
                pessoaAtualizada.setDataModificacao(LocalDateTime.now());
                pessoas[i] = pessoaAtualizada;
                break;
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i].getId() == id) {
                pessoas[i] = null; // Marca para exclusão
                // Compacta o array
                for (int j = i; j < contador-1; j++) {
                    pessoas[j] = pessoas[j+1];
                }
                contador--;
                break;
            }
        }
    }

    public Pessoa[] listarTodos() {
        Pessoa[] lista = new Pessoa[contador];
        System.arraycopy(pessoas, 0, lista, 0, contador);
        return lista;
    }

    public Pessoa[] getPessoas() {
        Pessoa[] resultado = new Pessoa[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = pessoas[i];
        }
        return resultado;
    }

}