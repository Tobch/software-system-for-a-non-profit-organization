package Factory;
//Factory Pattern
public class InKindDonation implements Donation {
    private String itemDescription;

    public InKindDonation(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public void processDonation() {
        System.out.println("Processing in-kind donation: " + itemDescription);
    }

    @Override
    public String getDetails() {
        return "In-Kind Donation: " + itemDescription;
    }
}