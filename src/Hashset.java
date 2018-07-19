import java.util.*;
public class Hashset
{
	public static void main(String[] args)
	{
		HashSet<String> hashset=new HashSet<String>();
		hashset.add("pradnya");
		hashset.add("jyoti");
		hashset.add("archana");
		hashset.add("anuya");
		hashset.add("anuya");

		System.out.println(hashset);
		
		LinkedHashSet<String> lhs=new LinkedHashSet<String>();
		lhs.add("tapasya");
		lhs.add("tanishka");
		lhs.add("varun");
		lhs.add("arya");
		lhs.add("suraj");
		System.out.println(lhs);

		TreeSet<String> treset=new TreeSet<String>();
		treset.add("tapasya");
		treset.add("tanishka");
		treset.add("varun");
		treset.add("arya");
		treset.add("suraj");
		System.out.println(treset);


		
	}

}
