/*Author: Hesham El Abd
 * Description: The programs reads a text file and counts the number of characters 
 * in the file excluding the white spaces
 * */
 import java.io.IOException;
 import java.io.FileReader;
 import java.io.BufferedReader;
 
 public class CharCounter{
	 public static void main(String []args) throws IOException {
		 BufferedReader input=null;
		 int charCounts=0;
		 try {
			 input= new BufferedReader(new FileReader(args[0]));
			 String line=input.readLine();
			 while(line !=null) {
				 String [] words=line.split("//s");
				 for (String word:words) {
					 charCounts+=word.length();
				 }
				 line=input.readLine();
			 }
		 }finally {
			 input.close();
			 System.out.println("The number of characters in your file "
					 + "is: "+charCounts);
		 }
	 }
 }