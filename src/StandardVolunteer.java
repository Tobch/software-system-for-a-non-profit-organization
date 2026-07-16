//Decorator Pattern
public class StandardVolunteer implements IVolunteer {
    private String name;

    public StandardVolunteer(String name) {
        this.name = name;
    }

    @Override
    public String getRoleDescription() {
        return name + " [Standard Volunteer]";
    }

    @Override
    public void update(String message) {
        System.out.println("Volunteer " + name + " received notification: " + message);
    }
}