package MVC.Controllers;

import Strategy.MessageManager;
import Strategy.EmailStrategy;
import Strategy.SMSStrategy;
import Strategy.SocialMediaStrategy;
import Singleton.FileDB;

public class CommunicationController {
    private MessageManager commManager = new MessageManager();
    private FileDB dbManager = FileDB.getInstance();
    private final String FILE_NAME = "communications_log.txt";

    public void sendMessage(String strategyType, String recipient, String message) {
        if (strategyType.equalsIgnoreCase("Email")) {
            commManager.setStrategy(new EmailStrategy()); 
        } else if (strategyType.equalsIgnoreCase("SMS")) {
            commManager.setStrategy(new SMSStrategy()); 
        } else if (strategyType.equalsIgnoreCase("Social")) {
            commManager.setStrategy(new SocialMediaStrategy());
        } else {
            System.out.println("Invalid method.");
            return;
        }
        commManager.executeCommunication(recipient, message);
        dbManager.createRecord(FILE_NAME, "Sent " + strategyType + " to " + recipient);
    }
}