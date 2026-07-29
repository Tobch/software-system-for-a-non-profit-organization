package MVC;
// MVC & User Control Panel
import java.util.List;
import Decorator.IVolunteer;
import Decorator.StandardVolunteer;
import Decorator.EventLeadDecorator;
import Decorator.FirstAidDecorator;
import Observer.Donor;
import Observer.Event;
import Strategy.EmailStrategy;
import Strategy.SMSStrategy;
import Strategy.SocialMediaStrategy;
import Strategy.MessageManager;
import Factory.DonationFactory;
import Factory.Donation;
import Singleton.FileDB;
import Clientrequirements.Beneficiary;

public class MainController {
    private FileDB dbManager;
    private DonationFactory donationFactory;
    private MessageManager commManager;

    public MainController() {
        this.dbManager = FileDB.getInstance(); 
        this.donationFactory = new DonationFactory();
        this.commManager = new MessageManager();
    }

    public void handleDonationInput(String type, String details) {
        Donation donation = donationFactory.createDonation(type, details);
        if (donation != null) {
            donation.processDonation();
            dbManager.createRecord("DONATION," + donation.getDetails()); 
        } else {
            System.out.println("Invalid donation type.");
        }
    }

    public void registerBeneficiary(String name, String needs) {
        Beneficiary ben = new Beneficiary(name, needs);
        dbManager.createRecord("BENEFICIARY," + ben.getDetails()); 
    }

    public void registerDonor(String donorName) {
    dbManager.createRecord("DONOR," + donorName);
    System.out.println("Successfully registered Donor: " + donorName);
    }

    public void viewAllRecords() {
        List<String> records = dbManager.readRecords();
        System.out.println("  System Records  ");
        for (String record : records) {
            System.out.println(record);
        }
    }

    public void updateSystemRecord(String oldRecord, String newRecord) {
        dbManager.updateRecord(oldRecord, newRecord);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String targetRecord) {
        dbManager.deleteRecord(targetRecord);
        System.out.println("Record deleted successfully.");
    }

    public void sendSystemMessage(String strategyType, String recipient, String message) {
        if (strategyType.equalsIgnoreCase("Email")) {
            commManager.setStrategy(new EmailStrategy());
        } else if (strategyType.equalsIgnoreCase("SMS")) {
            commManager.setStrategy(new SMSStrategy());
        } else if (strategyType.equalsIgnoreCase("Social")) {
            commManager.setStrategy(new SocialMediaStrategy());
        } else {
            System.out.println("Invalid communication method.");
            return;
        }
        
        commManager.executeCommunication(recipient, message);
    }

    public void handleEventCreation(String name, String date) {
    Event newEvent = new Event(name, date);
    List<String> allRecords = dbManager.readRecords();
    for (String record : allRecords) {
        if (record.startsWith("DONOR,")) {
            String[] parts = record.split(",");
            String donorName = parts[1];
            Donor realDonor = new Donor(donorName);
            newEvent.attach(realDonor);
        }
    }
        newEvent.notifyObservers(); 
        System.out.println("Successfully created Event: " + name + " on " + date);
        dbManager.createRecord("EVENT," + name + "," + date);
    }

    public void assignVolunteerRole(String volName, String role) {
        IVolunteer volunteer = new StandardVolunteer(volName);
        
        if (role.equalsIgnoreCase("Lead")) {
            volunteer = new EventLeadDecorator(volunteer);
        } else if (role.equalsIgnoreCase("FirstAid")) {
            volunteer = new FirstAidDecorator(volunteer);
        } 

        System.out.println("Assigned Role: " + volunteer.getRoleDescription());
        dbManager.createRecord("VOLUNTEER," + volunteer.getRoleDescription());
    }
}