import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class stopwords
{
	protected static ArrayList n;
	protected String[] st;
	 int u;
	public ArrayList<String> stop() {
   		ArrayList<String> n=new ArrayList<String>();
   	  try {
   	      String s;
             FileReader fr = new FileReader("stopWords.txt");
             BufferedReader br = new BufferedReader(fr);
             while( (s = br.readLine() ) != null ) {
              	  String[] st=s.split(",");
              	  for(String q:st) {
           	  n.add(q);}
         }}
         catch(IOException e) {
             e.printStackTrace();
         }
		 this.n=n;
		 return n;
	}
	public ArrayList getn()
	{
	return n;
	}
}