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

    public void adicionarNotaRecuperacao(double valor) {
        this.notaRecuperacao = valor;
    }

    public void setNotaRecuperacao(Double notaRecuperacao) {
        this.notaRecuperacao = notaRecuperacao;
    }

    public Double getNotaRecuperacao() {
        return notaRecuperacao;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public double calcularMediaPonderada() {
        double somaNotas = 0;
        double somaPesos = 0;

        for (int i = 0; i < notas.size(); i++) {
            somaNotas += notas.get(i).getValor() * notas.get(i).getPeso();
            somaPesos += notas.get(i).getPeso();
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
        if (mediaFinal >= curso.getMediaAprovacao()) {
            return "APROVADO";
        } else if (mediaFinal >= curso.getMediaRecuperacao()) {
            return "EM RECUPERAÇÃO";
        } else {
            return "REPROVADO";
        }
    }
}
