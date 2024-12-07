package escola;

class Nota {
    private double valor;
    private double peso;

    public Nota(double valor, double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public double getPeso() {
        return peso;
    }
}