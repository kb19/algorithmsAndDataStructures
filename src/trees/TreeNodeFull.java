package trees;

class TreeNodeFull {
	  
    // data members
    private int key;
    private TreeNodeFull left;
    private TreeNodeFull right;
  
    // Accessor methods
    public int key()        { return key; }
    public TreeNodeFull left()  { return left; }
    public TreeNodeFull right() { return right; }
  
    // Constructor
    public TreeNodeFull(int key) { this.key = key; left = null; right = null; }
  
    // Methods to set left and right subtrees
    public void setLeft(TreeNodeFull left)   { this.left = left; }
    public void setRight(TreeNodeFull right) { this.right = right; }
}
