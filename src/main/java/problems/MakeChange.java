package problems;

public class MakeChange 
{
	public static int makeChange(int amount, int[] denominations, int index, int[][] map)
	{
		if (index == denominations.length-1)
			return 1;
		
		int denominationValue = denominations[index];
		
		int ways = 0;
		for (int i = 0; i * denominationValue <= amount; i++)
		{
			int remainingAmount = amount - (1 * denominationValue);
			
			ways+=makeChange(remainingAmount, denominations, index+1, map);
		}
		
		return ways;
	}
	
	public static void main(String[] args) 
	{
		int[] dem = new int[]{ 25, 10, 5, 1};
		int[][] map = new int[100+1][dem.length+1];
				
		double result = MakeChange.makeChange(100, dem, 0, map);
		
		System.out.println("Result: " + result);
	}
}
