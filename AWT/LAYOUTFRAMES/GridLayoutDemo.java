import java.awt.*;
import java.applet.*;
public class GridLayoutDemo extends Applet {
	// <applet code="GridLayoutDemo" height="500" width="500"></applet>
	static final int n = 5 ;
	public void init(){
		setLayout(new GridLayout(n,n,20,20));// here 5 5 represents the hor and ver space between components and n represents the numbe of rows and columns
		int count = 0 ;
		for(int i = 0 ; i < n ; i++){
			for(int j=0;j<n;j++){
				// int k = i*n+j;   // soch thoda bhai same logic hai
				if(count>0){
					add(new Button(""+count));
				}
				count++;
			}
		}
	}
	@Override    
	public Insets getInsets(){       // this will add top left right bottom space between the component and the window border only
		return new Insets(10,10,10,10);
	}
}