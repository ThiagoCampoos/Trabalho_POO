package dao;

import java.time.LocalDateTime;
import model.PeriodoLetivo;

public class PeriodoLetivoDAO {
    private PeriodoLetivo[] periodos = new PeriodoLetivo[100];
    private int contador = 0;

    public void criar(PeriodoLetivo periodo) {
        periodo.setId(contador + 1);
        periodo.setDataCriacao(LocalDateTime.now());
        periodo.setDataModificacao(LocalDateTime.now());
        periodos[contador] = periodo;
        contador++;
    }

    public PeriodoLetivo buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (periodos[i] != null && periodos[i].getId() == id) {
                return periodos[i];
            }
        }
        return null;
    }

    public void atualizar(PeriodoLetivo periodoAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (periodos[i].getId() == periodoAtualizado.getId()) {
                periodoAtualizado.setDataModificacao(LocalDateTime.now());
                periodos[i] = periodoAtualizado;
                break;
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < contador; i++) {
            if (periodos[i].getId() == id) {
                periodos[i] = null;
                // Compacta o array após exclusão
                for (int j = i; j < contador - 1; j++) {
                    periodos[j] = periodos[j + 1];
                }
                contador--;
                break;
            }
        }
    }

    public PeriodoLetivo[] listarTodos() {
        PeriodoLetivo[] lista = new PeriodoLetivo[contador];
        System.arraycopy(periodos, 0, lista, 0, contador);
        return lista;
    }
}