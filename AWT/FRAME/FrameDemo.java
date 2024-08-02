// dekh bhai frame ka default layout frame hota hai borderLayout 
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
 class MyFrame extends Frame{
	MyFrame(){
		super("This is my title");
		setVisible(true);
		setSize(300,300);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
				//setVisible(false);  dikega but dikhega nahi
			}
		});
	}
}
public class FrameDemo {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		//f.setVisible(true);
		//f.setSize(300,300);
	}
}