package Factory;
//Factory Pattern
public class DonationFactory {
    public Donation createDonation(String type, String details) {
        if (type.equalsIgnoreCase("Online")) {
            double amount = Double.parseDouble(details);
            return new OnlineDonation(amount);
        } else if (type.equalsIgnoreCase("Check")) {
            return new CheckDonation(details);
        } else if (type.equalsIgnoreCase("InKind")) {
            return new InKindDonation(details);
        }
        return null;
    }
}