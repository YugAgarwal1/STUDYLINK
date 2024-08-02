import java.applet.*;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// <applet code="ButtonDemo" height="400" width="400"></applet>
public class ButtonDemo extends Applet implements ActionListener {
String msg = "";
String stime = "";
long time;
Button y,n,m;
public void init(){
	y = new Button("HELLO");
	n = new Button("HELLO");
	m = new Button("HELLO");
	add(y);
	add(n);
	add(m);
	y.addActionListener(this);
	n.addActionListener(this);
	m.addActionListener(this);
   
}
public void actionPerformed(ActionEvent ae){
   // y.setActionCommand("Yes");
	//  n.setActionCommand("No");
	//  m.setActionCommand("Maybe");
    // y.setLabel("YES");
    // n.setLabel("NO");
    // m.setLabel("MAYBE");
	String str = ae.getActionCommand();

	if(str.equals("YES")){     // alternate method to check is if(ae.getSource() == y)  here y represents the button name, getSource() is the method of the super class EventObject aur usko you accessed it with the subclass ActionEvent ka object
       msg = "You pressed yes through setLabel"; 
       time = ae.getWhen();   // returns the time at when the event occurs in long
       stime = time + " ";    // converts the long datatype into String 
	}
	else if(str.equals("NO")){
       msg = "You pressed no through setLabel";
       time = ae.getWhen();  // returns the time at when the event occurs in long
       stime = time + " ";   // converts the long datatype into String 
	}
	else if(str.equals("MAYBE")){
       msg = "You pressed maybe through setLabel";
       time = ae.getWhen();   // returns the time at when the event occurs in long
       stime = time + " ";  // converts the long datatype into String
	}

   else if(str.equals("Yes")){     // alternate method to check is if(ae.getSource() == y)  here y represents the button name, getSource() is the method of the super class EventObject aur usko you accessed it with the subclass ActionEvent ka object
       msg = "You pressed yes through setActioncommand"; 
       time = ae.getWhen();   // returns the time at when the event occurs in long
       stime = time + " ";    // converts the long datatype into String 
	}
	else if(str.equals("No")){
       msg = "You pressed no through setActioncommand";
       time = ae.getWhen();  // returns the time at when the event occurs in long
       stime = time + " ";   // converts the long datatype into String 
	}
	else if(str.equals("Maybe")){
       msg = "You pressed maybe through setActioncommand";
       time = ae.getWhen();   // returns the time at when the event occurs in long
       stime = time + " ";  // converts the long datatype into String
	}
	repaint();
}
public void paint(Graphics g){
   g.drawString(msg,5,100);
   g.drawString(stime,5,120);
}
}


// book mai likha hai tune check karrrr