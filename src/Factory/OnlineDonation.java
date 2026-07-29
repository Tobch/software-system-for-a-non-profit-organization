package Factory;
//Factory Pattern
//encapsulates the creation of different donation types so we don't have to use the new keyword everywhere in our main logic
public class OnlineDonation implements Donation {
    private double amount;

    public OnlineDonation(double amount) {
        this.amount = amount;
    }

    @Override
    public void processDonation() {
        System.out.println("Processing online donation of $" + amount);
    }

    @Override
    public String getDetails() {
        return "Online Donation: $" + amount;
    }
}