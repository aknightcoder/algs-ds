package unionfind;

public class QuickFind 
{
	private int[] id;
	
	public QuickFind(int N)
	{
		id = new int[N];
		
		for (int i = 0; i < id.length; i++)
		{
			id[i] = i;
		}
	}
	
	public boolean connected(int x, int y)
	{
		return id[x] == id[y];
	}
	
	public void union(int x, int y)
	{
		int i = id[x];
		int j = id[y];
		
		for (int k = 0; k < id.length; k++)
		{
			if (id[k] == i)
				id[k] = j;
		}
	}
}
