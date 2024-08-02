import java.util.*;
import java.io.*;
import java.util.regex.*;
public class wordHash{
   Map<String , Integer> words = new HashMap<>();
   public String[] readDataFromSourceFile(String sourceFile) throws IOException {
         String data = "";
         File f = new File(sourceFile);
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         String d = "";
         while( (d = br.readLine()) != null){
         	data = data + d;
         	data = data + " ";
         }
         return data.split("[\\W\\d_]");
	}

	public HashMap<String , Integer> addValueToHash(String []data){
		String []word = data;
		for(String w : word){
			if(w.equals("of") || w.equals("in") || w.equals("and") || w.equals("or") || w.equals("at") || w.equals("")){
				continue;
			}
			else{
                if(words.containsKey(w)){
                    int num = words.get(w) + 1;
                    words.put(w,(Integer)num);
                }
                else{
                	Integer num = new Integer(1);
                	words.put(w,num);
                }
			}
		}
		return new HashMap<String , Integer>(words);
	}

}