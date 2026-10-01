package modulo2;

import java.util.Scanner;

public class GestaoDeApolices {
    static Scanner scanner = new Scanner(System.in);
    static Apolice[] apolices = new Apolice[10];
    static int qtd = 0;
    static int opc;

    public static void main(String[] args){
        System.out.println("Gestão de Apólices");

        do{
            System.out.print("1- Cadastrar apólice\n2- Listar apólices\n3- Valor total de prêmios\n4- Ver apólices acima do valor\n5- Sair\nEscolha uma opção: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            if(opc == 1){
                cadastrarApolice();
            }else if(opc == 2){
                listarApolices();
            }else if(opc == 3){
                valueTotalPremios();
            }else if(opc == 4){
                contarAcimaDeValor();
            }else if(opc == 5){
                System.out.println("Exiting of system...");
            }else{
                System.out.println("Option invalid...");
            }
        }while(opc != 5);
    }


    static void cadastrarApolice(){
        System.out.println("Name: ");
        String nameSegurado = scanner.nextLine();

        System.out.println("Value: ");
        double valuePremio = Double.parseDouble(scanner.nextLine());

        System.out.println("Category: ");
        String category = scanner.nextLine();
        apolices[qtd] = new Apolice(nameSegurado, valuePremio, category);
        qtd++;
    }

    static void listarApolices(){
        for(int i = 0; i < qtd; i++){
            System.out.println("Name: " + apolices[i].getSegurado() + " | Prêmio: " + apolices[i].getPremio() + " | Category: " + apolices[i].getCategoria());

        }
    }

    static void valueTotalPremios(){
        double sumTotal = 0;
        for(int j = 0; j < qtd; j++){
            sumTotal += apolices[j].getPremio();
        }
        System.out.println("Valor total de Prêmios: " + sumTotal);
    }

    static void contarAcimaDeValor(){
        System.out.print("Valor de corte: ");
        double valueLimit = Double.parseDouble(scanner.nextLine());

        int totall = 0;
        for(int k = 0; k < qtd; k++){
            if(apolices[k].getPremio() > valueLimit){
                totall++;
            }
        }
        System.out.println("Total encontrado: " + totall);
    }


}
