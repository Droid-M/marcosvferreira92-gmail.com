
package FloydWarshall;

/**
 *
 * @author Adryel
 */
class FloydWarsall {

    final static int V = 1000;
    
    /**
     * Método de encontrar o menor caminho
     * @param graph É a matriz de adjacências
     * @return A matriz de solução do menor caminho
     */ 
    
    public int[][] MenorCaminho(int graph[][]) { 
  
        int dist[][] = new int[V][V]; 
        int i, j, k; 
        
        for (i = 0; i < V; i++) // Criando um clone da matriz original
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
        return graph;
    }
 } 
