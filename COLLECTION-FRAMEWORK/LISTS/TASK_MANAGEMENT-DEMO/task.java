import java.util.*;
public class task implements Comparable<task>{
    private String taskName;
    private String taskDescription;
    private int priority;
    private Date dueDate;
    private boolean isCompleted;
    
    public task(String taskName , String taskDescription , int priority	, Date dueDate){
    	this.taskName = taskName;
    	this.taskDescription = taskDescription;
    	this.priority = priority;
    	this.dueDate  = dueDate;
        this.isCompleted = false;
    }
  public String getTaskName(){return this.taskName;}
  public String getTaskDescription(){return this.taskDescription;}
  public int getPriority(){return this.priority;}
  public Date getDueDate(){return this.dueDate;}
  public boolean getCompleted(){return this.isCompleted;}
  public void setCompleted(boolean set){this.isCompleted = set;}
  public void setTaskName(String taskName){this.taskName = taskName;}
  public void setDescription(String taskDescription){this.taskDescription = taskDescription;}
  public void setPriority(int priority){this.priority = priority;}
  public void setDueDate(Date dueDate){}
  @Override
  public String toString(){
     return "[ ["+taskName+"] , ["+taskDescription+"] , ["+priority+"] , ["+dueDate.getDate()+"/"+dueDate.getMonth()+"/"+dueDate.getYear()+"] ]";
  }
  @Override
  public int compareTo(task t){ return t.getPriority() - this.getPriority();}

}