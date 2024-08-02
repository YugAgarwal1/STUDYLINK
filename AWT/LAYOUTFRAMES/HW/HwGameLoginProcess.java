import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//<applet code="HwGameLoginProcess" height="500" width="500"></applet>2qa                                                                                                                             
public class HwGameLoginProcess extends Applet implements ActionListener{
  Panel MainContainer ;
  Panel one,two,three,four;
  Button oneNext,twoNext,twoPre,threeNext,threePre,fourFinish,threeChange;
  Label oneHello,threePath,fourThank,twoCheck;
  TextArea twoData;
  Checkbox twoTerm;
  CardLayout flowGame = new CardLayout();
  public void init(){
   MainContainer = new Panel();
   MainContainer.setLayout(flowGame);  //adding the container and setting the layout

   one = new Panel();
   oneHello = new Label("HELLO WORLD");        //making the first sub container for the container
   oneNext = new Button("NEXT");
   one.add(oneHello);
   one.add(oneNext);                          //adding the components to the first subcontainer

   two = new Panel();
   twoData = new TextArea("THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION SCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLY SCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLYSCROLLBARS_HORIZONTAL_ONLYOF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME THESE ARE THE TERMS AND CONDITION OF THE GAME ",10,60,TextArea.SCROLLBARS_VERTICAL_ONLY);
   twoData.setEditable(false);
   twoTerm = new Checkbox();
   twoCheck = new Label("Please check this to see the previous");
   twoNext = new Button("NEXT");
   twoPre = new Button("PREVIOUS");    // making the second subContainer for the container
   two.add(twoData);
   two.add(twoTerm);
   two.add(twoCheck);
   two.add(twoPre);
   two.add(twoNext);                     //adding the components to the second subcontainer

   three = new Panel();
   threeNext = new Button("NEXT");
   threePre = new Button("PREVIOUS");
   threePath = new Label("This is the path for the game");   // making the third subContainer for the container
   threeChange = new Button("CHANGE");
   three.add(threePath);
   three.add(threeChange);
   three.add(threePre);
   three.add(threeNext);    //adding the components to the third subcontainer

   four = new Panel();
   fourThank = new Label("THANKYOU  FOR DOWNLOADING THE GAME");
   fourFinish = new Button("FINISH");      // making the fourth subContainer for the container
   four.add(fourThank);
   four.add(fourFinish);                  //adding the components to the fourth subcontainer

   MainContainer.add(one,"one");
   MainContainer.add(two,"two");
   MainContainer.add(three,"three");
   MainContainer.add(four,"four");   // adding the subContiner to the main container having cardlayout 
   add(MainContainer);

   oneNext.addActionListener(this);
   twoPre.addActionListener(this);
   twoNext.addActionListener(this);
   threePre.addActionListener(this);
   threeNext.addActionListener(this);
   fourFinish.addActionListener(this);

  }
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==oneNext){
      twoTerm.setState(false);
      flowGame.next(MainContainer);
    }
    else if(ae.getSource()==twoPre){
      flowGame.show(MainContainer,"one");
    }
    else if(ae.getSource()==twoNext){
      if(twoTerm.getState()){
        flowGame.next(MainContainer);
      }
    }
    else if(ae.getSource()==threePre){
      twoTerm.setState(false);
      flowGame.show(MainContainer,"two");
    }
    else if(ae.getSource()==threeNext){
      flowGame.next(MainContainer);
    }
    else if (ae.getSource()==fourFinish){
      stop();
    }

  }
  public void stop(){
    System.out.println("The execution is stopped and welcome to the game");  
    destroy();
  }
}