package escola;

class Curso {
    private String nome;
    private int semestres;
    private double mediaAprovacao;
    private double mediaRecuperacao;

    public Curso(String nome, int semestres, double mediaAprovacao, double mediaRecuperacao) {
        this.nome = nome;
        this.semestres = semestres;
        this.mediaAprovacao = mediaAprovacao;
        this.mediaRecuperacao = mediaRecuperacao;
    }

    public String getNome() {
        return nome;
    }

    public int getSemestres() {
        return semestres;
    }

    public double getMediaAprovacao() {
        return mediaAprovacao;
    }

    public double getMediaRecuperacao() {
        return mediaRecuperacao;
    }

    public String toString() {
        return nome + " (" + semestres + " semestres)";
    }
}
