class Outer{
	int normalOuterVar = 10;
	static int staticOuterVar = 10;
	class Inner{
		int normalInnerVar = 10;
		 int staticInnerVar = 10;
		void changeOuterVar(){
			normalOuterVar = 20;
			staticOuterVar = 20;
		}
		void displayOuterInnerVar(){
			System.out.println(normalOuterVar);
			System.out.println(normalInnerVar);
			System.out.println(staticOuterVar);
			System.out.println(staticInnerVar);
		}
	}
	void disply(){
		System.out.println("Function of the outer class");
	}
}
public class InnerClass{
	public static void main(String[] args) {
		Outer o = new Outer();
		o.disply();
		//o.changeOuterVar();
		//o.displayOuterInnerVar();
		Outer.Inner i = o.new Inner();
		i.changeOuterVar();
		i.displayOuterInnerVar();
		i.disply();
	}
}