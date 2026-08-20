package MVC.Views;

import MVC.Controllers.DonorController;
import java.util.Scanner;

public class DonorView {
    private Scanner scanner;
    private DonorController controller;

    public DonorView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new DonorController();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  Donor Management Menu");
            System.out.println("1. Register Donor");
            System.out.println("2. View Donors");
            System.out.println("3. Update a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter Donor Name: ");
                String name = scanner.nextLine();
                controller.registerDonor(name);
            } else if (choice.equals("2")) {
                controller.viewDonors();
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