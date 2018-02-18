package problems;

public class LongestSubSequence 
{
	public static int[] getLargestSubSequence(int[] x)
	{
		int[] p = new int[x.length];
		int[] m = new int[x.length+1];
	
		int l = 0;
		int newLo = 0;
		for (int i = 0; i < x.length; i++)
		{
			int lo = 1;
			int hi = l;
			
			while (lo < hi)
			{
				int mid = (lo+hi)/2;
				if (x[m[mid]] < x[i])
					lo = mid+1;
				else
					lo = mid -1;
			}
			
			newLo = lo;
			
			p[i] = m[newLo - 1];
			m[newLo] = i;
			
			if (newLo > l)
				l = newLo;
				
		}
		
		int[] s = new int[l];
		int k = m[l];
		
		for (int i = l-1; l > 0; l--)
		{
			s[i] = x[k];
			k = p[k];
		}
		
		return s;
	}
	
	public static int getLis(int[] a, int start)
    {
        int max = 1;
        int subMax = 1;
        for (int i = start + 1; i < a.length; i++)
        {
            subMax = getLis(a, i + 1);
            if (a[i - 1] < a[i] && subMax + 1 > max)
            {
                max = subMax + 1;
            }
        }

        if (subMax > max)
            max = subMax;

        return max;
    }
	
	public static void main(String[] args) 
	{
		//int[] arr = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 153};
		int[] arr = new int[] {1,3,5,2,4,6,9};
		int max = 1;
		max = LongestSubSequence.getLis(arr, 0);
		
		System.out.println(max);
	}
}
