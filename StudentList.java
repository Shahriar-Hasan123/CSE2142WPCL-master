import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				   BufferedReader bufferedReader = new BufferedReader(
					 new InputStreamReader(
							new FileInputStream("students.txt")));
			       String studentName = bufferedReader.readLine();
			       String names[] = studentName.split(",");
			       for(String name : names) {
				      System.out.println(name);
			       }
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			      BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			      String studentName = bufferedReader.readLine();
			      System.out.println(studentName);
		     	  String names[] = studentName.split(",");
				  Random random = new Random();
				  int index = random.nextInt();
				  System.out.println(names[index]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")) {
			System.out.println("Loading data ...");			
			try {
			     BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
			     String subArgument = args[0].substring(1);
	             Date date = new Date();
	             String dateFormatModel = "dd/mm/yyyy-hh:mm:ss a";
	             DateFormat dateFormat = new SimpleDateFormat(dateFormatModel);
	             String formatedate= dateFormat.format(date);
			     bufferedWriter.write(", "+subArgument+"\nList last updated on "+formatedate);
			     bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
			      BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				  String studentName = bufferedReader.readLine();
			      String names[] = studentName.split(",");
			      boolean done = false;
			      String searchName = args[0].substring(1);
			      for(int idx = 0; idx<names.length && !done; idx++) {
				    if(names[idx].equals(searchName)) {
					  System.out.println("We found it!");
						done=true;
				    }
				  }
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			      BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			      String names = bufferedReader.readLine();
			      char wordOfName[] = names.toCharArray();
			      boolean in_word = false;
			      int count=0;
			      for(char word:wordOfName) {
				    if(word ==' '){
					   if (!in_word) {
						   count++;
						   in_word =true;
					   }
					   else {
						   in_word=false;
					   }
				    }
			      }
			      System.out.println(count +" word(s) found " + wordOfName.length);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Invalid input by user");
		}
	}
}