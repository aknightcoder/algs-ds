package graphs.adjacencymatrix;


public class ConnectedComponents 
{
	private Graph graph;
	Dfs matrixDfs;
	boolean[] marked;
	
	public ConnectedComponents(Graph graph)
	{
		this.graph = graph;
		this.matrixDfs = new Dfs(graph);
		this.marked = new boolean [graph.V()];
	}
	
	public int getConnectedComponentCount()
	{
		int componentCount = 0;
		for (int vertex = 0; vertex < this.graph.V(); vertex++)
		{
			if (!marked[vertex])
			{   
				this.matrixDfs.dfs(vertex, marked);
				componentCount++;
			}
		}
		
		return componentCount;
	}
}
