package modulo2;

import java.util.*;
import java.util.stream.*;



public class PolicyManagement3 {
    static Scanner scanner = new Scanner(System.in);
    static List<Policy3> policies = new ArrayList<>();
    static Map<String, List<Policy3>> policiesByCategory = new HashMap<>();
    static int option;

    public static void main(String[] args) {
        System.out.println("Policy Management 3\n");

        do {
            System.out.print("1- Register policy\n2- List policies\n3- Total premium value\n4- Count policies above value\n5- Show existing categories\n6- Exit\nChoose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                try{
                 registerPolicy();
                } catch (valuePremiumException e) {
                    System.out.println(e.getMessage());
                }
            } else if (option == 2) {
                listPolicies();
            } else if (option == 3) {
                calculateTotalPremiums();
            } else if (option == 4) {
                countAboveValue();
            } else if (option == 5) {
                listExistingCategories();
            } else if (option == 6) {
                System.out.println("Exiting system...");
            } else {
                System.out.println("Invalid option...");
            }
        } while (option != 6);
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
}
