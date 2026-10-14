package moduloAlura;

import java.util.*;

public class exerciciosAlura {
    public static void main(String[] args) {
        List<String> funcionarios = new ArrayList<>();
        funcionarios.add("João");
        funcionarios.add("Maria");
        funcionarios.add("Vitor");
        funcionarios.add("Ana");

        System.out.println(funcionarios);

        funcionarios.remove("Vitor");
        System.out.println(funcionarios);

        System.out.println("Segundo funcionario: " + funcionarios.get(1));
        System.out.println("Total de funcionarios: " + funcionarios.size());

        Set<String> eventos = new HashSet<>();
        eventos.add("IA Conference Brasil");
        eventos.add("AI Summit");
        eventos.add("DevFest");
        eventos.add("Cloud Expo");
        eventos.add("IA Conference Brasil");
        eventos.add("DevFest");

        System.out.println(eventos);


        Map<Integer, String> clientes = new HashMap<>();

        clientes.put(1, "Diogo");
        clientes.put(2, "Bittar");
        clientes.put(3, "Pedro");

        System.out.println("O nome do cliente com ID 2 é: " + clientes.get(2));

        Map<Integer, String> cliente = new HashMap<>();
        cliente.put(1, "Maria");
        cliente.put(2, "Marcos");
        cliente.put(3, "Ana");
        cliente.put(4, "Joana");
        cliente.put(5, "Karen");

        int idCliente = 5;

        if(cliente.containsKey(idCliente)){
            String nomeCliente = cliente.get(idCliente);
            System.out.println("O nome do cliente com ID " + idCliente + " é: " + nomeCliente);
        }else{
            System.out.println("Cliente não encontrado...");
        }
    }
}
