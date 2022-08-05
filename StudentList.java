import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String getLineFromFile() throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.Students_File_Name)));
		return bufferedReader.readLine();
	}

	public static BufferedWriter getFileBufferedWriter() throws Exception {
       return new BufferedWriter(new FileWriter(Constants.Students_File_Name, true));
	}

	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals(Constants.List_of_Data)) {
			System.out.println(Constants.Loading_Data_Msg);
			try {
			       for(String name : getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)) {
				      System.out.println(name);
			       }
			} catch (Exception e){

			}
			System.out.println(Constants.Loaded_Data_Msg);
		}
		else if(args[0].equals(Constants.Random_Data)) {
			System.out.println(Constants.Loading_Data_Msg);
			try {
			      System.out.println(getLineFromFile());
		     	  String names[] =getLineFromFile().split(Constants.WORDS_SPLIT_REGEX);
				  System.out.println(names[new Random().nextInt()]);
			} catch (Exception e){

			}
			System.out.println(Constants.Loaded_Data_Msg);
		}
		else if(args[0].contains(Constants.Add_Data)) {
			System.out.println(Constants.Loading_Data_Msg);
			try {
			     BufferedWriter bufferedWriter = getFileBufferedWriter();
	             DateFormat dateFormat = new SimpleDateFormat(Constants.Date_Format_Pattern);
	             String formatdate= dateFormat.format(new Date());
			     bufferedWriter.write(Constants.WORDS_SPLIT_REGEX+" "+args[0].substring(Constants.Invalid_Arg_exit_status)+Constants.Updated_Data_Msg+formatdate);
			     bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println(Constants.Loaded_Data_Msg);
		}
		else if(args[0].contains(Constants.Find_Data)) {
			System.out.println(Constants.Loading_Data_Msg);
			try {

			      String names[] = getLineFromFile().split(Constants.WORDS_SPLIT_REGEX);
			      boolean done = false;
			      for(int idx = 0; idx<names.length && !done; idx++) {
				    if(names[idx].equals(args[0].substring(1))) {
					  System.out.println(Constants.Data_Found_Msg);
						done=true;
				    }
				  }
			} catch (Exception e){

			}
			System.out.println(Constants.Loaded_Data_Msg);
		}
		else if(args[0].contains(Constants.Count_Words))
		{
			System.out.println(Constants.Loading_Data_Msg);
			try {
			      boolean in_word = false;
			      int count=0;
			      for(char word:getLineFromFile().toCharArray()) {
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
			      System.out.println(count +Constants.Word_Founded_Data_Msg + getLineFromFile().toCharArray().length);
			} catch (Exception e){

			}
			System.out.println(Constants.Loaded_Data_Msg);
		}
		else{
			System.out.println(Constants.Invalid_Msg);
		}
	}
}