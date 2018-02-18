package problems;

import java.util.ArrayList;
import java.util.Collections;


public class StringCombination 
{
	private final StringBuilder sb;
	
	public StringCombination()
	{
		sb = new StringBuilder();
	}
	
	private ArrayList<String> printCombinations(int start, String str,  ArrayList<String> resultList)
	{
		for (int i = start; i < str.length(); i++)
		{
			sb.append(str.charAt(i));
			
			if (i < str.length())
				printCombinations(i + 1, str, resultList);
			
			resultList.add(sb.toString());
			sb.setLength(sb.length()-1);
		}
		
		return resultList;
	}
	
	public ArrayList<String> combine()
	{
		return printCombinations(0, "ABCD", new ArrayList<String>());
	}

	public static void main(String[] args) 
	{
		StringCombination c = new StringCombination();
		ArrayList<String> results = c.combine();
		Collections.sort(results);
		
		for(String item : results)
			System.out.println(item);
	}
}
