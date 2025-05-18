package service;

import javax.swing.JOptionPane;

import dao.AlunoTurmaDAO;
import dao.TurmaDAO;
import model.AlunoTurma;
import model.Pessoa;
import model.Turma;

public class MenuAdm {
    public static void exibirMenu(){
        // Novo código de autenticação
        if(!LoginService.fazerLogin()) {
            JOptionPane.showMessageDialog(null, "Acesso negado!");
            return;
        }
        
        Pessoa usuario = LoginService.getUsuarioLogado();
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado!");
            return;
        }
        
        boolean isAdmGeral = "ADMIN".equals(usuario.getTipo());
        boolean isAdmEscola = "ADMIN_ESCOLA".equals(usuario.getTipo());
        boolean isProfessor = "PROFESSOR".equals(usuario.getTipo());
        // Adicionar outros tipos de usuário conforme necessário (ex: ALUNO, FUNCIONARIO)

        String opcao;
        do {
            StringBuilder menuDinamico = new StringBuilder("Menu Principal \n");

            // Opções para ADMIN_GERAL e ADMIN_ESCOLA (1-9)
            if (isAdmGeral || isAdmEscola) {
                menuDinamico.append("1 - Cadastrar Pessoa \n");
                menuDinamico.append("2 - Listar Pessoas \n");
                menuDinamico.append("3 - Atualizar Pessoa \n");
                menuDinamico.append("4 - Excluir Pessoa \n");
                menuDinamico.append("5 - Cadastrar Aluno \n");
                menuDinamico.append("6 - Listar Alunos \n");
                menuDinamico.append("7 - Buscar Aluno \n"); 
                menuDinamico.append("8 - Atualizar Aluno \n");
                menuDinamico.append("9 - Excluir Aluno \n");
            }

            // Opções Comuns a todos os usuários logados (ou quase todos) (10-11)
            menuDinamico.append("10 - Registrar Evento Acadêmico \n");
            menuDinamico.append("11 - Visualizar Timeline do Aluno \n");

            // Opções para PROFESSOR, ADMIN_GERAL, ADMIN_ESCOLA (12-13)
            if (isProfessor || isAdmGeral || isAdmEscola) {
                menuDinamico.append("12 - Registrar Avaliação de Professor \n");
                menuDinamico.append("13 - Exibir Conselho de Classe \n");
            }

            // Opções exclusivas para ADMIN_GERAL (14-21)
            if (isAdmGeral) {
                menuDinamico.append("14 - Cadastrar Escola \n");
                menuDinamico.append("15 - Listar Escolas \n");
                menuDinamico.append("16 - Atualizar Escola \n");
                menuDinamico.append("17 - Excluir Escola \n");
                menuDinamico.append("18 - Vincular Usuário (Pessoa a Escola com Papel) \n");
                menuDinamico.append("19 - Listar Usuários \n");
                menuDinamico.append("20 - Editar Usuário \n");
                menuDinamico.append("21 - Excluir Usuário \n");
            }

            // Opções para ADMIN_GERAL e ADMIN_ESCOLA (22-37)
            if (isAdmGeral || isAdmEscola) {
                menuDinamico.append("22 - Cadastrar Curso \n");
                menuDinamico.append("23 - Listar Cursos \n");
                menuDinamico.append("24 - Atualizar Curso \n");
                menuDinamico.append("25 - Excluir Curso \n");
                menuDinamico.append("26 - Cadastrar Turma \n");
                menuDinamico.append("27 - Listar Turmas \n");
                menuDinamico.append("28 - Atualizar Turma \n");
                menuDinamico.append("29 - Excluir Turma \n");
                menuDinamico.append("30 - Vincular Aluno a Turma \n");
                menuDinamico.append("31 - Mover Alunos entre Turmas \n");
                menuDinamico.append("32 - Registrar Período Letivo \n");
                menuDinamico.append("33 - Listar Períodos Letivos \n");
                menuDinamico.append("34 - Atualizar Período Letivo \n");
                menuDinamico.append("35 - Excluir Período Letivo \n");
                menuDinamico.append("36 - Atualizar Evento Acadêmico \n");
                menuDinamico.append("37 - Excluir Evento Acadêmico \n");
                menuDinamico.append("38 - Visualizar Turma Completa \n");
            }

            // Opções para PROFESSOR, ADMIN_GERAL, ADMIN_ESCOLA (39-46)
            if (isProfessor || isAdmGeral || isAdmEscola) {
                menuDinamico.append("39 - Criar Registro de Professor \n");
                menuDinamico.append("40 - Listar Registros de Professor \n");
                menuDinamico.append("41 - Atualizar Registro de Professor \n");
                menuDinamico.append("42 - Excluir Registro de Professor \n");
                menuDinamico.append("43 - Criar Descrição de Registro de Professor \n");
                menuDinamico.append("44 - Listar Descrições por Registro de Professor \n");
                menuDinamico.append("45 - Atualizar Descrição de Registro de Professor \n");
                menuDinamico.append("46 - Excluir Descrição de Registro de Professor \n");
            }
            
            // Opções para ADMIN_ESCOLA (algumas podem ser herdadas de ADMIN_GERAL ou específicas)
            if (isAdmEscola) {
                menuDinamico.append("47 - Vincular Professor a Turma \n");
                menuDinamico.append("48 - Listar Professores por Turma \n");
                menuDinamico.append("49 - Atualizar Professores por Turma \n");
                menuDinamico.append("50 - Excluir Professores por Turma \n");
                menuDinamico.append("51 - Vincular Curso a Turma \n");
                menuDinamico.append("52 - Listar Cursos por Turma \n");
                menuDinamico.append("53 - Atualizar Cursos por Turma \n");
                menuDinamico.append("54 - Excluir Cursos por Turma \n");
                menuDinamico.append("55 - Vincular Aluno a Curso \n");
                menuDinamico.append("56 - Listar Alunos por Curso \n");
                menuDinamico.append("57 - Atualizar Alunos por Curso \n");
                menuDinamico.append("58 - Excluir Alunos por Curso \n");
                menuDinamico.append("59 - Vincular Aluno a Professor \n");
                menuDinamico.append("60 - Listar Alunos por Professor \n");
                menuDinamico.append("61 - Atualizar Alunos por Professor \n");
                menuDinamico.append("62 - Excluir Alunos por Professor \n");
                menuDinamico.append("63 - Vincular Curso a Professor \n");
                menuDinamico.append("64 - Listar Cursos por Professor \n");
                menuDinamico.append("65 - Atualizar Cursos por Professor \n");
                menuDinamico.append("66 - Excluir Cursos por Professor \n");
            }

            menuDinamico.append("0 - Sair \n");
            opcao = JOptionPane.showInputDialog(menuDinamico.toString());


            switch(opcao){
                case "0":
                    JOptionPane.showMessageDialog(null, "Podemos ver que Hoje e um grande dia para chorar!");
                    break;
                case "1":
                    if(isAdmGeral || isAdmEscola) PessoaService.criarPessoa();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "2":
                    if(isAdmGeral || isAdmEscola) PessoaService.listarPessoas();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "3":
                    if(isAdmGeral || isAdmEscola) PessoaService.atualizarPessoa();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "4":
                    if(isAdmGeral || isAdmEscola) PessoaService.excluirPessoa();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "5":
                    if(isAdmGeral || isAdmEscola) AlunoService.criarAluno();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "6":
                    if(isAdmGeral || isAdmEscola) AlunoService.listarAlunos(); // Supondo que AlunoService.listarAlunos() exista
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "7":
                    if(isAdmGeral || isAdmEscola) AlunoService.buscarAluno(); // Supondo que AlunoService.buscarAluno() exista
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "8":
                    if(isAdmGeral || isAdmEscola) AlunoService.atualizarAluno();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "9":
                    if(isAdmGeral || isAdmEscola) AlunoService.excluirAluno();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "10":
                    VidaAcademicaService.registrarEvento(); // Acesso comum, sem verificação específica aqui, mas pode ser adicionada se necessário
                    break;
                case "11":
                    VidaAcademicaService.visualizarTimelineAluno(); // Acesso comum
                    break;
                case "12":
                    if(isProfessor || isAdmGeral || isAdmEscola) ProfessorService.registrarAvaliacao();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "13":
                    if(isProfessor || isAdmGeral || isAdmEscola) ProfessorService.exibirConselhoClasse();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "14":
                    if(isAdmGeral) EscolaService.criarEscola();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "15":
                    if(isAdmGeral) EscolaService.listarEscolas();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "16":
                    if(isAdmGeral) EscolaService.atualizarEscola();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "17":
                    if(isAdmGeral) EscolaService.excluirEscola();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "18":
                    if(isAdmGeral) UsuarioService.criarUsuario();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "19":
                    if(isAdmGeral) UsuarioService.listarUsuarios();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "20":
                    if(isAdmGeral) UsuarioService.editarUsuario();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "21":
                    if(isAdmGeral) UsuarioService.excluirUsuario();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "22":
                    if(isAdmGeral || isAdmEscola) CursoService.criarCurso();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "23":
                    if(isAdmGeral || isAdmEscola) CursoService.listarCursos();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "24":
                    if(isAdmGeral || isAdmEscola) CursoService.atualizarCurso();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "25":
                    if(isAdmGeral || isAdmEscola) CursoService.excluirCurso();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "26":
                    if(isAdmGeral || isAdmEscola) TurmaService.criarTurma();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "27":
                    if(isAdmGeral || isAdmEscola) TurmaService.listarTurmas();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "28":
                    if(isAdmGeral || isAdmEscola) TurmaService.atualizarTurma();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "29":
                    if(isAdmGeral || isAdmEscola) TurmaService.excluirTurma();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "30":
                    if(isAdmGeral || isAdmEscola) AlunoTurmaService.criarTurma(); // Ajustado para AlunoTurmaService e adicionada verificação
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "31":
                    if(isAdmGeral || isAdmEscola) AlunoTurmaService.moverAlunosTurma(); // Ajustado para AlunoTurmaService e adicionada verificação
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "32":
                    if(isAdmGeral || isAdmEscola) PeriodoLetivoService.registrarPeriodoLetivo();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "33":
                    if(isAdmGeral || isAdmEscola) PeriodoLetivoService.listarPeriodosLetivos();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "34":
                    if(isAdmGeral || isAdmEscola) PeriodoLetivoService.atualizarPeriodoLetivo();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "35":
                    if(isAdmGeral || isAdmEscola) PeriodoLetivoService.excluirPeriodoLetivo();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "36":
                    if(isAdmGeral || isAdmEscola) VidaAcademicaService.atualizarEvento(); // Adicionada verificação de permissão
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "37":
                    if(isAdmGeral || isAdmEscola) VidaAcademicaService.excluirEvento(); // Adicionada verificação de permissão
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "38":
                    if(isAdmGeral || isAdmEscola) VisualizarTurmaCompleta(); // Adicionada verificação de permissão
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "39":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorService.criarRegistro();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "40":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorService.listarRegistros();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "41":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorService.atualizarRegistro();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "42":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorService.excluirRegistro();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "43":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorDescricaoService.criarDescricao();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "44":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorDescricaoService.listarDescricoesPorRegistro();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "45":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorDescricaoService.atualizarDescricao();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                case "46":
                    if(isProfessor || isAdmGeral || isAdmEscola) RegistroProfessorDescricaoService.excluirDescricao();
                    else JOptionPane.showMessageDialog(null, "Acesso negado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }while (!opcao.equals("0"));
    }

    public static void VisualizarTurmaCompleta() {
        String idTurmaStr = JOptionPane.showInputDialog("Digite o ID da Turma:");
        try {
            int idTurma = Integer.parseInt(idTurmaStr);
            Turma turma = new TurmaDAO().buscarPorId(idTurma);
            
            if (turma == null) {
                JOptionPane.showMessageDialog(null, "Turma não encontrada!");
                return;
            }
            
            // Correção: Criar instância do DAO
            AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();
            AlunoTurma[] vinculados = alunoTurmaDAO.buscarPorTurma(idTurma);
            StringBuilder sb = new StringBuilder();
            sb.append("Dados da Turma:\n");
            sb.append("Nome: ").append(turma.getNome()).append("\n");
            sb.append("Curso: ").append(turma.getCurso().getNome()).append("\n");
            sb.append("Escola: ").append(turma.getEscola().getNome()).append("\n\n");
            sb.append("Alunos Matriculados (").append(vinculados.length).append("):\n");
            
            for (AlunoTurma vinculo : vinculados) {
                sb.append("- ").append(vinculo.getAluno().getNome()).append("\n");
            }
            
            JOptionPane.showMessageDialog(null, sb.toString(), "Detalhes da Turma", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!");
        }
    }
}
