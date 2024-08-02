// class given
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
// <applet code="BasicEventHandling" height="400" width="400"></applet>
class MyMouseMotionListener implements MouseMotionListener{
private BasicEventHandling target = null;
MyMouseMotionListener(BasicEventHandling refobj){
	target = refobj ; 
}
public void mouseDragged(MouseEvent me){
	target.setMsg("*");
	target.setX(me.getX());
	target.setY(me.getY());
	target.setDoDrawString(true);
	target.repaint();
}
public void mouseMoved(MouseEvent me){
target.showStatus("Mouse Moving at : [ "+me.getX()+" , "+me.getY()+" ]");
}
}
class MyMouseListener extends MouseAdapter{
	private BasicEventHandling target = null;
	MyMouseListener(BasicEventHandling  refobj){
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
		target.setDoDrawString(false);
		target.repaint();
	}
}
public class BasicEventHandling extends Applet{
	private int x1,y1,x2,y2,x,y,x3,y3;
	private boolean doDrawString = false;
	private String msg;

public void init(){
this.addMouseListener(new MyMouseListener(this));
this.addMouseMotionListener(new MyMouseMotionListener(this));
}
public void setDoDrawString(boolean doDrawString){
	this.doDrawString = doDrawString ; 
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
public void setX3(int x3){
this.x3 = x3;
}
public void setY3(int y3){
this.y3 = y3;
}
public void CalculateRect(){
this.x3 = x2 - x1;
this.y3 = y2 - y1;
}
public void update(Graphics g){
if(doDrawString){
	g.drawString(msg,x,y);
}
else{
	g.drawRect(x1,y1,x3,y3);
}
}
}