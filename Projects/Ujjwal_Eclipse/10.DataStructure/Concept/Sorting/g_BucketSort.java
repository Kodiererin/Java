package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class g_BucketSort {
	public static void main(String[] args) {
		System.out.println("Hello World");
		bucketSort();
	}

	public static void bucketSort(){
		int[] arr = {20,88,70,85,75,95,95,18,82,60};
		int bucket = 5;

		int maxValue = arr[0];
		for(int i=0 ; i<arr.length ; i++) {
			maxValue = Math.max(maxValue, arr[i]);
		}
		
		maxValue++;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0 ; i<bucket ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0 ; i<arr.length ; i++	) {
			int bi = (bucket*arr[i])/maxValue;
			list.get(bi).add(arr[i]);
		}
		
		for(int i=0 ; i<bucket ; i++) {
			Collections.sort(list.get(i));
		}
		
		int index = 0;
		for(int i=0 ; i<bucket ; i++) {
			for(int j=0 ; j<list.get(i).size() ; j++) {
				arr[index] = list.get(i).get(j);
				index++;
			}
		}
		
		for(int i=0 ; i<arr.length ; i++)
			System.out.println(arr[i]);
	}
}