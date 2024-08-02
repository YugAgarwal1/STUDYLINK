import java.applet.*;
import java.awt.*;
import java.awt.event.*;
// <applet code="CheckBoxGroupDemo.class" height="500" width="500"></applet>
public class CheckBoxGroupDemo extends Applet implements ItemListener{
	String msg = "";
	Checkbox chk1,chk2,chk3,chk4;
	CheckboxGroup cbg ;
	public void init(){
		cbg = new CheckboxGroup(); 
		chk1 = new Checkbox("Windows xp",cbg,true);
		chk2 = new Checkbox("linux",cbg,true);
		chk3 = new Checkbox("Windows vista",cbg,true);
	    add(chk1);
	    add(chk2);
	    add(chk3);
	    chk1.addItemListener(this);
	    	    chk2.addItemListener(this);
	    	    	    chk3.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie){
		repaint();
	}
	public void paint(Graphics g){
		msg = "Current Selection is : ";
		chk4 = cbg.getSelectedCheckbox();
		msg += chk4.getLabel();
		g.drawString(msg,6,100);
	}
}