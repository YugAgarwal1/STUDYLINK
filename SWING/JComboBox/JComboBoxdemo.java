import java.awt.*;
import javax.swing.*;
// <applet code="JComboBoxDemo.class" width="500" height="500"></applet>
public class JComboBoxDemo extends JApplet {
   Choice c ;
   public void init(){
   	Container contentPane = getContentPane();
   	contentPane.setLayout(new FlowLayout());
   JComboBox c1 = new JComboBox();
   	c1.addItem("HI");
   	c1.addItem("BYE");     // this is objects but the type of the object is string JComboBox takes vector and not directly string matlab hum koi bhi object daal sakte hai isme
   	c1.addItem("GET");
   	c1.addItem("LOST");
   	c1.addItem("OPEN");
   	c1.addItem("FAST");
   	c1.addItem("SLOW");
    contentPane.add(c1);

    c= new Choice();
    c.add("HI");
    c.add("BYE");
    c.add("GET");
    c.add("LOST");
    c.add("OPEN");
    c.add("FAST");
    c.add("SLOW");
    contentPane.add(c);
   }
}
// code warning phekega cause we have used vector joh class vector use karti hai woh awrning deta he hai 
// remember it's just warning and not the error code compile hota hai 