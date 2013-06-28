package trees;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
 
    public int value;
 
    public TreeNode() {

    }
    
    public TreeNode(int value) {
    	this.value = value;
    }
    
    public void insertTreeNode(int value) {
		// Check to see if which side of the tree the value falls in
		if (value < this.value) {
			if (this.left != null) {
				insertTreeNode(this.left, value);
			} else {
				System.out.println("itInserted value on the left side: " + value);
				this.left = new TreeNode(value);
			}
		} else { 
			if (this.right != null) {
				insertTreeNode(this.right, value);
			} else {
				System.out.println("itInserted value on the right " + value);
				this.right = new TreeNode(value);
			}
		}
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
}
