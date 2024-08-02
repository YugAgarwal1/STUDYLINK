import java.applet.*;
import java.awt.*;
import java.awt.event.*;
// <applet code="ChoiceDemo" height="500" width="500"></applet>
public class ChoiceDemo extends Applet implements ItemListener{
Choice ch;
String msg = "";
public void init(){
	ch = new Choice();
	ch.add("adv java");
	ch.add("ds");
	ch.add("oss");
	ch.add("mup");
	add(ch);
	ch.addItemListener(this);
}
public void itemStateChanged(ItemEvent ie){
	repaint();
}
public void paint(Graphics g){
	msg = "Current selection is  = ";
	msg += ch.getSelectedItem();
	g.drawString(msg,10,100);
}
}