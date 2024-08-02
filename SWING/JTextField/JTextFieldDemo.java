
import java.awt.TextField;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
//<applet code="JTextFieldDemo" width="300" height="50"></applet>
public class JTextFieldDemo extends JApplet{
JTextField jtf ;
TextField t ;
public void init(){
	Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	jtf = new JTextField("this is swing ka textfield",15);
	t = new TextField("this is awt ka textfield",15);
	contentPane.add(jtf);
	contentPane.add(t);
}
}