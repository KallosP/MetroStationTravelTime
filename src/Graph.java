import java.util.*;

public class Graph {
	// An array of lists of Edge objects
	LinkedList<Edge> G[];
	int numVerteces;

	// Parameterized constructor
	public Graph(int n) 
	{
		this.numVerteces = n;
		
		G = new LinkedList[n];
		
		for(int i = 0; i < n; ++i) 
		{
			G[i] = new LinkedList<>();
		}
		
	}

	// Check if node U is connected to node V
	public boolean isConnected(int u, int v) 
	{
		for(int j = 0; j < G[u].size(); ++j) 
		{
			if(G[u].get(j).v == v)
			{
				return true;
			}
		}
		return false;
	}

	// For node U, add a new connection to node V, with weight W
	// Also add the reverse connection so our Graph is undirected
	public void addEdge(int u, int v, int w) 
	{
		G[u].add(new Edge(v, w));
		G[v].add(new Edge(u, w));
	}

	// Override the java default toString() method so we can print
	// our Graph in the format we want
	@Override
	public String toString() 
	{
		for (int i = 0; i < numVerteces; i++) 
		{
            if(G[i].size() > 0) 
            {
                System.out.print("Vertex " + i + " is connected to: ");
                
                for (int j = 0; j < G[i].size(); j++) 
                {
                    System.out.print(G[i].get(j) + " ");
                }
                
                System.out.println();
            }
        }
		return "";
	}
	
	/**
	 * Description: The first element of the path ArrayList corresponds to the starting vertex
	 * 				and the last element corresponds to the final vertex. All other elements 
	 * 				correspond to the vertex/vertices in between the starting and ending vertices.
	 * 				Any invalid paths result in an edge weight of 0.
	 * 
	 * @param path - Receives a desired path
	 */
	public int calculateTravelTime(ArrayList<Integer> path) 
	{
		
		int travelTime = 0;
		
		for(int i = 0; i < path.size(); ++i) 
		{

			int edgeWeight = 0;
				
			if(i == path.size() - 1) {
				break;
			}
			
			for(int j = 0; j < G[path.get(i)].size(); ++j) 
			{
				if(G[path.get(i)].get(j).v == path.get(i + 1))
				{
					edgeWeight = G[path.get(i)].get(j).w;
					break;
				}
			}
			
			travelTime += edgeWeight;
		}
		
		return travelTime;
	}
	
}
