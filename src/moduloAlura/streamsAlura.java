package moduloAlura;
import java.util.*;
import java.util.stream.Collectors;

public class streamsAlura {
    public static void main(String[] args) {
         List<String> funcionarios = List.of("Ana", "João", "Carlos", "Amanda");

         List<String> funcionariosLetraA = funcionarios.stream().filter(f -> f.startsWith("A")).collect(Collectors.toList());

        System.out.println(funcionarios);
        System.out.println(funcionariosLetraA);

        List<Double> valoresVenda = List.of(500.0, 1800.0, 6200.0);
        List<Double> comissao = valoresVenda.stream().map(v -> v * 0.05).collect(Collectors.toList());

        System.out.println(valoresVenda);
        System.out.println(comissao);

        double total = valoresVenda.stream().reduce(0.0, Double::sum);
        System.out.println(total);
    }
}
