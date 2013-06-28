package trees;

import java.util.HashMap;

  
// Class for a Binary BinaryTreeVerticalSum
// http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
public class BinaryTreeVerticalSum {
  
    private TreeNodeFull root;
  
    // Constructors
    public BinaryTreeVerticalSum() { root = null; }
    public BinaryTreeVerticalSum(TreeNodeFull n) { root = n; }
  
    // Method to be called by the consumer classes like Main class
    public void VerticalSumMain() { VerticalSum(root); }
  
    // A wrapper over VerticalSumUtil()
    private void VerticalSum(TreeNodeFull root) {
  
        // base case
        if (root == null) { return; }
  
        // Creates an empty hashMap hashMap
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
  
        // Calls the VerticalSumUtil() to store the vertical sum values in hashMap
        VerticalSumUtil(root, 0, hashMap);
  
        // Prints the values stored by VerticalSumUtil()
        if (hashMap != null) {
            System.out.println(hashMap.entrySet());
        }
    }
  
    // Traverses the tree in Inoorder form and builds a hashMap hashMap that
    // contains the vertical sum
    private void VerticalSumUtil(TreeNodeFull root, int horizDist,
                                          HashMap<Integer, Integer> hashMap) {
  
        // base case
        if (root == null) {  return; }
  
        // Store the values in hashMap for left subtree
        VerticalSumUtil(root.left(), horizDist - 1, hashMap);
  
        // Update vertical sum for horizDist of this node
        int prevSum = (hashMap.get(horizDist) == null) ? 0 : hashMap.get(horizDist);
        hashMap.put(horizDist, prevSum + root.key());
  
        // Store the values in hashMap for right subtree
        VerticalSumUtil(root.right(), horizDist + 1, hashMap);
    }
  
    public static void main(String[] args) {
        /* Create following Binary BinaryTreeVerticalSum
              1
            /    \
          2        3
         / \      / \
        4   5    6   7
  
        */
        TreeNodeFull root = new TreeNodeFull(1);
        root.setLeft(new TreeNodeFull(2));
        root.setRight(new TreeNodeFull(3));
        root.left().setLeft(new TreeNodeFull(4));
        root.left().setRight(new TreeNodeFull(5));
        root.right().setLeft(new TreeNodeFull(6));
        root.right().setRight(new TreeNodeFull(7));
        BinaryTreeVerticalSum t = new BinaryTreeVerticalSum(root);
  
        System.out.println("Following are the values of vertical sums with "
                + "the positions of the columns with respect to root ");
        t.VerticalSumMain();
    }
}