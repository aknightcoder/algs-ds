package problems;

public class DuplicateAndMissingValue 
{
	public int[] FindDuplicateAndMissingValue(int[] arr) throws IllegalArgumentException
	{
		int[] results = new int[2];
		
		if(arr == null)
			throw new IllegalArgumentException("arr is null");
		
		//assuming natural numbers > 0; we'll skip the 0 index to simplify
		boolean[] auxArr = new boolean[arr.length+1];
		
		for (int arrValue : arr)
		{
			if (auxArr[arrValue])
			{
				results[0] = arrValue;
				continue;
			}

			auxArr[arrValue] = true;
		}
		
		for (int i = 1; i < arr.length-1; i++)
		{
			if (!auxArr[i])
			{
				results[1] = i;
				break;
			}
		}
		
		return results;
	}
}
