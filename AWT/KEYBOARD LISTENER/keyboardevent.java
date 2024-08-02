import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
// <applet code="keyboardevent" height="500" width="500"></applet>
public class keyboardevent extends Applet implements KeyListener{
	String msg = "";
	boolean skip = false;
	public void init(){
     this.addKeyListener(this);
	}

	public void keyPressed(KeyEvent ke){
	     if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
	     	// if the length of the string is 0 and user press backspace then stringindex out of bound exception na aai isliye yeh likha hai 
	     	if(msg.length()==0){
          msg="";
	     	}
	     	else{
        msg = msg.substring(0,msg.length()-1);
	     	repaint();
	     	skip = true ;
	     	}
	     }
	     else{
	     	skip = false ; 
	     }
	}
	public void keyTyped(KeyEvent ke){
		if(!skip){
			msg += ke.getKeyChar();
			repaint();
		}
	}
	public void keyReleased(KeyEvent ke){

	}
  public void paint(Graphics g){
      g.drawString(msg,10,20);
  }
}