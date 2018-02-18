package sorting;

public class MergeSort {
	
	public int[] sort(int[] arr)
	{
		int[] aux = new int[arr.length];
		
		sort(arr, aux, 0, arr.length - 1);
		
		return arr;
	}
	
	private void sort(int[] arr, int[] aux, int lo, int hi)
	{
		if (hi <= lo)
			return;
		
		int mid = lo + (hi - lo) / 2;
		
		sort(arr, aux, lo, mid - 1);
		
		sort(arr, aux, mid + 1, hi);
		
		merge(arr, aux, lo, mid, hi);
	}
	
	private void merge(int[] arr, int[] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++)
			aux[k] = arr[k];
				
		int i = lo;
		int j = mid + 1;
		for (int k = i; k <= hi; k++)
		{
			if (i > mid)
			{
				arr[k] = aux[j++];
			}
			else if (j < mid)
			{
				arr[k] = aux[i++];
			}
			else if (arr[j] < arr[i])
			{
				arr[k] = arr[j++];
			}
			else 
			{
				arr[k] = arr[i++];
			}
		}
	}
}