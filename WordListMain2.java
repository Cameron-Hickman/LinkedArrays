import java.io.*;
import java.util.*;

/**
 * 
 * @author TMyatt
 * 
 */
public class WordListMain2 {

	/**
	 * 
	 * @param inLine String
	 * @return
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}
	
	/**
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
		long mSec, mSecSum = 0;
		try {
			// Open the required text file for sequential read
			Scanner inputFile =
					new Scanner (new File("bible-complete.txt"));
			
			WordArrayList wordArrayList;
			wordArrayList = new WordArrayList();
			
			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");
				// We're going to do a millisecond execution calc
				mSec = System.nanoTime()/1000000;
				for (String s: verseParsed) {
					wordArrayList.addWord(s.toLowerCase());
				}
				mSecSum += (System.nanoTime()/1000000 - mSec);
			}		
			// Close the required file when EOF is reached
			inputFile.close();
			wordArrayList.printWordList(10000);
	        System.out.println("Elapsed Time: " + mSecSum + " ms");
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch		
	} // END main
} // END class
