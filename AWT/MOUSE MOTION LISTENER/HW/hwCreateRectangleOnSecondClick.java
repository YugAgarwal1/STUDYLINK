import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
// <applet code="hwCreateRectangleOnSecondClick.class" height="500" width="500"></applet>
class basiceventhandling extends MouseAdapter{
	hwCreateRectangleOnSecondClick target = null;
	basiceventhandling(hwCreateRectangleOnSecondClick refobj){
          target = refobj ;
	}
	public void mouseClicked(MouseEvent me){
         if(target.set){
         	target.setX1(me.getX());
         	target.setY1(me.getY());
         	target.set = false ;
         }
         else{
         	target.setX2(me.getX());
         	target.setY2(me.getY());
         	target.set = true ;
         	target.CalculateRect();
         	target.repaint();
         }
	}
}
public class hwCreateRectangleOnSecondClick extends Applet{
	int x,y,x1,y1,x2,y2,doDrawString;
    boolean set = true ;	
public void init(){

	this.addMouseListener(new basiceventhandling(this));
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
public void paint(Graphics g){
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