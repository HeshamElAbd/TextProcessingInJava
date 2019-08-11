/*
 * Author: Hesham EL Abd
 * Description: A java program for counting the number of words in an input
 * text file. 
 */
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class WordCounter{
	public static void main(String []args) throws IOException {
		BufferedReader input = null; 
		int wordCount=0;
	try {
		input= new BufferedReader(new FileReader(args[0]));
		String line=input.readLine();
		while(line !=null) {
			String [] wordsInLine = line.split("\\s+");
			wordCount+=wordsInLine.length;
			line=input.readLine();
		}
		
	}finally {
		input.close();
		System.out.println("Total number of words is: " +wordCount);
		}
	}
}