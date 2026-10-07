package moduloAlura;

import java.util.Scanner;

public class desafioAlura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double saldo = 0;
        int option;

        do{
            System.out.println("1- Consultar saldo\n 2- Receber valor\n 3- Transferir valor\n 4- Sair\nEscolha sua opção");
            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("Saldo atual: " + saldo);
            }else if(option == 2){
                System.out.println("Quanto deseja receber: ");
                double valorRecebido = Double.parseDouble(scanner.nextLine());
                saldo += valorRecebido;
                System.out.println(saldo);
            }else if(option == 3){
                System.out.println("Quanto deseja transferir?: ");
                double valorTransferido = Double.parseDouble(scanner.nextLine());
                saldo -= valorTransferido;
                System.out.println(saldo);
            }else{
                System.out.println("Saindo...");
            }


        }while(option != 4);
    }
}
