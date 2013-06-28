package trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindSum {
	
	public static void find2NodesThatSum(TreeNode node, int sum) {
		List<TreeNode> l = new LinkedList<TreeNode>();
		convertIntoList(node, l);

		int low = 0;
		int high = l.size() - 1;

		while (low < high) {
			int tempSum = l.get(low).value + l.get(high).value;
			
			// Success, increment / decrement low/high to keep moving
			if (tempSum == sum) {
				System.out.println("nodes are: " + l.get(low).value + ", and " + l.get(high).value);
				
				low++;
				high--;

			// Too low, increase the low index
			} else if (tempSum < sum) {
				
				low++;
				
			// Too high, increase the high index
			} else {
				
				high--;
				
			}
		}
	}

	public static void convertIntoList(TreeNode node, List<TreeNode> l) {
		if (node == null) {
			return;
		} else {
			convertIntoList(node.left, l);
			l.add(node);
			convertIntoList(node.right, l);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.insertTreeNode(root, 10);
		root.insertTreeNode(root, 6);
		root.insertTreeNode(root, 2);
		root.insertTreeNode(root, 4);
		root.insertTreeNode(root, 8);
		root.insertTreeNode(root, 9);
		root.insertTreeNode(root, 1);
		root.insertTreeNode(root, 14);
		root.insertTreeNode(root, 3);
		
		FindSum.find2NodesThatSum(root, 5);
	}
}
