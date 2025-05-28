package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Pessoa;

public class PessoaDAO {
    private Pessoa[] pessoas = new Pessoa[1000];
    private int contador = 0;
    
    public PessoaDAO() {
        // Administrador Geral
        criar(new Pessoa("Admin Geral", LocalDate.of(1980, 1, 1), "(11) 99999-0001", "admin", "123", "ADMIN"));
        
        // Administrador de Escola
        criar(new Pessoa("Admin Escola", LocalDate.of(1985, 2, 15), "(11) 99999-0002", "adminescola", "123", "ADMIN_ESCOLA"));
        
        // Professores (2)
        criar(new Pessoa("Carlos Oliveira", LocalDate.of(1975, 5, 20), "(11) 99999-0003", "carlos", "p1", "PROFESSOR"));
        criar(new Pessoa("Maria Santos", LocalDate.of(1980, 8, 10), "(11) 99999-0004", "maria", "p2", "PROFESSOR"));
        
        // Funcionários (3)
        criar(new Pessoa("Roberto Silva", LocalDate.of(1990, 3, 25), "(11) 99999-0005", "roberto", "f1", "FUNCIONARIO"));
        criar(new Pessoa("Ana Pereira", LocalDate.of(1988, 7, 12), "(11) 99999-0006", "ana", "f2", "FUNCIONARIO"));
        criar(new Pessoa("Paulo Souza", LocalDate.of(1992, 11, 5), "(11) 99999-0007", "paulo", "f3", "FUNCIONARIO"));
        
        // Alunos (5)
        criar(new Pessoa("João Silva", LocalDate.of(2000, 1, 15), "(11) 99999-0008", "joao", "a1", "ALUNO"));
        criar(new Pessoa("Maria Souza", LocalDate.of(2001, 2, 20), "(11) 99999-0009", "maria", "a2", "ALUNO"));
        criar(new Pessoa("Pedro Oliveira", LocalDate.of(2002, 3, 25), "(11) 99999-0010", "pedro", "a3", "ALUNO"));
        criar(new Pessoa("Lucia Santos", LocalDate.of(2003, 4, 30), "(11) 99999-0011", "lucia", "a4", "ALUNO"));
        criar(new Pessoa("Ricardo Lima", LocalDate.of(2004, 5, 5), "(11) 99999-0012", "ricardo", "a5", "ALUNO"));
        
;
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