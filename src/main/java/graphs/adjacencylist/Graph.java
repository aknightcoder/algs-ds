package graphs.adjacencylist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	public boolean IsDirected;
	
    private int V;
    private int E;
    private Stack<Integer>[] adj;

    public Graph(int V) 
    {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        
        this.V = V;
        this.E = 0;
        
        initialiseLists(V);
    }

	private void initialiseLists(int V) 
	{
		this.adj = (Stack<Integer>[]) new Stack[V];
		
        for (int i = 0; i < V; i++)
        {
        	adj[i] = new Stack<Integer>();
        }
	}

    public int V() { return V; }
    
    public int E() { return E; }

    public void addEdge(int v, int w) 
    {
    	if (adj[v].isEmpty()) E++;
        
        adj[v].add(w);
        
        if (!IsDirected)
        	adj[w].add(v);
    }

    public boolean contains(int v, int w) {
        return adj[v].contains(w);
    }

    public Iterator<Integer> adj(int v) 
    {
        return adj[v].iterator();
    }
}