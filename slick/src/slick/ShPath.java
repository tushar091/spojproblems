package slick;

import java.util.HashMap;
import java.util.Scanner;

public class ShPath {
	public static int V = 0;

	/*
	 * returns index of minimum distance vertex
	 */
	int minDistance(int[] dist, Boolean spSet[]) {
		return 0;
	}

	void djiskstra(int graph[][], int src) {
		int dist[] = new int[V];

		Boolean spSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			spSet[i] = false;
		}
		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, spSet);

			for (int v = 0; v < V; v++) {
				if (!spSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v] && dist[v] != Integer.MAX_VALUE) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
		printSolution(dist);

	}
	
	public void printSolution(int[] dist){
		for (int i = 0; i < V; i++)
			System.out.println(i+" \t\t "+dist[i]);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t;
		t = scan.nextInt();
		ShPath sh = new ShPath();
		while (t > 0) {
			t--;
			int n;
			n = scan.nextInt();
			int graph[][] = new int[n][n];
			HashMap<String, Integer> nameInt = new HashMap();
			for (int i = 0; i < n; i++) {
				scan.nextLine();
				String name = scan.nextLine();
				// scan.nextLine();
				nameInt.put(name, i);
				int count = scan.nextInt();
				while (count > 0) {
					count--;
					int a = scan.nextInt();
					int b = scan.nextInt();
					graph[i][a - 1] = b;
				}

			}
			int ra = scan.nextInt();
			scan.nextLine();
			String s = scan.nextLine();
			String[] s1 = s.split(" ");
			sh.V = n;
			for (int i = 0; i < V; i++) {
				sh.djiskstra(graph, i);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(graph[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}

}
