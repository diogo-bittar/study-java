package modulo1;
import java.util.Scanner;

public class SystemGastos {
    public static void main(String[] args){
        System.out.println("Gerenciador de Estoque");

        Scanner scanner = new Scanner(System.in);
        int opc;
        do{
            System.out.println("Quantos dados serão cadastrados?: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            if(opc <= 0){
                System.out.println("Opção inválida.");
            }
        }while(opc <= 0);

        String[] descricoes = new String[opc];
        double[] values = new double[opc];
        String[] category = new String[opc];

        for (int i = 0; i < opc; i++){
            System.out.println("Descrição: ");
            descricoes[i] = scanner.nextLine();

            System.out.println("Valor: ");
            values[i] = Double.parseDouble(scanner.nextLine());

            System.out.println("Categoria: ");
            category[i] = scanner.nextLine();
        }
        double sumGastos = 0.0;
        for (int j = 0; j < opc; j++){
            System.out.println(descricoes[j]);
            System.out.println(values[j]);
            System.out.println(category[j]);

            if(values[j] >= 500.0){
                System.out.println("Gasto alto");
            }else if(values[j] >= 100.0){
                System.out.println("Gasto médio");
            }else{
                System.out.println("Gasto baixo");
            }
            sumGastos += values[j];
        }
        System.out.println("Média de gastos: " + (sumGastos / opc));

        int acimaDaMedia = 0;
        double media = sumGastos / opc;
        for (int k = 0; k < opc; k++){
            if(values[k] > media){
                System.out.println("Gastos acima da média: " + acimaDaMedia);
            }
        }
    }
}
