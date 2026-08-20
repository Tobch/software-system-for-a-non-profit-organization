package Template;

public class EventReport extends DocumentTemplate {
    
    @Override
    protected void addHeader() {
        System.out.println("EVENT SUMMARY REPORT");
    }

    @Override
    protected void addBody(String data) {
        System.out.println("Event Data: " + data);
    }

    @Override
    protected void addFooter() {
        System.out.println("Generated automatically by the Admin System");
    }
}