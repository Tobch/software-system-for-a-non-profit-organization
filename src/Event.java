//Observer Pattern
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private String date;
    private List<Observer> observers;

    public Event(String eventName, String date) {
        this.eventName = eventName;
        this.date = date;
        this.observers = new ArrayList<>();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update("Event update: " + eventName + " is now timed for " + date);
        }
    }

    public void updateEventDetails(String newDate) {
        this.date = newDate;
        notifyObservers(); // notify when details is changed
    }
}