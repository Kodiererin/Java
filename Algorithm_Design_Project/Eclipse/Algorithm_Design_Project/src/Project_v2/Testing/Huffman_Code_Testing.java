package Project_v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class MyData implements Comparable<MyData> , Comparator<MyData>{
	int frequency;
	byte data;
	MyData(int frequency , byte data){
		this.data = data;
		this.frequency = frequency;
	}
	@Override
	public int compare(MyData o1, MyData o2) {
		return o1.frequency==o2.frequency?0:o1.frequency>o2.frequency?-1:+1;			// Changed the Value
	}
	@Override
	public int compareTo(MyData o) {
		return o.frequency-this.frequency;											// Changed the Value
	}
	@Override
	public String toString() {
		return "Frequency - "+this.frequency+" & Bit_Value - "+this.data;
	}
}


public class Huffman_Code {
	static class Node implements Comparable<Node> , Comparator<Node>{
		MyData var;
		Node Right;
		Node Left;
		Node(){
			this.Left = null;
			this.Right = null;
			this.var = new MyData(Integer.MIN_VALUE, Byte.MIN_VALUE);
		}
		Node(MyData var){
			this.Left = null;
			this.var = var;
			this.Right = null;
		}
		@Override
		public int compare(Node o1, Node o2) {
			return o1.var.frequency==o2.var.frequency?0:o1.var.frequency>o2.var.frequency?1:-1;
		}
		@Override
		public int compareTo(Node o) {
			return this.var.frequency-o.var.frequency;
		}
		public String toString() {
			return this.var.data+"---"+this.var.frequency;
		}
	}
//	Getting the Data and Storing it into ArrayList
	public static void a_getData() {
//		String filePath = "C:\\Users\\Ujjwal\\Desktop\\Hello.txt";
		String filePath = "C:\\Users\\Ujjwal\\Desktop\\Algorithm_Design_Project\\Eclipse\\Algorithm_Design_Project\\src\\Project\\TestImage.jpg";
		
		java.util.TreeMap<Integer, Byte> tMap = new java.util.TreeMap<Integer, Byte>();
		java.util.ArrayList<MyData> list = new java.util.ArrayList<>();
		tMap = BitValue.compute(filePath);
		for (Map.Entry<Integer, Byte> entry : tMap.entrySet()) {
			Integer key = entry.getKey();
			Byte val = entry.getValue();
			list.add(new MyData(key,val));
		}
//		java.util.Collections.reverse(list);
//		displayList(list);
		HuffmanCode(tMap, list);
	}
//	Starting For Huffman Code
	public static void HuffmanCode(TreeMap<Integer, Byte> map , ArrayList<MyData> list) {
		System.out.println("Starting With The Huffman Code");
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(int i=0 ; i<list.size() ; i++) {
			queue.add(new Node(new MyData(list.get(i).frequency , list.get(i).data)));
		}
//		while(!queue.isEmpty()) {
//			System.out.println(queue.poll());
//		}
		Node Head = null;
		while(!queue.isEmpty()) {
			Node a = queue.poll();
			if(queue.peek()==null) {
				Head = a;
				break;
			}else if(queue.peek().var.frequency>=a.var.frequency) {
				Node b = new Node();
				b.Left = a;
				b.Right = queue.poll();
				b.var.frequency = b.Left.var.frequency+b.Right.var.frequency;
				queue.add(b);
			}else {
				Node c = queue.poll();
				if(c.var.frequency<queue.peek().var.frequency) {
					Node d = new Node();
					d.Left = c;
					d.Right = queue.poll();
					d.var.frequency = d.Left.var.frequency+d.Right.var.frequency;
					queue.add(d);
					queue.add(a);
				}
			}
		}
//		System.out.println("Mission Accomplished");
//		printHuffmanTree(Head);						// Huffman Tree Genetation Successful
		generateHuffmanCode(Head, list);
	}
	
	
	// Huffman Code Generation This Generates the Number.
	
//	---------------- This Gives the Huffman Code in Numbers -------------------------
//	static class Code {
//	    MyData data;
//	    int code;
//	    
//	    Code(MyData data) {
//	        this.code = 0;
//	        this.data = data;
//	    }
//	}
//
//	public static void generateHuffmanCode(Node head, ArrayList<MyData> list) {
//	    ArrayList<Code> codeList = new ArrayList<>();
//	    
//	    for (int i = 0; i < list.size(); i++) {
//	        MyData var = new MyData(list.get(i).frequency, list.get(i).data);
//	        codeList.add(new Code(var));
//	    }
//	    
//	    // Traverse each Data and find the Huffman Code
//	    for (int i = 0; i < codeList.size(); i++) {
//	        HuffmanCodeGeneration(codeList, head, codeList.get(i), 0);
//	    }
//	    
//	    // Display the Huffman Codes
//	    System.out.println("Printing the Huffman Codes");
//	    displayHuffmanCodes(codeList);
//	}
//
//	// Huffman Code Generation and Updation
//	public static void HuffmanCodeGeneration(ArrayList<Code> codeList, Node head, Code destination, int code) {
//	    if (head == null) {
//	        return;
//	    }
//	    
//	    if (head.var.data == destination.data.data) {
//	        destination.code = code;
//	    } else {
//	        HuffmanCodeGeneration(codeList, head.Left, destination, (code << 1) + 1);
//	        HuffmanCodeGeneration(codeList, head.Right, destination, code << 1);
//	    }
//	}
//	
//	--------------------------------------------------------------------------------

//	---------------- This Gives the Huffman Code in Strings -------------------------
	static class Code {
	    MyData data;
	    String code;
	    
