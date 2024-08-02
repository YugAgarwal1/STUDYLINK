import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// <applet code="JButtonDemo" height="50" width="300"></applet>
public class JButtonDemo extends JApplet implements ActionListener{
JTextField jtf ;
JButton jb ;
public void init(){
	Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	jtf = new JTextField(15);
	ImageIcon i1 = new ImageIcon("C:/Users/Admin/Desktop/STUDYLINK/SWING/JButtonDemo/images for check/i1.png");
	jb = new JButton("I Love Java",i1);
	jb.setActionCommand("Advance Java");
	contentPane.add(jb);
	ImageIcon i2 = new ImageIcon("C:/Users/Admin/Desktop/STUDYLINK/SWING/JButtonDemo/images for check/i2.png");
	jb.setRolloverIcon(i2);
    contentPane.add(jtf);
    	jb.addActionListener(this);
}
public void actionPerformed( ActionEvent ae){
	jtf.setText(ae.getActionCommand());
	jb.setEnabled(false);
}
}