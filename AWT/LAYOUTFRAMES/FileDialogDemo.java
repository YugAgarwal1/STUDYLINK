import java.awt.*;
import java.awt.event.*;
class SampleFrame extends Frame{
 SampleFrame(String title){
   super(title);
   addWindowListener(new WindowAdapter(){
   	public void windowClosing(WindowEvent we){
   		System.exit(0);
   	}
   });
 }
}
public class FileDialogDemo{
public static void main(String[] args) {
	Frame f = new SampleFrame("File Dialog Demo");
	f.setVisible(true);
	f.setSize(100,100);

	FileDialog fd = new FileDialog(f,"File Dialog",FileDialog.SAVE);
	fd.setVisible(true);
	// no need to make the size set of the fileDialog coz default set hota hai
	if(fd.getDirectory()!=null || fd.getFile()!= null ){
		System.out.println(fd.getDirectory()+fd.getFile());
	}
}
}