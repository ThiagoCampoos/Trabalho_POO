package dao;

import model.RegistroProfessor;
import java.time.LocalDateTime;

public class RegistroProfessorDAO {
    private RegistroProfessor[] registros = new RegistroProfessor[100];
    private int contador = 0;

    public RegistroProfessorDAO() {
        criar(new RegistroProfessor(1, "Professor 1", "Matemática", "Turma A"));
        criar(new RegistroProfessor(2, "Professor 2", "História", "Turma B"));
    }

    public void criar(RegistroProfessor registro) {
        registro.setId(contador + 1);
        registro.setDataCriacao(LocalDateTime.now());
        registro.setDataModificacao(LocalDateTime.now());
        registros[contador] = registro;
        contador++;
    }

    public RegistroProfessor buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (registros[i] != null && registros[i].getId() == id) {
                return registros[i];
            }
        }
        return null;
    }

    public void atualizar(RegistroProfessor registroAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (registros[i] != null && registros[i].getId() == registroAtualizado.getId()) {
                registroAtualizado.setDataModificacao(LocalDateTime.now());
                registros[i] = registroAtualizado;
                break;
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < contador; i++) {
            if (registros[i] != null && registros[i].getId() == id) {
                registros[i] = null;
                for (int j = i; j < contador - 1; j++) {
                    registros[j] = registros[j + 1];
                }
                contador--;
                break;
            }
        }
    }

    public RegistroProfessor[] listarTodos() {
        RegistroProfessor[] lista = new RegistroProfessor[contador];
        System.arraycopy(registros, 0, lista, 0, contador);
        return lista;
    }
}