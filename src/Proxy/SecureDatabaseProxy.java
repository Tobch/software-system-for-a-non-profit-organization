package Proxy;

public class SecureDatabaseProxy implements IDatabaseAdmin {
    private RealDatabaseAdmin realAdmin;
    private final String ADMIN_PASSWORD = "admin";

    public SecureDatabaseProxy() {
        this.realAdmin = new RealDatabaseAdmin();
    }
    @Override
    public void deleteRecord(String fileName, String dataToDelete, String password) {
        System.out.println("[Proxy] Verifying administrative credentials...");
        
        if (this.ADMIN_PASSWORD.equals(password)) {
            System.out.println("[Proxy] Access Granted. Forwarding delete request...");
            realAdmin.deleteRecord(fileName, dataToDelete, password);
        } else {
            System.out.println("[Proxy] Access Denied. Incorrect administrator password.");
        }
    }
}