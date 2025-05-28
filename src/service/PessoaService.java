package service;

import javax.swing.JOptionPane;

import dao.PessoaDAO;
import model.Pessoa;
import java.time.LocalDate;

public class PessoaService {
    private static PessoaDAO pessoaDAO = new PessoaDAO();

    public static void criarPessoa(){
        Pessoa pessoa = new Pessoa(null, null, null, null, null, null);
        pessoa.setNome(JOptionPane.showInputDialog("Nome completo:"));
        pessoa.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Data nascimento (AAAA-MM-DD):")));
        pessoa.setTelefone(JOptionPane.showInputDialog("Telefone:"));
        pessoa.setLogin(JOptionPane.showInputDialog("Login:"));
        pessoa.setSenha(JOptionPane.showInputDialog("Senha:"));
        
        pessoaDAO.criar(pessoa);
        JOptionPane.showMessageDialog(null, "Pessoa cadastrada com ID: " + pessoa.getId());
    }
    public static void listarPessoas() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa p : pessoaDAO.listarTodos()) {
            sb.append("ID: ").append(p.getId())
              .append("\nNome: ").append(p.getNome())
              .append("\nNascimento: ").append(p.getNascimento())
              .append("\nLogin: ").append(p.getLogin())
              .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void atualizarPessoa() {
        String idStr = JOptionPane.showInputDialog("Digite o ID da pessoa:");
        try {
            int id = Integer.parseInt(idStr);
            Pessoa pessoa = pessoaDAO.buscarPorId(id);
            
            if (pessoa != null) {
                pessoa.setNome(JOptionPane.showInputDialog("Novo nome:", pessoa.getNome()));
                pessoa.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Nova data nascimento (AAAA-MM-DD):", pessoa.getNascimento().toString())));
                pessoa.setTelefone(JOptionPane.showInputDialog("Novo telefone:", pessoa.getTelefone()));
                pessoa.setLogin(JOptionPane.showInputDialog("Novo login:", pessoa.getLogin()));
                pessoa.setSenha(JOptionPane.showInputDialog("Nova senha:"));
                
                pessoaDAO.atualizar(pessoa);
                JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na atualização: " + e.getMessage());
        }
    }
    public static void excluirPessoa() {
        String idStr = JOptionPane.showInputDialog("Digite o ID da pessoa para excluir:");
        try {
            int id = Integer.parseInt(idStr);
            Pessoa pessoa = pessoaDAO.buscarPorId(id);
            
            if (pessoa != null) {
                pessoaDAO.deletar(id);
                JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}