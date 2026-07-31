package MVC.Views;

import MVC.Controllers.VolunteerController;
import java.util.Scanner;

public class VolunteerView {
    private Scanner scanner;
    private VolunteerController controller;

    public VolunteerView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new VolunteerController();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  Volunteer Management Menu");
            System.out.println("1. Assign Volunteer Role");
            System.out.println("2. View Volunteers");
            System.out.println("3. Update a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter Volunteer Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Role (Standard/Lead/FirstAid): ");
                String role = scanner.nextLine();
                controller.assignVolunteer(name, role);
            } else if (choice.equals("2")) {
                controller.viewVolunteers();
            } else if (choice.equals("3")) {
                System.out.println("Enter the EXACT full record you want to change:");
                String oldRecord = scanner.nextLine();
                System.out.println("Enter the NEW data for this record:");
                String newRecord = scanner.nextLine();
                controller.updateSystemRecord(oldRecord, newRecord);
            } else if (choice.equals("4")) {
                System.out.println("Enter the EXACT full record you want to delete:");
                String targetRecord = scanner.nextLine();
                controller.deleteSystemRecord(targetRecord);
            } else if (choice.equals("5")) {
                back = true;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}