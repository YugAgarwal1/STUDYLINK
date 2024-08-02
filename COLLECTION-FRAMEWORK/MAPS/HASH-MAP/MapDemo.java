import java.util.Map;
import java.util.HashMap;
public class MapDemo{
	public static void main(String[] args) {
		Map<String,String> languages = new HashMap<>();

		languages.put("JAVA","An oop language which is meanr for hightly professional indivisual");
		languages.put("JAVASCRIPT","A scripting language which will capture complete web");
		languages.put("C","Love for this language will never gonna end");

	   if(languages.containsKey("JAVA")){
	  	System.out.println("JAVA key found in languages");
	  	System.out.println("JAVA :"+languages.get("JAVA"));
	  }
	  else{
	  	System.out.println("JAVA key is not found in the languages");
	  }
     
	 // System.out.println(languages.put("JAVA","MY LOVE!"));
	  System.out.println(languages.put("python","powerfull scripting language made over c++"));
     
	  languages.put(null,"hello world");
	  languages.put(null,"hellow orld again");

	  for(String key : languages.keySet()){
	  	System.out.println(key + " : "+languages.get(key));
	  }
	}
}