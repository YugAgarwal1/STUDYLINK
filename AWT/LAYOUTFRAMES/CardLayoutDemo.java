import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//<applet code="CardLayoutDemo.class" height="500" width="500"></applet>
public class CardLayoutDemo extends Applet implements ActionListener,MouseListener{
Checkbox Win98,WinNT,Solaris,Mac;
Panel OSCards;
CardLayout CardLO;
Button Win , Other ;
public void init(){
	Win = new Button("Windows");
	Other = new Button("Other");
	add(Win);
	add(Other);
    CardLO = new CardLayout();
    OSCards = new Panel();
    OSCards.setLayout(CardLO);
    // set panel layout to card layout 
    // applet panel ka layout abhi bhi flow he hai 

    Win98 = new Checkbox("Windows 98/xp",null,true);
    WinNT = new Checkbox("Windows NT");
    Solaris = new Checkbox("Solaris");
    Mac = new Checkbox("Mac");

    Panel winPan = new Panel();
   winPan.add(Win98);
   winPan.add(WinNT);

   Panel OtherPan = new Panel();
   OtherPan.add(Solaris);
   OtherPan.add(Mac);

   OSCards.add(winPan,"Windows");  // the second parameter defines the identifiable name of the container card aur yeh container panel kai liye hai woh yeh naam use karke next display show kar sakta hai simple
   OSCards.add(OtherPan,"Other");

   add(OSCards);

   Win.addActionListener(this);;
   Other.addActionListener(this);
   addMouseListener(this);
}
public void mousePressed(MouseEvent me){
	CardLO.next(OSCards);  // here cardlo is the object of cardlayout and oscard is the object of panel container jiske andar sabhh cards hai this means that cardlayouut has the function of next display etc
}
public void mouseEntered(MouseEvent me){}
public void mouseExited(MouseEvent me){}
public void mouseReleased(MouseEvent me){}
public void mouseClicked(MouseEvent me){}

public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==Win){
		CardLO.show(OSCards,"Windows");  //  here oscards is the object of the container having cardlayout as default manager and windows is the name of the container card present in the container oscards yeh usko naam se identify karega easy hai uske liye just like symbol and number on the card  of the deck
	}
	else{
		CardLO.show(OSCards,"Other");  // upar waala padhle samajh jaaega 
	}
}
}