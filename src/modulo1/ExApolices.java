package modulo1;
import java.util.Scanner;

public class ExApolices {

    static Scanner scanner = new Scanner(System.in);
    static String[] segurados = new String[5];
    static double[] premios = new double[5];
    static String[] categorias = new String[5];
    static int qtd = 0;
    static int opc;

    public static void main(String[] args){
        System.out.println("Menu do Sistema de Apólices");

        do{
            System.out.print("1- Cadastrar apólice\n2- Listar apólices\n3- Valor total de prêmios\n4- Ver apólices acima do valor\n5- Sair\nEscolha uma opção: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            if(opc == 1){
                cadastrarApolice();
            }else if(opc == 2){
                listarApolices();
            }else if(opc == 3){
                calcularTotalPremios();
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
        System.out.print("Nome do Segurado nessa Apolice: ");
        segurados[qtd] = scanner.nextLine();

        System.out.print("Valor do prêmio: ");
        premios[qtd] = Double.parseDouble(scanner.nextLine());

        System.out.print("Categoria envolvida: ");
        categorias[qtd] = scanner.nextLine();

        qtd++;
    }

    static void listarApolices(){
        for(int i = 0; i < qtd; i++){
            System.out.println("Apólices: " + segurados[i] + " | Prêmios: " + premios[i] + " | Categoria: " + categorias[i]);
        }
    }

    static void calcularTotalPremios(){
        double sumTotal = 0;
        for(int j = 0; j < qtd; j++){
            sumTotal += premios[j];
        }
        System.out.println("Valor total de prêmios: " + sumTotal);
    }

    static void contarAcimaDeValor(){
        System.out.print("Valor de corte: ");
        double valorLimite = Double.parseDouble(scanner.nextLine());

        int total = 0;
        for(int k = 0; k < qtd; k++){
            if(premios[k] > valorLimite){
                total++;
            }
        }
        System.out.println("Total encontrado: " + total);
    }
}
