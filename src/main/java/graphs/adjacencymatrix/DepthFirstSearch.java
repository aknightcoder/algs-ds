package graphs.adjacencymatrix;

import java.util.*;

public class DepthFirstSearch
{
	private boolean[] marked;

	private Graph graph;
	
	public DepthFirstSearch(Graph G)
	{
		graph = G;
		marked = new boolean[G.V()];
	}

	public List<Integer> dfs(int vertex) 
	{
		List<Integer> vertices = new ArrayList<Integer>();
		
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(vertex);
	    
	    while (!stack.isEmpty()) {
	        Integer v = stack.pop();
	        if (!marked[v]) {
	            marked[v] = true;
	            vertices.add(v);
	            for (int w : graph.adj(v))
	            {
	                stack.push(w);
	            }
	        }
	    }
	    
	    return vertices;
	}
	
	public List<Integer> dfs(int vertex, boolean[] marked) 
	{
		List<Integer> vertices = new ArrayList<Integer>();
		
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(vertex);

	    while (!stack.isEmpty()) {
	        Integer v = stack.pop();
	        if (!marked[v]) {
	            marked[v] = true;
	            vertices.add(v);
	            for (int w : graph.adj(v))
	            {
	                stack.push(w);
	            }
	        }
	    }
	    
	    return vertices;
	}
}
