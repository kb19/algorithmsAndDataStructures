package Throwaway;

import java.util.Arrays;

public class MergeSortArrayTest {
	
	public static void merge_sort(int[] array, int low, int high) {
		if(low < high) {
			int mid = (high + low) / 2;
			
			merge_sort(array, low, mid);
			merge_sort(array, mid + 1, high);
			
			merge(array, low, mid, high);
			
			System.out.println("\bMerge Sort");
			System.out.println(Arrays.toString(array));
		}
		
	}
	
	public static void merge(int[] array, int low, int mid, int high) {
		int[] helper = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;
		
		while(helperLeft <= mid && helperRight <= high) {
			if(array[helperLeft] < array[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			
			current++;
		}
		
		// Copy the remaining elements in the left array over
		for(int j = helperLeft; j < mid; j++) {
			array[current] = helper[j];
			current++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5, 1, 22, 99, 11, 6, 2, 34, 31, 23, 7, 1 };
		
		MergeSortArrayTest.merge_sort(array, 0, array.length - 1);
	}
}
