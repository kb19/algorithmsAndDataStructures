package sorting;

import java.util.Arrays;

// http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html
// find kth Minimum/Maximum element problem in O(k)
public class HeapSortMatrix {
	private static int[][] a;
	private static int[] masterHeap;
	private static int left;
	private static int right;
	private static int largest;

	/**
	 * We use the maxheap() function in a bottom-up manner 
	 * to create an array A[1..n], where n=A.length, into a 
	 * Max-Heap. The function buildheap() goes through the 
	 * remaining elements i.e. A[(n/2)+1, n] thus it take 
	 * linear time, produces a max-heap from an unordered input array. 
	 * 
	 * @param a
	 */
	public static void buildheap(int[][] a) {
		int n = a.length * a[0].length;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(a, i, n);
		}
	}
	
	/**
	 * It helps us to maintain the property of Max-Heap 
	 * i.e. the root value is always greater than the child 
	 * value and it takes a time of O(lg n). Therefore, we 
	 * can say that the running time of maxheap(int [] a, 
	 * int i) on a tree of height h  is O(h). 
	 * 
	 * @param a
	 * @param lastElement
	 */
	public static void maxheap(int[][] a, int lastElement, int n) {
		int leRow = (int) Math.floor( lastElement / 5 ); 
		int leCol = lastElement % 5;
		
		int leftRow = (int) Math.floor( left / 5 ); 
		int leftCol = left % 5;
		
		int rightRow = (int) Math.floor( right / 5 ); 
		int rightCol = right % 5;
		
		left = 2 * lastElement;
		right = 2 * lastElement + 1;
		
		// Recalculate largest
		if (left < n && a[leftRow][leftCol] > a[leRow][leCol]) {
			largest = left;
		} else {
			largest = lastElement;
		}
		
		int largestRow = (int) Math.floor( largest / 5 ); 
		int largestCol = largest % 5;

		if (right < n && a[rightRow][rightCol] > a[largestRow][largestCol]) {
			largest = right;
		}
		
		if (largest != lastElement) {
			// swap the root(maximum value) of the heap with the last element of the heap 
			swap(lastElement, largest);
			maxheap(a, largest, n);
		}
	}

	public static void swap(int lastElement, int largest) { 
		int leRow = (int) Math.floor( lastElement / 5 ); 
		int leCol = lastElement % 5;
		
		int largestRow = (int) Math.floor( largest / 5 ); 
		int largestCol = largest % 5;
		
		int t = a[leRow][leCol];
		a[leRow][leCol] = a[largestRow][largestCol];
		a[largestRow][largestCol] = t;
	}

	public static void matrixSort(int[][] matrix) {		
		a = matrix;
		buildheap(matrix);
		
		masterHeap = new int[15];
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 5; c++) {
				masterHeap[r*5 + c] = a[r][c];
				System.out.println((r*5+c) + " " + a[r][c]);
			}
		}
		
		System.out.println("mc " + Arrays.toString(masterHeap));
		
		// Account for array size less 1 since we are starting from the top
		int n = 15;
		for (int i = n - 1; i > 0; i--) {
			// swap the root(maximum value) of the heap with the last element of the heap
			swap(0, i);
			n--;
			maxheap(a, 0, n);
		}
	}

	public static void main(String[] args) {
		int[] a1 = { 4, 1, 3, 2, 16 };
		int[] a2 = { 9, 10, 4, 1, 3 };
		int[] a3 = { 2, 16, 9, 10, 77 };
		
		int[][] matrix = { a1, a2, a3 }; 
		
		matrixSort( matrix );
		
		System.out.println("\n");
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 5; c++) {
				System.out.println((r*5+c) + " " + a[r][c]);
			}
		}
	}
}