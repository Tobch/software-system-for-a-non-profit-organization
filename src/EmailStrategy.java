//Strategy Pattern
public class EmailStrategy implements CommunicationStrategy {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("this Email is sent to " + recipient + ": " + message);
    }
}