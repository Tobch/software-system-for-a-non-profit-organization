package MVC.Controllers;

import Observer.Event;
import Observer.Donor;
import Singleton.FileDB;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import Iterator.IAggregate;
import Iterator.RecordCollection;
import Iterator.IIterator;
import State.EventContext;
import Proxy.IDatabaseAdmin;
import Proxy.SecureDatabaseProxy;

public class EventController {
    private FileDB dbManager = FileDB.getInstance();
    private IDatabaseAdmin adminProxy = new SecureDatabaseProxy();
    private final String EVENT_FILE = "events_db.txt"; 
    private final String DONOR_FILE = "donors_db.txt";
    private Map<String, EventContext> eventLifecycles = new HashMap<>();

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
        List<String> rawRecords = dbManager.readRecords(EVENT_FILE);
        IAggregate recordCollection = new RecordCollection(rawRecords);
        IIterator iterator = recordCollection.createIterator();
        System.out.println("\n--- All Event Records ---");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------\n");
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(EVENT_FILE, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete, String password) {
        adminProxy.deleteRecord(EVENT_FILE, dataToDelete, password);
    }

    public void checkEventState(String eventName) {
        eventLifecycles.putIfAbsent(eventName, new EventContext(eventName));
        System.out.println("\n--- Current Event Status ---");
        eventLifecycles.get(eventName).showState();
        System.out.println("----------------------------\n");
    }

    public void advanceEventState(String eventName) {
        eventLifecycles.putIfAbsent(eventName, new EventContext(eventName));
        System.out.println("\n--- Updating Event Status ---");
        eventLifecycles.get(eventName).advanceState();
        eventLifecycles.get(eventName).showState();
        System.out.println("-----------------------------\n");
    }
}