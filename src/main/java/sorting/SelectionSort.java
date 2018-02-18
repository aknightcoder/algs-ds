package sorting;

public class SelectionSort
{
	public int[] Sort(int[] sourceArray)
	{
		for (int outerIndex = 0; outerIndex < sourceArray.length; outerIndex++)
		{
			int min = outerIndex;
			for (int innerIndex = outerIndex+1;  innerIndex < sourceArray.length; innerIndex++)
			{
				if (sourceArray[innerIndex] < sourceArray[min])
				{
					min = innerIndex;
				}
			}
			
			int swapValue = sourceArray[outerIndex];
			sourceArray[outerIndex] = sourceArray[min];
		    sourceArray[min] = swapValue;
		}
		
		return sourceArray;
	}
}