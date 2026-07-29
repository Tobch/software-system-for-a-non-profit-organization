package Factory;
//Factory Pattern
//encapsulates the creation of different donation types so we dont have to use the new keyword everywhere in our main logic
public interface Donation {
    void processDonation();
    String getDetails();
}