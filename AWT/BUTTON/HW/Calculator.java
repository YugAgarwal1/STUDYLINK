import java.applet.*;
import java.awt.*;
import java.awt.event.*;
// <applet code="Calculator" height="500" width="500"></applet>
public class Calculator extends Applet implements ActionListener{
	TextField t1 ;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bclear,bback;
public void init()
{
 b1 = new Button("1");
  b2 = new Button("2"); b3 = new Button("3"); b4 = new Button("4"); b5 = new Button("5"); b6 = new Button("6"); b7 = new Button("7"); b8 = new Button("8"); b9 = new Button("9"); b0 = new Button("0"); bclear = new Button("Clear");bback = new Button("Backspace"); 
  t1 = new TextField(15);
  add(t1);
  add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);add(b0);add(bclear);add(bback);
}
public void actionPerformed(ActionEvent ae){

}
public void paint(Graphics g){
	
}
}