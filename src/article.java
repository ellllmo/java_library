import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class article extends stopwords
{
 public ArrayList sr;
protected String[] st;
public static int q=0;
 article(String[] st,ArrayList sr)
{ 
	 this.sr=sr;
	 this.st=st;
}

public ArrayList getsr()
{
return sr;
}
public ArrayList split(String[] s,int e)
{
	ArrayList<String> sr=new ArrayList<String>();
	String[] st=s[e].split("\\s");
	for(int q=0;q<st.length;q++)
		for(int w=0;w<n.size();w++)
		{
		if(st[q].equalsIgnoreCase((String) n.get(w))==true)
		{
              st[q]="0";

		}}
	 for(String q:st) {
		 if(q!="0")
	  sr.add(q);}
	 this.sr=sr;
	 q+=sr.size();
	 return sr;
}

}




















