package model;

import java.time.LocalDate;

public class Professor extends Pessoa {
    private String disciplina;
    private int matricula;
    private LocalDate nascimento;
    private String telefone;
    private String email;
    private static String login;
    private static String senha;
    // Construtor
    public Professor(String disciplina, int matricula, String nome, LocalDate nascimento, String telefone, String email) {
        super(nome, nascimento, telefone, login, senha, "PROFESSOR");
        this.disciplina = disciplina;
        this.matricula = matricula;
    }
    // Getters e Setters
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


}