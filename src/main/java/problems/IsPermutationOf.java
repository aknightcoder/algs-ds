package problems;

import java.util.Arrays;

public class IsPermutationOf 
{
	public boolean isPermutation(String strA, String strB)
	{
		if (strA.length() != strB.length())
			return false;
		
		char[] strAContent = strA.toCharArray();
		Arrays.sort(strAContent);
		String sortedA = new String(strAContent);
	
		char[] strBContent = strB.toCharArray();
		Arrays.sort(strBContent);
		String sortedB = new String(strBContent);
		
		return sortedA.equals(sortedB);
	}
	
	public boolean isPermutation2(String strA, String strB)
	{
		if (strA.length() != strB.length())
			return false;
		
		int[] aLetters = new int[128]; // ASCII
		
		for (int i = 0; i < strA.length(); i++)
			aLetters[strA.charAt(i)] ++;
		
		for (int j = 0; j < strB.length(); j++)
		{
			if (--aLetters[(int)strB.charAt(j)] < 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String strA = "Adam";
		String strB = "damA";
		String strC = "Adao";
		
		IsPermutationOf p = new IsPermutationOf();
	    System.out.println(p.isPermutation(strA, strB));
		System.out.println(p.isPermutation2(strA, strB));
		System.out.println(p.isPermutation(strA, strC));
		System.out.println(p.isPermutation2(strA, strC));
	}
}
