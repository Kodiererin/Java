package Sorting;

import java.util.Collection;
import java.util.Collections;

public class g_BucketSort implements Comparable<Integer> {
	public static void main(String[] args) {
		int[] arr = {1,32,12,33,22,55};
		bucketSort(arr, 4);
	}
	public static void bucketSort(int[] arr , int k) {
		int n = arr.length;
		int maxValue = arr[0];
		
		for(int i=0 ; i<n ; i++)
			maxValue = Math.max(maxValue, arr[i]);
		
//		Initialising Arraylist
		java.util.ArrayList<java.util.ArrayList<Integer>> bucket = new java.util.ArrayList<>();
		
		for(int i=0 ; i<n ; i++) {
			bucket.add(new java.util.ArrayList<Integer>());
		}
		
		for(int i=0 ; i<n ; i++) {
			int bi = (k*arr[i])/maxValue;
			bucket.add(bi, arr[i]);
		}
		
		for(int i=0 ; i<k ; i++) {
			Collections.sort(bucket.get(i));
		}
		
		
		int index = 0;
		
		for(int i=0 ; i<bucket.size() ; i++) {
			for(int j=0 ; j<bucket.get(i).SIZE ; j++) {
				System.out.println(bucket.get(j));
			}
		}
	}
	@Override
	public int compareTo(Integer o) {
		return this.compareTo(o);
	}
}
