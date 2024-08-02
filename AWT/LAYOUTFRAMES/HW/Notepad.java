import java.awt.*;
import java.awt.event.*;
import java.io.*;

class DialogAbout extends Dialog implements ActionListener{
 Button b1 ;
 Label hey;
 int NextCount = 0 ;
 char []arr = new char[100];
     int count;
     int len;
     String temp;
 Label tp = new Label();
 TextArea tt =  new TextArea("text",20,70,TextArea.SCROLLBARS_VERTICAL_ONLY);;
 Button ok = new Button("OK");
 Button FindNext = new Button("NEXT");
 Button Replace = new Button("REPLACE");
 Button ReplaceAll = new Button("REPLACE ALL");
 TextField getData = new TextField(15);
 TextField takeInput = new TextField(15);
 Button clickArg = new Button("OK");
 TextArea t = new TextArea();
int startLength = 1 ;
boolean dataCheckOnce = true ; 
boolean replaceIfNotPresent = true ; 
String data = "";
DialogAbout( Frame parent , String title ){  // this dialog box is for the about section
super(parent,title,true);
setSize(200,200);
setLayout(new FlowLayout());
hey = new Label("Congratulations");
add(hey);
b1 = new Button("CLICK ME");
add(b1);
b1.addActionListener(this);
addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
			}
		});
setVisible(true);
	}	
 DialogAbout( Frame parent , String title , String text , TextArea t){   // this dialog box is related to the find process  
super(parent,title,true);
this.t = t;
setLayout(new FlowLayout());
setSize(600,600);
tt.setEditable(false);
add(tt);
tt.setText(text);
add(ok);
add(FindNext);
add(Replace);
add(ReplaceAll);
add(getData);
add(tp);
add(takeInput);
ok.addActionListener(this);
FindNext.addActionListener(this);
Replace.addActionListener(this);
ReplaceAll.addActionListener(this);  
addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
			}
		});
    setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae){
	      if(ae.getSource()==ok){
	      	 t.setText(tt.getText());
           dispose();
	      }
	      else if (ae.getSource()==ReplaceAll){
	      	String TextAreaData = tt.getText();
         String find = getData.getText();
         String replace = takeInput.getText();
         String ReplacedString;
         if(find.equals("")){}
         else if (replace.equals("")){}
         else{
         for(int i=0 ; i < TextAreaData.length() ; i++){
         	if(TextAreaData.charAt(i)==find.charAt(0)){
         		ReplacedString = TextAreaData.substring(i,i+(find.length())); 
         	if(ReplacedString.equals(find)){
         		ReplacedString = TextAreaData.replace(find,takeInput.getText());
         		tt.setText(ReplacedString);
         		break;
         	}
         }
         else {
         
         }
	      }
      }
	    }
	      else if(ae.getSource()==Replace){
	      String find = getData.getText();
        String replace = takeInput.getText();
        if(find.equals("") || replace.equals("")){}
        else{
        if(replaceIfNotPresent){
              //ReplaceNdFinf();
             tt.replaceRange(replace,startLength,((startLength-1)-(find.length()-1)));
            ReplaceNdFinf();
        }
        }
	      }
	      else if(ae.getSource()==FindNext){
            ReplaceNdFinf();           
	      }
	      else if(ae.getSource()==clickArg){
	      	dispose();
	      }
     }
     public void ReplaceNdFinf(){
         String TextAreaData = tt.getText();
            String find = getData.getText();
            System.out.println(TextAreaData);
            if(find.equals("")){}
            else{
                if(dataCheckOnce){
                find = getData.getText();
                data = find ;
                dataCheckOnce = false ; 
                startLength = 1 ;
                                 }
            else {
                find = getData.getText();
                if(find.equals(data)){}
                else{
                 data = find ;
                 startLength = 1 ;
                }
            }

            for(int i = startLength-1 ; i < TextAreaData.length() ; i++ ){
                if(TextAreaData.charAt(i) == find.charAt(0)){
                    System.out.println("string found");
                    String newString  = TextAreaData.substring(i,i+(find.length()));
                    if(newString.equals(find)){
                      System.out.println("String matched");
                      startLength = (i+find.length());
                  tt.select(startLength-1,i);
                  replaceIfNotPresent = true;
                  break;
                    }
                    else{
                  replaceIfNotPresent = false;
                }
                }
                else{
                    replaceIfNotPresent = false ;
                }
            }  
            }
           
     }

}

