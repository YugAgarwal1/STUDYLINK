import java.util.regex.Matcher;
import java.util.regex.Pattern;
class RegexDemo{
	public static void main(String[] args) {
		/*
		String myString  = "I Love Java but that does'nt mean that I don't love C!";
		System.out.println(myString);
System.out.println("------------------------------------------------------------------------------------------------------------------");
		String yourString = myString.replaceAll("I" ,"YOU");
		System.out.println(yourString);
System.out.println("------------------------------------------------------------------------------------------------------------------");
		//Character class of REGEX
		System.out.println(myString.replaceAll(".","!"));
		// . in regex matcches any character
System.out.println("------------------------------------------------------------------------------------------------------------------");
		String alphanumeric = "abcDeeeef129917zGhhiiiiabcDeeeeijkls9917z";
		System.out.println(alphanumeric);
		System.out.println(alphanumeric.replaceAll("abcDeeee","Java is Funny"));   
		System.out.println(alphanumeric.replaceAll("^abcDeeee","Java is Funny"));     //starts with
		System.out.println(alphanumeric.replaceAll("9917z$","Java is Funny"));        //ends with
System.out.println("------------------------------------------------------------------------------------------------------------------");           
        // String method - boolean matches(regex)
        alphanumeric = "hello";
        System.out.println(alphanumeric.matches("hello"));
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("hello$"));
        System.out.println(alphanumeric.matches("^hello$"));     //starts and ends with
System.out.println("------------------------------------------------------------------------------------------------------------------");
       alphanumeric = "abcDeeeef129917zGhhiiiiabcDeeeeijkls9917z";
       System.out.println(alphanumeric);
       System.out.println(alphanumeric.replaceAll("[aeiou]","X"));   // [] works on OR (ie. bracket mai se koi ek ek yaa phir joh match kare woh sab)
       System.out.println(alphanumeric.replaceAll("[aeiou][f1]","X")); // [][] works on (OR + followed by entire second) ie first mai se koi bhi ek that is floowed by the entire second one text
System.out.println("------------------------------------------------------------------------------------------------------------------");
      String name = "Mohit";
      System.out.println(name.replaceAll("[Mm]ohit","MOHIT"));  // []text represents that (any one from the first bracket + text)if matches then replace it simpleeeeeeeeeeeeeee
System.out.println("------------------------------------------------------------------------------------------------------------------");
      alphanumeric = "abcDeeeef129917zGhhiiiiabcDeeeeijkls9917z";
      System.out.println(alphanumeric.replaceAll("[aeiou]","X"));  //replaces each character in the bracket with th ereplaced once 
      System.out.println(alphanumeric.replaceAll("[^aeiou]","X"));   //[^text] - replace everything other than the mentioned characters [^a-z 3-9]
      System.out.println(alphanumeric.replaceAll("[^abcdef34567]","X")); //same as above
      System.out.println(alphanumeric.replaceAll("[^a-f3-7]","X"));    // a-f as well as 3-7 ko chodke sab replace ie case sensitiive hai yeh nakhre 
      System.out.println(alphanumeric.replaceAll("(?i)[^a-f3-7]","X"));  // a-f as well as A-F as well as 3-7 ko chodke sab replace ie (?i) to make case insensitive
      System.out.println(alphanumeric.replaceAll("[0-9]","X"));  // this will replace all the number between 0-9 with X easy hai bhia yeh toh
      System.out.println(alphanumeric.replaceAll("\\d","X"));   //does the same as above d for digit and double slash (\\) coz regex ko pata nahi chalega ki digit hai yaa escape sequence thus harr isme use \\
      System.out.println(alphanumeric.replaceAll("\\D","X")); // replace all the other characters  excepts digits thus D and (\\) to pata he hai kyu
System.out.println("------------------------------------------------------------------------------------------------------------------");
      String hasWhiteSpaces = "I have a   and a \t a tab,and also a newline\n";
      System.out.println(hasWhiteSpaces);
      System.out.println(hasWhiteSpaces.replaceAll("\\s","X"));  //replaces the tab and spaces( ) with X ie 's' stands space an double slash toh  ata he hai tujhe bro
      System.out.println(hasWhiteSpaces.replaceAll("[^\\s]","X"));  //replaces all the char remaining spaces and tab with the mentioned char
      System.out.println(hasWhiteSpaces.replaceAll("\\S","X")); // does the same work as above boiiiiiiiiiiiiii
      System.out.println(hasWhiteSpaces.replaceAll("\\w","X")); // replaces all the char a-z A-Z with the char mentioned
      System.out.println(hasWhiteSpaces.replaceAll("[^\\w]","X")); // replaces all the char except a-z and A-Z with the mentioned char
      System.out.println(hasWhiteSpaces.replaceAll("\\W","X")); // does the same work as above boiiiiiiiiiiiiiii
      System.out.println(hasWhiteSpaces.replaceAll("\\b","X")); // har word kai boundary pe mentioned char lagadega ie outside the boundaries
      System.out.println(hasWhiteSpaces.replaceAll("\\B","X")); // har word kai har letter kai beech mai mentioned char lagaega ie within the boundaries
System.out.println("------------------------------------------------------------------------------------------------------------------");
      alphanumeric = "abcDeeeef129917zGhhiiiiabcDeeeeijkls9917z";
      System.out.println(alphanumeric);
      System.out.println(alphanumeric.replaceAll("abcDe{3}","YYY"));  //replaes all the words with abcDeee ie only 3 e are compulsory
      System.out.println(alphanumeric.replaceAll("^abcDe{3}","YYY")); // replaces only if it starts wuth abcDeee ie 3e compulsory
      System.out.println(alphanumeric.replaceAll("abcDe{3,7}","YYY")); //replaces all the words with abcDe ie number of e are from 3 to 7 
      System.out.println(alphanumeric.replaceAll("abcDe{3,7}","YYY")); // replaces all the words with abcDe ie number of e is min 3 and max infinity
      System.out.println(alphanumeric.replaceAll("abcDe+","YYY")); //replaces all the words with abcDe +  represntes e yaa toh min 1 yaa toh max 
      System.out.println(alphanumeric.replaceAll("abcDe*","YYY")); // replaces all the words with the abcDe * represnets e yaa toh 0 ho sakta hai yaa infinity ie agar e nahi rahega toh chalega 
      System.out.println(alphanumeric.replaceAll("D+e*f","YYY")); //here d should be min 1 or many e yaa toh 0 yaa infinity and f toh compusory hai dude 
System.out.println("------------------------------------------------------------------------------------------------------------------");
	  */


//    DETAILS MANNNNNNNNNNNNNNNNN
/**
 * compile() used to create an object of pattern class[FACTORY METHOD] which accepts string regex
 * Pattern class has matcher() instance method to create a new object of matcher class which accepts the text on which regex pattern has to be matchd
 * Now we can use matches() [instance method] which returns true or false on whether th epattern has matched  or not
**/	


/*
System.out.println("------------------------------------------------------------------------------------------------------------------");
	StringBuffer htmlCode = new StringBuffer("<html><head><title>Java</title></head>");
	htmlCode.append("<body><h1>My Title</h1>");
	htmlCode.append("<div><p>This is simple paragraph</p></div>");
	htmlCode.append("<h2>About us</h2>");
	htmlCode.append("<p>This is another paragraph</p>");
	htmlCode.append("<h2>Contact us</h2>");
	htmlCode.append("<p>this is my address</p>");
	htmlCode.append("</body></html>");
System.out.println("------------------------------------------------------------------------------------------------------------------");

   String h2Pattern = "<h2>";
   Pattern pattern = Pattern.compile(h2Pattern);
   Matcher match = pattern.matcher(htmlCode);
   System.out.println(match.matches());    // yaha false aara hai pata nahi kyu bhenchod
System.out.println("------------------------------------------------------------------------------------------------------------------");
  */
   /**
    * matches() of matcher class works exactly like matches() of string class ie it tries to match the whole string with the given regex pattern
    * Matcher class has another instance method name as find() for the pattern in the given text if it finds then it retruns true otherwise it returns false
    * now there are two more method in matcher class they are start() and end() these methods are usefull when out matcher finds the pattern because they will give start and end indexes of that method
   **/
/*
System.out.println("------------------------------------------------------------------------------------------------------------------");  
   while(match.find()){
   	System.out.println("Occurance "+match.start()+" to "+match.end());
   }
System.out.println("------------------------------------------------------------------------------------------------------------------");
   
   */

   /**
    * (email)@(domain).(top_level_domain)
    * Matccher class has a method name as group() whose syntax is String group(int group_no)
   **/

/*
System.out.println("------------------------------------------------------------------------------------------------------------------");

   // GROUP REGEX
   String groupRegex = "(<h2>)(.*)(</h2>)";
   Pattern groupPattern = Pattern.compile(groupRegex);
   Matcher groupMatch = groupPattern.matcher(htmlCode);
   System.out.println(groupMatch.matches());
System.out.println("------------------------------------------------------------------------------------------------------------------");
   while(groupMatch.find()){
   	System.out.println("Internal Text : "+groupMatch.group(2));   // yk na . is lalchi saala sab data nikal liya 
   }
System.out.println("------------------------------------------------------------------------------------------------------------------");
*/

/**
 * GREEDY MATCHING - Jitna max match ho woh utna matcch karegi
 * RELECTANT MATCH - Jaha phele match mila wahi parr rukjana
 * so both example id of greedy greedy matching as we know that . is a greedy character
**/

/*
System.out.println("------------------------------------------------------------------------------------------------------------------");
String groupRegexReluctant = "(<h2>)(.*?)(</h2>)";
Pattern groupPatternRelectunt = Pattern.compile(groupRegexReluctant);
Matcher groupMatchRelectunt = groupPatternRelectunt.matcher(htmlCode);
System.out.println(groupMatchRelectunt.matches());
System.out.println("------------------------------------------------------------------------------------------------------------------");
while(groupMatchRelectunt.find()){
	System.out.println("INTERNAL TEXT : "+groupMatchRelectunt.group(2));
}
System.out.println("------------------------------------------------------------------------------------------------------------------");



        // VALIDATE PHONE NUMBER
String mobileNumber = "+91 9321612841"; // CALL ME
String mobileNumberRegex = "^\\+\\d{2}\\s[5-9]\\d{9}";
Pattern mobileNumerPattern = Pattern.compile(mobileNumberRegex);
Matcher mobileNumberMatcher  = mobileNumerPattern.matcher(mobileNumber);

if(mobileNumberMatcher.matches()){
	System.out.println("Mobile number is valid");
}
else{
	System.out.println("Mobile number is not valid");
}

*/

		// VALIDATE EMAIL ADDRESS
String email = "himanshu@studylinkclasses.com";
String emailRegex = "^[a-zA-Z]([\\.A-Za-z0-9_\\+-]+)*@([0-9A-Za-z][A-Za-z0-9]*)(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,}+)$";
Pattern emailPAttern = Pattern.compile(emailRegex);
Matcher emailMatch = emailPAttern.matcher(email);
if(emailMatch.matches()){
	System.out.println("valid email");
	System.out.println(emailMatch.group())3;
}
else{
	System.out.println("Invalid email");
}
}
}