	    Code(MyData data) {
	        this.code = "";
	        this.data = data;
	    }
	}

	public static void generateHuffmanCode(Node head, ArrayList<MyData> list) {
	    ArrayList<Code> codeList = new ArrayList<>();
	    
//	    Creating a LookUp table that Keeps the Byte as key and The Hoffman Code as Value
	    java.util.TreeMap<Byte, String> lookUpMap = new java.util.TreeMap<Byte, String>();
	    
	    
	    for (int i = 0; i < list.size(); i++) {
	        MyData var = new MyData(list.get(i).frequency, list.get(i).data);
	        codeList.add(new Code(var));
	    }
	    
	    // Traverse each Data and find the Huffman Code
	    
	    System.out.println("Reminder to Check that The LookUpMap has Been Created");
	    for (int i = 0; i < codeList.size(); i++) {
	        HuffmanCodeGeneration(codeList, head, codeList.get(i), "");
	        lookUpMap.put(codeList.get(i).data.data, codeList.get(i).code);								// Reminder : This is For String
	    }
	    
	    // Display the Huffman Codes
	    System.out.println("Printing the Huffman Codes");
	    displayHuffmanCodes(codeList);
	}

	// Huffman Code Generation and Updation
	public static void HuffmanCodeGeneration(ArrayList<Code> codeList, Node head, Code destination, String code) {
	    if (head == null) {
	        return;
	    }
	    
	    if (head.var.data == destination.data.data) {
	        destination.code = code;
	    } else {
	        HuffmanCodeGeneration(codeList, head.Left, destination, code + "1");
	        HuffmanCodeGeneration(codeList, head.Right, destination, code + "0");
	    }
	}
//	----------------------------------------------------------------------------------------------

	
	public static void displayHuffmanCodes(java.util.ArrayList<Code> list) {
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i).data.data+"	"+list.get(i).code);
		}
	}
	
	public static void printHuffmanTree(Node Head) {
		if(Head.Left==null && Head.Right==null) {
			System.out.println(Head);
		}
		else {
//			System.out.println(Head.var.frequency);
			printHuffmanTree(Head.Left);
			printHuffmanTree(Head.Right);
		}
	}
	
//	Creating a Method to Display for Testing
	public static void displayList(java.util.ArrayList<MyData> list) {
		for(int i=0 ; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	public static void main(String[] args) {
		a_getData();
	}
}
