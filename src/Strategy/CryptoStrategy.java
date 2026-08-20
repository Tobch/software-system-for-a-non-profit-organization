package Strategy;

public class CryptoStrategy implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("[Strategy] Selected: Cryptocurrency.");
        System.out.println("[Blockchain] Verifying wallet and transferring equivalent of $" + amount + "...");
        System.out.println("[Blockchain] Transaction Confirmed on ledger.");
    }
}
