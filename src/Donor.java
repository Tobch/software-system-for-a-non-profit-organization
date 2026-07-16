//Observer Pattern
public class Donor implements Observer {
    private String name;

    public Donor(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Donor " + name + " will get a notification: " + message);
    }
}
