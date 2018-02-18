package problems;

import java.util.ArrayList;

public class StringPermutations {

	private int calledCount;
	
	public ArrayList<String> permuteString(String str, int currentIndex, int endIndex, ArrayList<String> permutationList)
	{
		// just a trace variable to determine how many times this method is called
		calledCount++;
		
		if (currentIndex == endIndex)
		{
			permutationList.add(str);
		}
		else
		{
			for (int i = currentIndex; i <= endIndex; i++)
			{
				str = getPermutedString(str,currentIndex,i);
				permuteString(str,currentIndex+1, endIndex, permutationList);			
				str = getPermutedString(str,currentIndex,i);
			}
		}
		
		return permutationList;
	}
	
	private String getPermutedString(String str, int left, int right)
	{
		char[] charArray = str.toCharArray();
		
		char tmpChar = charArray[left];
		charArray[left] = charArray[right];
		charArray[right] = tmpChar;
		
		return String.valueOf(charArray);
	}
	
	public void printCalledCount()
	{
		System.out.println(String.format("Called %s ", calledCount));
	}
}
