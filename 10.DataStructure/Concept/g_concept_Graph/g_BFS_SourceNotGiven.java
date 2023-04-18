package g_concept_Graph;

public class g_BFS_SourceNotGiven {
	public static void createEdge(java.util.ArrayList<java.util.ArrayList<Integer>> adj , int x , int y) {
		adj.get(x).add(y);
		adj.get(y).add(x);
	}
	public static void creatingList() {
		int size = 7;
		
//		java.util.ArrayList<java.util.ArrayList<Integer>> adj = new java.util.ArrayList<java.util.ArrayList<Integer>>(size);
		java.util.ArrayList<java.util.ArrayList<Integer>> adj = new java.util.ArrayList<java.util.ArrayList<Integer>>(size);
		
		for(int i=0 ; i<size ; i++) {
			adj.add(new java.util.ArrayList<Integer>());
		}
		
		createEdge(adj, 0, 1);
		createEdge(adj, 0, 2);
		createEdge(adj, 1, 3);
		createEdge(adj, 2, 3);
		createEdge(adj, 3, 5);
		createEdge(adj, 3, 6);
		createEdge(adj, 3, 4);
		
//		show(adj);
		
		startingBFS(adj);
	}
	
//	Displaying the Data
	public static void show(java.util.ArrayList<java.util.ArrayList<Integer>> adj) {
		for(int i=0 ; i<adj.size() ; i++) {
			System.out.print(i+" ==> ");
			for(int j=0 ; j<adj.get(i).size() ; j++) {
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
//	Breadth First Search when Source is not given
	public static void startingBFS(java.util.ArrayList<java.util.ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		for(int i=0 ; i<adj.size() ; i++) {
			if(visited[i]==false) {
				deapthFirstSearch(adj, i, visited);
			}
		}
	}
	
	public static void deapthFirstSearch(java.util.ArrayList<java.util.ArrayList<Integer>> adj , int source , boolean[] visited) {
		java.util.Queue<Integer> queue = new java.util.LinkedList<>();
		visited[source] = true;
		queue.add(source);
		while(queue.isEmpty()==false) {
			int u = queue.poll();
			System.out.print(u+" ");
			for(int i=0 ; i<adj.get(u).size() ; i++) {
				if(visited[adj.get(u).get(i)]==false) {
					System.out.print(adj.get(u).get(i));
					visited[adj.get(u).get(i)] = true;
				}
				System.out.println();
			}
		}	
	}
	
	public static void main(String[] args) {
		creatingList();
	}
}
