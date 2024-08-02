// anonymous inner class
import java.lang.Thread;
import java.io.*;
    public class AnonymousInnerClass{

	 public static void counter(String name , int SpeedDuration ){
      	for (int i=0;i<=10;i++){
      		System.out.println(name+" : "+i);
      		try{
             Thread.sleep(SpeedDuration);
      		}catch(InterruptedException e){
      			System.out.println(e);
      		}
      	}
      }

public static void main(String[] args) {
	    
	    new Thread(new Runnable(){
	   	public void run(){
          counter("Thread 1",100);
	   	}
	   }).start();
 

	   	   new Thread(new Runnable(){
	   	   	public void run(){
	   	   		counter("Thread 2",200);
	   	   	}
	   }).start();

	}
}