package modulo1;

import java.util.Scanner;

public class Exemplo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas notas o aluno tem? ");
        int quantidade = scanner.nextInt();

        double[] notas = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double media = calcularMedia(notas);
        System.out.println("Média: " + media);
        System.out.println(media >= 6.0 ? "Aprovado" : "Reprovado");

        scanner.close();
    }

    public static double calcularMedia(double[] valores) {
        double soma = 0;
        for (double v : valores) {
            soma += v;
        }
        return soma / valores.length;
    }
}