package Matrix;

public class Search {
	/**
	 * Search starting in the last column of the first row. If the target
	 * value is less than the column / row we are in, we move left, if it's
	 * greater we move down a row.
	 * @param matrix
	 * @param target
	 */
	public static void sortedSearch(int[][] matrix, int target) {
		int r = matrix.length,
			c = matrix[0].length;
		
		int rIndex = 0,
			cIndex = c - 1;
		
		while(cIndex >= 0 && rIndex < r) {
			int curVal = matrix[rIndex][cIndex];
			
			System.out.printf("while------row: %d, col: %d, val: %d\n", rIndex, cIndex, curVal);
			
			if (curVal > target) {
				cIndex--;
			} else if(curVal < target) {
				rIndex++;
				// Should we reset cIndex to c - 1 here?
			} else if(curVal == target) {
				System.out.printf("found element at row: %d and col: %d", rIndex, cIndex);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 2, 3},
                {2, 3, 3, 14},
                {2, 4, 24, 25},
                {2, 4, 25, 27}};
		
		Search.sortedSearch(matrix, 4);
	}
}
