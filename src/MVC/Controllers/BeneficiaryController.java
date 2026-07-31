package MVC.Controllers;

import Clientrequirements.Beneficiary;
import Singleton.FileDB;
import java.util.List;

public class BeneficiaryController {
    private FileDB dbManager = FileDB.getInstance();
    private final String FILE_NAME = "beneficiaries_db.txt";

    public void addBeneficiary(String name, String needs) {
        Beneficiary ben = new Beneficiary(name, needs);
        dbManager.createRecord(FILE_NAME, ben.getDetails());
        System.out.println("Beneficiary saved successfully.");
    }

    public void viewBeneficiaries() {
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