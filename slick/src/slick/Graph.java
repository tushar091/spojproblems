package slick;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	private int V;
	private LinkedList<Integer> adj[];
	
	public Graph(int v){
		V = v;
		adj = new LinkedList[V];
		for(int i = 0;i<v;i++){
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v,int w){
		adj[v].add(w);
	}
	
	void dfsUtil(int v,boolean visited[]){
		visited[v] = true;
		
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()){
			v = i.next();
			if(!visited[v]){
				dfsUtil(v,visited);
			}
		}
		
	}
	
	int dfs(){
		boolean[] visited = new boolean[V];
		int c = 0;
		for(int i = 0;i<V;i++){
			if(!visited[i]){
				c++;
				dfsUtil(i,visited);
			}
		}
		return c;
	}
	
	public static void main(String args[]){
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j=0;j<m;j++){
				arr[i][j] = reader.nextInt();
			}
		}
		System.out.println(n + " " + m);
		Graph g = new Graph(m*n + 1);
		int count = 0;
		for(int i = 0;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j] == 1){
					g.addEdge(i*j + i + n, i*j + i + n);
				}
				if(i< m-1 && arr[i+1][j] == 1){
					g.addEdge((i)*j + i + n, (i+1)*j + i + n);
				}
				if(j < n-1 && arr[i][j+1] == 1){
					g.addEdge((i)*j + i + n, (i)*(j+1) + i + n);
				}
				if(i>0 && arr[i-1][j] == 1){
					g.addEdge((i)*j + i + n, (i-1)*j + i + n);
				}
				if(j>0 && arr[i][j-1] == 1){
					g.addEdge((i)*(j) + i + n, i*(j-1) + i + n);
				}
			}
		}
		int ct = g.dfs();
		System.out.println(" ct  = " +  ct);
	}
	
}


