package modulo1;
//Escreva um programa que leia 3 notas decimais via Scanner, calcule a média aritmética e informe se o aluno foi aprovado (média >= 7.0).
import java.util.Scanner;

public class ExercicioNotas {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double soma = 0;
        for (int i = 0; i < 3; i++){
            System.out.print("Digite a nota: ");
            double nota = scanner.nextDouble();
            soma += nota;
        }

        double media = soma / 3;
        if(media >= 7){
            System.out.print("Aprovado");
        }else{
            System.out.print("Reprovado");
        }
        scanner.close();
    }

}
