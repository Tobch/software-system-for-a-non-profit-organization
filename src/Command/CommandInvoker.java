package Command;
public class CommandInvoker {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command has been assigned to the invoker.");
        }
    }
}