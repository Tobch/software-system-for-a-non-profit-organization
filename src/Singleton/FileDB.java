package Singleton;
//Singleton Pattern
//it handles basic CRUD operations
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDB {
    private static FileDB instance;
    private String currentFile = "database.txt";

    private FileDB() {}

    public static FileDB getInstance() {
        if (instance == null) {
            instance = new FileDB();
        }
        return instance;
    }

    public void createRecord(String data) {
        try (FileWriter fw = new FileWriter(currentFile, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(data);
        } catch (IOException e) {
            System.out.println("Error saving record");
        }
    }

    public List<String> readRecords() {
        List<String> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(currentFile))) {
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found. A new one will be created");
        }
        return records;
    }

    public void updateRecord(String oldData, String newData) {
        List<String> records = readRecords();
        try (PrintWriter pw = new PrintWriter(currentFile)) {
            for (String record : records) {
                if (record.equals(oldData)) {
                    pw.println(newData);
                } else {
                    pw.println(record);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error updating record");
        }
    }

    public void deleteRecord(String dataToDelete) {
        List<String> records = readRecords();
        try (PrintWriter pw = new PrintWriter(currentFile)) {
            for (String record : records) {
                if (!record.equals(dataToDelete)) {
                    pw.println(record);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error deleting record");
        }
    }
}