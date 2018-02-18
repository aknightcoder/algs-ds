package graphs;

public class DirectedWeightedEdge implements Comparable<DirectedWeightedEdge>
{
	private final int v, w;
	
	private final double weight;
	
	public DirectedWeightedEdge(int v, int w, double weight)
	{
		this.v = v;

		this.w = w;

		this.weight = weight;
	}
	
	public int from()
	{
		return this.v;
	}
	
	public int to()
	{
		return this.w;
	}
	
	public double weight()
	{
		return this.weight;
	}

	public int compareTo(DirectedWeightedEdge o) 
	{
		return (this.weight < o.weight ? -1 : 1);
	}
}
