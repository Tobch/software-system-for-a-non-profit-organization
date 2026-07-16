//Strategy Pattern
public class MessageManager {
    private CommunicationStrategy strategy;

    // here we allow the user to set the strategy at runtime
    public void setStrategy(CommunicationStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeCommunication(String recipient, String message) {
        if (strategy == null) {
            System.out.println("No communication strategy is set.");
        } else {
            strategy.sendMessage(recipient, message);
        }
    }
}