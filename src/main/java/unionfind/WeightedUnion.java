package unionfind;

public class WeightedUnion 
{
	private int[] id; //values represent parents
	private int[] size;
	
	public WeightedUnion(int N)
	{
		id = new int[N];
		size = new int[N];
		
		for (int i = 0; i < id.length; i++) id[i] = i;
		for (int i = 0; i < size.length; i++) size[i] = 1;
	}
	
	public boolean connected(int x, int y)
	{
		return root(x) == root(y);
	}
	
	public void union(int x, int y)
	{
	    int i = root(x);
	    int j = root(y);
	    
	    if (i == j) return;
	    
	    if (size[i] < size[j])
	    {
	    	id[i] =  j;
	    	size[i] += size[j];
	    }
	    else 
	    {
	    	id[j] =  i;
	    	size[j] += size[i];
	    }
	}
	
	private int root(int i)
	{
		while (i != id[i]) i = id[i];
		
		return i;
	}
}
