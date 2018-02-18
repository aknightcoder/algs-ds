package problems;

import java.util.ArrayList;

public class SetWiseSubtraction 
{
	public ArrayList<Integer> getSet(int[] a, int[] b)
	{
		BinarySearch bSearch = new BinarySearch();
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		for(int i = 0; i < a.length; i++)
		{
			int foundValue = bSearch.findValue(b, 0, b.length-1, a[i]);
			
			if (foundValue == -1)
				resultList.add(a[i]);
		}
		
		return resultList;
	}
}


