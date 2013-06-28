package linkedlists;

public class DoublyLinkedListNode {
	DoublyLinkedListNode leftChild;
    DoublyLinkedListNode rightChild;
    int data;
 
    DoublyLinkedListNode(int data) {
    	this.data = data;
    }
    
    DoublyLinkedListNode(DoublyLinkedListNode leftChild, DoublyLinkedListNode rightChild, int data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoublyLinkedListNode)) return false;
 
        DoublyLinkedListNode node = (DoublyLinkedListNode) o;
 
        if (data != node.data) return false;
        if (leftChild != null ? !leftChild.equals(node.leftChild) : node.leftChild != null) return false;
        if (rightChild != null ? !rightChild.equals(node.rightChild) : node.rightChild != null) return false;
 
        return true;
    }
 
    @Override
    public int hashCode() {
        int result = leftChild != null ? leftChild.hashCode() : 0;
        result = 31 * result + (rightChild != null ? rightChild.hashCode() : 0);
        result = 31 * result + data;
        return result;
    }
    
    public boolean hasNext() {
    	return rightChild == null;
    }
    
    public boolean hasPrev() {
    	return leftChild == null;
    }
    
    public static void checkForCycle(DoublyLinkedListNode node) {
    	DoublyLinkedListNode slow;
    	DoublyLinkedListNode fast;
    	
    	slow = fast = node;
    	
    	while(node.rightChild != null && node.rightChild.rightChild != null) {
    		System.out.println(node.data);
    		
    		slow = node.rightChild;
    		fast = node.rightChild.rightChild;
    		
    		if (slow.data == fast.data) {
    			System.out.println("CYCLE FOUND");
    			return;
    		}
    		
    		node = node.rightChild;
    	}
    	
    }
    
    public static void main(String[] args) {
    	DoublyLinkedListNode head = new DoublyLinkedListNode(5);
		DoublyLinkedListNode n1 = new DoublyLinkedListNode(15);
		DoublyLinkedListNode n2 = new DoublyLinkedListNode(65);
		DoublyLinkedListNode n3 = new DoublyLinkedListNode(23);
		DoublyLinkedListNode n4 = new DoublyLinkedListNode(60);
		DoublyLinkedListNode n5 = new DoublyLinkedListNode(15);
		DoublyLinkedListNode n6 = new DoublyLinkedListNode(21);
		DoublyLinkedListNode last = new DoublyLinkedListNode(1);
		
		head.rightChild = n1;
		head.leftChild = last;
		
		n1.rightChild = n2;
		n1.leftChild = head;
		
		n2.rightChild = n3;
		n2.leftChild = n1;
		
		n3.rightChild = n4;
		n3.leftChild = n2;
		
		n4.rightChild = n5;
		n4.leftChild = n3;
	
		n5.rightChild = n6;
		n5.leftChild = n4;
		
		n6.rightChild = last;
		n6.leftChild = n5;
		
		last.rightChild = n1;
		last.leftChild = n6;
		
		DoublyLinkedListNode.checkForCycle(head);
    }
}
