//Decorator Pattern
//this allows us to add specific roles without changing the Volunteer class
// this so that Volunteers can attach to Events
public interface IVolunteer extends Observer {
    String getRoleDescription();
}