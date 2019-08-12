/* @Author: Hesham EL Abd
 * @Description: A JAVA program to count the number of occurrence of a specific
 * word in text file per line. i.e. it counts the number of occurrence per-line in a
 * text file. and then write the results to an output file. the results are written 
 * in a CSV file format.
 * @Usage: $ java CountesPerLine.java word text.txt outputfile 
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
public class CountesPerLine{
	public static void main(String []args) throws IOException{
		BufferedReader input=null;
		FileWriter output=null;
		int line_count=0;
		ArrayList<Integer> CountsPerLine = new ArrayList<Integer>();
		 try {
				input= new BufferedReader(new FileReader(args[1]));
				String line =input.readLine();
				Pattern pat= Pattern.compile(args[0]);
				while(line != null) {
					Matcher mat =pat.matcher(line);
					while(mat.find()) {
						line_count++;
					}
					CountsPerLine.add(line_count);
					line_count=0;
					line=input.readLine();
				}
			}finally {
				input.close();
				output=new FileWriter(args[2]+".csv");
				output.write("Line\t,\tCount\n");
				for (int iter=0;iter!=CountsPerLine.size();iter++) {
					output.write(iter+"\t,\t"+CountsPerLine.get(iter)+"\n");
				}
				output.close();
			}
	}
	
}

 





















