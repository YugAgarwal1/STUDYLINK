import java.util.*;
import java.io.*;
public class wordDemo {
	public static void main(String[] args) throws IOException{
    String sourceFile = "source.txt";
	String destinationFile = "destinationFile.txt";
	File f = new File(destinationFile);
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);
	       wordHash wh = new wordHash();	       
           String []data =wh.readDataFromSourceFile(sourceFile);
           HashMap<String , Integer> words = wh.addValueToHash(data);
           List<eachWord> d = new ArrayList<eachWord>(); 
      for(String key : words.keySet()){
	       eachWord e = new eachWord(key,words.get(key).intValue());
	       d.add(e);
	  }
	  Collections.sort(d);   
	  for(eachWord e1 : d){
          System.out.println(e1);
	  	  bw.write(e1.toString()+"\n");
	  }
	  bw.close();        
}

}

class eachWord implements Comparable<eachWord>{
	String name;
	int repeat;
	public eachWord(String name , int repeat){
		this.name = name;
		this.repeat = repeat;
	}
	public String getName(){
		return this.name;
	}
	public int getRepeat(){
		return this.repeat;
	}
	@Override
	public int compareTo(eachWord e){
      return e.getRepeat() - this.getRepeat();
	}
    @Override
	public String toString(){
      return "[ "+this.getName()+" : "+this.getRepeat()+" ]";
	}
}