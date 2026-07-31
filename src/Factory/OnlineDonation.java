package Factory;
//Factory Pattern
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