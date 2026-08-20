package Strategy;

import Adapter.IPaymentProcessor;
import Adapter.StripeAdapter;

public class CreditCardStrategy implements IPaymentStrategy {
    private IPaymentProcessor stripeAdapter = new StripeAdapter();

    @Override
    public void pay(double amount) {
        System.out.println("[Strategy] Selected: Credit Card.");
        stripeAdapter.processPayment(amount); 
    }
}
