import java.util.*;
import java.io.*;
public class taskDemo{
	public static void main(String[] args) throws IOException{
		Scanner st = new Scanner(System.in);
		project p = new project("PROJECT ONE");
		/*Date d1 = new Date(2024,9,10);
		Date d2 = new Date(2024,6,3);
		Date d3 = new Date(2024,2,7);
		Date d4 = new Date(2024,8,10);
		project p = new project("TERE NAKHRE");
		p.addTask("SINGING","you have to do singing and maintain your vocal cods",1,d4);
		p.addTask("DANCING","you have to do dancing and maintain your legs",2,d2);
        p.addTask("PLAYING","you have to do playing and maintain your hands",3,d3);
        p.addTask("RUNNING","you have to do running and maintain your running",4,d1);
        System.out.println("----------------------------------------------------------");
        p.printTask(2);
        System.out.println("----------------------------------------------------------");
        p.completeTask("RUNNING");
        System.out.println("----------------------------------------------------------");
        p.printTask(2);
        System.out.println("----------------------------------------------------------");
        history.printCompletedHistory();
        System.out.println("----------------------------------------------------------");
        task t = p.editTask("SINGING");
        if(t!=null){
        	p.editTaskInternal(t,"JUMPING INSTEAD SINGING","you selected jjumping instead of singing",7,d4);
        }
         p.printTask(2);
        System.out.println("----------------------------------------------------------");
        p.undoTask();
        p.printTask(2);
        System.out.println("----------------------------------------------------------"); 
        */
       int choice;
       boolean quit = false;
       Date d ;
       String taskName , taskDescription;
       int priority , date , month , year ;
       printMenu();
       System.out.println("--------------------------------------------------------------------------------");
       while(!quit){
       	choice = st.nextInt();
       	switch (choice){
       	case 1:
       		System.out.println("Enter the task name : ");
            taskName = st.next();
            System.out.println("Enter the description : ");
            taskDescription = st.next();
            System.out.println("Enter the priority : ");
            priority = st.nextInt();
            st.nextLine();
            System.out.println("Enter the date : ");
            date = st.nextInt();
             st.nextLine();
            System.out.println("Enter the month : ");
            month = st.nextInt();
             st.nextLine();
            System.out.println("Enter the year : ");
            year = st.nextInt();
             st.nextLine();
             d = new Date(year,month,date);
            if(p.addTask(taskName,taskDescription,priority,d)){
               System.out.println("TASK ADDED TO THE PROJECT : "+taskName);
            }
            else{
              System.out.println("THE TASK IS ALREADY PRESENT PRESENT IN THE PROJECT CHANGE THE TASKNAME");
            }
            System.out.println("--------------------------------------------------------------------------------");
            break;
          case 2 : 
          	System.out.println("Enter the task name : ");
          	taskName = st.next();
          	if(p.removeTask(taskName)){
          		System.out.println("THE TASK "+taskName+" IS REMOVED FROM THE PROJECT");
          	}
          	else{
          		System.out.println("THE TASK "+taskName+" IS ALREADY PRESENT IN THE PROJECT");
          	}
          	System.out.println("--------------------------------------------------------------------------------");
       	   break;
       	case 3:
       		System.out.println("Enter the task name : ");
            taskName = st.next();
            task t = p.editTask(taskName);
            if(t!=null){
            System.out.println("Enter the description : ");
            taskDescription = st.next();
            System.out.println("Enter the priority : ");
            priority = st.nextInt();
             st.nextLine();
            System.out.println("Enter the date : ");
            date = st.nextInt();
             st.nextLine();
            System.out.println("Enter the month : ");
            month = st.nextInt();
             st.nextLine();
            System.out.println("Enter the year : ");
            year = st.nextInt();
             st.nextLine();
             d = new Date(year,month,date);
            p.editTaskInternal(t,taskName,taskDescription,priority,d);
            System.out.println("THE TASK HAS BEEN UPDATED IN THE PROJECT");
            }
            else{
            	System.out.println("TASK IS NOT PRESENT IN THE PROJECT");
            }
            System.out.println("--------------------------------------------------------------------------------");
            break;
         case 4:
         	System.out.println("Enter the task name : ");
            taskName = st.next();
            if(p.completeTask(taskName)){
                System.out.println("TASK NAME : "+taskName+" HAS BEEN SET COMPLETED AND BEEN ADDED TO HISTORY");
            }
            else{
            	System.out.println("TASK IS NOT PRESENT IN THE PROJECT");
            }
            System.out.println("--------------------------------------------------------------------------------");
       	 break;
       	case 5:
       	    if(p.undoTask()){
               System.out.println("THE TASK IS UNDOED");
       	    }
       	    else{
       	    	System.out.println("HISTORY IS EMPTY");
       	    }
       	    System.out.println("--------------------------------------------------------------------------------");
       	    break;
       	case 6:
            p.printTask(1);
             System.out.println("--------------------------------------------------------------------------------");
            break;
        case 7:
        	p.printTask(2);
        	System.out.println("--------------------------------------------------------------------------------");
        	break;
        case 8:
        	history.printCompletedHistory();
        	System.out.println("--------------------------------------------------------------------------------");
        	break;
        case 9:
        	printMenu();
            System.out.println("--------------------------------------------------------------------------------");
        	break;
        case 10 :
        	quit = false;
        	System.out.println("--------------------------------------------------------------------------------");
        	break;
        default : 
        	System.out.println("ENTER THE CORRECT NUMBER BHAI");
       }
   }

	}
	private static void printMenu(){
		System.out.println("Select your choice");
		System.out.println("1.ADD TASK");
		System.out.println("2.REMOVE TASK");
		System.out.println("3.EDIT TASK");
		System.out.println("4.COMPLETE TASK");
		System.out.println("5.UNDO TASK");
		System.out.println("6.PRINT THE DATA SORTED BY PRIORITY");
        System.out.println("7.PRINT THE DATA SORTED BY DATE");
        System.out.println("8.PRINT THE COMPLETED TASK");
		System.out.println("9.PRINT THE MENU");
		System.out.println("10.EXIT");
	}
}