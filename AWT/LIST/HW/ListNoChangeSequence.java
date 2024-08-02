import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
//<applet code="ListNoChangeSequence.class" height="500" width="500"></applet> 
public class ListNoChangeSequence extends Applet implements ItemListener{
	List l1 ;
  String [] val = new String[5] ;    //array which takesh selected items
  String [] new1 = new String[5];    // array which will be storing the items in seleted format
  int newind = 0 ;
	public void init(){
   l1 = new List(5,true);
   l1.add("JAVA");
   l1.add("DCC");
   l1.add("MIC");
   l1.add("GAD");
   l1.add("SEN");
   l1.addItemListener(this);
   add(l1);
}
public void itemStateChanged(ItemEvent ie){
      repaint();
}
public boolean checkAddStatusOfFinalArray(String  arr){
    for(String c : new1){
      System.out.println(c);
      if(arr.equals(c)){ // sir commented this keep in mind always How can you compare two strings with == ???? I though equals() is used to compare in Java!
        return false;
      }
    }
    System.out.println();
    return true;
}
public boolean checkDeleteStatusOfFinalArray(String arr,String [] indexArray){
  for(String c : indexArray){
    if(arr.equals(c)){ 
        return true;
    }
  }
  return false;
}
public void paint(Graphics g){
   String msg = "Selected Subjects are :\n";
    val = l1.getSelectedItems();
   for(int i=0;i<val.length;i++){
     if(checkAddStatusOfFinalArray(val[i])){
       new1[newind] = val[i];
       newind++;
       break;
     }
   }
   for(int i=0;i<newind;i++){
    if((checkDeleteStatusOfFinalArray(new1[i],val))==false){
        for(int j = i ; j<new1.length-1 ; j++){    //shayad se error idhar he arra hai
          new1[j] = new1[j+1];
        }
        newind--;
        break;
    }
   }
   g.drawString(msg,10,40);
   int x = 60 ;
   for(int i=0;i<newind;i++){
      g.drawString(new1[i],10,x);
      x+=20;
   }
  
}
}