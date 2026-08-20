package MVC.Views;

import Facade.AdminFacade;
import java.util.Scanner;
import Adminpage.PageElement;
import Adminpage.PageCategory;
import Adminpage.ActionPage;

public class AdminView {
    private Scanner scanner;
    private AdminFacade adminFacade;
    private PageElement adminDashboard; 

    public AdminView(Scanner scanner) {
        this.scanner = scanner;
        this.adminFacade = new AdminFacade();
        buildAdminTree(); 
    }

    private void buildAdminTree() {
        adminDashboard = new PageCategory("Main Admin Dashboard");

        PageElement userManagement = new PageCategory("User Management Pages");
        userManagement.add(new ActionPage("Quick Volunteer Onboarding", "1"));

        userManagement.add(new ActionPage("Register VIP Donor", "2"));
        PageElement systemManagement = new PageCategory("System Control Pages");

        systemManagement.add(new ActionPage("Emergency Event Cancellation", "3"));
        
        systemManagement.add(new ActionPage("Back to Main Menu", "4"));

        adminDashboard.add(userManagement);
        adminDashboard.add(systemManagement);
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=========================================");
            adminDashboard.display(0);
            System.out.println("=========================================\n");
            
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Role (Standard/Lead/FirstAid): ");
                String role = scanner.nextLine();
                System.out.print("Contact Method (Email/SMS/Social): ");
                String method = scanner.nextLine();
                System.out.print("Contact Info: ");
                String contact = scanner.nextLine();
                adminFacade.onboardVolunteerAndNotify(name, role, method, contact);
                
            } else if (choice.equals("2")) {
                System.out.print("Enter VIP Donor Name: ");
                String name = scanner.nextLine();
                System.out.print("Donation Type (Online/Check/InKind): ");
                String type = scanner.nextLine();
                System.out.print("Donation Details (e.g., 500): ");
                String details = scanner.nextLine();
                System.out.print("Preferred Thank You Method (Email/SMS/Social): ");
                String method = scanner.nextLine();
                System.out.print("Contact Info: ");
                String contact = scanner.nextLine();
                adminFacade.registerVIPDonor(name, type, details, method, contact);
                
            } else if (choice.equals("3")) {
                System.out.print("Enter EXACT Event Record to Delete: ");
                String exactRecord = scanner.nextLine();
                System.out.print("Enter Event Name (for the message): ");
                String name = scanner.nextLine();
                System.out.print("Broadcast Method (Email/SMS/Social): ");
                String method = scanner.nextLine();
                System.out.print("Broadcast List/Group Contact Info: ");
                String contact = scanner.nextLine();
                adminFacade.cancelEventAndNotify(exactRecord, name, method, contact);
                
            } else if (choice.equals("4")) {
                back = true;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}