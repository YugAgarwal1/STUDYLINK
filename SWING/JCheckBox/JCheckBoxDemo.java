// images daalna sikhle bhai mere


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//<applet code="JCheckBoxDemo" width="400" height="50"></applet>
public class JCheckBoxDemo extends JApplet implements ItemListener{
JTextField jtf ;
public void init(){
	Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	//ImageIcon normal = new ImageIcon("C:/Users/Admin/Desktop/STUDYLINK/SWING/JButtonDemo/images for check/i1.png");
	//ImageIcon rollover = new ImageIcon("C:/Users/Admin/Desktop/STUDYLINK/SWING/JButtonDemo/images for check/i2.png");
	//ImageIcon selected = new ImageIcon("C:/Users/Admin/Desktop/STUDYLINK/SWING/JButtonDemo/images for check/i1.png");

	JCheckBox cb = new JCheckBox("C");
//	cb.setRolloverIcon(rollover);
   // cb.setSelectedIcon(selected);
    cb.addItemListener(this);
    contentPane.add(cb);

	cb = new JCheckBox("C++");
    //	cb.setRolloverIcon(rollover);
   // cb.setSelectedIcon(selected);
    cb.addItemListener(this);
    contentPane.add(cb);



	cb = new JCheckBox("java");
   //  	cb.setRolloverIcon(rollover);
   // cb.setSelectedIcon(selected);
    cb.addItemListener(this);
    contentPane.add(cb);

    cb = new JCheckBox("pearl");
   // cb.setRolloverIcon(rollover);
   // cb.setSelectedIcon(selected);
    cb.addItemListener(this);
    contentPane.add(cb);
jtf = new JTextField(15);
contentPane.add(jtf);
}

public void itemStateChanged(ItemEvent ae){
JCheckBox cb  = (JCheckBox)ae.getItem();
if(cb.isSelected()){
	jtf.setText(jtf.getText()+" "+cb.getText());
}
}
}