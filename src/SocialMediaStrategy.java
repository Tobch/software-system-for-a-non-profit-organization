//Strategy Pattern
public class SocialMediaStrategy implements CommunicationStrategy {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("this Social Media post is for " + recipient + ": " + message);
    }
}