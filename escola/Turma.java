package escola;

import java.util.ArrayList;
import java.util.List;

class Turma {

    private String identificacao;
    private Curso curso;
    private List<Estudante> estudantes;
    private List<Professor> professores;
    private List<LogModificacaoNota> logs;

    public Turma(String identificacao, Curso curso) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.estudantes = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.logs = new ArrayList<>();

    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void adicionarEstudante(Estudante estudante) {
        this.estudantes.add(estudante);

    }

    public void alterarNotaEstudante(Professor coordenador, Estudante estudante, double novaNota) {
        if (coordenador.isCoordenador()) {
            for (Nota nota : estudante.getNotas()) {
                double notaAnterior = nota.getValor();
                nota.setValor(novaNota);
                LogModificacaoNota log = new LogModificacaoNota(coordenador.nome, notaAnterior, novaNota);
                logs.add(log);
            }
        } else {
            System.out.println("Somente coordenadores podem alterar notas.");
        }
    }

    public void mostrarInformacoes() {
        System.out.println("Turma: " + identificacao);
        System.out.println("Curso: " + curso.getNome());

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor vinculado.");
        } else {
            System.out.println("Professores:");
            for (Professor professor : professores) {
                professor.print();
            }
        }
    }

    public void gerarListas() {
        List<Estudante> aprovados = new ArrayList<>();
        List<Estudante> reprovados = new ArrayList<>();
        List<Estudante> emRecuperacao = new ArrayList<>();

        for (Estudante estudante : estudantes) {
            double media = estudante.calcularMediaPonderada();
            double mediaFinal = (notaRec != null) ? (media + notaRec) / 2 : media;
            double  notaRec = estudante.getNotaRecuperacao();

             if (media >= curso.getMediaAprovacao()) {
                aprovados.add(estudante); 
            } else if (media < curso.getMediaRecuperacao()) {
                reprovados.add(estudante); 
            } else { 
                if (notaRec == null) {
                    emRecuperacao.add(estudante); 
                } else {
                    if (mediaFinal < 5) {
                        reprovados.add(estudante); 
                    } else {
                        aprovados.add(estudante); 
                    }
                }
            }
        }

        System.out.println("Lista de Aprovados:");
        for (Estudante estudante : aprovados) {
            System.out.println(estudante.nome);
        }

        System.out.println("\nLista de Reprovados:");
        for (Estudante estudante : reprovados) {
            System.out.println(estudante.nome);
        }

        System.out.println("\nLista de Estudantes em Recuperação:");
        for (Estudante estudante : emRecuperacao) {
            System.out.println(estudante.nome);
        }
    }

    public void gerarEstatisticas() {
        int aprovados = 0;
        int emRecuperacao = 0;
        int reprovados = 0;

        for (Estudante estudante : estudantes) {
            String status = estudante.getStatus(curso);
            switch (status) {
                case "APROVADO":
                    aprovados++;
                    break;
                case "EM RECUPERAÇÃO":
                    emRecuperacao++;
                    break;
                case "REPROVADO":
                    reprovados++;
                    break;
            }

        }
        System.out.println("Estatísticas da Turma: " + identificacao);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Em Recuperação: " + emRecuperacao);
        System.out.println("Reprovados: " + reprovados);
    }

    public void print() {

        mostrarInformacoes();

        System.out.println("\nEstudantes:");
        for (Estudante e : estudantes) {
            e.print();
            System.out.println();
        }

        gerarEstatisticas();
        gerarListas();
    }

    public void emitirListaFinal() {
        System.out.println("==== Lista Final Após Recuperação ====");
        for (Estudante estudante : estudantes) {
            String status = estudante.getStatus(curso);
            System.out.println("Nome: " + estudante.nome);
            System.out.println("Status: " + status);

            if ("EM RECUPERAÇÃO".equals(status)) {
                if (estudante.getNotaRecuperacao() == null) {
                    System.out.println("Nota de Recuperação: SN (Sem Nota)");
                } else {
                    System.out.println("Nota de Recuperação: " + estudante.getNotaRecuperacao());
                    double media = estudante.calcularMediaPonderada();
                    double mediaFinal = (media + estudante.getNotaRecuperacao()) / 2;
                    if (mediaFinal < 5) {
                        System.out.println("Status Final (Após Rec): REPROVADO");
                    } else {
                        System.out.println("Status Final (Após Rec): APROVADO");
                    }
                }
            }
            System.out.println();
        }
    }

}
