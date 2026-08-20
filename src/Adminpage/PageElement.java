package Adminpage;

public abstract class PageElement {
    
    public void add(PageElement element) {
        throw new UnsupportedOperationException();
    }

    public void remove(PageElement element) {
        throw new UnsupportedOperationException();
    }
    public abstract void display(int indentLevel);
}