import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.*;
//<applet code="JScrollPaneDemo" width="500" height="500"></applet>
public class JScrollPaneDemo extends JApplet{
	public void init(){
		Container contentPane = getContentPane();
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(10,8));
		int b = 0;
		for(int i=0;i<10;i++){
			for(int j=0;j<8;j++){
				jp.add(new JButton("Button "+b));
				++b;
			}
		}

		int v = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane jsp = new JScrollPane(jp,v,h);
		contentPane.add(jsp);
	}
}