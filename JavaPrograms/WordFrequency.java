/* @Author: Hesham El Abd
 * @ Description: A program that can be used to get the frequency of each word 
 * in a text corps.and write the results into an output csv file.
 * @usage: java WordFrequency.java input.txt output
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
public class WordFrequency {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			throw new IOException(
	"please provide an input text file and the name of your output file");
		}
		FileWriter output=null;
		BufferedReader input=null;
		String [] words;
		HashMap<String,Integer> mymap=new HashMap<String,Integer>(10000);
		try {
			input =new BufferedReader (new FileReader(args[0]));
			String line = input.readLine();
			while(line !=null) {
				words=line.split(" ");
				for (String word: words) {
					if(mymap.containsKey(word)) {
						mymap.replace(word, mymap.get(word)+1);
					} else {
						mymap.put(word, 1);
					}
				}
				line=input.readLine();
				}
				TreeMap<String,Integer> orderedRes = new TreeMap<String,Integer>(mymap);
				output=new FileWriter(args[1]+".csv");
				output.write("Word \t , \t count \n");
				for(String word: orderedRes.keySet()) {
					Integer count=orderedRes.get(word);
					output.write(word+" \t , \t "+count+" \n");
				}
		}catch(Exception e) {
			System.err.println(" an error occured ");
			e.printStackTrace();
		} finally {
			if(input != null) {
				input.close();
			}
			if(output != null) {
				output.close();
			}
		}

	}

}
