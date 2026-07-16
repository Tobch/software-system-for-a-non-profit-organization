//Decorator Pattern
public class EventLeadDecorator extends RoleDecorator {

    public EventLeadDecorator(IVolunteer tempVolunteer) {
        super(tempVolunteer);
    }

    @Override
    public String getRoleDescription() {
        return super.getRoleDescription() + ", Event Lead";
    }
}