package graphs.adjacencylist;

import java.util.Stack;

import com.aknightcoder.ds.graphs.DirectedWeightedEdge;

public class EdgeWeightedDiGraph 
{
	private final int v;
	private final Stack<DirectedWeightedEdge>[] adj;
	
	public EdgeWeightedDiGraph(int v)
	{
		this.v = v;
		this.adj = (Stack<DirectedWeightedEdge>[]) new Stack[v];
		
		for (int i = 0; i < V(); i++)
        {
        	adj[i] = new Stack<DirectedWeightedEdge>();
        }
	}
	
	public int V()
	{
		return v;
	}
	
	public void addEdge(DirectedWeightedEdge edge)
	{
		adj[edge.from()].add(edge);
	}
	
	public Iterable<DirectedWeightedEdge> adj(int v)
	{
		return adj[v];
	}
}
