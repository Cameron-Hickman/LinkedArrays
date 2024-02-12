import java.util.*;

/**
 * 
 * @author CHickman
 * 
 * Description: The implementation of WordList
 * using the Java build-in ArrayList dynamic arrays.
 */

class WordCountNode {
	/** initialize word*/
	String word;
	
	/** initialize count*/
	int count;
	
	
	
	/**
	 * WordCountNode constructor
	 * @param inWord
	 * param is the inserted word
	 */
	public WordCountNode(String inWord) {
		word = inWord;
		count = 1;
	}	
	
	/**
	 * @return the word object
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the count object
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the count object, auto-incremented
	 */
	public int incrementCount() {
		count++;
		return count;
	}
}

/**
 * 
 * @author CHickman
 * 
 * Description: The implementation of WordList
 * using the Java built-in Linked List.
 */
public class WordLinkedList extends WordList {
	/**initialize words linked list*/
	static LinkedList<WordCountNode> words = new LinkedList<WordCountNode>();
	
	/**
	 * Public constructor method WordLinkedList
	 */
	public WordLinkedList() {
		super();
		
	}
	
	
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
public int findWord(String inWord) {
		
		boolean foundWord = false;
		int count = 0;
		
		ListIterator<WordCountNode> wli = words.listIterator();
		
		while(wli.hasNext()) {
			WordCountNode n = (WordCountNode) wli.next();
			if( inWord.compareTo(n.getWord()) == 0) {
				foundWord = true ;
				count = n.getCount();
				break;
				
			}
		}
		
		if (foundWord) {
			return count;
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
	ListIterator<WordCountNode> wli = words.listIterator();
	int count = 0;
	
	while(wli.hasNext()) {
		WordCountNode n = (WordCountNode) wli.next();
		if( inWord.compareTo(n.getWord()) == 0) {
			foundWord = true ;
			n.incrementCount();
			count = n.getCount();
			break;
			
		}
	}
	if (foundWord) {
		super.incTotalAllWords();
		
	}
	else {
		super.incNumUniqueWords();
		super.incTotalAllWords();
		wli.add(new WordCountNode(inWord));
		
		
	}
	
	return count;
	
			
}



/**
 * Public method incWord
 * @param inWord String
 * @return 0 if inWord not found, new inWord count if found
 */
public int incWord(String inWord) {
	boolean foundWord = false;
	ListIterator<WordCountNode> wli = words.listIterator();
	int count = 0;
	
	while(wli.hasNext()) {
		WordCountNode n = (WordCountNode) wli.next();
		if( inWord.compareTo(n.getWord()) == 0) {
			foundWord = true ;
			count = n.getCount();
			n.incrementCount();
			break;
			
		}
	}
	if (foundWord) {
		super.incTotalAllWords();
		
		return count;
	}
	else {
		return 0;
	}
	
}





/**
 * Public method printWordList
 * @param inMinimum int
 */
public void printWordList(int inMinimum) {
	System.out.println(super.toString());
	ListIterator<WordCountNode> wli = words.listIterator();

	while(wli.hasNext()) {
		WordCountNode n = (WordCountNode) wli.next();
		if( n.getCount() > inMinimum) {
			
			System.out.println(n.getWord()+" "+n.getCount());
			
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

	
	
	
	
	