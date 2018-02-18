package problems;

public class PaperSheafs 
{
	public static void findMissingPage(int[] arr)
	{
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
		    if (arr[i] == 0) {
		         idx = i; 
		    } else {
		         sum += arr[i];
		    }
		}

		// the total sum of numbers between 1 and arr.length.
		int total = (arr.length + 1) * arr.length / 2;

		System.out.println("missing number is: " + (total - sum));
	}	
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {1, 2 , 3, 0, 5, 0, 7, 8, 9, 10};
		
		PaperSheafs.findMissingPage(arr);
	}
}
