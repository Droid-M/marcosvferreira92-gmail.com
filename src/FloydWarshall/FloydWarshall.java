
package FloydWarshall;

/**
 *
 * @author Adryel
 */
class AllPairShortestPath 
{ 
    final static int INF = 99999;
    
  
    void floydWarshall(int graph[][], int V) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
        
        for (k = 0; k < V; k++) 
        { 
            
            for (i = 0; i < V; i++) 
            { 
               
                for (j = 0; j < V; j++) 
                { 
                    
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        }
    }
 } 
