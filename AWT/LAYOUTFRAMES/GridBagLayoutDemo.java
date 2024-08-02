import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//<applet code="GridBagLayoutDemo" width="500" height="500"></applet>
public class GridBagLayoutDemo extends Applet{
	GridBagLayout one = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();
  public void init(){
    Panel p = new Panel();
    p.setLayout(one);
  	c.gridx = 0;
  	c.gridy = 0 ;
    c.fill = GridBagConstraints.BOTH;
     c.gridwidth = GridBagConstraints.REMAINDER;            
     c.gridheight = 2;  
     p.add(new TextField("this is the text field created and it will be the textfield"));

     c.gridwidth = 1 ;
     c.gridheight = 1 ;
     for(int i = 0 ; i < 5 ; i++) {
     	for(int j=0 ; j<5 ; j++){
     		p.add(new Button("button"));
     	}
     }
     add(p);
  }
}