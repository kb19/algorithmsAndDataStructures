package trees;

public class Find {
	public Find() {
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
		
		findFirstAncestor(root, 8, null);
		findCommonAncestor(root, 8, 14);
	}
	
	public void findFirstAncestor(TreeNode node, int value, TreeNode prev) {
		if (node == null) {
			return;
		}
		
		// Go right
		if (value > node.value) {
			findFirstAncestor(node.right, value, node);
		} else if (value < node.value ) { // Go left
			findFirstAncestor(node.left, value, node);
		} else { // Match
			System.out.println("matched " + value + " ancestor value: " + prev.value);
		}
	}
	
	public void findCommonAncestor(TreeNode root, int first, int second) {
		if(root == null) {
			return;
		}
		
		// They are in the same tree, go right
		if (root.value < first && root.value < second) {
			findCommonAncestor(root.right, first, second);
		} else if (root.value > first && root.value > second) {
			findCommonAncestor(root.right, first, second);
		} else {// We found our ancestor
			System.out.println("common ancestor is " + root.value);
		}
	}
	
	public static void main(String[] args) {
		Find f = new Find();
	}
}
