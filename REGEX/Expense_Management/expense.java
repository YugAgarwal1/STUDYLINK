import java.util.*;
import java.io.*;
import java.util.regex.*;
class expense implements Comparable<expense>{
    public String categoryName ;
    public String description ;
    public Date d ;
    public int expenseSpent ;
    ArrayList<expense> data = new ArrayList<>();
    File f ;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    BufferedWriter bw;
    
    public expense(){}
    public expense(String cat , String des , Date d , int amt){
       this.categoryName = cat;
       this.description = des;
       this.d = d;
       this.expenseSpent = amt;
    }
    public Date getDate(){return this.d;}
    public int getExpense(){return this.expenseSpent;}
    public  void refillArrayList() throws IOException{
        String dataCat = returnCategory();
        String dataExp = returnExpense();
        Pattern pattern2 = Pattern.compile("(\\s*)(\"category-name)(\\s*\"\\s*:\\s*\")(.*?)(\"\\s*,\"\\s*description\\s*)(\"\\s*:\\s*\")(.*?)(\"\\s*,\\s*\"\\s*date\\s*)(\"\\s*:\\s*\")(.*?)(\"\\s*})");
        Matcher matcher2 = pattern2.matcher(dataCat); 
        Pattern pattern3 = Pattern.compile("(\\{\\s*\"amount\\s*\"\\s*:\\s*)(.*?)(\\})");
        Matcher matcher3 = pattern3.matcher(dataExp);
        while(matcher2.find() && matcher3.find() ){
          String []temp = returnDateSplit(matcher2.group(10));
          int amount = Integer.parseInt(matcher3.group(2));
          int date = Integer.parseInt(temp[0]);
          int month = (Integer.parseInt(temp[1]));
          int year = Integer.parseInt(temp[2]);
        //  System.out.println(date); //  working properly
        //  System.out.println(month); //   working properly
        //  System.out.println(year);  // working properly
          Date d = new Date(year,--month,date);
           int monthdec = d.getMonth();
        //  System.out.println(d.getDate()+"/"+(++monthdec)+"/"+d.getYear());
          expense s = new expense(matcher2.group(4).trim() , matcher2.group(7).trim() , d , amount);
          //System.out.println(matcher2.group(4).trim()+" , "+matcher2.group(7).trim()+" , "+matcher2.group(10).trim()+" , "+amount);
          data.add(s);
        }
     printExpense();
    }
    public String[] returnDateSplit(String s){
       return s.split("/");
    }
    
    public void printExpense(){
        Collections.sort(data);
        System.out.println(data);  
    }

    public void printMonthlyExpenseTotal(){
      if(data.size()>=1){
       Collections.sort(data);
       expense s = data.get(0);
       int startDate = s.getDate().getDate();
       int startMonth = s.getDate().getMonth();
       startMonth = startMonth + 1;
       int startYear = s.getDate().getYear();
       int sum = s.getExpense();
       for(int i = 1 ; i < data.size(); i++){
           if(startYear==data.get(i).getDate().getYear()){
                 int month = data.get(i).getDate().getMonth();
                 //month = month - 1;
                if(startMonth==(--month)){
                   sum = sum + data.get(i).getExpense();
                }
                else{
                  System.out.println(sum);
                  sum = data.get(1).getExpense();
                  startMonth = --month;
                }
           }
           else{
              startYear = data.get(i).getDate().getYear();
           }
       }
      }
    }

    public void addExpense(String category , String description , Date d , int expenseSpent) throws IOException{
       this.categoryName = category ;
       this.description = description;
       this.d = d;
       this.expenseSpent = expenseSpent; 
       data.add(this);
       addDataToFile();
    } 
    public String getDataFromFile() throws IOException{
      f = new File("try.json");
      fr = new FileReader(f);
      br = new BufferedReader(fr);
      String data = "";
        String d = br.readLine();
        while(d != null){
          data = data + d;
          d = br.readLine();
        }
        fr.close();
        br.close();
      //  System.out.println(data);
        return data;
    }

    public void addDataToFile() throws IOException {
       String cat  = addCategoryData(categoryName,description,d);
       String exp = addExpenseData(expenseSpent);
       writeDataToFile(cat,exp); 
    }

    public String returnCategory() throws IOException{
      String data = getDataFromFile();
       Pattern pattern  = Pattern.compile("(\"categories\"\\:\\[)(.*?)(\\]\\,)");
      Matcher matcher = pattern.matcher(data);
      if(matcher.find()){
        return matcher.group(2);
      }
      return "";
    }

    public String returnExpense() throws IOException{
      String data = getDataFromFile();
      Pattern pattern1 = Pattern.compile("(\"expenses\"\\:\\[)(.*?)(\\])");
      Matcher matcher1 = pattern1.matcher(data);
      if(matcher1.find()){
           return  matcher1.group(2);
      }
      return "";
    }

    public String addCategoryData(String category,String desc,Date d) throws IOException{
       int month = d.getMonth();
      String ret =""+returnCategory()+"{ \"category-name\":\""+category+"\",\"description\":\""+desc+"\",\"date\":\""+d.getDate()+"/"+(++month)+"/"+d.getYear()+"\"},";
      return ret;
    }
    
    public String addExpenseData(int amount) throws IOException{
      String ret = ""+returnExpense()+"{\"amount\":"+amount+"},";
      return ret;
    }
    public void writeDataToFile(String category , String amount) throws IOException{
        String f1 = "{\"categories\":["+category+"],\"expenses\":["+amount+"]}";
        f = new File("try.json");
        fw = new FileWriter(f);
        bw = new BufferedWriter(fw);
        bw.write(f1);
        bw.close();
    }

    @Override
    public String toString(){
         int month = d.getMonth();
         return "["+this.categoryName+" , "+this.description+" , "+d.getDate()+"/"+(++month)+"/"+d.getYear()+" , "+this.expenseSpent+" ]";
    }

    @Override
    public int compareTo(expense s1){
       return this.getDate().compareTo(s1.getDate());
    }
}