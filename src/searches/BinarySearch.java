package searches;

public class BinarySearch {
	public static boolean binarySearchIt(int[] array, int target) {
		if (array.length == 0 || array == null)
			return false;
		
		int low = 0;
		int high = array.length - 1;// Why is 1 here?
		
		// <= is important because when low == high the item will be foudn
		while (low <= high) {
			
			// Add low to account for a non-zero offset
			System.out.println("low: " + low + " high: " + high);
			int mid = low + ( high - low ) / 2;
			System.out.println("checking : " + mid );
			
			// Target is in the left half of the array
			// NB: Offset the high and low by 1 to avoid counting the mid
			// number twice
			if (target < array[mid]) {
				high = mid - 1; 
			} else if (target > array[mid]){ // Target is in the right half of the array
				low = mid + 1;
			} else {
				System.out.println("Number found at index " + mid);
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void binarySearchRec(int[] array, int target, int low, int high) {
		if (low <= high) {
			int mid = (high + low) / 2;
			
			int midVal = array[mid];
			
			System.out.println("high: " + high + " mid: " + mid + " low: " + low + " looking at val: " + midVal);
			
			if (target > midVal) {
				binarySearchRec(array, target, mid + 1, high);
			} else if (target < midVal) {
				binarySearchRec(array, target, low, mid - 1);
			} else {
				System.out.println("Found target at index: " + mid);
			}
		}
	}
	
	/** 
	 * Finds the square root using binary search
	 */
	public static void findSquareRoot(int n) {
	  int low = 0;
	  int high = n+1;
	  
	  while (high-low > 1) {
		  int mid = (low + high) / 2;
		  
		  if (mid * mid == n) {
			  System.out.println("number is: " + mid);
			  break;
		  } else if (mid * mid < n) {
			  low = mid;  
		  } else {
		      high = mid;
		  }   
	  }
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15 };
		BinarySearch.binarySearchIt(array, 2);
		
		//BinarySearch.binarySearchRec(array, 15, 0, array.length - 1);
		BinarySearch.findSquareRoot(81);
	}
}
