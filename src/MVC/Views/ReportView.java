package MVC.Views;

import MVC.Controllers.ReportController;
import java.util.Scanner;

public class ReportView {
    private Scanner scanner;
    private ReportController controller;

    public ReportView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new ReportController();
    }

    public void showMenu() {
        System.out.println("\n--- System Reports ---");
        System.out.println("1. Donation Report");
        System.out.println("2. Event Report");
        System.out.print("Select a report to generate: ");
        
        String choice = scanner.nextLine();
        controller.generateReport(choice);
    }
}