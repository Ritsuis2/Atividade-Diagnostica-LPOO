package escola;

import java.util.ArrayList;
import java.util.List;

class Estudante extends Pessoa {

    private String matricula;
    private List<Nota> notas;
    private Double notaRecuperacao;
    private List<LogModificacaoNota> logs;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
        this.notas = new ArrayList<>();
        this.notaRecuperacao = null;
        this.logs = new ArrayList<>();

    }

    public void adicionarNota(Double nota1, Double nota2, Double nota3, Double peso1, Double peso2, Double peso3) {
        notas.add(new Nota(nota1, nota2, nota3, peso1, peso2, peso3));
    }

    public void modificarNota(int index, double novaNota, String nomeCoordenador) {
        if (index >= 0 && index < notas.size()) {
            Nota nota = notas.get(index);
            double notaAnterior = nota.calcularMedia();
            nota.setNota1(novaNota);

            LogModificacaoNota log = new LogModificacaoNota(nomeCoordenador, notaAnterior, novaNota);
            logs.add(log);
            log.printLog(); 
        }
    }

    public void imprimirLogs() {
        for (LogModificacaoNota log : logs) {
            log.printLog();
        }
    }

    public void adicionarNotaRecuperacao(double valor) {
        this.notaRecuperacao = valor;
    }

    public Double getNotaRecuperacao() {
        return notaRecuperacao;
    }

    public double calcularMediaPonderada() {
        double somaNotas = 0;
        double somaPesos = 0;

        for (Nota nota : notas) {
            somaNotas += nota.calcularMedia() * nota.peso1;
            somaPesos += nota.getPeso1;
        }

        return somaPesos == 0 ? 0 : somaNotas / somaPesos;
    }

    public String getStatus(Curso curso) {
        double media = calcularMediaPonderada();

        if (notaRecuperacao == null) {
            if (media >= curso.getMediaAprovacao()) {
                return "APROVADO";
            } else if (media >= curso.getMediaRecuperacao()) {
                return "EM RECUPERAÇÃO";
            } else {
                return "REPROVADO";
            }
        }

        double mediaFinal = (media + notaRecuperacao) / 2;
        return mediaFinal >= curso.getMediaAprovacao() ? "APROVADO" : (mediaFinal >= curso.getMediaRecuperacao() ? "EM RECUPERAÇÃO" : "REPROVADO");

    }
}
