// class given
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
// <applet code="HWCreateRectangleOnRelease" height="400" width="400"></applet>
class MyMouseListener extends MouseAdapter{
	private HWCreateRectangleOnRelease target = null;
	MyMouseListener(HWCreateRectangleOnRelease  refobj){
		target = refobj ; 
	}
	public void mousePressed(MouseEvent me){
		target.setX1(me.getX());
		target.setY1(me.getY());
	}
	public void mouseReleased(MouseEvent me){
		target.setX2(me.getX());
		target.setY2(me.getY());
		target.CalculateRect();
		target.repaint();
	}
}
public class HWCreateRectangleOnRelease extends Applet{
	private int x1,y1,x2,y2,x,y,x3,y3,tx1,ty1,tx2,ty2;
	private int  doDrawString = 0;
	private String msg;

public void init(){
this.addMouseListener(new MyMouseListener(this));
}
public void setMsg(String msg){
	this.msg = msg;
}
public void setX(int x){
	this.x = x;
}
public void setY(int y){
	this.y = y;
}
public void setX1(int x1){
	this.x1 = x1;
}
public void setX2(int x2){
	this.x2 = x2;
}
public void setY1(int y1){
	this.y1 = y1;
}
public void setY2(int y2){
	this.y2 = y2;
}
public void CalculateRect(){
 if(x1<x2 && y1<y2){doDrawString = 1;}
 else if(x2<x1 && y2<y1){doDrawString = 2 ;}
 else if(x1>x2 && y1<y2){doDrawString = 3;}
 else if(x1<x2 && y1>y2){doDrawString = 4 ;}
}
public void update(Graphics g){
   if(doDrawString == 2){
   	g.drawRect(x2,y2,(x1-x2),(y1-y2));
   }
   else if(doDrawString == 1){
   	g.drawRect(x1,y1,(x2-x1),(y2-y1));
   }
   else if(doDrawString == 3){
   	g.drawRect(x2,y1,(x1-x2),(y2-y1));
   }
   else if(doDrawString == 4){
   	g.drawRect(x1,y2,(x2-x1),(y1-y2));
   }   
}
}