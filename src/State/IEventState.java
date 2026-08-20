package State;

public interface IEventState {
    void nextState(EventContext context);
    void printStatus();
}