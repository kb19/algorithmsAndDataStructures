import java.util.Arrays;


public class MergeSort {
	public static void mergesort(int[] array, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			System.out.printf("low: %d, middle: %d high: %d\n", low, middle, high);
			mergesort(array, low, middle);
			System.out.printf("done first mergesort...low: %d, middle: %d high: %d\n", low, middle, high);
			mergesort(array, middle + 1, high);
			System.out.printf("done second mergesort...low: %d, middle: %d high: %d\n", low, middle, high);
			merge(array, low, middle, high);
		}
	}
	
	public static void merge(int[] array, int low, int middle, int high) {
		System.out.printf("merging low: %d middle: %d high: %d\n", low, middle, high);
		int[] helper = new int[array.length];
		
		// Copy both halves into a helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/* Iterate through helper array. Compare the left and right 
		 * half, copying back the smaller element from the two halves
		 * into the original array
		 */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // Right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			
			current++;
		}
		
		/* Copy the rest of the left side of the array into the 
		 * target array
		 */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		int[] array = {5, 10, 2, 1, 3, 6, 1, 1, 2, 12, 22, 101, 95, 22};
		System.out.println(Arrays.toString(array));
		MergeSort.mergesort(array, 0, 13);
		
	}
}
