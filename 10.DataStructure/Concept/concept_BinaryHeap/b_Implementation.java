package concept_BinaryHeap;

public class b_Implementation 
{
	class MinHeap
	{
		int [] arr;
		int size;
		int capacity;
		MinHeap(int c)
		{
			arr = new int[c];
			size = 0;
			capacity = c;
		}
		
		int left(int i)
		{
			return (2*i+1);
		}
		int right(int i)
		{
			return (2*i+2);
		}
		int parent(int i)
		{
			return (i-i)/2;
		}
	}
}
