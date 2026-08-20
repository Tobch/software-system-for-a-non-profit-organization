package Command;

import Singleton.FileDB;
import Template.DocumentTemplate;
import Template.DonationReceipt;
import Template.EventReport;
import java.util.List;

public class ReportCommand implements ICommand {
    private FileDB dbManager;
    private String targetDatabaseFile;

    public ReportCommand(String targetDatabaseFile) {
        this.dbManager = FileDB.getInstance();
        this.targetDatabaseFile = targetDatabaseFile;
    }

    @Override
    public void execute() {
        System.out.println("\n>>> Generating System Report for: " + targetDatabaseFile + " <<<");
        
        List<String> records = dbManager.readRecords(targetDatabaseFile);
        
        if (records.isEmpty()) {
            System.out.println("No records found in " + targetDatabaseFile);
            return;
        }

        DocumentTemplate template;
        if (targetDatabaseFile.equals("donations_db.txt")) {
            template = new DonationReceipt();
        } else {
            template = new EventReport();
        }

        for (String record : records) {
            template.generateDocument(record);
        }
        
        System.out.println("\n>>> End of Report <<<");
    }
}