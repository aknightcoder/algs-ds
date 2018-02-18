package sorting;

public class InsertionSort {

	public int[] sort(int[] inputArray)
	{
		int i,j;

		for (i = 1; i < inputArray.length; i++)
		{
			j = i;
			
			while (j > 0 && inputArray[j] < inputArray[j-1])
			{
				swapValues(inputArray, j, j - 1);
				j = j - 1;
			}
		}

		return inputArray;
	}
	
	private void swapValues(int[] inputArray, int right, int left)
	{
		int tempValue = inputArray[right];
		
		inputArray[right] = inputArray[left];
		
		inputArray[left] = tempValue;
	}
}
