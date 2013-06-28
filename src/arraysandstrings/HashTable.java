package arraysandstrings;

import java.util.HashMap;

class TestObject {
	int data;
	
	public TestObject(int data) {
		this.data = data;
	}
	
	public Integer getId() {
		Integer i = new Integer(data);
		return i.hashCode();
	}
}

public class HashTable {
	public HashMap<Integer, TestObject> buildMap(TestObject[] booleans) {
		HashMap<Integer, TestObject> map = new HashMap<Integer, TestObject>();
		for (TestObject o : booleans) {
			System.out.println("id: " + o.getId());
			map.put(o.getId(), o);
		}
		return map;
	}
	
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		
		TestObject to1 = new TestObject(1);
		TestObject to2 = new TestObject(2);
		TestObject to3 = new TestObject(3);
		TestObject to4 = new TestObject(4);
		TestObject to5 = new TestObject(5);
		
		TestObject[] toArr = {to1, to2, to3, to4, to5};
		
		HashMap<Integer, TestObject> result = ht.buildMap(toArr);
		System.out.println(result.toString());
	}
}
