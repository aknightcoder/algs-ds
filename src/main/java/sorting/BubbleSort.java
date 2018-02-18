package sorting;

public class BubbleSort
{
	public int[] Sort(int[] arr)
	{
		if (arr == null)
			return new int[0];
		
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length-1; j++)
			{
				if (arr[j -1] > arr[j])
				{   
					int swapValue = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = swapValue;
				}
			}
		}
		
		return arr;
	}
}