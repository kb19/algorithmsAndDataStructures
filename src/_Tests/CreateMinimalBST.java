package _Tests;

import trees.TreeNode;

public class CreateMinimalBST {

	public static TreeNode create(int[] array, int start, int end) {
		if (start < end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		TreeNode head = new TreeNode(array[mid]);
		head.left = create(array, start, mid - 1);
		head.right = create(array, mid + 1, end);
		
		return head;
	}
	
	public static void main(String[] args) {
		int[] array = {6, 2, 3, 4, 5, 6, 7, 1, 2, 7, 9, 10, 12, 13};
		
		TreeNode n = CreateMinimalBST.create(array, 0, array.length - 1);
		
	}
}
