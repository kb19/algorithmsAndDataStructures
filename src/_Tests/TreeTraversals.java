package _Tests;

import java.util.Queue;

import stackandqueues.Stack;
import trees.TreeNode;

public class TreeTraversals {
	public static void inorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		
		inorderTraversal(node.left);
		
		System.out.println("At node: " + node.value);
		
		inorderTraversal(node.right);
	}
	
	public static void breadthFirst(TreeNode node) {
		stackandqueues.Queue q = new stackandqueues.Queue();
		
		q.enqueue(node);
		
		while(!q.isEmpty()) {
			TreeNode n = (TreeNode) q.dequeue();
			
			if (n != null) {
				System.out.println("Looking at node: " + n.value);
				
				q.enqueue(n.left);
				q.enqueue(n.right);
			}
		}
	}
	
	public static void depthFirst(TreeNode node) {
		Stack s = new Stack();
		
		s.push(node);
		
		while (!s.isEmpty()) {
			TreeNode n = (TreeNode) s.pop();
			
			if (n != null) {
				System.out.println("Looking at node: " + n.value);
				
				s.push(n.right);
				s.push(n.left);
			}
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
		
		System.out.println("-----in order traversal");
		TreeTraversals.inorderTraversal(tn);
		
		System.out.println("\n-----breadth first traversal");
		TreeTraversals.breadthFirst(tn);
		
		System.out.println("\n-----depth first traversal");
		TreeTraversals.depthFirst(tn);
	}
}
