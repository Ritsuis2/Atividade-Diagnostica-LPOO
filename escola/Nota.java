package escola;

class Nota {

    Double nota1;
    Double nota2;
    Double nota3;
    Double peso1;
    Double peso2;
    Double peso3;
    Curso curso;
    Turma turma;

    public Nota() {
        nota1 = null;
        nota2 = null;
        nota3 = null;
        peso1 = 1.0; // Caso não haja pesos, a média será simples
        peso2 = 1.0;
        peso3 = 1.0;
    }

    public double calcularMedia() {
        if ((nota1 == null) || (nota2 == null) || (nota3 == null)) {
            return -1;
        }

        boolean pesosDefinidos = (peso1 != null && peso2 != null && peso3 != null);

        if (pesosDefinidos) {
            // Média ponderada
            return (nota1 * peso1 + nota2 * peso2 + nota3 * peso3) / (peso1 + peso2 + peso3);
        } else {
            // Média simples
            return (nota1 + nota2 + nota3) / 3;
        }
    }

    public String getSituacao() {
        double media = calcularMedia();
        if (media >= curso
           {

        }
        ,getMediaRecuperacao()
            
        
        
            ) {
            return "Aprovado";
        }else if (media >=curso.getMediaRecuperacao()) {
            return "Em recuperação";
        }else {
            return "Reprovado";
        }
    }

}
