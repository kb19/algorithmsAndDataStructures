package _Tests;

import java.util.HashMap;

import trees.TreeNode;

public class BstVerticalSum {
	public static void calculateSum(TreeNode node) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		verticalSum(node, hm, 0);
		
		System.out.println("hash map:");
		System.out.println(hm.entrySet());
	}
	
	public static void verticalSum(TreeNode node, HashMap<Integer, Integer> hm, int hDist) {
		if (node == null) {
			return;
		}
		
		// Going left, we subtract 1
		verticalSum(node.left, hm, hDist - 1);
		
		if (hm.containsKey(hDist)) {
			int existingVal = hm.get(hDist);
			hm.put(hDist, existingVal + node.value);
		} else {
			hm.put(hDist, node.value);
		}
		
		// Going right, we add 1
		verticalSum(node.right, hm, hDist + 1);
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
		
		BstVerticalSum.calculateSum(tn);
	}
}
