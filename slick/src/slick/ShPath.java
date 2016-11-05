package slick;

public class ShPath {
	public static int V = 0;
	
	int minDistance(int[] dist,Boolean spSet[]){
		return 0;
	}
	
	void djiskstra(int graph[][],int src){
		int dist[] = new int[V]; 
		
		Boolean spSet[] = new Boolean[V];
		
		for(int i = 0;i<V;i++){
			dist[i] = Integer.MAX_VALUE;
			spSet[i] = false;
		}
		dist[src] = 0;
		
		for(int count = 0;count<V-1;count++){
			int u = minDistance(dist,spSet);
			
			for(int v = 0;v<V;v++){
				if(!spSet[v] && graph[u][v] != 0 && )
			}
		}
		
		
	}
	
	
	public static void main(String[] args){
		
	}

}
