import java.util..Objects;

public final class Student{
	private final int seatNumber ;
	private final String name;
	private final String mothersName;
    
    public Student(int seatNumber,String name , String mothersName){
     this.seatNumber = seatNumber;
     this.name = name;
     this.mothersName = mothersName;
    }

    public int getSeatNumber(){return this.seatNumber;}
    public String getName(){ return this.name;}
    public String getMothersName(){return this.mothersName;}

    public String toString(){
    	return "["+seatNumber+", "+name+", "+mothersName+"]";
    }

    @Override
    public int hashCode(){
    	System.out.println("Students hashCode has been called");
    	int hash  = Objects.hash(this.seatNumber,this.name,this.mothersName);
    	return hash;
    }

    @Override
    public boolean equals(Object o){
    	System.out.println("equls() of student class has been called");
        if(this==o || getClass()!=o.getClass()) return false;

        Student studentObj = (Student)o;
        return seatNumber == studentObj.seatNumber && name.equals(studentObj.name) && mothersName.equals(studentObj.mothersName);
    }
}