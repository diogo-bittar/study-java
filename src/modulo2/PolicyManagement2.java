package modulo2;

import java.util.*;

public class PolicyManagement2 {
    static Scanner scanner = new Scanner(System.in);
    static List<Policy2> policies = new ArrayList<>();
    static Map<String, List<Policy2>> policiesByCategory = new HashMap<>();
    static int opc;

    public static void main(String[] args) {
        System.out.println("Policy Management 2\n");

        do {
            System.out.print("1- Register policy\n2- List policies\n3- Total premium value\n4- Count policies above value\n5- Show existing categories\n6- Exit\nChoose an option: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            if (opc == 1) {
                registerPolicy();
            } else if (opc == 2) {
                listPolicies();
            } else if (opc == 3) {
                calculateTotalPremiums();
            } else if (opc == 4) {
                countAboveValue();
            } else if (opc == 5) {
                listExistingCategories();
            } else if (opc == 6) {
                System.out.println("Exiting system...");
            } else {
                System.out.println("Invalid option...");
            }
        } while (opc != 6);
    }

    static void registerPolicy() {
        System.out.print("Insured name: ");
        String insuredName = scanner.nextLine();

        System.out.print("Premium value: ");
        double premiumValue = Double.parseDouble(scanner.nextLine());

        System.out.print("Policy category: ");
        String category = scanner.nextLine();

        Policy2 newPolicy = new Policy2(insuredName, premiumValue, category);
        policies.add(newPolicy);

        if (!policiesByCategory.containsKey(category)) {
            policiesByCategory.put(category, new ArrayList<>());
        }
        policiesByCategory.get(category).add(newPolicy);
    }

    static void listPolicies() {
        for (Policy2 p : policies) {
            System.out.println("Insured: " + p.getInsuredName() + " | Premium: " + p.getPremiumValue() + " | Category: " + p.getCategory());
        }
    }

    static void calculateTotalPremiums() {
        double total = 0;
        for (Policy2 p : policies) {
            total += p.getPremiumValue();
        }
        System.out.println("Total premium value: " + total);
    }

    static void countAboveValue() {
        System.out.print("Cutoff value for search: ");
        double limitValue = Double.parseDouble(scanner.nextLine());

        int count = 0;
        for (Policy2 p : policies) {
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