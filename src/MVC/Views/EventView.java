package MVC.Views;

import MVC.Controllers.EventController;
import java.util.Scanner;

public class EventView {
    private Scanner scanner;
    private EventController controller;

    public EventView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new EventController();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  Event Management Menu");
            System.out.println("1. Create Event (Notifies Donors)");
            System.out.println("2. View Events");
            System.out.println("3. Update a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Manage Event Lifecycle (State Pattern)");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter Event Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Event Date: ");
                String date = scanner.nextLine();
                controller.createEvent(name, date);
            } else if (choice.equals("2")) {
                controller.viewEvents();
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
                System.out.print("Enter the Event Name you want to manage: ");
                String eventName = scanner.nextLine();
                boolean managingState = true;
                while (managingState) {
                    System.out.println("\n--- Lifecycle Manager for: " + eventName + " ---");
                    System.out.println("1. Check Current Phase");
                    System.out.println("2. Advance to Next Phase");
                    System.out.println("3. Go Back");
                    System.out.print("Select action: ");
                    String stateChoice = scanner.nextLine();
                    if (stateChoice.equals("1")) {
                        controller.checkEventState(eventName);
                    } else if (stateChoice.equals("2")) {
                        controller.advanceEventState(eventName);
                    } else if (stateChoice.equals("3")) {
                        managingState = false;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
            } else if (choice.equals("6")) {
                back = true;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}