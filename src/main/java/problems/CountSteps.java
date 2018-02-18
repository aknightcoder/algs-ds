package problems;

public class CountSteps 
{
	public static int CountStepPossibilities(int n)
	{
		if (n < 0)
		{
			return 0;
		}
		else if (n == 0)
		{
			return 1;
		}
		else
		{
			return (CountStepPossibilities(n-1) + CountStepPossibilities(n-2) + CountStepPossibilities(n-3));
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println(CountSteps.CountStepPossibilities(6));
	}
}
