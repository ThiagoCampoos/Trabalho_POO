package dao;

import java.time.LocalDateTime;
import model.Escola;

public class EscolaDAO {
    private Escola[] escolas = new Escola[1000];
    private int contador = 0;

    public EscolaDAO() {
        criar(new Escola("Escola Estadual Nossa Senhora Do Carmo", "Betim", "31302598781"));
        criar(new Escola("Escola Estadual Amelia Santana Barbosa", "betim", "31302598782"));

    }

    public void inserirEscola(Escola escola) {
        for(int i = 0; i < escolas.length; i++) {
            if(escolas[i] == null) {
                escola.setId(i + 1);
                escola.setDataCriacao(LocalDateTime.now());
                escola.setDataModificacao(LocalDateTime.now());
                escolas[i] = escola;
                break;
            }
        }
    } 

    public void criar(Escola escola) {
        escola.setId(contador + 1);
        escola.setDataCriacao(LocalDateTime.now());
        escola.setDataModificacao(LocalDateTime.now());
        escolas[contador] = escola;
        contador++;
    }
    public Escola buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (escolas[i].getId() == id) {
                return escolas[i];
            }
        }
        return null;
    }

    public void atualizar(Escola escolaAtualizada) {
        for (int i = 0; i < contador; i++) {
            if (escolas[i].getId() == escolaAtualizada.getId()) {
                escolaAtualizada.setDataModificacao(LocalDateTime.now());
                escolas[i] = escolaAtualizada;
                break;
            }
        }
    }
    public void excluir(int id) {
        for (int i = 0; i < contador; i++) {
            if (escolas[i] != null && escolas[i].getId() == id) {
                // Move todos os elementos subsequentes uma posição para trás
                for (int j = i; j < contador - 1; j++) {
                    escolas[j] = escolas[j + 1];
                }
                escolas[contador - 1] = null; // Limpa a última posição antiga
                contador--;
                break;
            }
        }
    }

    public Escola[] listarTodos() {
        Escola[] lista = new Escola[contador];
        int indiceLista = 0;
        for (int i = 0; i < contador; i++) {
            if (escolas[i] != null) { // Adicionado para garantir que não copie nulos se houver falha na exclusão
                lista[indiceLista++] = escolas[i];
            }
        }
        // Se houve nulos no meio por alguma razão (não deveria com a exclusão correta)
        // ajusta o tamanho do array.
        if (indiceLista < contador) {
            Escola[] listaAjustada = new Escola[indiceLista];
            System.arraycopy(lista, 0, listaAjustada, 0, indiceLista);
            return listaAjustada;
        }
        return lista;
    }
    // O método deletar(int id) foi removido por ser redundante com excluir(int id)

}
