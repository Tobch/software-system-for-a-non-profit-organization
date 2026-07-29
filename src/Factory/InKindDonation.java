package Factory;
//Factory Pattern
//encapsulates the creation of different donation types so we don't have to use the new keyword everywhere in our main logic
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