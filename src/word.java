import java.util.ArrayList;
import java.util.HashMap;

public class word  extends article{
	
	word(String[] st, ArrayList sr, String word) {
		super(st,sr);
	}
	protected String word;
	protected ArrayList r;
	protected HashMap hmap;
	 public HashMap search(String[] s,int m,article[] a)
	   {
	   	HashMap<String,ArrayList > hmap = new HashMap<String,ArrayList>();
	    String word;
	   	for(int p=0;p<m;p++)
	   	{
	   	for(int q=0;q<a[p].sr.size();q++)
	   	{
		ArrayList<String> r=new ArrayList<String>();
	    word=(String) a[p].sr.get(q);
	   // System.out.println(q);
	   	for(int w=0;w<m;w++)
	   	{
	   if(a[w].sr.indexOf(word)!=-1)
	   {
		   r.add("article["+w+"] ");
			 // System.out.println(r);
		   continue;
	   }
	   	}
	   	hmap.put(word,r);	
		 this.hmap=hmap;
	   }
		 setr(r);}
			//System.out.println(hmap);
	   	return hmap;
}
	 public void seth(HashMap hmap)
	 {
		 this.hmap=hmap;
	 }
	 public HashMap geth()
	 {
		 return hmap;
	 }
	 public void setr(ArrayList r)
	 {
		 this.r=r;
	 }
	 public ArrayList getr()
	 {
		 return r;
	 }
}
