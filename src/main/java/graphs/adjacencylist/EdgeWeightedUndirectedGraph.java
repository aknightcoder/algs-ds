package graphs.adjacencylist;

import java.util.ArrayList;
import java.util.Stack;

import com.aknightcoder.ds.graphs.WeightedEdge;

public class EdgeWeightedUndirectedGraph 
{
	private final int  V;
	private int E;
	private Stack<WeightedEdge>[] adj;
	 
	public EdgeWeightedUndirectedGraph(int vertexCount)
	{
		this.V = vertexCount;
		this.E = 0;
		
		initialiseLists();
	}
	
	private void initialiseLists() 
	{
		this.adj = (Stack<WeightedEdge>[]) new Stack[V];
		
        for (int i = 0; i < V; i++)
        {
        	adj[i] = new Stack<WeightedEdge>();
        }
	}

	public Iterable<WeightedEdge> adj(int vertex)
	{
		return adj[vertex];
	}
	
	public void addEdge(WeightedEdge edge)
	{
		E++;
		int x = edge.either();
		int y = edge.other(x);
		
		adj[x].add(edge);
		adj[y].add(edge);
	}
	
	public int V()
	{
		return V;
	}
	
	public int E()
	{
		return E;
	}
	
	public Iterable<WeightedEdge> edges()
	{
		ArrayList<WeightedEdge> list = new ArrayList<WeightedEdge>();
		
		for (int vertex = 0; vertex < V(); vertex++)
		{
			int selfLoops = 0;
			for (WeightedEdge edge : adj(vertex))
			{
				if (edge.other(vertex) > 0)
				{
					list.add(edge);
				} 
				else if (edge.other(vertex) == vertex)
				{
					if (selfLoops % 2 == 0) list.add(edge);
					selfLoops++;
				}
			}
		}
		
		return list;
	}

}
