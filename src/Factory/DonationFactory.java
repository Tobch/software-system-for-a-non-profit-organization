package Factory;
//Factory Pattern
//encapsulates the creation of different donation types so we don't have to use the new keyword everywhere in our main logic
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