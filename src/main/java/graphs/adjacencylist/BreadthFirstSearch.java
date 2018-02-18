package graphs.adjacencylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch
{
	private boolean[] marked;
	
	private Graph graph;
	
	public BreadthFirstSearch(Graph G)
	{
		graph = G;

		marked = new boolean[G.V()];
	}

	public List<Integer> bfs(int startVertex) 
	{
		List<Integer> vertices = new ArrayList<Integer>();
		
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    
	    queue.add(startVertex);

	    while (!queue.isEmpty()) 
	    {
	        Integer vertex = queue.poll();
	        
	        if (!marked[vertex])
	        {
	            marked[vertex] = true;
	            
	            vertices.add(vertex);
	            
	            Iterator<Integer> iterator = (Iterator<Integer>) graph.adj(vertex);
	            
	            while(iterator.hasNext())
	            {
	            	queue.add(iterator.next());
	            }
	        }
	    }
	    
	    return vertices;
	}
}
