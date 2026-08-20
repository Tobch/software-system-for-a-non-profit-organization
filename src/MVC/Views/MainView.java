package MVC.Views;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n  Non-Profit System Main Menu  ");
            System.out.println("1. Manage Donations");
            System.out.println("2. Manage Beneficiaries");
            System.out.println("3. Manage Events");
            System.out.println("4. Manage Volunteers");
            System.out.println("5. Manage Donors");
            System.out.println("6. Send Communications");
            System.out.println("7. Admin Quick Actions");
            System.out.println("8. Generate System Reports");
            System.out.println("9. Exit System");
            System.out.print("Select a module: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": new DonationView(scanner).showMenu(); break;
                case "2": new BeneficiaryView(scanner).showMenu(); break;
                case "3": new EventView(scanner).showMenu(); break;
                case "4": new VolunteerView(scanner).showMenu(); break;
                case "5": new DonorView(scanner).showMenu(); break;
                case "6": new CommunicationView(scanner).showMenu(); break;
                case "7": new AdminView(scanner).showMenu(); break; 
                case "8": new ReportView(scanner).showMenu(); break;
                case "9": running = false; System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}