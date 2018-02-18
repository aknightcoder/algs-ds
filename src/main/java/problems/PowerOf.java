package problems;

public class PowerOf 
{
	public double toPower(int x, int y)
	{
		int absY = Math.abs(y);
		
		if (absY <= 1) return x;
		
		double result = 1;

		while (absY > 0)
		{
			if (absY % 2 == 0)
			{
				result *=  x * x;
				
				absY = absY - 2;
			}
			else 
			{
			    result *= x;
	
				absY--;
			}
		}
		
		if (y < 0)
			result = 1/result;
		
		return result;
	}
}
