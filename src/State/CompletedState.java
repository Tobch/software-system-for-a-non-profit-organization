package State;

public class CompletedState implements IEventState {
    @Override
    public void nextState(EventContext context) {
        System.out.println("State Error: The event is already completed and closed");
    }

    @Override
    public void printStatus() {
        System.out.println("State: COMPLETED - The event has finished successfully");
    }
}