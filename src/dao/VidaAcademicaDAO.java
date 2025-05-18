package dao;
import model.VidaAcademica;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
public class VidaAcademicaDAO {
    private VidaAcademica[] vidaAcademica = new VidaAcademica[1000];
    private int contador = 0;

    public void criar(VidaAcademica vidaAcademica) {
        vidaAcademica.setId(contador + 1);
        vidaAcademica.setDataCriacao(java.time.LocalDateTime.now());
        vidaAcademica.setDataModificacao(java.time.LocalDateTime.now());
        this.vidaAcademica[contador] = vidaAcademica;
        contador++;
    }
    public VidaAcademica buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (vidaAcademica[i].getId() == id) {
                return vidaAcademica[i];
            }
        }
        return null; // Não encontrou
    }
    
    public VidaAcademica[] listarTodos() {
        VidaAcademica[] resultado = new VidaAcademica[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = vidaAcademica[i];
        }
        return resultado;
    }

    public void atualizar(VidaAcademica vidaAtualizada) {
        for (int i = 0; i < contador; i++) {
            if (vidaAcademica[i].getId() == vidaAtualizada.getId()) {
                vidaAtualizada.setDataModificacao(LocalDateTime.now());
                vidaAcademica[i] = vidaAtualizada;
                break;
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < contador; i++) {
            if (vidaAcademica[i].getId() == id) {
                vidaAcademica[i] = null;
                for (int j = i; j < contador - 1; j++) {
                    vidaAcademica[j] = vidaAcademica[j + 1];
                }
                contador--;
                break;
            }
        }
    }
    public VidaAcademica[] listarPorAlunoId(int idAluno) {
        return Arrays.stream(vidaAcademica)
            .filter(va -> va != null && va.getAlunoId() == idAluno)
            .sorted(Comparator.comparing(VidaAcademica::getDataEvento))
            .toArray(VidaAcademica[]::new);
    }
}
