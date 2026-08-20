package State;

public class ActiveState implements IEventState {
    @Override
    public void nextState(EventContext context) {
        context.setState(new CompletedState());
    }

    @Override
    public void printStatus() {
        System.out.println("State: ACTIVE - The event is happening right now! Donations are open");
    }
}