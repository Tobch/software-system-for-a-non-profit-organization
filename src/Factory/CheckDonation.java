package Factory;
//Factory Pattern
//encapsulates the creation of different donation types so we don't have to use the new keyword everywhere in our main logic
public class CheckDonation implements Donation {
    private String checkNumber;

    public CheckDonation(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public void processDonation() {
        System.out.println("Processing check donation, Check #" + checkNumber);
    }

    @Override
    public String getDetails() {
        return "Check Donation: #" + checkNumber;
    }
}