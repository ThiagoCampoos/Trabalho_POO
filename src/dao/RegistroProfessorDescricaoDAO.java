package dao;

import model.RegistroProfessorDescricao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroProfessorDescricaoDAO {
    private List<RegistroProfessorDescricao> registrosDescricoes = new ArrayList<>();
    private int proximoId = 1;

    public void criar(RegistroProfessorDescricao descricao) {
        descricao.setId(proximoId++);
        descricao.setDataCriacao(LocalDateTime.now());
        descricao.setDataModificacao(LocalDateTime.now());
        registrosDescricoes.add(descricao);
    }

    public RegistroProfessorDescricao buscarPorId(int id) {
        for (RegistroProfessorDescricao descricao : registrosDescricoes) {
            if (descricao.getId() == id) {
                return descricao;
            }
        }
        return null;
    }

    public List<RegistroProfessorDescricao> listarTodos() {
        return new ArrayList<>(registrosDescricoes); // Retorna uma cópia para evitar modificações externas
    }

    public void atualizar(RegistroProfessorDescricao descricaoAtualizada) {
        for (int i = 0; i < registrosDescricoes.size(); i++) {
            if (registrosDescricoes.get(i).getId() == descricaoAtualizada.getId()) {
                descricaoAtualizada.setDataModificacao(LocalDateTime.now());
                registrosDescricoes.set(i, descricaoAtualizada);
                return;
            }
        }
    }

    public void deletar(int id) {
        registrosDescricoes.removeIf(descricao -> descricao.getId() == id);
    }

    // Método para buscar descrições por ID do RegistroProfessor principal
    public List<RegistroProfessorDescricao> buscarPorRegistroProfessorId(int registroId) {
        List<RegistroProfessorDescricao> descricoesFiltradas = new ArrayList<>();
        for (RegistroProfessorDescricao descricao : registrosDescricoes) {
            if (descricao.getRegistro() != null && descricao.getRegistro().getId() == registroId) {
                descricoesFiltradas.add(descricao);
            }
        }
        return descricoesFiltradas;
    }

    // Método para buscar descrições por ID do Aluno
    public List<RegistroProfessorDescricao> buscarPorAlunoId(int alunoId) {
        List<RegistroProfessorDescricao> descricoesFiltradas = new ArrayList<>();
        for (RegistroProfessorDescricao descricao : registrosDescricoes) {
            if (descricao.getAluno() != null && descricao.getAluno().getId() == alunoId) {
                descricoesFiltradas.add(descricao);
            }
        }
        return descricoesFiltradas;
    }
}