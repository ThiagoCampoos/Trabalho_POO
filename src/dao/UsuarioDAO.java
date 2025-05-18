package dao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
public class UsuarioDAO {
    private Usuario[] usuarios = new Usuario[1000];
    private int contador = 0;

    public void criar(Usuario usuario) {
        usuario.setId(contador + 1);
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setDataModificacao(LocalDateTime.now());
        usuarios[contador] = usuario;
        contador++;
    }
    public Usuario buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null;
    }
    
    public void atualizar(Usuario usuario) {
        usuario.setDataModificacao(LocalDateTime.now());
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == usuario.getId()) {
                usuarios[i] = usuario;
                break;
            }
        }
    }

    public List<Usuario> listarPorEscola(int escolaId) {
        List<Usuario> usuariosEscola = new ArrayList<>();
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getEscolaId() == escolaId) {
                usuariosEscola.add(usuarios[i]);
            }
        }
        return usuariosEscola;
    }
    
    public void excluir(int id) {
        int posicao = -1;
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == id) {
                posicao = i;
                break;
            }
        }
        
        if (posicao != -1) {
            // Desloca todos os elementos após o elemento removido
            for (int i = posicao; i < contador - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }
            usuarios[contador - 1] = null; // Remove a referência do último elemento
            contador--;
        }
    }
    
    public Usuario[] listarTodos() {
        Usuario[] resultado = new Usuario[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = usuarios[i];
        }
        return resultado;
    }
}
