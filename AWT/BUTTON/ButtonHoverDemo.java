import java.applet.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
// <applet code="ButtonHoverDemo.class" height="500" width="500"></applet>
public class ButtonHoverDemo extends Applet implements FocusListener{
	String str ;
	Button b1,b2;
	public void init(){
		b1 = new Button("Please hover me!");
		b2 = new Button("Another Button");
		add(b1);
		add(b2);
		b1.addMouseListener(new ButtonHoverEventHandler());
		b1.addFocusListener(this);
		b2.addFocusListener(this);
		b2.addMouseListener(new ButtonHoverEventHandler());
	}
	public void focusGained(FocusEvent fe){
		((Component)fe.getSource()).setBackground(Color.CYAN);
		Component src = fe.getOppositeComponent();
	    str = src+"";
	    repaint();
	}
	public void focusLost(FocusEvent fe){
		((Component)fe.getSource()).setBackground(Color.WHITE);
	    Component src = fe.getOppositeComponent();
	    str = src+"";
	    repaint();
	}
	public void paint(Graphics g){
		g.drawString(str,20,40);
	}
}
class ButtonHoverEventHandler extends MouseAdapter{
	public void mouseEntered(MouseEvent me){
        ((Component)me.getSource()).setBackground(Color.CYAN);
	}
	public void mouseExited(MouseEvent me){
        ((Component)me.getSource()).setBackground(Color.WHITE);
	}
}