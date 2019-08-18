/* @Author: Hesham El Abd
 * @Description: A Java program that reads an input text file and then produced
 * a summary about the number of occurrences of each character in the text file.
 * @Notice: Spaces are not counted finally the results are written to a CSV output
 * file.
 * @Usage: java GetCharStat.java input.txt output
 * */
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.TreeMap;

public class GetCharStat {
	public static void main(String[] args) throws IOException {
		if(args.length !=2) {
			throw new IOException("please provide an input text file and "+
			"for writing the results."+"The number of parameters you provide is "+
					args.length+" !!!");
		}
		BufferedReader input=null;
		FileWriter output=null;
		HashMap<String,Integer> char_counts= new HashMap<String,Integer>(50);
		TreeMap<String,Integer> sortedRes=null;
		try{
			input = new BufferedReader(new FileReader(args[0]));
			String line =input.readLine();
			while(line !=null) {
				char[] line_char= line.toCharArray();
				for (char _achar: line_char) {
					if(char_counts.containsKey(String.valueOf(_achar))){
						Integer old_value=char_counts.get(String.valueOf(_achar));
						char_counts.replace(String.valueOf(_achar),old_value+1);	
					}
					else {
						char_counts.put(String.valueOf(_achar),1);	
					}
				}
				line= input.readLine();
			}
		    sortedRes=new TreeMap<String,Integer>(char_counts);
		    output=new FileWriter(args[1]+".csv");
		    output.write("Character,count \n");
		    for(String char_key:sortedRes.keySet()) {
		    	Integer count = sortedRes.get(char_key);
		    	output.write(char_key+","+count+" \n");
		    }
		}catch(Exception e) {
			System.err.println("an error has occured while carrying your operation");
			e.printStackTrace();
		}finally{
			if(input!=null) {
				input.close();
			}
			if(output!=null) {
				output.close();
			}
		}
	} 
}












