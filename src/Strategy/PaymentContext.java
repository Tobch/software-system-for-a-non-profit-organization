package Strategy;

public class PaymentContext {
    private IPaymentStrategy strategy;

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("No payment strategy selected.");
        }
    }
}