import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class InsetsDemo extends Applet{
//<applet code="InsetsDemo.class" height="400" width="200"></applet>
	public void init(){
		setLayout(new BorderLayout(10,10));
		setBackground(Color.cyan);
		add(new Button("This is across the top"),BorderLayout.NORTH);
		add(new Button("footer message might go there"),BorderLayout.SOUTH);
		add(new Button("Right"),BorderLayout.EAST);
		add(new Button("East"),BorderLayout.EAST); // do baaar east daala hai toh second waala aayega
		add(new Button("left"),BorderLayout.WEST);
		String msg = "JAVA is the best programming language"+"\nBut most of us like dotnet"+"\nWhich is also a frm of oop";
		add(new TextArea(msg),BorderLayout.CENTER);
	}
	@Override
	public Insets getInsets(){
		return new Insets(10,10,10,10);
	}
}