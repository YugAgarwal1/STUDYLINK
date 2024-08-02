import java.util.HashMap;

public class Marks{
	private HashMap<String , Float> subjectMarks;
	public Marks(){

	} 
	public void adMark(String subjectName , float mark){
		subjectMarks.put(subjectName,mark);
	}
	public float getMark(String subjectName){
		return subjectMarks.get(subjectName);
	}
	public HashMap<String , Float> getSubjectMarks(){
		return new HashMap<>(subjectMarks);
	}

	@Override
	public String toString(){
		StringBuilder returnedString  = new StringBuilder();
		for(String subjectName : this.subjectMarks.getKey()){
			returnedString.append(subjectName).append(":").append(subjectMarks.get(subjectName)).append("");
		}
		return returnedString.toString();
	}
}