package MVC.Controllers;

import Observer.Event;
import Observer.Donor;
import Singleton.FileDB;
import java.util.List;

public class EventController {
    private FileDB dbManager = FileDB.getInstance();
    private final String EVENT_FILE = "events_db.txt"; 
    private final String DONOR_FILE = "donors_db.txt";

    public void createEvent(String name, String date) {
        Event newEvent = new Event(name, date);
        
        List<String> donors = dbManager.readRecords(DONOR_FILE);
        for (String donorName : donors) {
            newEvent.attach(new Donor(donorName));
        }
        
        newEvent.notifyObservers();
        dbManager.createRecord(EVENT_FILE, "Event: " + name + " | Date: " + date);
        System.out.println("Successfully created Event: " + name + " on " + date);
    }

    public void viewEvents() {
        List<String> records = dbManager.readRecords(EVENT_FILE);
        records.forEach(System.out::println);
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(EVENT_FILE, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete) {
        dbManager.deleteRecord(EVENT_FILE, dataToDelete);
        System.out.println("Record deleted successfully.");
    }
}