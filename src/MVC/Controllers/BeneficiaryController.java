package MVC.Controllers;

import Clientrequirements.Beneficiary;
import Singleton.FileDB;
import java.util.List;
import Iterator.IAggregate;
import Iterator.RecordCollection;
import Iterator.IIterator;
import Proxy.IDatabaseAdmin;
import Proxy.SecureDatabaseProxy;

public class BeneficiaryController {
    private FileDB dbManager = FileDB.getInstance();
    private IDatabaseAdmin adminProxy = new SecureDatabaseProxy();
    private final String FILE_NAME = "beneficiaries_db.txt";

    public void addBeneficiary(String name, String needs) {
        Beneficiary ben = new Beneficiary(name, needs);
        dbManager.createRecord(FILE_NAME, ben.getDetails());
        System.out.println("Beneficiary saved successfully.");
    }

    public void viewBeneficiaries() {
        List<String> rawRecords = dbManager.readRecords(FILE_NAME);
        IAggregate recordCollection = new RecordCollection(rawRecords);
        IIterator iterator = recordCollection.createIterator();
        System.out.println("\n--- All Beneficiary Records ---");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------\n");
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(FILE_NAME, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete, String password) {
        adminProxy.deleteRecord(FILE_NAME, dataToDelete, password);
    }
}