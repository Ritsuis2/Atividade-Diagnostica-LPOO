
import java.util.ArrayList;
import java.util.List;

interface Printable {
    void print();
}

class Curso {
    private String nome;
    private int semestres;

    public Curso(String nome, int semestres) {
        this.nome = nome;
        this.semestres = semestres;
    }

    public String getNome() {
        return nome;
    }

    public int getSemestres() {
        return semestres;
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

    public Estudante(String nome, String cpf, String endereco, String telefone, String matricula) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
    }

    public void print() {
        super.print();
        System.out.println("Matricula: " + matricula);
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

    public void print() {
        System.out.println("Turma: " + identificacao + ", Curso: " + curso.getNome());

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor vinculado.");
        } else {
            System.out.println("Professores:");
            for (Professor professor : professores) {
                professor.print();
            }
        }

        System.out.println("Estudantes:");
        for (Estudante e : estudantes) {
            e.print();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Engenharia de Software", 9);
        Curso curso2 = new Curso("Banco de Dados", 7);

        Professor professor1 = new Professor("Luis Araujo", "000.000.00-0", "Rua X, Bairro Y", "987662577", 12345);
        Professor professor2 = new Professor("Rosangela Garcia", "111.111.11-1", "Rua Z, Bairro W", "912345678", 67890);

        Estudante estudante1 = new Estudante("Joao Souza", "222.222.22-2", "Rua A, Bairro B", "987654321", "2023001");
        Estudante estudante2 = new Estudante("Mirele Oliveira", "333.333.33-3", "Rua C, Bairro D", "998877665", "2023002");
        Estudante estudante3 = new Estudante("Ana Costa", "444.444.444-4", "Rua E, Bairro F", "985633211", "5552668");
        Estudante estudante4 = new Estudante("Andressa Mota", "555.555.555-5", "Rua G, Bairro H", "998544721", "5586441");
        Estudante estudante5 = new Estudante("Analice Silva", "666.666.666-6", "Rua I, Bairro J", "9971655", "2020322");

        Turma turma1 = new Turma("TURMA1", curso1);
        Turma turma2 = new Turma("TURMA2", curso2);

        turma1.adicionarEstudante(estudante1);
        turma1.adicionarEstudante(estudante2);
        turma1.adicionarEstudante(estudante3);
        turma1.adicionarEstudante(estudante4);
        turma1.adicionarEstudante(estudante5);
        turma1.adicionarProfessor(professor1);
        turma1.adicionarProfessor(professor2);

        turma2.adicionarEstudante(estudante1);
        turma2.adicionarEstudante(estudante2);
        turma2.adicionarEstudante(estudante3);
        turma2.adicionarEstudante(estudante4);
        turma2.adicionarEstudante(estudante5);
        
        turma2.adicionarProfessor(professor1);
        turma2.adicionarProfessor(professor2);


        turma1.print();
        System.out.println();
        turma2.print();
    }
}
