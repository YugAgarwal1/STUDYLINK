import java.awt.*;
import javax.swing.*;
//<applet code="JTabbedPaneDemo.class" width="400" height="100"></applet>
public class JTabbedPaneDemo extends JApplet{
	public void init(){
		JTabbedPane jtp = new JTabbedPane(JTabbedPane.BOTTOM);
		jtp.addTab("CITIES",new CitiesPanel());
		jtp.addTab("COLORS",new ColorsPanel());
		jtp.addTab("FLAVOURS",new FlavoursPanel());
		getContentPane().add(jtp);
	}
}
class CitiesPanel extends JPanel{
	public CitiesPanel(){
		add(new JButton("NEW YORK"));
				add(new JButton("LONDON"));
						add(new JButton("HONG KONG"));
								add(new JButton("TOKYO"));
	}
}

class ColorsPanel extends JPanel{
	public ColorsPanel(){
		add(new JCheckBox("RED"));
				add(new JCheckBox("BLUE"));
						add(new JCheckBox("GREEN"));
								add(new JCheckBox("YELLOW"));
	}
}

class FlavoursPanel extends JPanel{
	public FlavoursPanel(){
	JComboBox jb = new JComboBox();
	jb.addItem("VANILLA");
	jb.addItem("BUTTER SCOTCH");
	jb.addItem("CHOCOLATE");
	add(jb);
	}
}