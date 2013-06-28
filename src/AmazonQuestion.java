import java.util.Arrays;


public class AmazonQuestion {
	public static int[] matrixToArray(int[][] matrix) {
		int r = matrix.length;
		
		int[] prev = null;
		for (int i = 0; i + 1 < r; i++) {
			if (prev == null) {
				prev = mergeArrays(matrix[i], matrix[i+1]);
			} else {
				prev = mergeArrays(prev, matrix[i+1]);
			}
		}
		
		return prev;
	}
	
	public static int[] mergeArrays(int[] a, int[] b) {		
		int[] merged = new int[a.length + b.length];
		int i = 0, colA = 0, colB = 0;
		
		while (colA < a.length && colB < b.length){
			if (a[colA] < b[colB]) {
				merged[i] = a[colA];
				colA++;
			} else {
				merged[i] = b[colB];
				colB++;
			}
			
			i++;
		}
		
		while (colA < a.length) {
			merged[i] = a[colA];
			colA++;
			i++;
		}
		
		while (colB < b.length) {
			merged[i] = b[colB];
			colB++;
			i++;
		}
		
		return merged;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 2, 3},
		                  {2, 3, 3, 14},
		                  {2, 4, 24, 25},
		                  {2, 4, 25, 27}};
		
		int[] result = AmazonQuestion.matrixToArray(matrix);
		System.out.printf("The array version of the matrix is %s", Arrays.toString(result));
	}
}
