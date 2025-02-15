package escola;

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

        Estudante estudante2 = new Estudante("Mirele Oliveira", "333.333.33-3", "Rua C, Bairro D", "998877665",
                "2023002");
        estudante2.adicionarNota(7.0, 4);
        estudante2.adicionarNota(8.0, 3);
        estudante2.adicionarNota(8.5, 3);

        Estudante estudante3 = new Estudante("Ana Costa", "444.444.444-4", "Rua E, Bairro F", "985633211", "5552668");
        estudante3.adicionarNota(5.0, 2);
        estudante3.adicionarNota(4.5, 3);
        estudante3.adicionarNota(6.0, 5);

        Estudante estudante4 = new Estudante("Andressa Mota", "555.555.555-5", "Rua G, Bairro H", "998544721",
                "5586441");
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
