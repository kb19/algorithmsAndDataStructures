package trees;

import java.util.Arrays;

public class FindPathsSumNonBST {
	
	public static void findsum2(TreeNode node, int sum, int[] path, int level) {
		if(node == null) {
			return;
		}
	
		path[level] = node.value;
		
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t+=path[i];
			if(t==sum) {
				print(path, i, level);
			}
		}
		
		findsum2(node.left, sum, path, level + 1);
		findsum2(node.right, sum, path, level + 1);
	}
	
	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findsum2(node, sum, path, 0);
	}
	
	public static void print(int[] path, int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.println(path[i] + " ");
		}
		
		System.out.println();
	}
	
	public static int depth(TreeNode node) {
		if (node == null) return 0;
		
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
	
	public static void findsum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) 
			return;
		
		System.out.println("looking at level: " + level);
		System.out.println(Arrays.toString(path));
		
		path[level] = node.value;
		
		// Add everything up
		int t = 0;
		for(int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum)
				System.out.println("path found %s" + Arrays.toString(path));
		}
		
		// Recurse
		findsum(node.left, sum, path, level + 1);
		findsum(node.right, sum, path, level + 1);
	}
	
	public static void inorder(TreeNode node) {
		if (node == null)
			return;
		
		inorder(node.left);
		System.out.println(node.value);
		inorder(node.right);
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(5);
		TreeNode left = new TreeNode(10);
		TreeNode right = new TreeNode(1);
		
		TreeNode leftleft = new TreeNode(22);
		TreeNode leftleftleft = new TreeNode(2);
		TreeNode leftleftright = new TreeNode(3);
		
		TreeNode leftright = new TreeNode(7);
		TreeNode leftrightleft = new TreeNode(3);
		TreeNode leftrightright = new TreeNode(6);
		
		TreeNode rightleft = new TreeNode(9);
		TreeNode rightleftleft = new TreeNode(10);
		TreeNode rightleftright = new TreeNode(2);
		
		leftleft.left = leftleftleft;
		leftleft.right = leftleftright;
		
		leftright.left = leftrightleft;
		leftright.right = leftrightright;
		
		rightleft.left = rightleftleft;
		rightleft.right = rightleftright;
		
		left.left = leftleft;
		left.right = leftright;
		
		right.left = rightleft;
		
		head.left = left;
		head.right = right;
		
		FindPathsSumNonBST.inorder(head);
		
		int[] path = new int[4];
		FindPathsSumNonBST.findsum(head, 20, path, 0);
		
		FindPathsSumNonBST.findSum(head, 20);
	}
}
