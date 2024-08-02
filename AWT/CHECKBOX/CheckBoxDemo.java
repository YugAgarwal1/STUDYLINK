import java.applet.*;
import java.awt.event.*;
import java.awt.*;
// <applet code="CheckBoxDemo" height="500" width="500"></applet>
public class CheckBoxDemo extends Applet implements ItemListener{
	Checkbox chk1,chk2,chk3;
	Label l1,l2,l3;
	public void init(){
		chk1 = new Checkbox("Windows xp");
		chk2 = new Checkbox("Linux");
		chk3 = new Checkbox("windows Vista");
		l1 = new Label("");
		l2 = new Label("");
		l3 = new Label("");
        add(chk1);  
        add(chk2); 
        add(chk3); 
        add(l1); 
        add(l2); 
        add(l3);
        chk1.addItemListener(this);
           chk2.addItemListener(this);
           chk3.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie){
		if(ie.getSource()==chk1){
			if(chk1.getState()){
				l1.setText("You selected Windows xp");
			}
			else {
				l1.setText("");
			}
		}
			else if(ie.getSource()==chk2){
			if(chk2.getState()){
				l2.setText("You selected linux");
			}
			else {
				l2.setText("");
			}
		}
			else if(ie.getSource()==chk3){
			if(chk3.getState()){
				l3.setText("You selected Windows vista");
			}
			else {
				l3.setText("");
			}
		}
	}

	}