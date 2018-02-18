package problems;

public class SingleCycle 
{
	public static boolean HasSingleCyle(int[] arr)
	{
		int idx = 0;
		for (int i = 0; i < arr.length; i++)
		{
			idx = arr[idx] + i % arr.length;
			
			if (idx < 0 || idx > arr.length-1)
				System.out.println("Invalid idx");
		}
		return idx == arr[0]+0 % arr.length;
	}
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {1, 1, 1, 1, 1, -3};
		
		boolean result = SingleCycle.HasSingleCyle(arr);
		
		System.out.println(result);
	}
}
