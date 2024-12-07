package escola;

class LogModificacaoNota {
    private String nomeCoordenador;
    private double notaAnterior;
    private double notaAtual;

    public LogModificacaoNota(String nomeCoordenador, double notaAnterior, double notaAtual) {
        this.nomeCoordenador = nomeCoordenador;
        this.notaAnterior = notaAnterior;
        this.notaAtual = notaAtual;
    }

    public void printLog() {
        System.out.println("Coordenador: " + nomeCoordenador);
        System.out.println("Nota Anterior: " + notaAnterior);
        System.out.println("Nota Atual: " + notaAtual);
    }
}
