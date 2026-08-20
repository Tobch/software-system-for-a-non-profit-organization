package Singleton;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDB {
    private static FileDB instance;

    private FileDB() {}

    public static FileDB getInstance() {
        if (instance == null) {
            instance = new FileDB();
        }
        return instance;
    }

    public void createRecord(String fileName, String data) {
        try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(data);
        } catch (IOException e) {
            System.out.println("Error saving record to " + fileName);
        }
    }

    public List<String> readRecords(String fileName) {
        List<String> records = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return records; 
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found.");
        }
        return records;
    }

    public void updateRecord(String fileName, String oldData, String newData) {
        List<String> records = readRecords(fileName);
        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (String record : records) {
                if (record.equals(oldData)) {
                    pw.println(newData);
                } else {
                    pw.println(record);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error updating record in " + fileName);
        }
    }

    public void deleteRecord(String fileName, String dataToDelete) {
        List<String> records = readRecords(fileName);
        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (String record : records) {
                if (!record.equals(dataToDelete)) {
                    pw.println(record);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error deleting record in " + fileName);
        }
    }
}