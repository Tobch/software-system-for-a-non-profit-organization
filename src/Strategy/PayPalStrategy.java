package Strategy;

public class PayPalStrategy implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("[Strategy] Selected: PayPal.");
        System.out.println("[PayPal API] Processing payment of $" + amount + "...");
        System.out.println("[PayPal API] Transaction Successful.");
    }
}