class caesercipher {
	String text ;
	private int key;
	public caesercipher(int key){
		this.key = key;
	}
	public void encrypt(TextArea f,BufferedWriter bw){
		try{
     text = f.getText();
     String new1 = "";
     byte []arr = text.getBytes();
     for(byte t : arr){
         t += key ;
         new1 += ((char)t);
     }
     bw.write(new1);
   }catch(Exception e){
   	System.out.println("Exception aaya idiot");
   }
	}

	public String decrypt(String text){
     String text1 = text ;
     String new1="";
     byte []arr = text1.getBytes();
       for(byte t : arr){
         t -= key ;
         new1 += ((char)t);
     }
     return new1;
	}

}

public class Notepad extends Frame implements ActionListener{
	String filePath = "";
	String msg = "";
	FileWriter writer ;
	BufferedWriter bw;
	    Boolean once = true;
	    TextArea ta = new TextArea("",10,100,TextArea.SCROLLBARS_VERTICAL_ONLY);
        MenuBar mbar = new MenuBar();
	    Menu File = new Menu("FILE");
	    Menu Edit = new Menu("EDIT");
	    Menu Help = new Menu("HELP");
	    MenuShortcut saveShortcutn = new MenuShortcut(KeyEvent.VK_N, false); // Ctrl + N
	    MenuItem New = new MenuItem("NEW",saveShortcutn);
	         MenuShortcut saveShortcuto = new MenuShortcut(KeyEvent.VK_O, false); // Ctrl + O
        MenuItem Open = new MenuItem("OPEN",saveShortcuto);
         MenuShortcut saveShortcuts = new MenuShortcut(KeyEvent.VK_S, false); // Ctrl + S
        MenuItem Save = new MenuItem("SAVE",saveShortcuts);
        MenuShortcut saveShortcutss = new MenuShortcut(KeyEvent.VK_SHIFT+KeyEvent.VK_S, false); // Ctrl + Shift + s
        MenuItem SaveAs = new MenuItem("SAVE AS",saveShortcutss);
       MenuItem Exit = new MenuItem("EXIT");
        MenuShortcut saveShortcutc = new MenuShortcut(KeyEvent.VK_C, false); // Ctrl + C
        MenuShortcut saveShortcutx = new MenuShortcut(KeyEvent.VK_X, false); // Ctrl + X
        MenuShortcut saveShortcutv = new MenuShortcut(KeyEvent.VK_V, false); // Ctrl + V
        MenuShortcut saveShortcutf = new MenuShortcut(KeyEvent.VK_F, false); // Ctrl + F
        MenuShortcut saveShortcuta = new MenuShortcut(KeyEvent.VK_A, false); // Ctrl + A
        MenuItem Cut = new MenuItem("CUT",saveShortcutx);
        MenuItem Copy = new MenuItem("COPY",saveShortcutc);
        MenuItem Paste = new MenuItem("PASTE",saveShortcutv);
        MenuItem Find = new MenuItem("FIND",saveShortcutf);
        MenuItem About = new MenuItem("ABOUT");
        MenuItem SelectAll = new MenuItem("SELECT ALL",saveShortcuta);

