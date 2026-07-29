package Clientrequirements;
//Client Requirements
//we create a simple module that tracks the non-profit beneficiaries
public class Beneficiary {
    private String name;
    private String needs;

    public Beneficiary(String name, String needs) {
        this.name = name;
        this.needs = needs;
    }

    public String getDetails() {
        return "Beneficiary: " + name + " | Needs: " + needs;
    }
}