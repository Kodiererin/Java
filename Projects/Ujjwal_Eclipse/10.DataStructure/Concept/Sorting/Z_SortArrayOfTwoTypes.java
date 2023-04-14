package Sorting;

public class Z_SortArrayOfTwoTypes 
{
	public static void question()
	{
		System.out.println("We have to Segregate array into two types ");
		System.out.println("Segregate Positive and NEgative");
		System.out.println("Input : [ 15,-3,-2 ,18]");
		System.out.println("Output : [-3,-2,15,18]");
		
		System.out.println("Segregate Even and Odd");
		System.out.println("Input : [15,14,13,12]");
		System.out.println("Output : 14,12,15,13");
		
		System.out.println("Segregate a Binary Array");
		System.out.println("Input : [0,1,1,1,0]");
		System.out.println("Output : [0,0,1,1,1]");
	}
	public static int[] segregate(int[] arr)
	{
		int[] temp = new int[arr.length];
		int i=0;
		for(int j=0 ; j<arr.length ; j++)
		{
			if(arr[j]<0)
			{
				temp[i] = arr[j];
				i++;
			}
		}
		for(int j=0 ; j<arr.length ; j++)
		{
			if(arr[j]>=0)
			{
				temp[i] = arr[j];
				i++;
			}
		}
		for(int j=0 ; j<arr.length ; j++)
		{
			arr[j] = temp[j];
		}
		return arr;
	}
	public static void main(String[] args) 
	{
//		We are doing the First Problem as other problem are more or like same
//		question();
//		Lets try
		int[] arr = {-1,2,-1,23,23,-10,9,0};
		int[] temp = new int[arr.length];
		temp = segregate(arr);
		for(int i=0 ; i<arr.length ; i++)
		{
			System.out.println(arr[i]);
		}
		}
	}
