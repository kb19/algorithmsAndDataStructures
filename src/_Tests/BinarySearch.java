package _Tests;

public class BinarySearch {
	public static void search(int[] array, int target, int low, int high) {
		if (low <= high) {
			int mid = (high + low) / 2;
			
			int midVal = array[mid];
			
			System.out.println("high: " + high + " mid: " + mid + " low: " + low + " looking at val: " + midVal);
			
			if (target > midVal) {
				search(array, target, mid + 1, high);
			} else if (target < midVal) {
				search(array, target, low, mid - 1);
			} else {
				System.out.println("Found target at index: " + mid);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 8, 9, 12, 14, 16, 18, 20};
		
		BinarySearch.search(array, 14, 0, array.length - 1);
	}
}
