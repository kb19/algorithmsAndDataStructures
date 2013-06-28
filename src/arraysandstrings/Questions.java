package arraysandstrings;

import java.util.Arrays;
import java.util.Hashtable;

public class Questions {
	public boolean uniqueCheck(String str) {
		Hashtable ht = new Hashtable();
		
		if (str.length() > 256) {
			return false;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (ht.containsKey(c)) {
				return false;
			} else {
				ht.put(c, true);
			}
		}
		
		return true;
	}
	
	public String spaceReplace(String str) {
		return str.replaceAll("\\s", "%20");
	}
	
	public String spaceReplaceNoRegex(String str) {
		char[] strArr = str.toCharArray();
		
		int length = strArr.length,
			spaceNum = 0;
		
		// Calculate how many spaces are in the string
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == ' ') {
				spaceNum++;
			}
		}
		
		int newLength = strArr.length + spaceNum*2,
			newIdx = 0;
		char[] newArr = new char[newLength];
		
		for (int x = 0; x < strArr.length; x++) {
			char c = strArr[x];
			
			if (c == ' ') {
				newArr[newIdx] = '%';
				newArr[newIdx + 1] = '2';
				newArr[newIdx + 2] = '0';
				
				newIdx += 3;
			} else {
				newArr[newIdx] = c;
				newIdx++;
			}
		}
		
		return new String(newArr);
	}
	
	public boolean permutationCheck(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] str1arr = str1.toCharArray();
		Arrays.sort(str1arr);
		
		char[] str2arr = str2.toCharArray();
		Arrays.sort(str2arr);
		
		return Arrays.equals(str1arr, str2arr);
	}
	
	/**
	 * Checks to see if str2 is a rotation of str1
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean isRotation(String str1, String str2) {
		String strDouble = str1 + str1;
		
		return strDouble.contains(str2);
	}
	
	public static void main(String[] args) {
		Questions q = new Questions();
		
		boolean isUnique = q.uniqueCheck("derpderpderp");
		System.out.println("\nis 'derpderpderp' unique? " + isUnique);
		
		isUnique = q.uniqueCheck("qwertyuiopasdfghjkl");
		System.out.println("\nis 'qwertyuiopasdfghjkl' unique? " + isUnique);
		
		boolean isPermutation = q.permutationCheck("derp", "perd");
		System.out.println("\nisPermutation: " + isPermutation);
		
		System.out.println("\nreplaced string: " + q.spaceReplace("derp derp a bad body"));
		
		System.out.println("\nreplaced string no regex: " + q.spaceReplaceNoRegex("derp derp a bad body"));
		
		System.out.println("\nis substring: " + q.isRotation("erpd", "pder"));
	}
}
