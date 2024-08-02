class Utils{
	public static <T> void printArray(T array[]){  //generic method
    System.out.println("ARRAY CONTAINS : ");
    for(T element  : array){
    	System.out.print(element + " ");
    }
    System.out.println();
	}
}
public class GenericMethod{
	public static void main(String[] args) {
		Integer intArray[] = {1,3,5,7,9};
		String stringArray [] = {"hwllo","yug","hyeee"};
		Utils.printArray(intArray);
		Utils.printArray(stringArray);
	}
}