import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BasicMouseEventHandling extends Applet implements MouseListener{
	String msg = "";
	int displayX,displayY;
	// <applet code="BasicMouseEventHandling" height="300" width="300"></applet>
	public void init(){
       addMouseListener(thi);
	}
	
	public void paint(Graphics g){
       g.drawString(msg,displayX,displayY);
	}
 
    public void mouseEntered(MouseEvent me){
      msg = "Entered";
      displayX = 10;
      displayY = 20;
      repaint();
    }

     
    public void mouseExited(MouseEvent me){
      msg = "Exited";
      displayX = 10;
      displayY = 20;
      repaint();
    }

     
    public void mouseReleased(MouseEvent me){
       msg = "Released";
      displayX = me.getX();
      displayY = me.getY();
      repaint();
    }

     
    public void mousePressed(MouseEvent me){
      msg = "Pressed";
    displayX = me.getX();
      displayY = me.getY();
      repaint();
    }

     
    public void mouseClicked(MouseEvent me){
      msg = "Clicked";
      displayX = me.getX();
      displayY = me.getY();
      repaint();
    }

     

}