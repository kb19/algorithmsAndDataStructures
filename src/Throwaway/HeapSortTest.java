package Throwaway;

public class HeapSortTest {
	private static int[] a;
	private static int n;
	private static int left, right;
	private static int largest;
	
	public static void build_heap(int[] a) {
		//build heap
		n = a.length - 1;
		
		for(int i = n/2; i >= 0; i--) {
			max_heap(a, i);
		}
	}
	
	public static void sort(int[] array) {
		a = array;
		build_heap(a);
		
		
		for (int i = n; i > 0; i--) {
			//loop and 
			swap( 0, i);
			n = n - 1;
			max_heap(array, 0);
		}
	}
	
	public static void max_heap(int[] array, int i) {
		left = 2 * i + 1;
		right = 2 * i + 2;
		
		if (left <= n && array[left] > array[i]) {
			largest = left;
		} else {
			largest = i;
		}
		
		if (right <= n && array[right] > array[largest]) {
			largest = right;
		}
		
		// Swap and max heap again
		if (largest != i) {
			swap(i, largest);
			max_heap(array, largest);
		}
	}
	
	public static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	 public static void main(String[] args) {
        int []a1={4,1,3,2,16,9,10,14,8,7};
        sort(a1);
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i] + " ");
        }
    }
}
