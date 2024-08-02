import java.util.*;
public class history{
	private static LinkedList <task> history = new LinkedList<task>();
    public static void printCompletedHistory(){
    	if(history.size()>0){
    		for(task t : history){
    		System.out.println(t);
                             	}
    	}
        else{
        	System.out.println("HISTORY IS EMPTY");
        }
    }
    public static void addToCompletedHistory(task t){
       task t1 = t;
       history.add(t1);
    }

    public static task undoFromCompletedHistory(){
       if(history.size()>0){
       	  return history.removeLast();
       }
       return null;
    }
}