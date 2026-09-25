package modulo1;
import java.util.Scanner;

public class CadastroNotas {
    public static void main(String[] args){
        System.out.println("Cadastro de notas");
        Scanner scanner = new Scanner(System.in);

        int opc;
        int qtd = 0;
        String[] names = new String[30];
        double[] notes = new double[30];

        do{
            System.out.print("1- Cadastrar aluno\n2- Listar alunos\n3- Ver média da turma\n4- Ver alunos aprovados\n5- Sair\nEscolha uma opção: ");
            opc = scanner.nextInt();
            scanner.nextLine();


            if (opc == 1){
                System.out.print("Nome do aluno: ");
                names[qtd] = scanner.nextLine();

                System.out.print("Nota do aluno: ");
                notes[qtd] = Double.parseDouble(scanner.nextLine());
                qtd++;
            }else if(opc == 2){
                for(int i = 0; i < qtd; i++){
                    System.out.println("Nome do aluno: " + names[i] + "  | Nota: " + notes[i]);
                }
            }else if(opc == 3){
                double soma = 0;
                for(int i = 0; i < qtd; i++){
                    soma+=notes[i];
                }
                if(qtd > 0){
                    System.out.println("Média: " + (soma / qtd));
                }
            }

        }while(opc != 5);
    }
}
