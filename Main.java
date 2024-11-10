import java.util.ArrayList;
import java.util.List;

interface Printable {
    void print();
}

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

    public double getPeso() {
        return peso;
    }
}

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

class Professor extends Pessoa {
    private int siape;

    public Professor(String nome, String cpf, String endereco, String telefone, int siape) {
        super(nome, cpf, endereco, telefone);
        this.siape = siape;
    }

    public void print() {
        super.print();
        System.out.println("SIAPE: " + siape);
    }
}

class Estudante extends Pessoa {
    private String matricula;
    private List<Double> notas;
    private List<Double> pesos;
    private Double notaRecuperacao;

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
        this.notas = new ArrayList<>();
        this.pesos = new ArrayList<>();
        this.notaRecuperacao = null;
    }

    public void adicionarNota(double valor, double peso) {
        this.notas.add(valor);
        this.pesos.add(peso);
    }

    public void adicionarNotaRecuperacao(double valor) {
        this.notaRecuperacao = valor;
    }

    public double calcularMediaPonderada() {
        double somaNotas = 0;
        double somaPesos = 0;

        for (int i = 0; i < notas.size(); i++) {
            somaNotas += notas.get(i) * pesos.get(i);
            somaPesos += pesos.get(i);
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

    public void print(Curso curso) {
        super.print();
        System.out.println("Matricula: " + matricula);
        System.out.println("Media Ponderada: " + calcularMediaPonderada());
        System.out.println("Status: " + getStatus(curso));
        if (notaRecuperacao != null) {
            System.out.println("Nota de Recuperação: " + notaRecuperacao);
        } else {
            System.out.println("Nota de Recuperação: SN");
        }
    }
}
class Turma {
    private String identificacao;
    private Curso curso;
    private List<Estudante> estudantes;
    private List<Professor> professores;

    public Turma(String identificacao, Curso curso) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.estudantes = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void adicionarEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
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
            String status = estudante.getStatus(curso);
            if (status.equals("APROVADO")) {
                aprovados.add(estudante);
            } else if (status.equals("REPROVADO")) {
                reprovados.add(estudante);
            } else if (status.equals("EM RECUPERAÇÃO")) {
                emRecuperacao.add(estudante);
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

        for (Estudante estudante : estudantes){
            String status =  estudante.getStatus(curso);
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
            e.print(curso);
            System.out.println();
        }

        gerarEstatisticas();
        gerarListas();
    }
}

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Engenharia de Software", 9, 7.0, 2.5);
        Curso curso2 = new Curso("Banco de Dados", 7, 7.0, 2.5);

        Professor professor1 = new Professor("Luis Araujo", "000.000.00-0", "Rua X, Bairro Y", "987662577", 12345);
        Professor professor2 = new Professor("Rosangela Garcia", "111.111.11-1", "Rua Z, Bairro W", "912345678", 67890);

        Estudante estudante1 = new Estudante("Joao Souza", "222.222.22-2", "Rua A, Bairro B", "987654321", "2023001");
        estudante1.adicionarNota(8.5, 3);
        estudante1.adicionarNota(6.0, 3);
        estudante1.adicionarNota(9.0, 4);

        Estudante estudante2 = new Estudante("Mirele Oliveira", "333.333.33-3", "Rua C, Bairro D", "998877665", "2023002");
        estudante2.adicionarNota(7.0, 4);
        estudante2.adicionarNota(8.0, 3);
        estudante2.adicionarNota(5.0, 3);

        Estudante estudante3 = new Estudante("Ana Costa", "444.444.444-4", "Rua E, Bairro F", "985633211", "5552668");
        estudante3.adicionarNota(5.0, 2);
        estudante3.adicionarNota(4.5, 3);
        estudante3.adicionarNota(6.0, 5);

        Estudante estudante4 = new Estudante("Andressa Mota", "555.555.555-5", "Rua G, Bairro H", "998544721", "5586441");
        estudante4.adicionarNota(10.0, 5);
        estudante4.adicionarNota(9.0, 3);
        estudante4.adicionarNota(8.5, 2);

        Estudante estudante5 = new Estudante("Analice Silva", "666.666.666-6", "Rua I, Bairro J", "9971655", "2020322");
        estudante5.adicionarNota(2.0, 3);
        estudante5.adicionarNota(3.5, 3);
        estudante5.adicionarNota(4.0, 4);

        estudante5.adicionarNotaRecuperacao(6.0);

        Turma turma1 = new Turma("TURMA1", curso1);
        turma1.adicionarEstudante(estudante1);
        turma1.adicionarEstudante(estudante2);
        turma1.adicionarEstudante(estudante3);
        turma1.adicionarEstudante(estudante4);
        turma1.adicionarEstudante(estudante5);
        turma1.adicionarProfessor(professor1);
        turma1.adicionarProfessor(professor2);

        Turma turma2 = new Turma("TURMA2", curso2);
        turma2.adicionarEstudante(estudante1);
        turma2.adicionarEstudante(estudante2);
        turma2.adicionarEstudante(estudante3);
        turma2.adicionarEstudante(estudante4);
        turma2.adicionarEstudante(estudante5);
        turma2.adicionarProfessor(professor1);
        turma2.adicionarProfessor(professor2);

        System.out.println("==== Turma 1 ====");
        turma1.print();
    
        System.out.println("==== Turma 2 ====");
        turma2.print();
    }
}