	Notepad(){
		super("This is my NOTEPAD");
		setSize(1000,1000);
		setVisible(true);
		add(ta);
		setMenuBar(mbar);
	    mbar.add(File);
	    mbar.add(Edit);
	    mbar.add(Help);
        File.add(New);
        File.add(new MenuItem("-"));
        File.add(Open);
        File.add(new MenuItem("-"));
        File.add(Save);
        File.add(new MenuItem("-"));
        File.add(SaveAs);
        File.add(new MenuItem("-"));
        File.add(Exit);
        Edit.add(Cut);
        Edit.add(new MenuItem("-"));
        Edit.add(Copy);
        Edit.add(new MenuItem("-"));
        Edit.add(Paste);
        Edit.add(new MenuItem("-"));
        Edit.add(Find);
        Edit.add(new MenuItem("-"));
        Edit.add(SelectAll);
        Help.add(About);
          About.addActionListener(this);
          Exit.addActionListener(this);
          Find.addActionListener(this);
          New.addActionListener(this);
          Save.addActionListener(this);
          Open.addActionListener(this);
          Copy.addActionListener(this);
          SaveAs.addActionListener(this);
          Cut.addActionListener(this);
          Paste.addActionListener(this);
          SelectAll.addActionListener(this);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==About){
          	//Notepad n = new Notepad();
          new DialogAbout(this,"ABOUT SECTION");
          }
          else if(ae.getSource()==Exit){
          	System.exit(0);
          }
          else if(ae.getSource()==Find){
          	   String text = ta.getText();
               new DialogAbout(this,"Find",text,ta);    
          }
          else if(ae.getSource()==New){
            ta .replaceRange("",0,(ta.getText()).length());
          	once = true;
          }
          else if(ae.getSource()==Save){
          	 caesercipher c ;
          	if(once){
              FileDialog fd = new FileDialog(this,"FILE DIALOG SAVE",FileDialog.SAVE);
              fd.setVisible(true);
              try{
              if(fd.getDirectory()!=null || fd.getFile()!= null){
              filePath = fd.getDirectory()+fd.getFile()+".ya"; 
              writer = new FileWriter(filePath);
              bw = new BufferedWriter(writer);
              c = new caesercipher(5);
              c.encrypt(ta,bw);
              bw.flush();
              bw.close();
              once = false;
            }
            }catch(Exception e){
            	System.out.println(e.getMessage());
            }
          	}
          	else {
          		try{
             writer = new FileWriter(filePath);
             bw = new BufferedWriter(writer);
             c = new caesercipher(5);
             c.encrypt(ta,bw);
             bw.flush();
             bw.close();
           }catch(Exception e){
           	System.out.println(e.getMessage());
           }
          	}
          }
          else if(ae.getSource()==Open){
          	caesercipher c = new caesercipher(5);
          	once = false;
          	try{
          	FileDialog fe = new FileDialog(this,"FILE DIALOG LOAD",FileDialog.LOAD);
          	fe.setVisible(true);
          	filePath = fe.getDirectory()+fe.getFile();
          	FileReader fr = new FileReader(filePath);
          	BufferedReader br = new BufferedReader(fr);
          	ta.setText("");
          	String text = br.readLine();
          	while(text!=null){
          		ta.append((c.decrypt(text))+"\n");
          		text = br.readLine();
          	} 
          	br.close();
          	fr.close();
          }catch(Exception e){
          	System.out.println(e.getMessage());
          }
          }
          else if(ae.getSource()==Copy){
          	 msg = ta.getSelectedText();
          	 System.out.println(msg);
          }
          else if(ae.getSource()==Cut){
          	msg = ta.getSelectedText();
          	ta.replaceRange("",ta.getSelectionStart(),ta.getSelectionEnd());
          }
          else if (ae.getSource()==SaveAs){
              FileDialog fd = new FileDialog(this,"FILE DIALOG SAVE",FileDialog.SAVE);
              caesercipher c = new caesercipher(5);
              fd.setVisible(true);
              try{
              if(fd.getDirectory()!=null || fd.getFile()!= null){
              filePath = fd.getDirectory()+fd.getFile()+".ya"; 
              writer = new FileWriter(filePath);
              bw = new BufferedWriter(writer);
              c = new caesercipher(5);
              c.encrypt(ta,bw);
              bw.flush();
              bw.close();
              once = false;
            }
            }catch(Exception e){
            	System.out.println(e.getMessage());
            }
          }
          else if(ae.getSource()==Paste){
          	if(ta.getSelectedText()!=""){
          		ta.replaceRange(msg,ta.getSelectionStart(),ta.getSelectionEnd());
          	}
          	else {
          	int pos = ta.getCaretPosition();
          	ta.insert(msg,pos);
          	}
          }
          else if(ae.getSource()==SelectAll){
             ta.selectAll();
          }
          } 
	public static void main(String[] args) {
		Notepad one = new Notepad();
	}
}