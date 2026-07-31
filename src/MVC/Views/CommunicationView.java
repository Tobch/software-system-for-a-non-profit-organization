package MVC.Views;

import MVC.Controllers.CommunicationController;
import java.util.Scanner;

public class CommunicationView {
    private Scanner scanner;
    private CommunicationController controller;

    public CommunicationView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new CommunicationController();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  Communications Menu");
            System.out.println("1. Send Message");
            System.out.println("2. Back");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Method (Email/SMS/Social): ");
                String method = scanner.nextLine();
                System.out.print("Recipient: ");
                String recipient = scanner.nextLine();
                System.out.print("Message: ");
                String message = scanner.nextLine();
                controller.sendMessage(method, recipient, message);
            } else if (choice.equals("2")) {
                back = true;
            }
        }
    }
}