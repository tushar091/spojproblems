package slick;

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
		
	}
	
	void dfs(){
		
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
		for(int i = 0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.println(arr[i][j] + " ");
			}
		}
		Graph g = new Graph(m*n);
		int count = 0;
		for(int i = 0;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j] == 1){
					g.addEdge(i*j + i + n, i*j + i + n);
				}
				if(i< m-1 && arr[i+1][j] == 1){
					g.addEdge((i)*j + i + n, (i+1)*j + i + n);
				}
				if(j <= n-1 && arr[i+1][j] == 1){
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
		
	}
	
}


