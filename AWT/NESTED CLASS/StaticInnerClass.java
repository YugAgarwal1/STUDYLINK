// static inner class
class Outer{
	int normalVar = 10;
	private static int staticVar1 = 10;
	public static int staticVar2 = 20;

	public static void OuterStaticFunction(){
		System.out.println("This is the static function of the outer class");
	}

	public void OuterNonStaticFunction(){
		System.out.println("This is the non-static function of the outer class");
	}

	static class Inner{
    int normaVar1 = 10;
    static int num =10;
    Outer o = new Outer();
    public void PrintNormalDataFromObjectOfOuterClassInsideInnerClass(){
    	System.out.println(o.normalVar);
    }
    public void ChangeOuterVariable(){
    	//normalVar = 100; 
    	staticVar1 = 100;
    	staticVar2 = 100;
    	System.out.println("The outer class varibale are changing");
    	PrintNormalDataFromObjectOfOuterClassInsideInnerClass();
    }     

    public void AccessOuterMethods(){
    	System.out.println("Now we are accessing the function of the outer class from the method of inner class onluy static is possible");
    	OuterStaticFunction();
        //OuterNonStaticFunction();
    }

	}
}
public class StaticInnerClass{
	public static void main(String[] args) {
	  Outer.Inner inner = new Outer.Inner();
	  inner.ChangeOuterVariable();
      inner.AccessOuterMethods();
       // inner.normalVar = 10; object of the inner class cannot access the outerclass var and methods in the main methods
     //  inner.normalVar1 = 10; object of the inner class cannot access the innerClass non-static var and non-Static function in the main methods
      inner.num = 10;  // possible coz object of the static class can only access the static member in the main function
           //  inner.staticVar1=10;   // not possible coz the variable is static but the variable is of the outer class 
	}
}