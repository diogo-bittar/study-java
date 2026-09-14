package modulo1;

import java.util.Scanner;

public class ExSystemNotes {
    public static void main(String[] args){
        System.out.println("Sistema de Notas");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos alunos serão cadastrados?: ");
        String line = scanner.nextLine();

        int qtdAlun = Integer.parseInt(line);

        String[] names = new String[qtdAlun];
        double[] note1 = new double[qtdAlun];
        double[] note2 = new double[qtdAlun];

        for(int i = 0; i < qtdAlun; i++){
            System.out.println("Nome do Aluno: ");
            names[i] = scanner.nextLine();

            System.out.println("Nota 1: ");
            note1[i] = Double.parseDouble(scanner.nextLine());

            System.out.println("Nota 2: ");
            note2[i] = Double.parseDouble(scanner.nextLine());

        }
        double sumNotes = 0.0;
        int alunsAprovados = 0;
        for(int j = 0; j < qtdAlun; j++){
            double media = (note1[j] + note2[j]) / 2;
            System.out.println(names[j]);
            System.out.println(note1[j]);
            System.out.println(note2[j]);

            if (media >= 7.0){
                System.out.println("Aprovado");
                alunsAprovados++;
            }else if (media >= 5.0){
                System.out.println("Exame");
            }else{
                System.out.println("Reprovado");
            }
            sumNotes += media;
        }
        System.out.println("Média da Turma: " + (sumNotes / qtdAlun));
        System.out.println("Aprovados: " + alunsAprovados);


    }
}
