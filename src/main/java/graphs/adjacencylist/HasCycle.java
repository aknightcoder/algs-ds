package graphs.adjacencylist;

import java.util.Iterator;
import java.util.Stack;

public class HasCycle 
{
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> stack;
	private boolean hasCycle;
	
	private Graph graph;
	
	public HasCycle(Graph adjacencyListGraph)
	{
		graph = adjacencyListGraph;
		marked = new boolean[adjacencyListGraph.V()];
		stack = new Stack<Integer>();
		
		initializeEdgeTo();
	}
	
	private void initializeEdgeTo()
	{
		edgeTo = new int[graph.V()];
		
		for (int i = 0; i < edgeTo.length; i++)
			edgeTo[i] = -1;
	}
	
	public boolean hasCycle(int vertex) 
	{
	    Stack<Integer> localStack = new Stack<Integer>();
	    
	    localStack.push(vertex);
	    
	    while (!localStack.isEmpty()) 
	    {
	        Integer currentVertex = localStack.pop();
	        
	        marked[currentVertex] = true;
 
	        Iterator<Integer> iterator = (Iterator<Integer>) graph.adj(currentVertex);
	        while(iterator.hasNext())
	        {
	            int adjacentVertex = iterator.next();
	            if (!marked[adjacentVertex]) 
	    	    {
	            	edgeTo[adjacentVertex] = currentVertex;
	            	localStack.push(adjacentVertex);
	    	    }
	            else if(adjacentVertex != edgeTo[currentVertex])
	    	    {
	    	        return true;
	    	    }
	        }
	    }
	    
	    return false;
	}
	
	public void hasCycleRecursive(int vertex, int parentVertex)
	{
		marked[vertex] = true;
		
		Iterator<Integer> iterator = (Iterator<Integer>) graph.adj(vertex);
		while(iterator.hasNext())
		{
			int nextVertex = iterator.next();
			if (!marked[nextVertex])
		    {
				hasCycleRecursive(nextVertex, vertex);
		    }
			else if (nextVertex != parentVertex)
    	    {
    	        hasCycle = true;
    	    }
		}
	}
	
	public boolean getHasCycle()
	{
		return hasCycle;
	}
}
