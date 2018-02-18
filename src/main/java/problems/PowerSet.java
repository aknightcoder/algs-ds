package problems;

import java.util.ArrayList;

public class PowerSet 
{
	public static <T> ArrayList<ArrayList<T>> getPowerSet(T[] arr)
	{
		int numberOfSubSets = 1 << arr.length;
		ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();

		for (int i = 0; i < numberOfSubSets; i++)
		{
		   int pos = arr.length - 1;
		   int bitmask = i;
		   
		   ArrayList<T> subList = new ArrayList<T>();
		   list.add(subList);
		   while(bitmask > 0)
		   {
			   if((bitmask & 1) == 1)
				   list.get(i).add(arr[pos]);
		    
			   bitmask >>= 1;
		       pos--;
		   }
		 }
		
		return list;
	}
	
	public static void main(String[] args) 
	{
		String[] arr = new String[] {"a","b","c", "d"};

		ArrayList<ArrayList<String>> result = PowerSet.getPowerSet(arr);
	}

}
