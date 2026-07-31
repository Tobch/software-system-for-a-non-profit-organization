package MVC.Controllers;

import Factory.DonationFactory;
import Factory.Donation;
import Singleton.FileDB;
import java.util.List;

public class DonationController {
    private FileDB dbManager = FileDB.getInstance();
    private DonationFactory factory = new DonationFactory();
    private final String FILE_NAME = "donations_db.txt";

    public void addDonation(String type, String details) {
        Donation donation = factory.createDonation(type, details);
        if (donation != null) {
            donation.processDonation();
            dbManager.createRecord(FILE_NAME, donation.getDetails());
            System.out.println("Donation saved successfully.");
        } else {
            System.out.println("Invalid type.");
        }
    }

    public void viewDonations() {
        List<String> records = dbManager.readRecords(FILE_NAME);
        records.forEach(System.out::println);
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(FILE_NAME, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete) {
        dbManager.deleteRecord(FILE_NAME, dataToDelete);
        System.out.println("Record deleted successfully.");
    }
}