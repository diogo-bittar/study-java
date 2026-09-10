package modulo1;

public class ExercicioPares {
    public static void main(String[] args){
        int[] numeros = {1, 2, 4, 7, 9};

        for (int i = 0; i < 5; i++){
            if(numeros[i] % 2 == 0){
                System.out.println("Pares:" + numeros[i]);
            }
        }
    }
}
