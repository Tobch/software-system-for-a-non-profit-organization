package MVC.Controllers;

import Factory.DonationFactory;
import Factory.Donation;
import Singleton.FileDB;
import Iterator.IAggregate;
import Iterator.RecordCollection;
import Iterator.IIterator;
import Proxy.IDatabaseAdmin;
import Proxy.SecureDatabaseProxy;
import Strategy.PaymentContext;
import Strategy.CreditCardStrategy;
import Strategy.PayPalStrategy;
import Strategy.CryptoStrategy;
import java.util.List;

public class DonationController {
    private FileDB dbManager = FileDB.getInstance();
    private DonationFactory factory = new DonationFactory();
    private IDatabaseAdmin adminProxy = new SecureDatabaseProxy();
    private final String FILE_NAME = "donations_db.txt";

    public void addDonation(String type, String details, String onlineMethod) {
        Donation donation = factory.createDonation(type, details);
        if (donation != null) {
            
            if (type.equalsIgnoreCase("Online")) {
                double amount = 0.0;
                try {
                    String numericPart = details.replaceAll("[^\\d.]", "");
                    if (!numericPart.isEmpty()) {
                        amount = Double.parseDouble(numericPart);
                    }
                    PaymentContext paymentContext = new PaymentContext();
                    
                    if (onlineMethod.equalsIgnoreCase("CreditCard")) {
                        paymentContext.setPaymentStrategy(new CreditCardStrategy());
                    } else if (onlineMethod.equalsIgnoreCase("PayPal")) {
                        paymentContext.setPaymentStrategy(new PayPalStrategy());
                    } else if (onlineMethod.equalsIgnoreCase("Crypto")) {
                        paymentContext.setPaymentStrategy(new CryptoStrategy());
                    } else {
                        System.out.println("Invalid selection. Defaulting to Credit Card.");
                        paymentContext.setPaymentStrategy(new CreditCardStrategy());
                    }
                    paymentContext.executePayment(amount);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Could not read a valid payment amount.");
                }
            }
            donation.processDonation();
            dbManager.createRecord(FILE_NAME, donation.getDetails());
            System.out.println("Donation saved successfully.");
        } else {
            System.out.println("Invalid type.");
        }
    }

    public void viewDonations() {
        List<String> rawRecords = dbManager.readRecords(FILE_NAME);
        IAggregate recordCollection = new RecordCollection(rawRecords);
        IIterator iterator = recordCollection.createIterator();
        System.out.println("\n--- All Donation Records ---");
        // here we use the Iterator Pattern to traverse the records
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------\n");
    }

    public void updateSystemRecord(String oldData, String newData) {
        dbManager.updateRecord(FILE_NAME, oldData, newData);
        System.out.println("Record updated successfully.");
    }

    public void deleteSystemRecord(String dataToDelete, String password) {
        adminProxy.deleteRecord(FILE_NAME, dataToDelete, password);
    }
}