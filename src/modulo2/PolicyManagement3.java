package modulo2;

import java.util.*;
import java.util.stream.*;


/**
 *
 */
public class PolicyManagement3 {
    static Scanner scanner = new Scanner(System.in);
    static List<Policy3> policies = new ArrayList<>();
    static Map<String, List<Policy3>> policiesByCategory = new HashMap<>();
    static int option;
    static Notificador notificador = new NotificadorSms();

    public static void main(String[] args) {
        System.out.println("Policy Management 3\n");

        do {
            System.out.print("1- Register policy\n2- List policies\n3- Total premium value\n4- Count policies above value\n5- Show existing categories\n6- Remove Policy\n7- List of category\n8- Total premiums by category\n9- Category with most policies\n10- Exit\nChoose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    try {
                        registerPolicy();
                    } catch (valuePremiumException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    listPolicies();
                    break;
                case 3:
                    calculateTotalPremiums();
                    break;
                case 4:
                    countAboveValue();
                    break;
                case 5:
                    listExistingCategories();
                    break;
                case 6:
                    removePolicy();
                    break;
                case 7:
                    listPoliciesByCategory();
                    break;
                case 8:
                    totalPremiumsByCategory();
                    break;
                case 9:
                    categoryWithMostPolicies();
                    break;
                case 10:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        } while (option != 10);
    }

    static void registerPolicy(){
        System.out.print("Insured name: ");
        String insuredName = scanner.nextLine();

        System.out.print("Premium value: ");
        double premiumValue = Double.parseDouble(scanner.nextLine());
        if(premiumValue <= 0){
            throw new valuePremiumException("Value invalid...");
        }

        System.out.print("Policy category: ");
        String category = scanner.nextLine();

        Policy3 newPolicy = new Policy3(insuredName, premiumValue, category);
        policies.add(newPolicy);
        notificador.notificar("Policy add sucess", insuredName);

        if (!policiesByCategory.containsKey(category)) {
            policiesByCategory.put(category, new ArrayList<>());
        }
        policiesByCategory.get(category).add(newPolicy);
    }

    static void listPolicies() {
        policies.stream().forEach(p -> System.out.println("Insured: " + p.getInsuredName() + " | Premium: " + p.getPremiumValue() + " | Category: " + p.getCategory()));
    }

    static void calculateTotalPremiums() {
        double total = policies.stream().mapToDouble(p -> p.getPremiumValue()).sum();
        System.out.println("Total premium value: " + total);
    }
//
    static void countAboveValue() {
        System.out.print("Cutoff value for search: ");
        double limitValue = Double.parseDouble(scanner.nextLine());

        int count = 0;
        for (Policy3 p : policies) {
            if (p.getPremiumValue() > limitValue) {
                count++;
            }
        }
        System.out.println("Policies found above value: " + count);
    }

    static void listExistingCategories() {
        Set<String> categories = policiesByCategory.keySet();
        for (String category : categories) {
            System.out.println(category);
        }
    }

    static void removePolicy(){
        System.out.print("Name of policy for remove: ");
        String nameRemove = scanner.nextLine();

        boolean removed = policies.removeIf(p -> p.getInsuredName().equals(nameRemove));
        if (removed) {
            policiesByCategory.values().forEach(lista -> lista.removeIf(pol -> pol.getInsuredName().equals(nameRemove)));
            policiesByCategory.entrySet().removeIf(entry -> entry.getValue().isEmpty());
            notificador.notificar("Policy removed", nameRemove);
        } else {
            System.out.println("Insured not found...");
        }
    }

    static void listPoliciesByCategory(){
        System.out.print("Name of category: ");
        String categoryName = scanner.nextLine();
        if(policiesByCategory.containsKey(categoryName)){
            for(Policy3 p : policiesByCategory.get(categoryName)){
                System.out.println("Insured: " + p.getInsuredName() + " | Premium: " + p.getPremiumValue() + " | Category: " + p.getCategory());
            }
        }else{
            System.out.println("Category invalid...");
        }
    }

    static void totalPremiumsByCategory(){
        Set<String> categories = policiesByCategory.keySet();
        for (String category : categories){
            double total = 0;
            for(Policy3 p : policiesByCategory.get(category)){
                total += p.getPremiumValue();
            }
            System.out.println(category + ": " + total);
        }
    }

    static void categoryWithMostPolicies() {
        double maiorTamanho = 0;
        String categoryHigh = null;

        for (String category : policiesByCategory.keySet()) {
            int quantidade = policiesByCategory.get(category).size();

            if (quantidade > maiorTamanho) {
                maiorTamanho = quantidade;
                categoryHigh = category;

            }
        }
        if (categoryHigh == null) {
            System.out.println("No policies registered.");

        } else {
            System.out.println("Category with most policies: "
                    + categoryHigh + " (" + maiorTamanho + ")");
        }
    }

}
