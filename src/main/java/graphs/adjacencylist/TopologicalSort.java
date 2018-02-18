package graphs.adjacencylist;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort 
{
	private boolean[] marked;
	private Graph graph;
	private Stack<Integer> postorder;
	
	public TopologicalSort(Graph G)
	{
		graph = G;
		marked = new boolean[G.V()];
		postorder = new Stack<Integer>();
	}
	
	public Iterable<Integer> reversePost()
	{
		return postorder;
	}
	
	public void topologicalSort()
	{
		for (int i = 0; i < graph.V(); i++)
		{
			if (!marked[i])
				topologicalSort(i);
		}
	}

	private void topologicalSort(int vertex) 
	{
		marked[vertex] = true;
		
		Iterator<Integer> iterator = (Iterator<Integer>) graph.adj(vertex);
		while(iterator.hasNext())
		{
			int nextVertex = iterator.next();
			if (!marked[nextVertex])
		    {
				topologicalSort(nextVertex);
		    }
		}
		
		postorder.add(vertex);
	}
}
