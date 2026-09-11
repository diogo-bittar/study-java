package modulo1;

import java.util.Scanner;

public class ExercicioMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Adicionar");
            System.out.println("2 - Consultar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Escreva aqui: ");
                String resposta = scanner.nextLine();

                System.out.println("Adicionado com sucesso: " + resposta);

            } else if (opcao == 2) {
                System.out.println("Consulta realizada.");

            } else if (opcao == 0) {
                System.out.println("Saindo...");

            } else {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}