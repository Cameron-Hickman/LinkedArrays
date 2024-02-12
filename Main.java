import java.io.*;
import java.util.*;

/**
* 
* @author CHickman
* 
* Description: Main class used to implement all other project classes
*/

public class Main {
	
	/**
	 * getVerse - Parse and return only the Psalms verse
	 * @param inLine the input line to parse
	 * @return the Psalms Verse
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}

	/**
	 * main method
	 * @param args an array of command-line arguments for the application 
	 */
	public static void  main(String[] args) {
		long mSec, mSecSum = 0;
		try {
			// open required text file to read
			Scanner inputFile = new Scanner (new File(args[0]));
			WordArrayList wordArrayList = null;
			WordLinkedList wordLinkedList = null;
			WordHashMap wordHashMap = null;
			
			// switch to control which listing class is used
			switch(args[1]) {
				case "A":
					wordArrayList = new WordArrayList();
					break;
				case "L": 
					wordLinkedList = new WordLinkedList();
					break;
				case "H":
					wordHashMap = new WordHashMap();
					break;
			}
			
			
			//Check for EOF, read the next line, and display it
				while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");
				
				mSec = System.nanoTime()/1000000;
				for (String s: verseParsed) {
					
					// switch to control which listing class is used
					switch(args[1]) {
					case "A":
						wordArrayList.addWord(s.toLowerCase());
						break;
					case "L": 
						wordLinkedList.addWord(s.toLowerCase());
						break;
					case "H":
						wordHashMap.addWord(s.toLowerCase());
						break;
					}
					
										
				}
				mSecSum += (System.nanoTime()/1000000 - mSec);
			}
			//Close the required file when EOF is reached
			inputFile.close();
			
			// switch to control printing
			switch(args[1]) {
			case "A":
				wordArrayList.printWordList(Integer.parseInt(args[2]));
				break;
			case "L": 
				wordLinkedList.printWordList(Integer.parseInt(args[2]));
				break;
			case "H":
				wordHashMap.printWordList(Integer.parseInt(args[2]));
				break;
			}
			
			
			System.out.println("Elasped Time:" + mSecSum + " ms");
		}// END try
			catch (Exception e) {
				// All Exceptions come here for graceful termination
				System.out.println("Error: " + e);
			} // END catch		
		} // END main
	} // END class
