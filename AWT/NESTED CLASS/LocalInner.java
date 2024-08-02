//local inner class 
class Outer{
   protected static int outerVar;
	Outer(int value){
		outerVar = value;
	}
    public void haveFun(){
    int localVar = 10;
     // localVar = 10*5;
    	class Inner{
    		private int innerVar;
    		Inner(int value){
    			innerVar = value;
    		}
    		void timepass(){
    			outerVar = outerVar*2;
    			innerVar = innerVar*2;
    		// 	localVar = localVar*2;
    		}
    		void display(){
    			System.out.println("Inside display of inner");
    			System.out.println("outerVar = "+outerVar);
    		//  System.out.println("localVar = "+localVar);
    		}
    	}
    	Inner ob = new Inner(20);
    	ob.timepass();
    	ob.display();
      //  localVar = 10*5;
    }
    public void show(){
    	System.out.println("Outer class printing outerVar "+outerVar);
    }
}
public class LocalInner{
	public static void main(String[] args) {
		Outer outer = new Outer(10);
		outer.haveFun();
		outer.show();
	}
}