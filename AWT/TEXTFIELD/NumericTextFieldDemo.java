import java.applet.*;
import java.awt.*;
import java.awt.event.*;
class NumericTextField extends TextField implements KeyListener{
	{
		addKeyListener(this);
	}
	NumericTextField(){
		super();
	}
	NumericTextField(int numChars){
		super(numChars);
	}
	NumericTextField(String str){
		sanitizeInput(str);
		setText(str);
	}
	NumericTextField(String str , int numChars){
		sanitizeInput(str);
		setText(str);
		setColumns(numChars);
	}
	public void keyPressed(KeyEvent ke){
		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()~`{}[]\\|\":';,./<>?";
		char typedCharacter = ke.getKeyChar();
		if(typedCharacter!=KeyEvent.CHAR_UNDEFINED){  // checks if the types character is not tab,capslock,f0-f9,shift,ctrl,fn,alt etc
			if(charSet.indexOf(typedCharacter)!=-1){
				ke.consume();
			}
		}
	}
	public void keyReleased(KeyEvent ke){}
	public void keyTyped(KeyEvent ke){}
	public void sanitizeInput(String str) throws IllegalArgumentException{
		for(char ch : str.toCharArray()){
			if(Character.isLetter(ch)){
			throw new IllegalArgumentException("NO ALPHABET SUPPORTED IN THE TEXT FIELD");	
			}
		}
	}
}
//<applet code="NumericTextFieldDemo.class" height="500" width="500"></applet>
public class NumericTextFieldDemo extends Applet{
public void init(){
	add(new NumericTextField("1234"));
}
}