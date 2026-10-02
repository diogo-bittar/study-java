package modulo2;

public class Policy3 {
    private String insuredName;
    private double premiumValue;
    private String category;


    public Policy3(String insuredName, double premiumValue, String category){
        this.insuredName = insuredName;
        this.premiumValue = premiumValue;
        this.category = category;
    }

    public String getInsuredName() { return insuredName; }
    public double getPremiumValue() { return premiumValue; }
    public String getCategory() { return category; }
}
