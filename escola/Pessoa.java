package escola;

abstract class Pessoa implements Printable {
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void print() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereco: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}
