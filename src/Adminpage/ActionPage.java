package Adminpage;

public class ActionPage extends PageElement {
    private String pageName;
    private String menuOption; 

    public ActionPage(String pageName, String menuOption) {
        this.pageName = pageName;
        this.menuOption = menuOption;
    }

    @Override
    public void display(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        System.out.println(indent + menuOption + ". " + pageName);
    }
}