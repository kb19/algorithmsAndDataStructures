package sorting;

import java.util.Arrays;

public class Mergesort {
	public static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			// Take offset into account if low isn't 0
			int mid = (high + low) / 2;
			
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			
			merge(array, low, mid, high);
			
			System.out.println("\bMerge Sort");
			System.out.println(Arrays.toString(array));
		}
	}
	
	public static void merge(int[] array, int low, int mid, int high) {
		// Create array that holds unsorted values
		int[] helperArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			helperArray[i] = array[i];
		}
		
		// Helper vars
		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;
		
		// Comparisons
		while(helperLeft <= mid && helperRight <= high) {
			// Left - to - Right
			if (helperArray[helperLeft] < helperArray[helperRight]) {
				array[current] = helperArray[helperLeft];
				helperLeft++;
			} else {
				array[current] = helperArray[helperRight];
				helperRight++;
			}
			
			current++;
		}
		
		// Copy the left array over
		for(int i = helperLeft; i <= mid; i++) {
			array[current] = helperArray[i];
			current++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5, 1, 22, 99, 11, 6, 2, 34, 31, 23, 7, 1 };
		
		Mergesort.mergeSort( array, 0, array.length - 1 );
	}
}
