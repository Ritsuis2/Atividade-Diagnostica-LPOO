package escola;

class Professor extends Pessoa {

    private int siape;
    private boolean isCoordenador;

    public Professor(String nome, String cpf, String endereco, String telefone, int siape) {
        super(nome, cpf, endereco, telefone);
        this.siape = siape;
        this.isCoordenador = isCoordenador;

    }

    public boolean isCoordenador() {
        return isCoordenador;
    }

    public void print() {
        super.print();
        System.out.println("SIAPE: " + siape);
        System.out.println("Coordenador: " + (isCoordenador ? "Sim" : "Não"));

    }
}
