package linkedlists;

public class MergeSort {
	public static LinkedListNode merge_sort(LinkedListNode head) {
        if (head == null || head.next == null) { 
        	return head; 
        }
        
        LinkedListNode middle = getMiddle(head); //get the middle of the list
        LinkedListNode sHalf = middle.next;
        
        // Cap off the first half of the linked list for the head
        middle.next = null; 

        return merge(merge_sort(head), merge_sort(sHalf));  //recurse on that
    }

    public static LinkedListNode merge(LinkedListNode a, LinkedListNode b) {
        LinkedListNode dummyHead = new LinkedListNode(); 
        LinkedListNode curr = dummyHead;
        
        while (a !=null && b!= null) {
            if (a.data <= b.data) { 
            	curr.next = a; 
            	a = a.next; 
            } else { 
            	curr.next = b; 
            	b = b.next; 
            }
            
            curr = curr.next;
        }
        
        curr.next = (a == null) ? b : a;
        
        return dummyHead.next;
    }

    public static LinkedListNode getMiddle(LinkedListNode head) {
        if(head == null) { 
        	return head; 
        }
        
        LinkedListNode slow, fast; 
        slow = fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; 
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
    	LinkedListNode root = new LinkedListNode(10);
    	root.appendToTail(1);
    	root.appendToTail(100);
    	root.appendToTail(22);
    	root.appendToTail(3);
    	root.appendToTail(19);
    	root.appendToTail(15);
    	root.appendToTail(11);
    	root.appendToTail(55);
    	
    	LinkedListNode result = MergeSort.merge_sort(root);
    	
    	System.out.println("sorted ll");
    	LinkedListNode.print(result);
    }
}
