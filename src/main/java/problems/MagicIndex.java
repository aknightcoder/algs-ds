package problems;

// chapter 9 cracking the coding interview
public class MagicIndex 
{
	public int findMagicArrayIndexWithDistinctValues(int[] arr, int start, int end)
	{
		if (start < 0 || end < start || end >= arr.length)
			return -1;
		
		int mid = (start + end) / 2;
		
		if (arr[mid] == mid)
		{
			return mid;
		}
		else if (arr[mid] < mid)
		{
			return findMagicArrayIndexWithDistinctValues(arr, mid+1, end); // if mid value < mid index move right
		}
		else
		{
			return findMagicArrayIndexWithDistinctValues(arr, start, mid-1); // if mid value > mid index move left
		}
	}
	
	public int findMagicArrayIndex(int[] arr, int start, int end)
	{
		if (start < 0 || end < start || end >= arr.length)
			return -1;
		
		int midIndex = (start + end) / 2;
		
		int midValue = arr[midIndex];
		
		if (midValue == midIndex)
		{
			return midIndex;
		}

		int leftIndex = Math.min(midIndex-1, midValue);
		int left = findMagicArrayIndex(arr, leftIndex, end); // if mid value < mid index move right
		
		if (left >= 0)
			return left;
	
		int rightIndex = Math.max(midIndex+1, midValue);
		int right = findMagicArrayIndex(arr, start, rightIndex); // if mid value > mid index move left
		
		return right;
	}
}
