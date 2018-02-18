package graphs.adjacencymatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	boolean[] marked;
	private Graph graph;
	
	public BreadthFirstSearch(Graph G)
	{
		graph = G;
		marked = new boolean[G.V()];
	}

	public List<Integer> bfs(int vertex) 
	{
		List<Integer> vertices = new ArrayList<Integer>();
		
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.add(vertex);
	    
	    while (!queue.isEmpty()) {
	        Integer v = queue.remove();
	        if (!marked[v]) {
	            marked[v] = true;
	            vertices.add(v);
	            for (int w : graph.adj(v))
	            {
	                queue.add(w);
	            }
	        }
	    }
	    
	    return vertices;
	}
}
