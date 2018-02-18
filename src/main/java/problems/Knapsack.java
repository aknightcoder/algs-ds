package problems;

/* 
 * 	The knapsack problem is a problem in combinatorial optimization: 
 * 	Given a set of items, each with a mass and a value, determine the number of each item to include 
 *  in a collection so that the total weight is less than or equal to a given limit 
 *  and the total value is as large as possible. 
 * */
public class Knapsack 
{
	public static double fillKnapsack(int[] wt, int[] val, int maxWeight)
	{
		int n = wt.length;
		int[][] v = new int[n+1][maxWeight+1];
		
		for (int item = 1; item <= n; item++)
		{
			for (int weight = 1; weight <=maxWeight; weight++)
			{
				if (wt[item-1] <= weight)
				{
					v[item][weight] = Math.max(val[item-1]+v[item-1][weight-wt[item-1]], v[item-1][weight]);
				}
				else
				{
					v[item][weight] = v[item-1][weight];
				}
			}
		}
		
		return v[n][maxWeight];
	}
	
	public static void main(String[] args) 
	{
		int val[] = {10, 40, 30, 50};
		int wt[] = {5, 4, 6, 3};
		int W = 10;

		double max = Knapsack.fillKnapsack(wt,val,W);
		System.out.printf("Max:"+ max);
	}
}
