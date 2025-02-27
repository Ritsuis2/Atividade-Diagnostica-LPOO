package escola;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Curso curso1 = new Curso("Engenharia de Software", 9, 7.0, 2.5);
        Curso curso2 = new Curso("Banco de Dados", 7, 7.0, 2.5);

        Professor professor1 = new Professor("Luis Araujo", "000.000.00-0", "Rua X, Bairro Y", "987662577", 12345);
        Professor professor2 = new Professor("Rosangela Garcia", "111.111.11-1", "Rua Z, Bairro W", "912345678", 67890);

        Estudante estudante1 = new Estudante("Joao Souza", "222.222.22-2", "Rua A, Bairro B", "987654321", "2023001");
        estudante1.adicionarNota(8.5, 6.0, 9.0, 3.0, 3.0, 4.0);  
        Estudante estudante2 = new Estudante("Mirele Oliveira", "333.333.33-3", "Rua C, Bairro D", "998877665",
                "2023002");
        estudante2.adicionarNota(7.0, 8.0, 8.5, 4.0, 3.0, 3.0); 

        Estudante estudante3 = new Estudante("Ana Costa", "444.444.444-4", "Rua E, Bairro F", "985633211", "5552668");
        estudante3.adicionarNota(5.0, 4.5, 6.0, 2.0, 3.0, 5.0);  
        Estudante estudante4 = new Estudante("Andressa Mota", "555.555.555-5", "Rua G, Bairro H", "998544721",
                "5586441");
        estudante4.adicionarNota(10.0, 9.0, 8.5, 5.0, 3.0, 2.0);  

        Estudante estudante5 = new Estudante("Analice Silva", "666.666.666-6", "Rua I, Bairro J", "9971655", "2020322");
        estudante5.adicionarNota(2.0, 3.5, 4.0, 3.0, 3.0, 4.0); 

        estudante5.adicionarNotaRecuperacao(6.0);

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Modificar nota de um estudante");
            System.out.println("2. Ver logs de um estudante");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do coordenador: ");
                    String coordenador = scanner.nextLine();
                    System.out.print("Digite o índice da nota a modificar (0 para primeira nota): ");
                    int indice = scanner.nextInt();
                    System.out.print("Digite a nova nota: ");
                    double novaNota = scanner.nextDouble();
                    estudante1.modificarNota(indice, novaNota, coordenador);
                    break;
                case 2:
                    estudante1.imprimirLogs();  // Exibe os logs
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
        scanner.close();

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
        turma1.emitirListaFinal();
        
        System.out.println("==== Turma 2 ====");
        turma2.print();
        turma2.emitirListaFinal(); 

    }
}
