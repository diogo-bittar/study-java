package moduloAlura;
import java.util.Scanner;

public class aula1 {
    public static void main(String[] args){
        System.out.println("Bem vindo ao DegeStreaming");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos filmes deseja cadastrar?: ");
        String linha = scanner.nextLine();

        int qtd = Integer.parseInt(linha);

        String[] names = new String[qtd];
        int[] years = new int[qtd];
        double[] notes = new double[qtd];

        for (int i = 0; i < qtd ; i++) {
            System.out.println("Name: ");
            names[i] = scanner.nextLine();

            System.out.println("Year: ");
            years[i] = Integer.parseInt(scanner.nextLine());

            System.out.println("Notes: ");
            notes[i] =  Double.parseDouble(scanner.nextLine());
        }
        double sum = 0.0;
        for (int j = 0; j < qtd; j++){
            System.out.println(names[j]);
            System.out.println(years[j]);
            System.out.println(notes[j]);

            if(notes[j] >= 8.0){
                System.out.println("Filme Imperdível");
            }else if(notes[j] >= 5.0){
                System.out.println("Filme Bom");
            }else{
                System.out.println("Filme Fraco");
            }
            sum += notes[j];
        }
    }

}
