package moduloAlura;

import java.util.*;

public class colecoesAlura {
    public static void main(String[] args) {
        List<String> funcionarios = new ArrayList<>();

        funcionarios.add("Diogo");
        funcionarios.add("Maria");
        funcionarios.add("Pedro");
        funcionarios.add("Diogo");

        System.out.println(funcionarios);

        Set<String> produtos = new HashSet<>();
        produtos.add("Água");
        produtos.add("Água de coco");
        produtos.add("Água");
        System.out.println(produtos);

        Map<Integer, String> clientes = new HashMap<>();
        clientes.put(1, "Diogo");
        clientes.put(2, "Bittar");
        clientes.put(3, "Pedro");

        System.out.println(clientes);
    }
}
