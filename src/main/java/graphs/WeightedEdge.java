package graphs;

public class WeightedEdge implements Comparable<WeightedEdge>
{
	private final int x, y;

	
	private final double weight;
	
	public WeightedEdge(int x, int y, double weight)
	{
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
	
	public int either()
	{ 
		return this.x;
	}
	
	public int other (int vertex)
	{
		return (vertex == this.x ? this.y : this.x);
	}

	public int compareTo(WeightedEdge edge) 
	{
		if (this.weight < edge.weight)
			return -1;
		else if (this.weight > edge.weight)
			return 1;
		
		return 0;
	}
	
	
}
