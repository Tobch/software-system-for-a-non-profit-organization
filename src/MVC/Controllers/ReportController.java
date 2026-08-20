package MVC.Controllers;

import Command.CommandInvoker;
import Command.ReportCommand;


public class ReportController {
    private CommandInvoker invoker;

    public ReportController() {
        this.invoker = new CommandInvoker();
    }

    public void generateReport(String type) {
        if (type.equals("1")) {
            invoker.setCommand(new ReportCommand("donations_db.txt"));
            invoker.executeCommand();
        } else if (type.equals("2")) {
            invoker.setCommand(new ReportCommand("events_db.txt"));
            invoker.executeCommand();
        } else {
            System.out.println("Invalid report type.");
        }
    }
}