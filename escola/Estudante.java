package escola;

import java.util.ArrayList;
import java.util.List;

class Estudante extends Pessoa {

    private String matricula;
    private List<Nota> notas;
    private Double notaRecuperacao;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
        this.notas = new ArrayList<>();
        this.notaRecuperacao = null;
    }

    public void adicionarNota(Double nota1, Double nota2, Double nota3, Double peso1, Double peso2, Double peso3) {
        notas.add(new Nota(nota1, nota2, nota3, peso1, peso2, peso3));
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
            somaPesos += nota.peso1;
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
