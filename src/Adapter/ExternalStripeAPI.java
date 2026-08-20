package Adapter;
public class ExternalStripeAPI {
    
    public void makeTransaction(double cash, String currency) {
        System.out.println("[Stripe API] Processing transaction of " + cash + " " + currency);
        System.out.println("[Stripe API] Transaction Approved.");
    }
}