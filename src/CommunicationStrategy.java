//Strategy Pattern
//swap out communication methods (Email and SMS and Social Media)
public interface CommunicationStrategy {
    void sendMessage(String recipient, String message);
}