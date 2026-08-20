package MVC.Views;

import MVC.Controllers.DonationController;
import java.util.Scanner;

public class DonationView {
    private Scanner scanner;
    private DonationController controller;

    public DonationView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new DonationController();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n Donation Management Menu");
            System.out.println("1. Add Donation");
            System.out.println("2. View All Donations");
            System.out.println("3. Update a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Type (Online/Check/InKind): ");
                String type = scanner.nextLine();
                String onlineMethod = "";
                if (type.equalsIgnoreCase("Online")) {
                    System.out.print("Select Payment Strategy (CreditCard/PayPal/Crypto): ");
                    onlineMethod = scanner.nextLine();
                }
                System.out.print("Details (e.g., amount or item description): ");
                String details = scanner.nextLine();
                controller.addDonation(type, details, onlineMethod);
            } else if (choice.equals("2")) {
                controller.viewDonations();
            } else if (choice.equals("3")) {
                System.out.println("Enter the EXACT full record you want to change:");
                String oldRecord = scanner.nextLine();
                System.out.println("Enter the NEW data for this record:");
                String newRecord = scanner.nextLine();
                controller.updateSystemRecord(oldRecord, newRecord);
            } else if (choice.equals("4")) {
                System.out.println("Enter the EXACT full record you want to delete:");
                String targetRecord = scanner.nextLine();
                System.out.print("Enter Admin Password to authorize deletion: ");
                String password = scanner.nextLine();
                controller.deleteSystemRecord(targetRecord, password);

            } else if (choice.equals("5")) {
                back = true;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}