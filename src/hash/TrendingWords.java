package hash;

import java.util.HashMap;
import java.util.List;

public class TrendingWords {
	
	public TrendingWords() {
		String[] words = {"derp", "barf", "test", "barf", "michael", "house", "house", "house", "tree", "road", "car", "car", "truck", "person", "friend", "book","book", "book", "book", "book"};
	
		buildMap(words);
	}
	
	public HashMap<String, Integer> buildMap(String[] words) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String word : words) {
			if (map.containsKey(word)) {
				int wordCount = map.get(word);
				map.put(word, wordCount + 1);
			} else {
				map.put(word, 1);
			}
		}
		

		
		return map;
	}
	
	public static void main(String[] args) {
		TrendingWords tw = new TrendingWords();
	}
}
