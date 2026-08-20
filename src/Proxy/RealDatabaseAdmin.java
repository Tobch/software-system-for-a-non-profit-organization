package Proxy;

import Singleton.FileDB;

public class RealDatabaseAdmin implements IDatabaseAdmin {
    private FileDB dbManager = FileDB.getInstance();

    @Override
    public void deleteRecord(String fileName, String dataToDelete, String password) {
        dbManager.deleteRecord(fileName, dataToDelete);
        System.out.println("Record deleted successfully from " + fileName);
    }
}