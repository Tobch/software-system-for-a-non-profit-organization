package MVC;
//The View & User Control Panel
import java.util.Scanner;

public class ConsoleView {
    private MainController controller;
    private Scanner scanner;

    public ConsoleView() {
        this.controller = new MainController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n  Non-Profit Organization Control Panel  ");
            System.out.println("1. Add Donation (Factory Pattern)");
            System.out.println("2. Add Beneficiary (Client Req)");
            System.out.println("3. Send Communication (Strategy Pattern)");
            System.out.println("4. Create Event (Observer Pattern)");
            System.out.println("5. Assign Volunteer (Decorator Pattern)");
            System.out.println("6. View All Records (Singleton Pattern)");
            System.out.println("7. Update a Record (Update)");
            System.out.println("8. Delete a Record (Delete)");
            System.out.println("9. Add Donor (Observer Registration)");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Donation Type (Online/Check/InKind): ");
                String type = scanner.nextLine();
                System.out.print("Enter Details (Amount, Check #, or Item): ");
                String details = scanner.nextLine();
                controller.handleDonationInput(type, details);

            } else if (choice.equals("2")) {
                System.out.print("Enter Beneficiary Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Beneficiary Needs: ");
                String needs = scanner.nextLine();
                controller.registerBeneficiary(name, needs);

            } else if (choice.equals("3")) {
                System.out.print("Enter Method (Email/SMS/Social): ");
                String method = scanner.nextLine();
                System.out.print("Enter Recipient Name: ");
                String recipient = scanner.nextLine();
                System.out.print("Enter Message: ");
                String message = scanner.nextLine();
                controller.sendSystemMessage(method, recipient, message);

            } else if (choice.equals("4")) {
                System.out.print("Enter Event Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Event Date: ");
                String date = scanner.nextLine();
                controller.handleEventCreation(name, date);

            } else if (choice.equals("5")) {
                System.out.print("Enter Volunteer Name: ");
                String volName = scanner.nextLine();
                System.out.print("Enter Role (Standard/Lead/FirstAid): ");
                String role = scanner.nextLine();
                controller.assignVolunteerRole(volName, role);

            } else if (choice.equals("6")) {
                controller.viewAllRecords();

            } else if (choice.equals("7")) {
                System.out.println("Enter the EXACT full record you want to change:");
                String oldRecord = scanner.nextLine();
                System.out.println("Enter the NEW data for this record:");
                String newRecord = scanner.nextLine();
                controller.updateSystemRecord(oldRecord, newRecord);

            } else if (choice.equals("8")) {
                System.out.println("Enter the EXACT full record you want to delete:");
                String targetRecord = scanner.nextLine();
                controller.deleteSystemRecord(targetRecord);

            } else if (choice.equals("9")) {
                System.out.print("Enter Donor Name: ");
                String donorName = scanner.nextLine();
                controller.registerDonor(donorName);

            } else if (choice.equals("10")) {
                System.out.println("Exiting System...");
                running = false;

            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        view.displayMainMenu();
    }
}