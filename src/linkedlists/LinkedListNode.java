package linkedlists;

import java.util.Hashtable;

import stackandqueues.Stack;

public class LinkedListNode {
	LinkedListNode next = null;
	int data;
	
	public LinkedListNode() {
		
	}
	public LinkedListNode(int d) {
		data = d;
	}
	
	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		
		while (n.next != null) {
			n = n.next;
		}
		
		n.next = end;
	}
	
	public LinkedListNode deleteNode(LinkedListNode head, int d) {
		LinkedListNode n = head;
		
		if (n.data == d) {
			return head.next;
		}
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		
		return head;
	}
	
	public static LinkedListNode deleteDupsNoBuffer(LinkedListNode head) {
		if (head == null) {
			return head;
		}
		
		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode runner = current;
			
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			current = current.next;
		}
		
		return head;
	}
	
	public static LinkedListNode deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		LinkedListNode head = n;
		
		while (n != null) { 
			
			if (table.containsKey(n.data)) { 
				previous.next = n.next;
			} else { 
				table.put(n.data, true);
				previous = n;
			}
			
			n = n.next;
		}
		
		return head;
	}
	
	/** NTH TO LAST PROBLEMS **/
	public static int nthToLastRec(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		
		int i = nthToLastRec(head.next, k) + 1;
		if (i == k) {
			System.out.println("The " + k + "th to last value is: " + head.data);
		}
		
		return i;
	}
	
	public static LinkedListNode nthToLastIt(LinkedListNode head, int k) {
		if (k <= 0) return null;
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		// Move p2 K positions forward in the list
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null) return null;
			p2 = p2.next;
		}
		
		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		
		return p1;
	}
	
	public static void print(LinkedListNode n) {
		if (n != null) {
			System.out.println(n.data);
		}
		while (n.next != null) {
			System.out.println(n.next.data);
			n = n.next;
		}
	}
	
	public static void hasCycle(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		while (node.next != null && node.next.next != null) {
			System.out.println("slow: " + slow.data + " fast " + fast.data);
			
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow.data == fast.data) {
				System.out.println("CYCLE");
				return;
			}
			
			node = node.next;
		}
	}
	
	public static void findBeginning(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow.data == fast.data) {
				break;
			}
		}
		
		// No loop
		if (fast == null || fast.next == null) {
			return;
		}
		
		System.out.println("at the break, slow: " + slow.data + " fast: " + fast.data);
		
		slow = node;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		System.out.println("loop is at: " + fast.data);
	}
	
	public static void isPalindrome(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		Stack s = new Stack();
		
		System.out.println("head is: " + slow.data);
		
		while(fast != null && fast.next != null) {
			System.out.println("pushing " + slow.data + " onto the stack");
			s.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Odd number of elements, skip middle
		if (fast != null) {
			System.out.println("odd number of elements");
			slow = slow.next;
		}
		
		while(slow != null) {
			System.out.println("looking at " + slow.data);
			int val = ((Integer)s.pop()).intValue();
			
			if(slow.data != val) {
				System.out.println("not a palindrome.");
				break;
			}
			
			slow = slow.next;
		}
	}
	
	public static void main(String[] args) {
		// Initialize the LinkedList
//		LinkedListNode mll = new LinkedListNode(10);
//		mll.appendToTail(9);
//		mll.appendToTail(29);
//		mll.appendToTail(11);
//		mll.appendToTail(3);
//		mll.appendToTail(10);
//		mll.appendToTail(5);
//		mll.appendToTail(1);
//		mll.appendToTail(9);
//		mll.appendToTail(50);
//		
//		System.out.println("Printing LinkedList...");
//		LinkedListNode.print(mll);
		
//		System.out.println("\nDeleting duplicates no buffer...");
//		LinkedListNode revList = LinkedListNode.deleteDupsNoBuffer(mll);
//		LinkedListNode.print(revList);
//		
//		System.out.println("\nDeleting duplicates...");
//		revList = LinkedListNode.deleteDups(mll);
//		LinkedListNode.print(revList);		
		
//		System.out.println("\nFinding the kth to last");
//		LinkedListNode.nthToLastRec(mll, 3);
		
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode n1 = new LinkedListNode(2);
		LinkedListNode n2 = new LinkedListNode(3);
		LinkedListNode n3 = new LinkedListNode(4);
		LinkedListNode n4 = new LinkedListNode(3);
		LinkedListNode n5 = new LinkedListNode(2);
		LinkedListNode n6 = new LinkedListNode(1);
//		LinkedListNode n7 = new LinkedListNode(8);
//		LinkedListNode n8 = new LinkedListNode(9);
//		LinkedListNode n9 = new LinkedListNode(10);
//		LinkedListNode n10 = new LinkedListNode(11);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
//		n6.next = n7;
//		n7.next = n8;
//		n8.next = n9;
//		n9.next = n10;
		
		
		//LinkedListNode.findBeginning(head);
		LinkedListNode.isPalindrome(head);
	}
}
