package MVC.Controllers;

import Singleton.FileDB;
import java.util.List;
import Iterator.IAggregate;
import Iterator.RecordCollection;
import Iterator.IIterator;
import Proxy.IDatabaseAdmin;
import Proxy.SecureDatabaseProxy;

public class DonorController {
    private FileDB dbManager = FileDB.getInstance();
    private IDatabaseAdmin adminProxy = new SecureDatabaseProxy();
    private final String FILE_NAME = "donors_db.txt";

    public void registerDonor(String name) {
        dbManager.createRecord(FILE_NAME, name);
        System.out.println("Successfully registered Donor: " + name);
    }

    public void viewDonors() {
        List<String> rawRecords = dbManager.readRecords(FILE_NAME);
        IAggregate recordCollection = new RecordCollection(rawRecords);
        IIterator iterator = recordCollection.createIterator();
        System.out.println("\n--- All Donor Records ---");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------\n");
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(FILE_NAME, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete, String password) {
        adminProxy.deleteRecord(FILE_NAME, dataToDelete, password);
    }
}