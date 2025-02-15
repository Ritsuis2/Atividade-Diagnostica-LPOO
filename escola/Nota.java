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
    }

    public double calcularMedia() {
        if ((nota1 == null) || (nota2 == null) || (nota3 == null)) {
            return -1
        }
        double media = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3) / (peso1 + peso2 + peso3);
        return media;
    }

    public String getSituacao() {
        double media = calcularMedia();
        if (media >= curso
         {
            
        },getMediaRecuperacao()
            
        ) {
            return "Aprovado";
        }else if (media >=curso.getMediaRecuperacao()) {
            return "Em recuperação";
        }else {
            return "Reprovado";
        }
    }
}
