package MVC.Controllers;

import Decorator.IVolunteer;
import Decorator.StandardVolunteer;
import Decorator.EventLeadDecorator;
import Decorator.FirstAidDecorator;
import Singleton.FileDB;
import java.util.List;

public class VolunteerController {
    private FileDB dbManager = FileDB.getInstance();
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