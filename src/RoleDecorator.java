//Decorator Pattern
public abstract class RoleDecorator implements IVolunteer {
    protected IVolunteer tempVolunteer;

    public RoleDecorator(IVolunteer tempVolunteer) {
        this.tempVolunteer = tempVolunteer;
    }

    @Override
    public String getRoleDescription() {
        return tempVolunteer.getRoleDescription();
    }

    @Override
    public void update(String message) {
        // Delegate the update call to the underlying volunteer
        tempVolunteer.update(message); 
    }
}