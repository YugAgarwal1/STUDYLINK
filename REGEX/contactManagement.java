import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.regex.*;
import java.io.*;
class SampleDialog extends Dialog implements ActionListener{
	public SampleDialog(Frame parent , String title){
		super(parent , "WARNING" , true);
		 setLayout(new FlowLayout());
		setSize(500,500);
		String m ="";
       add(new Label(title));
        Button b = new Button("OK");
        add(b);
        b.addActionListener(this);
        setVisible(true);
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
class myFrame extends Frame implements ActionListener{

	/*DEFINING THE OBJECT FOR FILE HANDLING*/
	File f = new File("dataContactManagement.xml");
	FileInputStream fin;
	BufferedReader br;
    Pattern groupPattern;
    Matcher groupMatcher;
	Container mainContainer = new Container();
	Container data_gather = new Container();
	Container table_gather = new Container();
	JLabel name_label = new JLabel("Enter the name :");
	JLabel phno_label = new JLabel("Enter phno :");
		JLabel add_label = new JLabel("Enter address :");
			JLabel eid_label = new JLabel("Enter email id :");
				JLabel dob_label = new JLabel("Enter dob :");
					JLabel gdr_label = new JLabel("Enter Gender :");
					JLabel msg = new JLabel("CHECK THE DATA");
	JTextField name_jtf = new JTextField(7);
	JTextField phno_jtf = new JTextField(7);
	JTextField add_jtf = new JTextField(7);
	JTextField eid_jtf = new JTextField(7);
	JTextField dob_jtf = new JTextField(7);
	JTextField gdr_jtf = new JTextField(7);
	JButton submit_button = new JButton("SUBMIT");
	JButton delete_button  = new JButton("DELETE");
	DefaultTableModel dtm ;
	JTable table;
	 JScrollPane jsp ;
	 		String []colHeads = {"NAME","PH_NO","ADDRESS","EMAIL_ID","DOB","GENDER"};
		Object [][] data ;	
		int i_ind = 0 ;
		int j_ind = 0;
	myFrame(){
		super("This is my title");
		setSize(1000,1000);
		setVisible(true);
		 msg.setVisible(false);
		data_gather.setLayout(new FlowLayout());
		table_gather.setLayout(new FlowLayout());
		mainContainer.setLayout(new BorderLayout());
        dtm = new DefaultTableModel(data,colHeads);
		table = new JTable(dtm); 
		table.setGridColor(Color.red);
	    table.setSelectionBackground(Color.blue);
	    table.setSelectionForeground(Color.green);
	    table.setBackground(Color.black);
	    table.setForeground(Color.white);
	   // table.setCellSelectionEnabled(false);   //pure row ko select hone ko enable disable
	    table.getTableHeader().setReorderingAllowed(false);   // allows to enable or disable the column swaapping ka jhanjat
	    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	    jsp = new JScrollPane(table,v,h);
       data_gather.add(name_label);
        data_gather.add(name_jtf);
        data_gather.add(phno_label);
        data_gather.add(phno_jtf);
        data_gather.add(add_label);
        data_gather.add(add_jtf);
        data_gather.add(eid_label);
        data_gather.add(eid_jtf);
        data_gather.add(dob_label);
        data_gather.add(dob_jtf);
        data_gather.add(gdr_label);
       data_gather.add(gdr_jtf);
        data_gather.add(submit_button);
        data_gather.add(delete_button);
        data_gather.add(msg);
        submit_button.addActionListener(this);
        delete_button.addActionListener(this);
        table_gather.add(jsp);       
        mainContainer.add(data_gather,BorderLayout.NORTH);
        mainContainer.add(table_gather,BorderLayout.SOUTH);
        table.setSelectionMode(1);
	    addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent we){
          	System.exit(0);
          }
		});
        add(mainContainer,BorderLayout.CENTER);
        TakeDataFromFileAndUpdateOnStart();
	}
	public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit_button){
           String []data_collected = new String[6];
		data_collected[0] = name_jtf.getText();
        data_collected[1] = phno_jtf.getText();
        data_collected[2] = add_jtf.getText();
        data_collected[3] = eid_jtf.getText();
        data_collected[4] = dob_jtf.getText();
        data_collected[5] = gdr_jtf.getText();
       boolean bool = false;
        for(int i = 0 ; i < 6 ; i++){
        	if(data_collected[i].equals("")){
        	  clearTextFieldData();
               bool = false;        		
        	  new SampleDialog(this,"COLUMNS ARE STILL EMPTY");
               break;
        	}
        	else{
        		if(checkDataValid(data_collected[i],i)){
                    if(i==1){
                             if(checkPhoneNumberIsNotRepeat(data_collected[1])){
                                 bool = true;
                                                                               }
                             else{
                                clearTextFieldData();
                                new SampleDialog(this,"THE DATA SHOULD BE IDENTICAL,THE PHONE NUMBER SHOULD BE DIFFERENT");
                                break;
                                 }
                            }
        	                                           } 
        	    else{
        		 bool = false;
                 clearTextFieldData();
        		 new SampleDialog(this,"FOLLOW PROPER RULES TO ENTER DATA");
                 break;
        	    }
        	    }
        }
        if(bool){
         dtm.addRow(data_collected);   //adds the data to the latest row of the table
         msg.setText("DATA ENTERED SUCCESSFULLY");
        	msg.setVisible(true);
        	clearTextFieldData();
        	 WriteDataToFile(data_collected);
        }	
        }
        

        if(ae.getSource() == delete_button){
        int num  =	table.getSelectedRow();
        	if(num!=-1){
              DeleteDataFromFile(num);
              dtm.removeRow(num);
        	}
        	else{
        		new SampleDialog(this,"PLEASE SELECT ATLEAST ONE ROW TO DELETE");
        	}
        }
	}

    public boolean checkPhoneNumberIsNotRepeat(String num){
        for(int i = 0 ; i < dtm.getRowCount() ; i++){
            if((dtm.getValueAt(i,1).toString()).equals(num)){
                return false;
            }
        }
        return true;
    }

	public boolean checkDataValid(String data , int index){
       String [] regexData = {"([A-Za-z])+(\\s[A-Za-z]{1,})*(\\s[A-Za-z]{1,})*","^[5-9]\\d{9}","(^[A-Za-z\\s]{1,})(,[A-Z\\sa-z]{1,})(,[A-Z\\sa-z]{1,})(,[0-9]{6,6})$","^[a-zA-Z]([\\.A-Za-z0-9_\\+-]+)*@([0-9A-Za-z][A-Za-z0-9]*)(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,}+)$","([0-9]{1,2})(/[0-9]{1,2})(/[0-9]{4,4})","(^[feFE]{2})*([MALEmale]{4})$"};
       String regex_identical = regexData[index];
       String data_identical = data ;
       Pattern pattern = Pattern.compile(regex_identical);
       Matcher match = pattern.matcher(data_identical);
       if(match.matches()){
       	return true;
       }
       else {
       	//System.out.println(data_identical);
       	return false;
       }
	}

	public void clearTextFieldData(){
		name_jtf.setText("");
           phno_jtf.setText("");
            add_jtf.setText("");
             eid_jtf.setText("");
            dob_jtf.setText("");
             gdr_jtf.setText("");
	}



    //this function will update the table everytime the program will be started
    public void TakeDataFromFileAndUpdateOnStart(){
      int n = 0 ;
      StringBuffer entire_data = ReadDataFromFile();
       //checks the number of contact so that we get the number of contact present
       String one = "(<contact>)(.*?)(</contact>)";
       Pattern groupPattern1 = Pattern.compile(one);
       Matcher groupMatcher1 = groupPattern1.matcher(entire_data.toString());
       while(groupMatcher1.find()){
          n++;
       }
       int k = n ;
       String []s = new String[6];
       while(k!=0){
        dtm.addRow(s);
        k--;
       }
      String [] groupRegex = {"(<name>)(.*?)(</name>)",
                              "(<phoneNumber>)(.*?)(</phoneNumber>)",
                              "(<address>)(.*?)(</address>)",
                              "(<emailID>)(.*?)(</emailID>)",
                              "(<dateOfBirth>)(.*?)(</dateOfBirth>)",
                              "(<gender>)(.*?)(</gender>)"
                             };

       String [] data_to_be_added = new String[20];
       for(int i = 0 ; i<6 ; i++){
         Pattern groupPattern2 = Pattern.compile(groupRegex[i]);
          Matcher groupMatcher2 = groupPattern2.matcher(entire_data);
          int j = 0;
          while(groupMatcher2.find()){
             data_to_be_added[j] = groupMatcher2.group(2);
             j++;
          }
          j=0;
          addDataVerticallyToTableAfterFreshRun(data_to_be_added,n,i);
       }

    }

    public void addDataVerticallyToTableAfterFreshRun(String []arr,int numRow , int numCol){
         try{
         for(int i=0;i<numRow;i++){
            //System.out.println(arr[i]);
            table.setValueAt(arr[i],i,numCol);   //yeh function barabar nahi chalra tha idk y
         }
         }
         catch(Exception e){
            System.out.println("throws and exception");
         }
      
    }

	// this function writes the data to the file ie. only appends the data
   public void WriteDataToFile(String []data_collected){
     StringBuffer entire_data = ReadDataFromFile();
    // System.out.println(entire_data);    // correct xhalra hai
    StringBuffer sb = new StringBuffer();
     String groupRegex = "(<contactList>)(.*?)(</contactList>)";
     groupPattern = Pattern.compile(groupRegex);
     groupMatcher = groupPattern.matcher(entire_data);

    // idhar he error aara hai pata nahi bahi kyu dimaag kharab hogay hai 4 ghante se dhundra karra hu yaaaaaaaaaaaaaaaaaar   -- got the key -> tu joh .? use karra tha usme se . joh hai woh \n ko nahi ginta aur terminate ho jata hai isliye op blank aara tha tera thanks to regex101
     while(groupMatcher.find()){
     	sb.append(groupMatcher.group(2));
        StringBuffer sb2 = addDataToFile(data_collected,sb);
        String newFileTransferData =  "<contactList>"+groupMatcher.replaceAll(sb2.toString())+"</contactList>";
       // System.out.println(newFileTransferData);
        makeChangesInTheFileAfterOperation(newFileTransferData);
     }
    //System.out.println(sb);
   }

   public void makeChangesInTheFileAfterOperation(String data){
   	String s = data;
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            writer.write(s);
        } catch (IOException e) {
            System.out.println("An IOException was caught: " + e.getMessage());
        }
   }



   public StringBuffer addDataToFile(String []data_collected,StringBuffer sb){
       StringBuffer sb1 = sb;
       sb1.append("<contact><name>");
       sb1.append(data_collected[0]+"</name><phoneNumber>");
       sb1.append(data_collected[1]+"</phoneNumber><address>");
       sb1.append(data_collected[2]+"</address><emailID>");
       sb1.append(data_collected[3]+"</emailID><dateOfBirth>");       
       sb1.append(data_collected[4]+"</dateOfBirth><gender>");
       sb1.append(data_collected[5]+"</gender></contact>");
       //System.out.println(sb1);
       return sb1;
   }    
    

    //this function will delete the data from thw file once the delete button is selected
   public void DeleteDataFromFile(int num){
     StringBuffer entire_data1 = ReadDataFromFile();
   // System.out.println(entire_data1);    // correct xhalra hai
     String groupRegex3 = "(<contactList>)(.*?)(</contactList>)";
     Pattern groupPattern3 = Pattern.compile(groupRegex3);
     Matcher  groupMatcher3 = groupPattern3.matcher(entire_data1);
     if(groupMatcher3.find()){
        String sb3 = groupMatcher3.group(2).toString();
      //System.out.println(sb3);// totally working correct till here
        String find = "<contact><name>"+dtm.getValueAt(num,0).toString()+"</name><phoneNumber>"+dtm.getValueAt(num,1).toString()+"</phoneNumber><address>"+dtm.getValueAt(num,2).toString()+"</address><emailID>"+dtm.getValueAt(num,3).toString()+"</emailID><dateOfBirth>"+dtm.getValueAt(num,4).toString()+"</dateOfBirth><gender>"+dtm.getValueAt(num,5).toString()+"</gender></contact>";
        Pattern groupPattern4 = Pattern.compile(find);
        Matcher groupMatcher4 = groupPattern4.matcher(sb3);
         if(groupMatcher4.find()){
           String sb4 = "<contactList>"+sb3.replaceAll(find,"")+"</contactList>";
           makeChangesInTheFileAfterOperation(sb4);
                                 }
     }
   }

   // this function reads the entire data from the file and returns a stringBuffer
   public StringBuffer ReadDataFromFile(){
   	StringBuffer entire_data  = new StringBuffer();
   	try{
   	  fin = new FileInputStream(f);
   	  br= new BufferedReader(new InputStreamReader(fin));
      String line ="";
      while((line=br.readLine())!=null){
      	entire_data.append(line);
      }
            return entire_data;
   	}catch(Exception e){
      return entire_data;
   	} 
   }
}


public class contactManagement{
		public static void main(String []args){
   new myFrame();
}
}