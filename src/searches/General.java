package searches;

import stackandqueues.Queue;
import stackandqueues.Stack;

class Node {
	Node left = null;
	Node right = null;
	int data;
	boolean visited = false;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void addLeft(Node left) {
		this.left = left;
	}
	
	public void addRight(Node right) {
		this.right = right;
	}
}

class General {
	/**
	 * Implement using a Queue. If we have a graph check for visited nodes to
	 * avoid an infinite loop.
	 * 
	 * @param root
	 * @param target
	 * @param level
	 * @return
	 */
	public static void bfs(Node root, int target) {
	    if (root == null)
	        return;
	    
	    Queue queue = new Queue() ;
	    queue.enqueue(root);
	    
	    while(!queue.isEmpty()){
	        Node node = (Node)queue.dequeue();
	        
	        if (node.data == target) {
	        	System.out.println("Found target");
	        	return;
	        }
	        
	        System.out.print(node.data + " ");
	                
	        if(node.left != null) queue.enqueue(node.left);
	        if(node.right != null) queue.enqueue(node.right);
	    }
	}
	
	/**
	 * Implement using a Stack
	 * @param root
	 * @param target
	 * @param level
	 * @return
	 */
	public static boolean dfs(Node root, int target, int level) {
		if (root == null) {
			return false;
		}
		
		if (root.data == target) {
			System.out.println("target found on level: " + level);
			return true;
		}
		
		System.out.print(root.data + " ");
		
		level++;
		return dfs(root.left, target, level) || dfs(root.right, target, level);
    }
	
	public static void dfsStack(Node root, int target) {
		if (root == null)
	        return;
	    
	    Stack s = new Stack();
	    s.push(root);
	    
	    while(!s.isEmpty()){
	        Node node = (Node)s.pop();
	        
	        if (node.data == target) {
	        	System.out.println("Found target");
	        	return;
	        }
	        
	        System.out.print(node.data + " ");
	        
	        if(node.right != null) s.push(node.right);
	        if(node.left != null) s.push(node.left);
	    }
    }
	
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.println(root.data);
		inorder(root.left);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(55);
		
		Node left2 = new Node(22);
		Node right2 = new Node(82);
		
		Node left3 = new Node(10);
		Node leftleft3 = new Node(2);
		Node right3 = new Node(34);
		Node rightright3 = new Node(86);
		
		left2.addLeft(left3);
		left2.addRight(leftleft3);
		right2.addLeft(right3);
		right2.addRight(rightright3);
		
		root.addLeft(left2);
		root.addRight(right2);
		
		General.inorder(root);
		
		//boolean result = General.dfs(root, 22, 0);
		//System.out.println("Was the search term found? " + result);
		
		System.out.print("\nBFS: ");
		General.bfs(root, 34);
		
		System.out.print("\nDFS: ");
		General.dfs(root, 86, 0);
		
		System.out.print("\nDFS stack: ");
		General.dfsStack(root, 86);
		
	}
}