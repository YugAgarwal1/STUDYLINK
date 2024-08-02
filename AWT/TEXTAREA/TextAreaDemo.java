import java.applet.*;
import java.awt.*;
import java.awt.event.*;
// <applet code="TextAreaDemo.java" height="500" width="500"></applet>
public class TextAreaDemo extends Applet{
  TextArea ta;
  Button b;
  public void init(){
  	b = new Button("REPLACE");
  	ta = new TextArea("Advanced JAVA is Boring",10,60,TextArea.SCROLLBARS_BOTH);
  	add(b);
  	add(ta);
  	ta.requestFocus();
  	b.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent ae){
  			ta.replaceRange("MUP",9,13);
  		}
  	});
  }
}