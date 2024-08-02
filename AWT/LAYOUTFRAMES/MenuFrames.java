import java.awt.event.*;
import java.awt.*;
public class MenuFrames extends Frame{
MenuFrames(){
	super("MenuBar Example");
	setSize(300,300);
	setVisible(true);
    MenuBar mbar = new MenuBar();
    setMenuBar(mbar);
    Menu fileMenu = new Menu("File");
    Menu editMenu = new Menu("Edit");
    Menu sub = new Menu("Sub Menu");
    mbar.add(fileMenu);
    mbar.add(editMenu);
    mbar.add(sub);
    MenuItem exit = new MenuItem("Exit");
    MenuItem dash = new MenuItem("-");
    MenuItem new1 = new MenuItem("new");
    MenuItem cut = new MenuItem("cut");
    MenuItem copy = new MenuItem("copy");
    MenuItem find = new MenuItem("find");
    CheckboxMenuItem replace = new CheckboxMenuItem("replace",true);  
    fileMenu.add(new1);
    fileMenu.add(dash);
    fileMenu.add(exit);
    editMenu.add(cut);
    editMenu.add(copy);
    editMenu.add(new MenuItem("-"));
    editMenu.add(sub);
    sub.add(find);
    sub.add(replace);
    addWindowListener(new WindowAdapter(){
    	public void windowClosing(WindowEvent we){
              System.exit(0);
    	}
    });
}
public static void main(String[] args) {
	new MenuFrames();
}
}