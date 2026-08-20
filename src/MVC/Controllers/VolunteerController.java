package MVC.Controllers;

import Decorator.IVolunteer;
import Decorator.StandardVolunteer;
import Decorator.EventLeadDecorator;
import Decorator.FirstAidDecorator;
import Singleton.FileDB;
import java.util.List;
import Iterator.IAggregate;
import Iterator.RecordCollection;
import Iterator.IIterator;
import Proxy.IDatabaseAdmin;
import Proxy.SecureDatabaseProxy;

public class VolunteerController {
    private FileDB dbManager = FileDB.getInstance();
    private IDatabaseAdmin adminProxy = new SecureDatabaseProxy();
    private final String FILE_NAME = "volunteers_db.txt";

    public void assignVolunteer(String name, String role) {
        IVolunteer volunteer = new StandardVolunteer(name);
        
        if (role.equalsIgnoreCase("Lead")) {
            volunteer = new EventLeadDecorator(volunteer);
        } else if (role.equalsIgnoreCase("FirstAid")) {
            volunteer = new FirstAidDecorator(volunteer);
        }
        
        dbManager.createRecord(FILE_NAME, volunteer.getRoleDescription());
        System.out.println("Assigned Role: " + volunteer.getRoleDescription());
    }

    public void viewVolunteers() {
        List<String> rawRecords = dbManager.readRecords(FILE_NAME);
        IAggregate recordCollection = new RecordCollection(rawRecords);
        IIterator iterator = recordCollection.createIterator();
        System.out.println("\n--- All Volunteer Records ---");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------\n");
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(FILE_NAME, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete, String password) {
        adminProxy.deleteRecord(FILE_NAME, dataToDelete, password);
    }
}