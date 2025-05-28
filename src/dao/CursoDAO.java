package dao;

import java.time.LocalDateTime;
import model.Curso;

public class CursoDAO {
    private Curso[] cursos = new Curso[100];
    private int contador = 0;

    public CursoDAO() {
        criar(new Curso("Informatica Basica", "INF", "Tecnologia"));
        criar(new Curso("Excel e PowerBI", "EPB", "Tecnologia"));
        criar(new Curso("Admistração", "ADM", "Exatas"));
        criar(new Curso("Eletrica Industrial", "EI", "Tecnologia"));
    }

    public void criar(Curso curso) {
        curso.setId(contador + 1);
        curso.setDataCriacao(LocalDateTime.now());
        curso.setDataModificacao(LocalDateTime.now());
        cursos[contador] = curso;
        contador++;
    }

    public Curso buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].getId() == id) {
                return cursos[i];
            }
        }
        return null;
    }

    public void atualizar(Curso cursoAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].getId() == cursoAtualizado.getId()) {
                cursoAtualizado.setDataModificacao(LocalDateTime.now());
                cursos[i] = cursoAtualizado;
                break;
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < contador; i++) {
            if (cursos[i].getId() == id) {
                cursos[i] = null;
                for (int j = i; j < contador-1; j++) {
                    cursos[j] = cursos[j+1];
                }
                contador--;
                break;
            }
        }
    }

    public Curso[] listarTodos() {
        Curso[] lista = new Curso[contador];
        System.arraycopy(cursos, 0, lista, 0, contador);
        return lista;
    }
}
