package slick;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

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
	
	void printEdgeList(){
		for(int i = 0;i<adj.length;i++){
			Iterator<Integer> it = adj[i].listIterator();
			System.out.print(i + " ");
			while(it.hasNext()){
				int v = it.next();
				System.out.print(v + " ");
			}
			System.out.println(" ");
		}
	}
	int count = 0;
	void dfsUtil(int v,boolean visited[]){
		visited[v] = true;
		count++;
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()){
			v = i.next();
			if(!visited[v]){
				dfsUtil(v,visited);
			}
		}
		
	}
	private static HashMap<Integer,Integer> countMap = new HashMap();
	int dfs(){
		boolean[] visited = new boolean[V];
		int c = 0;
		for(int i = 1;i<V;i++){
			if(!visited[i]){
				c++;
				dfsUtil(i,visited);
				if(countMap.get(count) != null){
					int a = countMap.get(count);
					a = a + 1;
					countMap.put(count, a);
				}else{
					countMap.put(count, 1);
				}
				count = 0;
			}
		}
		return c;
	}
	
	public static void main(String args[]){
		while(true){
			Scanner reader = new Scanner(System.in);
			while(true){
			int n = reader.nextInt();
			int m = reader.nextInt();
			if(n == 0 && m == 0){
				break;
			}
			int v = 1;
			int[][] arr = new int[n][m];
			for(int i = 0;i<n;i++){
				for(int j=0;j<m;j++){
					arr[i][j] = reader.nextInt();
					if(arr[i][j] == 1){
						arr[i][j] = v++;
					}
				}
			}
			Graph g = new Graph(v);
			int count = 0;
			for(int i = 0;i<n;i++){
				for(int j = 0;j<m;j++){
					if(arr[i][j] >= 1){
						g.addEdge(arr[i][j], arr[i][j]);
						if(i< m-1 && arr[i+1][j] >= 1){
							g.addEdge(arr[i][j], arr[i+1][j]);
							//System.out.println("add edge " + arr[i][j] + " " + arr[i+1][j]);
						}
						if(j < n-1 && arr[i][j+1] >= 1){
							g.addEdge(arr[i][j], arr[i][j+1]);
							//System.out.println("add edge " + arr[i][j] + " " + arr[i][j+1]);
						}
						if(i>0 && arr[i-1][j] >= 1){
							g.addEdge(arr[i][j], arr[i-1][j]);
							//System.out.println("add edge " + arr[i][j] + " " + arr[i-1][j]);
						}
						if(j>0 && arr[i][j-1] >= 1){
							g.addEdge(arr[i][j], arr[i][j-1]);
							//System.out.println("add edge " + arr[i][j] + " " + arr[i][j-1]);
						}
					}
				}
			}
			//g.printEdgeList();
			int ct = g.dfs();
			System.out.println(ct);
			Map<Integer, Integer> map = new TreeMap<Integer, Integer>(countMap);
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				  int key = entry.getKey();
				  int value = entry.getValue();
				  System.out.println(key + " " + value);
			}
			countMap.clear();
		}
		}
	}
	
}


