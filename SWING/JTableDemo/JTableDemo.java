import java.awt.*;
import javax.swing.*;
//<applet code="JTableDemo" height="400" width="400"></applet>
public class JTableDemo extends JApplet{
	public void init(){
		Container contentPane  =  getContentPane();
		// contentPane.setLayout(new BorderLAyout());
		final String []colshead = {"Subject" ,"Fees","Professor"};
		final Object [][]data ={
			                   {"C", "5800" , "HT"},
                               {"EOE", "5900" , "Jigar"},
                               {"RDBMS", "5600" , "Pratik"},
                               {"Java", "20000" , "HT"},
                               {"ADV Java", "58000" , "HT"}
	                          };
	    JTable table = new JTable(data,colshead);
	    table.setGridColor(Color.red);
	    table.setSelectionBackground(Color.blue);
	    table.setSelectionForeground(Color.green);
	    table.setBackground(Color.black);
	    table.setForeground(Color.white);
	    table.setCellSelectionEnabled(false);   //pure row ko select hone ko enable disable
	    table.getTableHeader().setReorderingAllowed(false);   // allows to enable or disable the column swaapping ka jhanjat
	    table.setAutoResizeMode(AUTO_RESIZE_OFF);
	    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	    JScrollPane jsp = new JScrollPane(table,v,h);
	    contentPane.add(jsp,BorderLayout.CENTER);
	}
}