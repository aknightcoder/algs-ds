package sorting;

public class QuickSort
{
	public int[] sort(int[] arr)
	{
		sort(arr, 0, arr.length -1);
		
		return arr;
	}
	
	private void sort(int[] arr, int lo, int hi)
	{
		if (hi <= lo)
			return;
		
		int mid = partitionArray(arr, lo, hi);
		
		sort(arr, lo, mid - 1);
		
		sort(arr, mid + 1, hi);
	}
	
	private int partitionArray(int[] arr, int lo, int hi)
	{
		int leftPointer = lo;
		
		int rightPointer = hi + 1;
		
		while (true)
		{
			while (arr[++leftPointer] < arr[lo])
			{
				if (leftPointer == hi)
					break;
			}
			
			while (arr[--rightPointer] > arr[lo])
			{
				if (rightPointer == lo)
					break;
			}
			
			if (leftPointer >= rightPointer)
				break;
			
			swapValue(arr, leftPointer, rightPointer);
		}
		
		swapValue(arr, lo, rightPointer);
		
		return rightPointer;
	}
	
	private void swapValue(int[] arr, int left, int right)
	{
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}