package State;

public class EventContext {
    private IEventState state;
    private String eventName;

    public EventContext(String eventName) {
        this.eventName = eventName;
        // This is the default state when an event is first created
        this.state = new PlanningState(); 
    }

    public void setState(IEventState state) {
        this.state = state;
    }

    public void advanceState() {
        state.nextState(this);
    }

    public void showState() {
        System.out.print("Event '" + eventName + "' -> ");
        state.printStatus();
    }
}