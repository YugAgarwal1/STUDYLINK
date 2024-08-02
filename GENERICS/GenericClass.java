class Wrapper<T>{   //generic class
 private T obj ; 
 public T getObj(){ return obj;}
 public void setObj(T obj){this.obj = obj;}
}
public class GenericClass{
	public static void main(String[] args) {
		Wrapper<Integer> intWrapper = new Wrapper<>();
				Wrapper<String> stringWrapper = new Wrapper<>();
		        intWrapper.setObj(10);
		        System.out.println(intWrapper.getObj());

		        stringWrapper.setObj("java");
		        System.out.println(stringWrapper.getObj());
	}
}