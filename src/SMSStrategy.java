//Strategy Pattern
public class SMSStrategy implements CommunicationStrategy {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("this SMS is sent to " + recipient + ": " + message);
    }
}