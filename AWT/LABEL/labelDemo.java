import java.applet.*;
import java.awt.*;
//<applet code="labelDemo" height=500 width=500></applet>
public class labelDemo extends Applet{
  Label one,two,three;
  public void init(){
  	one = new Label("one",Label.CENTER);
  	one.setBackground(Color.CYAN);
  	two = new Label("two",Label.RIGHT);
  	two.setBackground(Color.CYAN);
  	three = new Label("three",Label.LEFT);
  	three.setBackground(Color.CYAN);
  	add(one);
  	add(two);
  	add(three);
  }
}