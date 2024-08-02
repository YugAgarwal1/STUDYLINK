import java.util.*;
public class project{
	private String projectName;
	ArrayList<task> tasks ;
	task t;
	//user will create a single project and add multiple task in it 
	public project(String projectName){
		this.projectName = projectName ;
	  tasks  = new ArrayList<>();
	}

	public boolean addTask(String taskName,String taskDescription ,int priority, Date dueDate){
       if(findTask(taskName)==null){
            t = new task(taskName,taskDescription,priority,dueDate);
            return tasks.add(t);
       }
         return false;
	}
    

    private task findTask(String taskName){
    	for(task task : tasks){
    		if(task.getTaskName().equalsIgnoreCase(taskName)){
               return task;
    		}
    	}
    	return null;
    }

    public boolean completeTask(String taskName){
       task t = findTask(taskName);
       if(t!=null){
           history.addToCompletedHistory(t);
           tasks.remove(t);
           return true;
       }
       return false;
    }


    public Comparator<task> SORT_BY_DATE = new Comparator<task>() {
    @Override
    public int compare(task t1, task t2) {
        return t1.getDueDate().compareTo(t2.getDueDate());
                                         }
       };

    public void printTask(int i){
    	if(tasks.size()>0){
    		if(i==1){
    			     		Collections.sort(tasks);
    		}
    		else if(i==2){
    			       Collections.sort(tasks,SORT_BY_DATE);
    		}
        for(task t : tasks){
    			System.out.println(t);
    	 } 
    	}
    	else{
    		System.out.println("THE TASK LIST IS EMPTY ADD A TASK FIRST");
    	}  
     }

    public boolean removeTask(String taskName){
    	task t = findTask(taskName);
    	if(t!=null) {
         tasks.remove(t);
    	   return true;
    	}
     return false;
    }

    public task editTask(String taskName){
    	 task t = findTask(taskName);
       if(t!=null){
       	return t;
       }
       else{
       	return null;
       }
    }
    public void editTaskInternal(task t , String editTaskName , String editDescription , int editPriority , Date d){
        t.setTaskName(editTaskName);
        t.setDescription(editDescription);
        t.setPriority(editPriority);
        t.setDueDate(d);
    }
    public boolean undoTask(){
       task t = history.undoFromCompletedHistory();
       if(t!=null){
       	tasks.add(t);
       	return true;
       }
       else{
         return false;
       }
    }

}