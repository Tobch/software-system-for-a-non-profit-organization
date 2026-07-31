package Factory;
//Factory Pattern
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