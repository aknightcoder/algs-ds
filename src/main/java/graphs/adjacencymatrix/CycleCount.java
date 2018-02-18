package graphs.adjacencymatrix;

import java.util.Stack;

public class CycleCount
{
	private Graph graph;
	private boolean[] marked;
	private boolean hasCycle;
	
	public CycleCount(Graph graph)
	{
		this.graph = graph;
		this.marked = new boolean[graph.V()];
	}
	
	public boolean HasCycle(int vertex)
	{
		dfs(vertex);
		
		return this.hasCycle;
	}
	
	private void dfs(int vertex)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int[] parents = new int[graph.V()];
		
		stack.push(vertex);
		while (!stack.isEmpty())
		{
			int currentVertex = stack.pop();
			marked[currentVertex] = true;
			for (int nextVertex : graph.adj(currentVertex))
			{
				if (!marked[nextVertex])
				{
					marked[nextVertex] = true;
					stack.push(nextVertex);
					parents[nextVertex]	= currentVertex;
				}
				else if (parents[currentVertex] != currentVertex)
				{
					this.hasCycle = true;
				}	
			}
			
		}
	}
}
