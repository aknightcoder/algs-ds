package graphs.adjacencylist;

import java.util.Stack;

import com.aknightcoder.ds.graphs.DirectedWeightedEdge;
import com.aknightcoder.ds.priorityqueue.IndexedMinPQ;

public class ShortestPaths 
{
	private final EdgeWeightedDiGraph graph;
	
	private double[] distanceTo;
	
	private DirectedWeightedEdge[] edgeTo;
	
	private IndexedMinPQ<Double> pq;
	
	public ShortestPaths(EdgeWeightedDiGraph graph, int source)
	{
		this.graph = graph;
		
		distanceTo = new double[graph.V()];
		
		edgeTo = new DirectedWeightedEdge[graph.V()];
		
		pq = new IndexedMinPQ<Double>(graph.V());
		
		for (int i = 0; i < graph.V(); i++)
			distanceTo[i] = Double.POSITIVE_INFINITY;
		
		distanceTo[source] = 0.0;
		
		pq.insert(source, distanceTo[source]);
		
		while (!pq.isEmpty())
		{
			int vertex = pq.delMin();
			
			for (DirectedWeightedEdge edge : graph.adj(vertex))
			{
				relax(edge);
			}
		}
	}
	
	public double distanceTo(int v)
	{
		return distanceTo[v];
	}
	
	public Iterable<DirectedWeightedEdge> pathTo(int v)
	{
		Stack<DirectedWeightedEdge> path = new Stack<DirectedWeightedEdge>();
		
		for(DirectedWeightedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		
		return path;
	}
	
	private void relax(DirectedWeightedEdge e)
	{
		int v = e.from();
		int w = e.to();
		
		if (distanceTo[w] > distanceTo[v] + e.weight())
		{
			distanceTo[w] = distanceTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w))
			{
				pq.decreaseKey(w, distanceTo[w]);
			}
			else{
				pq.insert(w, e.weight());
			}
		}
	}
}
