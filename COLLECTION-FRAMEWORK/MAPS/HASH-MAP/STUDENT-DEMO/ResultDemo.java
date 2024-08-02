import java.util.HashMap;
/**
 * Rules to make a class immutable :
 * 1. Declre the class as final
 * 2. Declare all the fields of that class as final and private
 * 3. Initialie all the field in the construtor
 * 4. donot provide any setter or any means to modify any field
 * 5. you can provide getters
 * 6. ensure  exclusive access to muttable components by making defensive copies
 * 7. handle collections properly by returning unmodifiable views or deep copies
 */
public class ResultDemo{
	public static void main(String[] args) {
    	Student s1 = new Student(101,"somay","vineeta");
    	    	Student s2 = new Student(102,"pooja","anju");
    	    	    	Student s1 = new Student(103,"mohit","reena");	

    	 Marks m3 = new Marks();
    	 m3.addMark("java",56);
    	 m3.addMark("mup",52);

    	 HashMap<Student , Marks> resultMap = new HashMap<>();
    	 resultMap.put(s1,m1);
    	 	resultMap.put(s2,m2);
    	 	resultMap.put(s3,m3);

    	 	for(HashMap.Entry<Student ,Marks> entry : resultMap.entrySet()){
                Student student = entry.getKey();
                Marks marks = entry.getValue();

                System.out.println(student);
                System.out.println(marks);
    	 	}
	}

}