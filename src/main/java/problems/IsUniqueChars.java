package problems;

import java.util.HashSet;

public class IsUniqueChars {

	public boolean isUniqueCharsHashSet(String str)
	{
		if (str.length() == 0) return false;
		
		HashSet<Integer> charMap = new HashSet<Integer>();
		
		for (int i = 0; i < str.length(); i++)
		{
			int intValue = Character.getNumericValue(str.charAt(i));
			
			if (charMap.contains(intValue))
				return false;
			else
				charMap.add(intValue);
		}
		
		return true;
	}
	
	public boolean isUniqueCharsArray(String str)
	{
		if (str.length() == 0) return false;
		
		boolean[] chars_found = new boolean[256];
		
		for (int i = 0; i < str.length(); i++)
		{
			int charValue = str.charAt(i);
			
			if (chars_found[charValue]) return false;
			
			chars_found[charValue] = true;
		}
		
		return true;
	}
}
