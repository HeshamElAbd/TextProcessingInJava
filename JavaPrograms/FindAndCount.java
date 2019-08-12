/* @Author: Hesham EL Abd
 * @Description: a simple JAVA program that uses regex to search for user input word 
 * in a text file and then print the number of occurrences
 * @usage:$ java FindAndCount.java word text.txt.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FindAndCount{
	public static void main(String []args) throws IOException {
		BufferedReader input=null;
		int count=0;
		try {
			input=new BufferedReader(new FileReader(args[1]));
			Pattern pat = Pattern.compile("\\b"+args[0]+"\\b");
			String line = input.readLine();
			while(line !=null) {
				Matcher mat = pat.matcher(line);
				while(mat.find()) {
					count++;
				}
				line=input.readLine();
			}
		}finally{
			input.close();
			System.out.println("The count is: "+count);
		}
	}
}