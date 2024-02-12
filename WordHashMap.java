import java.util.Map.Entry;

import java.util.*;

/**
 * 
 * @author CHickman
 * 
 * Description: The implementation of WordList
 * using the built in Java HashMap.
 */
public class WordHashMap extends WordList {
	/**initialize hash map*/
	static HashMap<String, Integer>wordsHash = new HashMap<String, Integer>();
	
	/**
	 * Public constructor method WordLinkedList
	 */
	public WordHashMap() {
		super();
		
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		boolean foundWord = false;
		
		if (wordsHash.containsKey(inWord)) {
			foundWord = true;
			
		}
		
		if(foundWord) {
			return wordsHash.get(inWord);
		}
		else {
			return 0;
		}
	}
	/**
	 * Public method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList
	 */
	public boolean existsWord(String inWord) {
		if (findWord(inWord) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Public method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		boolean foundWord = false;
		int count = wordsHash.getOrDefault(inWord, 0);
		
		if (wordsHash.containsKey(inWord)) {
			foundWord = true;
			
		}
		
		if (foundWord) {
			wordsHash.put(inWord, count + 1);	
			super.incTotalAllWords();
		}
		else {
			super.incNumUniqueWords();
			super.incTotalAllWords();
			wordsHash.put(inWord, 1);
			
		}
		
		return wordsHash.get(inWord);
		
	}
	
	
	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		boolean foundWord = false;
		int count = wordsHash.getOrDefault(inWord, 0);
		
		if (wordsHash.containsKey(inWord)) {
			foundWord = true;
			
		}
		
		if (foundWord) {
			wordsHash.put(inWord, count + 1);	
			super.incTotalAllWords();
			return wordsHash.get(inWord);
		}
		else {
			return 0;
		}
		
	}

	// Code to print hash list using an iterator
	public void printWordList(int inMinimum) {
		System.out.println(super.toString());
		if (wordsHash.size() > 0) {
			
			
			
			
			for( Entry<String, Integer> entry : wordsHash.entrySet() ){
				if(entry.getValue() >= inMinimum) {
			    System.out.println( entry.getKey() + ": " + entry.getValue() );
			}
			}
			
		}
		
	}
	/**
	 * Public string method toString
	 * @return A string with Unique Words and Total Word Count
	 */
	public String toString() {
		return super.toString();
	}

}

