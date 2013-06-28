package stackandqueues;

public class StackMax {
	NodeInt main, max;
	
	public Integer pop() {
		if (main != null) {
			Integer item = main.data;
			main = main.next;
			max = max.next;
			
			return item;
		}
		
		return null;
	}
	
	public void push(int item) {
		NodeInt newNode = new NodeInt(item);
		newNode.next = main;
		main = newNode;
		
		// Update max
		Integer oldMax = max.data;
		
		// Push the old max onto the stack
		NodeInt newMax;
		if (oldMax > item) {
			newMax = new NodeInt(oldMax);
		} else { // Push the new max onto the stack
			newMax = new NodeInt(item);
		}
		
		newMax.next = max;
		max = newMax;
	}
	
	public Object peek() {
		return main.data;
	}
	
	public Integer peekMax() {
		return max.data;
	}
	
	public boolean isEmpty() {
		return main == null;
	}

}
