package State;

public class PlanningState implements IEventState {
    @Override
    public void nextState(EventContext context) {
        context.setState(new ActiveState());
    }

    @Override
    public void printStatus() {
        System.out.println("State: PLANNING - The event is currently being organized, Volunteers are being gathered");
    }
}