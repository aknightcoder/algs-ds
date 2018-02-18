package problems;

public class BinarySearch 
{
	public static int findValue(int[] arr, int start, int end, int value)
	{
		if (end < start || end > arr.length - 1)
			return -1;
		
		int mid = (start + end) / 2;
		
		if (arr[mid] == value)
		{
			return value;
		}
		else if (arr[mid] < value)
		{
			return findValue(arr, mid + 1, end, value);
		}
		else
		{
			return findValue(arr, start, mid -1, value);
		}
	}
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {1, 2 , 3, 4, 5, 6, 7, 8, 9, 10};
		
		int result = BinarySearch.findValue(arr, 0, arr.length - 1, 7);
		
		System.out.println(result);
	}
}
