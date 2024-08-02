import java.applet.*;
import java.awt.*;
//<applet code="ChangeLayoutFrameInApplet.class" height="500" width="500"></applet>
public class ChangeLayoutFrameInApplet extends Applet {
   public void init(){
   	setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
   	add(new Button("select1"));
   	add(new Button("Select2"));
   	add(new Button("Select3"));
   }
}