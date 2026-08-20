package Adminpage;

import java.util.ArrayList;
import java.util.List;

public class PageCategory extends PageElement {
    private String categoryName;
    private List<PageElement> children = new ArrayList<>();

    public PageCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public void add(PageElement element) {
        children.add(element);
    }

    @Override
    public void remove(PageElement element) {
        children.remove(element);
    }

    @Override
    public void display(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        System.out.println(indent + "+ [Category] " + categoryName);
        for (PageElement child : children) {
            child.display(indentLevel + 4);
        }
    }
}
