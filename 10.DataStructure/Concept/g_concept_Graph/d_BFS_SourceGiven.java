
package g_concept_Graph;
import java.util.*;
class myList
{
	public static void addEdge(ArrayList<ArrayList<Integer>>obj , int u , int v)
	{
		obj.get(u).add(v);
		obj.get(v).add(u);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Number Of Vertices = 8");
		int vertices = 8;
		ArrayList<ArrayList<Integer>> obj = new ArrayList<ArrayList<Integer>>(8);
		for(int i=0 ; i<vertices ; i++)
		{
			obj.add(new ArrayList<Integer>());
		}
//		addList(obj,0,1);
//		addList(obj,0,3);
//		addList(obj,1,2);
//		addList(obj,1,3);
//		addList(obj,2,3);
//		addList(obj,2,6);
//		addList(obj,3,4);
//		addList(obj,3,5);
//		addList(obj,5,7);
//		addList(obj,6,7);
		addEdge(obj,0,1); 
    	addEdge(obj,0,2); 
    	addEdge(obj,1,2); 
    	addEdge(obj,2,3); 
    	addEdge(obj,1,3);
    	addEdge(obj,3,4);
    	addEdge(obj,2,4);
		
//		display(obj);
		bfs(obj,2);
		System.out.println("------------------------");
		breadthFirstSearch(obj,2);
	}
	
	public static void display(ArrayList<ArrayList<Integer>>obj)
	{
		for(int i=0 ; i<obj.size() ; i++)
		{
			System.out.print(i+"--->");
			for(int j=0 ; j<obj.get(i).size() ; j++)
			{
				System.out.print(obj.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
//	1. Ek array Banao Boolean wala. ar Sbko false kr do.
//	2. Fir us Source ko array me True kr do.
//	3. Us array ke elements ko print kr do ar un saare elements ko true kr do.
//	4. Fir ek loop shuru se chalao ar dekho jiska array me false h use print kr do ar baaki ko print k=mt kro!.
	
//	Code 1
	public static void bfs(ArrayList<ArrayList<Integer>> obj , int source)
	{
		boolean[] arr = new boolean[obj.size()];
		for(int i=0 ; i<arr.length ; i++)
		{
			arr[i] = false;
		}
		arr[source] = true;
		System.out.println(source);
		for(int i=0 ; i<obj.get(source).size() ; i++)
		{
			arr[obj.get(source).get(i)]=true;
			System.out.println(obj.get(source).get(i));
		}
		for(int i=0 ; i<obj.size() ; i++)
		{
			for(int j=0 ; j<obj.get(i).size() ; j++)
			{
				if(arr[obj.get(i).get(j)]==false)
				{
					arr[obj.get(i).get(j)] = true;
					System.out.println(obj.get(i).get(j));
				}
			}
		}
	}
//	Code 2    **********************************************************************************************************
//	1. Ek array Banao Boolean wala. ar Sbko false kr do.
//	2. Fir us Source ko array me True kr do.
//	3. Source ke subarray ko queue DS me add kr do!.
//	4. Fir ek loop chalao jb tk queue empty na ho jaye!
//	5. ar Jb queue me add kro toh print kr do ar uske elements ko true kr do!
//	6. Fir un elements ko check kro jo queue me add hue h! Check if False print else dont print and so.............................
	public static void breadthFirstSearch(ArrayList<ArrayList<Integer>> obj , int source)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] arr = new boolean[obj.size()];
		for(int i=0 ; i<arr.length ; i++)
		{
			arr[i] = false;
		}
		queue.add(source);
		arr[source] = true;
		while(queue.isEmpty()==false)
		{
			int u = queue.poll();
			System.out.print(u+" ");
			for(int i=0 ; i<obj.get(u).size() ; i++)
			{
				if(arr[obj.get(u).get(i)]==false)
				{
					arr[obj.get(u).get(i)]=true;
					queue.add(obj.get(u).get(i));
				}
			}
		}
	}
}
