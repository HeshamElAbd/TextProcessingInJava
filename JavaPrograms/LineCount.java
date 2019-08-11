/* Author: Hesham El Abd
 * Description: A JAVA program that reads an input text files and count
 * the number of lines in that file 
 * */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LineCount{
	public static void main(String[] args) throws IOException {
		BufferedReader input =null;
		int linecounts=0;
	try{
		input = new BufferedReader(new FileReader(args[0]));
		String line =input.readLine();
		while(line !=null) {
			linecounts++;
			line=input.readLine();
			}
		}finally{
			input.close();
			System.out.println("Number of lines is: "+ linecounts);
		}
	}
}