package _Tests;

import trees.TreeNode;

public class BstFindKth {
	
	public static int max(TreeNode node, int k) {
		if (node == null) {
			return -1;
		}

		// Get the number of nodes in the right subtree
	    int right = count(node.right);
	    
	    System.out.println("right: " + right);
	    
	    // +1 to account for the root node
	    if (k == right + 1)
	        return node.value;
	    
	    // If there are less nodes in the left right than K, we go left
	    // Revise K by subtracting the nodes in the right subtree, which will
	    // all be smaller than the ones in the left
	    else if (right < k)
	        return max(node.left, k - right - 1);
	    
	    // There are more nodes in the left tree than K, keep K the same
	    else
	        return max(node.right, k);
	}
	
	public static int min(TreeNode node, int k) {
		if (node == null) {
			return -1;
		}

		// Get the number of nodes in the left subtree
	    int left = count(node.left);
	    
	    System.out.println("smallest left: " + left);
	    
	    // +1 to account for the root node
	    if (k == left + 1) {
	    	System.out.println("match " + k + " left " + (left + 1));
	        return node.value;
	    }
	    
	    // If there are less nodes in the left tree than K, we go right
	    // Revise K by subtracting the nodes in the left subtree, which will
	    // all be smaller than the ones in the right
	    else if (left < k)
	        return min(node.right, k - left - 1);
	    
	    // There are more nodes in the left tree than K, keep K the same
	    else {
	    	System.out.println("going left");
	        return min(node.left, k);
	    }
	}
	
	public static int count(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return count(node.left) + count(node.right) + 1;
		}
	}
	
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(10);
		tn.insertTreeNode(5);
		tn.insertTreeNode(20);
		tn.insertTreeNode(3);
		tn.insertTreeNode(7);
		tn.insertTreeNode(17);
		tn.insertTreeNode(25);
		tn.insertTreeNode(1);
		tn.insertTreeNode(4);
		tn.insertTreeNode(6);
		tn.insertTreeNode(8);
		
		System.out.println("4th Largest is: " + BstFindKth.max(tn, 4));
		
		System.out.println("Smallest is: " + BstFindKth.min(tn, 1));
	}
}
