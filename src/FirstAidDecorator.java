//Decorator Pattern
public class FirstAidDecorator extends RoleDecorator {

    public FirstAidDecorator(IVolunteer tempVolunteer) {
        super(tempVolunteer);
    }

    @Override
    public String getRoleDescription() {
        return super.getRoleDescription() + ", First Aid Certified";
    }
}