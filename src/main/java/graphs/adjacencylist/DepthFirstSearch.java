package graphs.adjacencylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch
{
	private boolean[] marked;
	private Graph graph;
	
	public DepthFirstSearch(Graph G)
	{
		graph = G;

		marked = new boolean[G.V()];
	}

	public List<Integer> dfs(int startVertex) 
	{
		List<Integer> vertices = new ArrayList<Integer>();
		
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    stack.push(startVertex);

	    while (!stack.isEmpty()) 
	    {
	        Integer vertex = stack.pop();
	        
	        if (!marked[vertex])
	        {
	            marked[vertex] = true;
	            
	            vertices.add(vertex);
	            
	            Iterator<Integer> iterator = (Iterator<Integer>) graph.adj(vertex);
	            
	            while(iterator.hasNext())
	            {
	                stack.push(iterator.next());
	            }
	        }
	    }
	    
	    return vertices;
	}
}
