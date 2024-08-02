  import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
// <applet code="hwkeyboardevent" height="500" width="500"></applet>
public class hwkeyboardevent extends Applet implements KeyListener {
String [] msg = new String[100];
int ind = 0 ;
boolean  skip = false;
boolean makeFirst = false;
public void init(){
	this.addKeyListener(this);
}
public void keyPressed(KeyEvent ke){
	makeFirst = true ;
 if(ke.getKeyCode() == KeyEvent.VK_ENTER){
   skip = true;
   ind ++;
   msg[ind] = "";
   repaint();
 }
 else if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE){
    skip = true;
    if(msg[0].length()-1 == -1){
       msg[0] = "";
    }
    else if(msg[ind].length()-1 == -1){
    	ind--;
    	repaint();
    }
    else{
         msg[ind] = msg[ind].substring(0,msg[ind].length()-1);
         repaint();
    }
 }
 else{
    skip = false;
 }
}
public void keyReleased(KeyEvent ke){
System.out.println("The key is released");
}
public void keyTyped(KeyEvent ke){
   if(!skip){
   	msg[ind] += ke.getKeyChar();
   	repaint();
   }
}
public void paint(Graphics g){
	if(makeFirst == false){
	   msg[0] = "";
	}
	else{
		int x = 10;
		for(int i = 0 ; i<= ind ; i++){
			g.drawString(msg[i],10,x);
			x+=20;
		}
           }
	}
}