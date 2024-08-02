import java.applet.*;
import java.awt.*;
import java.awt.event.*;
// <applet code="MakeShapeThroughChoice.class" height="500" width="500"></applet>

class basiceventhandling extends MouseAdapter{
   MakeShapeThroughChoice target = null;
   basiceventhandling(MakeShapeThroughChoice refobj){
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
            target.setWidthHeightAndStartCoordinate();
            target.repaint();
         }
   }
}


public class MakeShapeThroughChoice extends Applet implements ItemListener{
   boolean set = true;
   int height,width,xe,ye,x1,y1,x2,y2,doDrawString;
	Checkbox chk1 , chk2 , chk3 ;  // represents the filled and unfilled 
	Checkbox c1 , c2 , c3 ,c4 ;  // representes the color
	Choice ch ;
	CheckboxGroup cbg1 , cbg2 ;
	int [] x = {50,100,150};
	int [] y = {100,50,100};
	public void init(){
      cbg1 = new CheckboxGroup();
      chk1 = new Checkbox("FILLED",cbg1,true);
      chk2 = new Checkbox("UNFILLED",cbg1,false);
      cbg2 = new CheckboxGroup();
      c1 = new Checkbox("YELLOW",cbg2,true);
      c2 = new Checkbox("CYAN",cbg2,false);
      c3 = new Checkbox("GREEN",cbg2,false);
      ch = new Choice();
      ch.add("RECTANGLE");
      ch.add("CIRCLE");
      ch.add("LINE");
      ch.add("POLYGON");
      add(chk1); add(chk2); add(ch); add(c1); add(c2); add(c3);
      chk1.addItemListener(this);
      chk2.addItemListener(this);
      ch.addItemListener(this);
      c1.addItemListener(this);
      c2.addItemListener(this);
      c3.addItemListener(this);
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
public void setWidthHeightAndStartCoordinate(){
   if(doDrawString==1){
      this.xe =x1 ;
      this.ye = y1;
     this.width = x2 - x1 ;
     this.height = y2 - y1 ;
   }
   else if(doDrawString==2){
     this.xe = x2;
     this.ye = y2;
     this.width = x1- x2 ;
     this.height = y1 - y2 ;
   }
   else if(doDrawString==3){
     this.xe = x2;
     this.ye = y1;
     this.width = x1 - x2 ;
     this.height = y2 - y1 ;
   }
   else if(doDrawString==4){
     this.xe = x1;
     this.ye = y2;
     this.width = x2 - x1 ;
     this.height = y1 - y2 ;
   }
}
public void CalculateRect(){
 if(x1<x2 && y1<y2){doDrawString = 1;}
 else if(x2<x1 && y2<y1){doDrawString = 2 ;}
 else if(x1>x2 && y1<y2){doDrawString = 3;}
 else if(x1<x2 && y1>y2){doDrawString = 4 ;}
}
	public void itemStateChanged(ItemEvent ie){
        if(ch.getSelectedItem()=="POLYGON"){
         repaint();
        }
	}
	public void paint(Graphics g){
       chk3 = cbg1.getSelectedCheckbox();
       c4 = cbg2.getSelectedCheckbox();
       String color = c4.getLabel();
       if(chk3.getLabel()=="FILLED"){
         if(ch.getSelectedItem()=="RECTANGLE"){
           if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.fillRect(xe,ye,width,height);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.fillRect(xe,ye,width,height);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.fillRect(xe,ye,width,height);
           }
         }
         else if(ch.getSelectedItem()=="CIRCLE"){
           if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.fillOval(xe,ye,width,height);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.fillOval(xe,ye,width,height);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.fillOval(xe,ye,width,height);
           }
         }
         else if(ch.getSelectedItem()=="LINE"){
              if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.drawLine(x1,y1,x2,y2);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.drawLine(x1,y1,x2,y2);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.drawLine(x1,y1,x2,y2);
           }
         }
         else if(ch.getSelectedItem()=="POLYGON"){
              if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.fillPolygon(x,y,3);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.fillPolygon(x,y,3);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.fillPolygon(x,y,3);
           }
         }
       }
       else if(chk3.getLabel()=="UNFILLED"){
         if(ch.getSelectedItem()=="RECTANGLE"){
           if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.drawRect(xe,ye,width,height);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.drawRect(xe,ye,width,height);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.drawRect(xe,ye,width,height);
           }
         }
         else if(ch.getSelectedItem()=="CIRCLE"){
           if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.drawOval(xe,ye,width,height);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.drawOval(xe,ye,width,height);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.drawOval(xe,ye,width,height);
           }
         }
         else if(ch.getSelectedItem()=="LINE"){
              if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.drawLine(x1,y1,x2,y2);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.drawLine(x1,y1,x2,y2);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.drawLine(x1,y1,x2,y2);
           }
         }
         else if(ch.getSelectedItem()=="POLYGON"){
              if(color=="CYAN"){
              g.setColor(Color.CYAN);
              g.drawPolygon(x,y,3);
           }
           else if(color=="YELLOW"){
              g.setColor(Color.YELLOW);
              g.drawPolygon(x,y,3);
           }
           else if(color=="GREEN"){
              g.setColor(Color.GREEN);
              g.drawPolygon(x,y,3);
           }
         }
       }
	}
}