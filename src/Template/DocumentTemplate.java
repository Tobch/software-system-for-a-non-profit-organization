package Template;

public abstract class DocumentTemplate {
    
    public final void generateDocument(String data) {
        System.out.println("\n--------------------------------------------------");
        addHeader();
        addBody(data);
        addFooter();
        System.out.println("--------------------------------------------------");
    }

    protected abstract void addHeader();
    protected abstract void addBody(String data);
    protected abstract void addFooter();
}