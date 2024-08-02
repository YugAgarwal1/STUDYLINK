import java.applet.*;
import java.awt.*;
import java.awt.event.*;
// <applet code="TextFieldDemo.class" height="500" width="500"></applet>
public class TextFieldDemo extends Applet implements ActionListener{
	TextField name,pass;
	public void init(){
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('*');
		add(new Label("name : "));
		add(name);
		add(new Label("password :"));
		add(pass);
		name.addActionListener(this);
		pass.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		repaint();
	}
	public void paint(Graphics g){
		g.drawString("name : "+name.getText(),6,60);
		g.drawString("Selected text in name : "+name.getSelectedText(),6,80);
		g.drawString("Password : "+pass.getText(),6,100);
	}
}