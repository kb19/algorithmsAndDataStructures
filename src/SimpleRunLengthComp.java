
public class SimpleRunLengthComp {
	private String compress(String input) {
		
		int charCount = 0;
		char prevChar = 0;
		String encodedStr = "";
		
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			// New character, add onto the compressed string
			if (prevChar != c && i != 0) {
				encodedStr +=  Integer.toString(charCount) + prevChar;
				charCount = 1;
			} else { // Same character, increase the count
				charCount++;
			}
			
			prevChar = c;
		}
		
		// Make sure the last characters are added to the compressed string
		encodedStr += prevChar + Integer.toString(charCount);
		
		return encodedStr;
		
	}
	
	public static void main(String[] args) {
		SimpleRunLengthComp srlc = new SimpleRunLengthComp();
		
		String val = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		String compStr = srlc.compress(val);
		
		System.out.printf("compressed string is %s", compStr);
	}
}
