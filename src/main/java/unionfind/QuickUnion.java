package unionfind;

public class QuickUnion 
{
	private int[] id;
	
	public QuickUnion(int N)
	{
		id = new int[N];
		
		for (int i = 0; i < id.length; i++) id[i] = i;
	}
	
	public boolean connected(int x, int y)
	{
		return root(x) == root(y);
	}
	
	public void union(int x, int y)
	{
		int i = root(x);
		int j = root(y);
		
		id[i] = j;
	}
	
	private int root(int i)
	{
		while (i != id[i])
			i = id[i];
		
		return i;
	}
}
