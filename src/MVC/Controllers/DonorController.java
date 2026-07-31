package MVC.Controllers;

import Singleton.FileDB;
import java.util.List;

public class DonorController {
    private FileDB dbManager = FileDB.getInstance();
    private final String FILE_NAME = "donors_db.txt";

    public void registerDonor(String name) {
        dbManager.createRecord(FILE_NAME, name);
        System.out.println("Successfully registered Donor: " + name);
    }

    public void viewDonors() {
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