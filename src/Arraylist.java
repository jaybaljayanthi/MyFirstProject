import java.util.*;
public class Arraylist 
{
	public static void main(String arg[])
	{
		 ArrayList<String> list=new ArrayList<String>();
		list.add("Sunita");
		list.add("vinod");
		list.add("deepak");
		list.add("nisha");
		list.add("nitesh");
		  System.out.println(list.size());

		list.set(2, "jayanthi");
		
		Iterator<String> itr=list.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next()); 
		   
		
	}
		  System.out.println(list.size());
	}
}
