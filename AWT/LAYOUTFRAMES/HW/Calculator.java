import java.applet.*;
import java.awt.*;
//<applet code="Calculator" width="500" height="500"></applet>
public class Calculator extends Applet{
  Panel p;
  TextField t ;
  int count = 1;
  public void init(){
  	setLayout(new BorderLayout());  
    p = new Panel();
    t = new TextField(50);
    GridLayout gb = new GridLayout(5,5,5,5);
    p.setLayout(gb);
    for(int i = 0 ; i < 5 ; i++){
    	for(int j = 0 ; j < 5 ; j++ ){
    		p.add(new Button(""+count));
    		count++;
    	}
    }
    add(t,BorderLayout.NORTH);
    add(p,BorderLayout.CENTER);
  }
}