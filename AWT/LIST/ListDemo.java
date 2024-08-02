import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class ListDemo extends Applet implements ItemListener{
	// <applet code="ListDemo.class" height="500" width="500"></applet>
String msg= "";
List L1;
public void init(){
L1 = new List(3,true);
L1.add("Adv java");
L1.add("sen");
L1.add("gad");
L1.add("java");
L1.add("mup");
add(L1);
L1.addItemListener(this);
}
public void itemStateChanged(ItemEvent ie){
	repaint();
}
public void paint(Graphics g){
	int ind[];
	msg = "Selected Subjects are : ";
	ind = L1.getSelectedIndexes();
	for(int i=0;i<ind.length;i++){
		msg+= L1.getItem(ind[i])+" ";
	}
	g.drawString(msg,6,200);
}
}