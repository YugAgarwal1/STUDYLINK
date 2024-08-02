import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class DocumentionCreation{
	File f;
   int refno=1;
	FileInputStream fin ;
	BufferedReader br ;
	StringBuffer []sb4 = new StringBuffer[8];
	int maintainIndexOfBuffer;
	StringBuffer sb3 = new StringBuffer();
   StringBuffer sb7 = new StringBuffer();
	public static void main(String[] args) {

		DocumentionCreation dr = new DocumentionCreation();

				//initializinng of the each element of the buffer
		for(int i = 0 ; i<dr.sb4.length;i++){
           dr.sb4[i] = new StringBuffer("");
		}


		Scanner st = new Scanner(System.in);
	    //this will check whether the user enters the file name as correct or not
	    while(true){
	    System.out.println("Enter the name of the file");
	    String fileName = st.next();
	  File f = new File ("C:/Users/Admin/Desktop/"+fileName);
         if(f.exists()){
         	dr.ExtractCommentFromTheData(dr.ReadDataFromfile(f));
	    	break;
	    }
	    else{
	    	System.out.println("the file does not exists");
            continue;
	    } 
	                }
	                                        }
   // this function reads the data from the existing file and returns it in the form of StringBuffer
	   public StringBuffer ReadDataFromfile(File f){
       	StringBuffer sb = new StringBuffer();
	   	String data = "";
	   	try{
	   			   	fin = new FileInputStream(f);
	   	br = new BufferedReader(new InputStreamReader(fin));
	   	while((data = br.readLine()) != null){
	   		sb.append(data);
	   		sb.append("\n");
	   	}
	   	return sb;
	   }
	   	catch(Exception e){
	   		System.out.println("error");
	   		return sb;
	   	}

                                            }
   //this function will extract the comments part from the file and will store it in a StringBuffer ka array
   public void  ExtractCommentFromTheData(StringBuffer sb){
   	StringBuffer sb1 = new StringBuffer(sb);
   // System.out.println(sb1);  // idhar tak solid chalra hai boiiiiiiiiii
   // removing all the newlines from the stringbuffer
   String data_without_newline = (sb1.toString()).replaceAll("\n","");
  // System.out.println(data_without_newline);
   Pattern pattern = Pattern.compile("(/\\*\\*)(.*?)(\\*/)(.*?)(\\))");
   Matcher matcher = pattern.matcher(data_without_newline);
   while(matcher.find()){
 //  System.out.println(matcher.group(4)+")");   //no error here boiiiiiiiiii
   MakeDataForTheFile( matcher.group(2).toString() , (matcher.group(4).toString())+")" );
   }  
   CreateHtmlFileAndAddDataToIt(sb3,sb7);
   }


   //this function will create an HTML file and add the content in the file
   public void CreateHtmlFileAndAddDataToIt(StringBuffer s,StringBuffer s1){
   	StringBuffer sb6 = new StringBuffer("<!DOCTYPE html>\n<html>\n<head><style>");
   	sb6.append("body{\nbackground-color:bisque;\n}\n");
      sb6.append("a {\n text-decoration : none ; color:blue;}");
      sb6.append(".allmeth{\nbackground-color:yellow;\ncolor:black;\nfont-weight:bolder;width:max-content;padding-right:10px;padding-left:10px;}");
      sb6.append("td{\nheight: max-content;\nbackground-color:white;\nborder: 1px solid black;padding-right : 30px;}");
   	sb6.append(".big{\nheight: max-content;\nwidth: 100%;\ndisplay:flex;\nflex-direction : column;\nalign-content : space-evenly;\nbackground-color : white;\npadding-top:0px;\n}");
   	sb6.append("p{\nwidth : 100%;\ncolor:black;\ndisplay: flex;\nflex-direction: column;\njustify-content:center;\nmargin-top:5px;\nmargin-bottom:5px;}\n</style>\n");
      sb6.append("<title>DOCUMENT</title>\n</head>\n<body><div class='allmeth'><a href='#ref1' style='color: black;'>ALL METHODS</a></div>");
      sb6.append("<table class ='one'>");
      sb6.append(s1.toString()+"</table>");
   	sb6.append(s.toString());
   	sb6.append("</body>\n</html>");
   	try{
   			File f1 = new File("file.html");
   	        BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
   	        //System.out.println(sb6.toString());
            bw.write(sb6.toString());
            bw.close();   //remember this you always forget to close the bufferedwriter and then you cry in file handling
   	}
   	catch(Exception e){
   		System.out.println("error");
   	}
   }



   //this function will simply create a format of sections
   public void MakeDataForTheFile(String de,String syn){
   	String syntax = syn;
   	String data = de 	;
      //System.out.println(syntax);
   maintainIndexOfBuffer = 0 ;
             //pattern matchinf for the definition
   Pattern pattern1 = Pattern.compile("(\\*)(\\s*)*([^@]*.?)((\\*)(\\s*)*(\\@)*)");
   Matcher matcher1 = pattern1.matcher(data);
   while(matcher1.find()){
   	sb4[0].append((matcher1.group(3).toString()).replaceAll("\\*",""));
   	sb4[0].append("<br>");
   }
    // pattern matching for the param tag
   Pattern pattern2 = Pattern.compile("(@param)(.*?)(\\*)");
   Matcher matcher2 = pattern2.matcher(data);
   while(matcher2.find()){
   	sb4[1].append(matcher2.group(2));
   	sb4[1].append("<br>");
   }

           // pattern matching for the return
   Pattern pattern3 = Pattern.compile("(@return)(.*?)(\\*)");
   Matcher matcher3 = pattern3.matcher(data);
   while(matcher3.find()){
   	sb4[2].append(matcher3.group(2));
   	sb4[2].append("<br>");
   }
          // pattern matching for the throws
   Pattern pattern4 = Pattern.compile("(@throws)(\\s*)*(.*?)(\\*)");
   String dataNew = data+"\\*/";
   Matcher matcher4 = pattern4.matcher(dataNew);
   while(matcher4.find()){
   	sb4[3].append((matcher4.group(3).toString()).replaceAll("/",""));
   	sb4[3].append("<br>");
   }

         //syntac to fully jaaega cox sirf wahi data extract kiya hai tune bhaiiiiiiiii
   String da = syntax.replaceAll("<","&lt").replaceAll(">","&gt");
   sb4[4].append(da);
   sb4[4].append("<br>");
    
   //pattern for geting the name of the function from the syntax variable
   Pattern pattern5 = Pattern.compile("(.*?)(\\s)(.*?)(\\()(.*?)(\\))");
   Matcher matcher5 = pattern5.matcher(syntax); 
   while(matcher5.find()){
      String temp = (matcher5.group(3).toString()).trim();
      //System.out.println(temp);
      int index = temp.length()-1;
      StringBuffer newTemp = new StringBuffer();
      while(index!=0){
         if(temp.charAt(index)!=' '){
         	newTemp.append(temp.charAt(index));
         }
         else{
         	break;
         }
         index--;
      }
     //System.out.println(newTemp.reverse().toString());
     sb4[5].append(newTemp.reverse().toString());
     sb4[5].append("<br>"); 
     //newTemp.replace(0,newTemp.length(),"");
     String repData = newTemp.toString()+"("+matcher5.group(5)+")";
     sb4[6].append(repData.replaceAll("<","&lt").replaceAll(">","&gt"));   //sb4[6] consist the right top data of tr aur description to tere paar already hai he
     //System.out.println(matcher5.group(3).trim());
     String temp1 = matcher5.group(3).toString().trim();
     int temp1Length = temp1.length();
     String temp2 = "";  //here temp string to seperate the specifier with the data
     //System.out.println(temp1);
      index = 0 ;
      while(index<temp1.length()){
      if(temp1.charAt(index) ==' '){
         temp2 = temp1.substring(++index,temp1Length);
         //System.out.println(temp2);
         break;
      }
      index++;
      }
     //now simply reverse the stringBuffer reverse it and remove the fucntion name to get the return type
      StringBuffer  temp3 = new StringBuffer(temp2);
      String temp4 = "";
      temp3.reverse();
      index = 0;
      while(index<temp3.length()){
         if(temp3.charAt(index)==' '){
            StringBuffer d = new StringBuffer(temp3.toString().substring(++index,temp3.length()));
           temp4 = d.reverse().toString();
            break;
         }
         index++;
      }
      sb4[7].append(temp4);  //this is having the return type of the function which is to be written in the data
   }

   makeSectionFromTheIndivisualData(sb4,refno);
   refno++;
   //reassigning the stringBuffer array to ""
   for(int i = 0 ; i<sb4.length;i++){
   	    sb4[i].replace(0,sb4[i].length(),"");
   }
}


//this function will make the section from the extracted data
public void makeSectionFromTheIndivisualData(StringBuffer []sr,int no){
	StringBuffer []sb5 = sr;
	StringBuffer makeTable = new StringBuffer("<tr><td>");
   makeTable.append(sb5[7]+"</td><td><a href='#ref"+no+"'>");
   makeTable.append(sb5[6]+"</a><p>"+sb5[0]+"</p></td></tr>");
   StringBuffer makeSection  = new StringBuffer("<section class='big' id='ref"+no+"'><p style='background-color: grey; font-size: 25px;'>"+sb5[5]+"</p>");
	makeSection.append("<p><b>SYNTAX : </b><br>"+sb5[4]+"</p>");
	if((sb5[0].toString()).isEmpty()==false){
	makeSection.append("<p><b>DEFINITION : </b><br>"+sb5[0]+"</p>");
    }
	if((sb5[2].toString()).isEmpty()==false){
	makeSection.append("<p><b>RETURNS : </b><br>"+sb5[2]+"</p>");
	}
	if((sb5[1].toString()).isEmpty()==false){
 	makeSection.append("<p><b>PARAM : </b><br>"+sb5[1]+"</p>");
	}
	if((sb5[3].toString()).isEmpty()==false){
	makeSection.append("<p><b>THROWS : </b><br>"+sb5[3]+"</p>");
	}
	makeSection.append("</section><br><br>");


	addSectionToTheHtmlCode(makeSection);
   addTableToTheHtmlCode(makeTable);
	//System.out.println(sb5[0]);
}
//this function will take the section and add it in the body content together
public void addSectionToTheHtmlCode(StringBuffer sbr){
	StringBuffer sbr1 = sbr;
     sb3.append(sbr1.toString());
}
public void addTableToTheHtmlCode(StringBuffer sbr){
     sb7.append(sbr.toString());
}
}