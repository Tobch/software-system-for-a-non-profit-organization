package MVC.Views;

import MVC.Controllers.BeneficiaryController;
import java.util.Scanner;

public class BeneficiaryView {
    private Scanner scanner;
    private BeneficiaryController controller;

    public BeneficiaryView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new BeneficiaryController();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  Beneficiary Management Menu");
            System.out.println("1. Add Beneficiary");
            System.out.println("2. View Beneficiaries");
            System.out.println("3. Update a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter Beneficiary Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Beneficiary Needs: ");
                String needs = scanner.nextLine();
                controller.addBeneficiary(name, needs);
            } else if (choice.equals("2")) {
                controller.viewBeneficiaries();
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