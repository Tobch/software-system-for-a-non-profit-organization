package Template;

public class DonationReceipt extends DocumentTemplate {
    
    @Override
    protected void addHeader() {
        System.out.println("OFFICIAL DONATION RECEIPT");
    }

    @Override
    protected void addBody(String data) {
        System.out.println("Record Details : " + data);
    }

    @Override
    protected void addFooter() {
        System.out.println("Thank you for your generous support of our mission");
    }
}