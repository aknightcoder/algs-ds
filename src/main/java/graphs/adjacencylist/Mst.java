package graphs.adjacencylist;

import java.util.LinkedList;
import java.util.Queue;

import com.aknightcoder.ds.graphs.WeightedEdge;
import com.aknightcoder.ds.priorityqueue.MinPQ;
import com.aknightcoder.ds.uf.QuickUnion;

public class Mst 
{
	private final EdgeWeightedUndirectedGraph graph;
	
	private Queue<WeightedEdge> mst = new LinkedList<WeightedEdge>();
	
	public Mst(EdgeWeightedUndirectedGraph graph)
	{
		this.graph = graph;
		
		MinPQ<WeightedEdge> pq = new MinPQ<WeightedEdge>(graph.V());
		
		QuickUnion uf = new QuickUnion(graph.V());

		for (WeightedEdge edge : graph.edges())
		{
			pq.insert(edge);
		}
		
		while (!pq.isEmpty() && mst.size() < graph.V()-1)
		{
			WeightedEdge edge = pq.delMin();
			
			int v = edge.either();
			int w = edge.other(v);
			
			if (!uf.connected(v, w))
			{
				uf.union(v, w);
				mst.add(edge);
			}
		}
	}
	
	public Iterable<WeightedEdge> edges()
	{
		return mst;
	}
}
