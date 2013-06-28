package trees;

public class FindKthInBST {
	
	public FindKthInBST() {
		TreeNode root = new TreeNode(5);
		insertTreeNode(root, 10);
		insertTreeNode(root, 6);
		insertTreeNode(root, 2);
		insertTreeNode(root, 4);
		insertTreeNode(root, 8);
		insertTreeNode(root, 9);
		insertTreeNode(root, 1);
		insertTreeNode(root, 14);
		insertTreeNode(root, 3);
		
		int max = max(root, 4);
		System.out.println("4th largest: " + max);
		
		int min = min(root, 6);
		System.out.println("4th smallest: " + min);
	}

	static int count(TreeNode root){
	    if(root == null)
	        return 0;
	    else
	        return count(root.left) + count(root.right) +1;
	}
	
	static int max(TreeNode root, int k) {
	    if(root == null)
	        return -1;
	    
	    int right = count(root.right);

	    // +1 to account for the root node
	    if(k == right + 1)
	        return root.value;
	    
	    // If there are less nodes in the right tree than K, we go left
	    // Revise K to offset the nodes in the right tree
	    // - subtract 1 to also account for the root node
	    else if(right < k)
	        return max(root.left, k - right - 1);
	    
	    // There are more nodes in the right tree than K, keep K the same
	    else return max(root.right, k);
	}

	static int min(TreeNode root, int k) {
	    if (root==null)
	        return -1;

	    int left = count(root.left);
	    
	    System.out.println("left: " + left);
	    
	    // +1 to account for the root node
	    if(k == left + 1)
	        return root.value;
	    
	    // If there are less nodes in the left tree than K, we go right
	    // Revise K to offset the nodes in the left tree
	    // - subtract 1 to also account for the root node
	    else if (left < k)
	        return min(root.right, k - left - 1);
	    
	    // There are more nodes in the left tree than K, keep K the same
	    else
	        return min(root.left, k);
	}
	
	public void insertTreeNode(TreeNode node, int value) {
		// Check to see if which side of the tree the value falls in
		if (value < node.value) {
			if (node.left != null) {
				insertTreeNode(node.left, value);
			} else {
				System.out.println("Inserted value on the left side: " + value);
				node.left = new TreeNode(value);
			}
		} else { 
			if (node.right != null) {
				insertTreeNode(node.right, value);
			} else {
				System.out.println("Inserted value on the right " + value);
				node.right = new TreeNode(value);
			}
		}
	}
	
	public static void main(String[] args) {
		FindKthInBST t = new FindKthInBST();
	}
}
