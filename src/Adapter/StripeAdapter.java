package Adapter;
public class StripeAdapter implements IPaymentProcessor {
    private ExternalStripeAPI stripeAPI;

    public StripeAdapter() {
        this.stripeAPI = new ExternalStripeAPI();
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Adapter: Translating local payment request to Stripe format...");
        stripeAPI.makeTransaction(amount, "USD");
    }
}