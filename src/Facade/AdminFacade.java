package Facade;

import MVC.Controllers.VolunteerController;
import MVC.Controllers.CommunicationController;
import MVC.Controllers.DonorController;
import MVC.Controllers.DonationController;
import MVC.Controllers.EventController;

public class AdminFacade {
    private VolunteerController volunteerController;
    private CommunicationController communicationController;
    private DonorController donorController;
    private DonationController donationController;
    private EventController eventController;

    public AdminFacade() {
        this.volunteerController = new VolunteerController();
        this.communicationController = new CommunicationController();
        this.donorController = new DonorController();
        this.donationController = new DonationController();
        this.eventController = new EventController();
    }

    public void onboardVolunteerAndNotify(String name, String role, String method, String contactInfo) {
        System.out.println("\n[Facade] Starting Quick Onboarding Process...");
        volunteerController.assignVolunteer(name, role);
        String message = "Welcome " + name + ", you are assigned as " + role;
        communicationController.sendMessage(method, contactInfo, message);
        System.out.println("[Facade] Quick Onboarding Complete.\n");
    }

    public void registerVIPDonor(String name, String type, String details, String method, String contactInfo) {
        System.out.println("\n[Facade] Processing VIP Donor Registration...");
        donorController.registerDonor(name);
        donationController.addDonation(name, type, details);
        
        String message = "Thank you for your generous " + type + " donation, " + name + "!";
        communicationController.sendMessage(method, contactInfo, message);
        System.out.println("[Facade] VIP Registration Complete.\n");
    }

    public void cancelEventAndNotify(String exactEventRecord, String eventName, String method, String contactInfo) {
        System.out.println("\n[Facade] Initiating Emergency Event Cancellation...");
        eventController.deleteSystemRecord(exactEventRecord, eventName);
        
        String message = "URGENT: The event '" + eventName + "' has been cancelled.";
        communicationController.sendMessage(method, contactInfo, message);
        System.out.println("[Facade] Event Cancellation Protocol Complete.\n");
    }
}