import java.awt.*;
import java.awt.event.*;
class SampleDialog extends Dialog implements ActionListener{
	SampleDialog(Frame parent,String title){
       super(parent,title,false);  // here false represents the modeless and true is modal that is access the other frame 
       setLayout(new FlowLayout());   // yeh layout hum dialog box ka set karre hai coz dialog ka default frame layout is borderLayout thats why
       setSize(200,200);
       add(new Label("Press this button"));
       Button b = new Button("Cancel");
       add(b);
       b.addActionListener(this);
       addWindowListener(new WindowAdapter(){
       	public void windowClosing(WindowEvent we){
       		dispose();
       	}
       });
	}
	public void actionPerformed(ActionEvent ae){
		dispose();
	}
}
public class DialogDemo extends Frame{
   DialogDemo(){
   	setVisible(true);
   	setSize(300,300);
   	SampleDialog denew = new SampleDialog(this,"New Dialog");
   	denew.setVisible(true);

   	addWindowListener(new WindowAdapter(){
   		public void windowClosing(WindowEvent we){
   			System.exit(0);
   		}
   	});
   }
   public static void main(String[] args) {
   	DialogDemo obj = new DialogDemo();
   }
}