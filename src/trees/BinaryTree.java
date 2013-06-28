package trees;

import java.util.LinkedList;

// Binary Search Tree Class
public class BinaryTree {
	public class DoublyLinkedNode {
		public DoublyLinkedNode prev;
		public DoublyLinkedNode next;
		public int data;
		
		public DoublyLinkedNode(int data) {
			this.data = data;
		}
		
		public void addNext(DoublyLinkedNode node) {
			this.next = node;
		}
		
		public void addPrev(DoublyLinkedNode node) {
			this.prev = node;
		}
		
	    public boolean hasNext() {
	    	return next != null;
	    }
	}
	
	int index = 0;
	public BinaryTree() {
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
		
		//serialize(root);
		
		/*
		String tree = "5  2  1  #  #  4  3  #  #  #  10  6  #  8  #  9  #  #  14  #  # ";
		
		String[] treeArr = tree.split(" ");
		
		// Remove spaces
		int treeArrLength = treeArr.length;
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < treeArrLength; i++) {
			String val = treeArr[i];
			if (val.length() > 0) {
				v.add(val);
			}
		}
		
		Object[] stringArr = v.toArray();
		TreeNode head = new TreeNode();
		head = deserialize(null, stringArr);
		
		dfPreOrder(head);
		
		//dfInOrder(head);

		System.out.println("\nIn Order Traversal");
		dfInOrder(root);
		
		System.out.println("\nPre Order Traversal");
		dfPreOrder(root);
		
		System.out.println("\nPost Order Traversal");
		dfPostOrder(root);

//		convertToLL(root);
//		printList(llfirst);
//		printListRev(lllast);
		
//		LinkedList<Integer> dll = convertToLLInPlace(root, new LinkedList<Integer>());
//		System.out.println(dll);
		
//		System.out.println("CONVERTING TO DLL");
//		
//		DoublyLinkedNode dln = convertToDLL(root, null, null);
//		printList(dln);
 */
		
		int[] inOrderArray = {1, 5, 10, 40, 30, 15, 28, 20};
		TreeNode specialTree = buildSpecialTreeFromInorder(inOrderArray, 0, inOrderArray.length - 1);
		dfInOrder(specialTree);
	}
	
	public void printList(DoublyLinkedNode node) {
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public void printListRev(DoublyLinkedNode node) {
		while(node != null) {
			System.out.println(node.data);
			node = node.prev;
		}
	}
	
	public TreeNode deserialize(TreeNode node, Object[] array) {
		String str = (String)array[index];
		
		if (str.equals("#")) {
			return null;
		} else {
			int i = Integer.parseInt(str);
			node = new TreeNode(i);
			
			index++;
			System.out.println("    before left: " + (index));
			node.left = deserialize(node.left, array);
			
			index++;
			System.out.println("    before right: " + (index));
			node.right = deserialize(node.right, array);
		}		
	
		return node;
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
	/***** DEPTH FIRST TRAVERSALS *****/
	
	// Given an in-order traversal of a special binary tree having property 
	// that the node is always greater than its left and right child
	// ex: {1, 5, 10, 40, 30, 15, 28, 20}
	public TreeNode buildSpecialTreeFromInorder(int[] array, int low, int high) {
		if (low > high) {
			return null;
		}
		
		int maxIndex = getMaxIndex(array, low, high);
		
		// Make a node for the max element
		TreeNode root = new TreeNode( array[maxIndex] );
		
		if (low == high) {
			return root;
		}
		
		// Build the left side
		root.left = buildSpecialTreeFromInorder(array, low, maxIndex - 1);
		
		// Build the right side
		root.right = buildSpecialTreeFromInorder(array, maxIndex + 1, high);
		
		return root;
		
	}
	public int getMaxIndex(int[] array, int low, int high) {
		int max = array[low],
			maxIndex = low;
		
		for(int i = low + 1; i < high; i++) {
			if (max < array[i]) {
				max = array[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	/**
	 * In Order Traversal
	 * 
	 * 1) Visit the left subtree
	 * 2) Visit the root
	 * 3) Visit the right subtree
	 * 
	 * @param node
	 */
	public void dfInOrder(TreeNode node) {
		if (node != null) {
			dfInOrder(node.left);
			System.out.println("Value of the node is: " + node.value);
			dfInOrder(node.right);
		}
	}
	
	/**
	 * Pre Order Traversal
	 * 
	 * 1) Visit the root
	 * 2) Visit the left subtree
	 * 3) Visit the right subtree
	 * 
	 * @param node
	 */
	public void dfPreOrder(TreeNode node) {
		if (node != null) {
			System.out.println("Visiting node: " + node.value);
			dfPreOrder(node.left);
			dfPreOrder(node.right);
		}
	}
	
	/**
	 * Post Order Traversal
	 * 
	 * 1) Visit the left subtree
	 * 2) Visit the right subtree
	 * 3) Visit the root
	 * 
	 * @param node
	 */
	public void dfPostOrder(TreeNode node) {
		if (node != null) {
			dfPostOrder(node.left);
			dfPostOrder(node.right);
			System.out.println("Visiting node: " + node.value);
		}
	}
	
	public void serialize(TreeNode root) {
		if (root == null) {
			System.out.printf(" # ");
		} else {
			System.out.printf(" %s ", root.value);
			serialize(root.left);
			serialize(root.right);
		}
	}

	/** CONVERSION ALGOS **/
	// Doesnt work
	private DoublyLinkedNode convertToDLL(TreeNode root, DoublyLinkedNode first, DoublyLinkedNode last) {
	    if (root == null) {
	        return null;
	    }
	    
	    convertToDLL(root.left, first, last);   
	    
	    // Inorder portion of things
	    DoublyLinkedNode newNode = new DoublyLinkedNode(root.value);
	    final DoublyLinkedNode l = last;
	    last = newNode;
	    
	    if (l == null) {
	        first = newNode;
	        System.out.println("null");
	    } else {
	        l.next = newNode;
	        last.prev = l;
	    }
	    
	    convertToDLL(root.right, first, last);
	    
	    printList(first);
	    System.out.println("--------");
	    
	    return first;
	}
	
	private LinkedList<Integer> convertToLLInPlace(TreeNode root, LinkedList<Integer> head) {
	    if (root == null) {
	        return null;
	    }
	    
	    convertToLLInPlace(root.left, head);
    	
	    head.addLast(root.value);
    	
    	convertToLLInPlace(root.right, head);
    	
	    return head;
	}
	
	DoublyLinkedNode llfirst = null;
	DoublyLinkedNode lllast = null;
	private void convertToLL(TreeNode root) {
	    if (root == null) {
	        return;
	    }
	    
	    convertToLL(root.left);   
	    
	    // Inorder portion of things
	    DoublyLinkedNode newNode = new DoublyLinkedNode(root.value);
	    
	    final DoublyLinkedNode l = lllast;
	    lllast = newNode;
	    
	    if (l == null)	
	    	llfirst = newNode;
	    else {
	        l.next = newNode;
	        lllast.prev = l;
	    }
	    
	    convertToLL(root.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
	}
}
