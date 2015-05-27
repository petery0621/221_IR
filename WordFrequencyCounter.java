package one.b;

import one.a.Frequency;
import one.a.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Counts the total number of words and their frequencies in a text file.
 */
public final class WordFrequencyCounter {
	/**
	 * This class should not be instantiated.
	 */
	private WordFrequencyCounter() {}
	
	/**
	 * Takes the input list of words and processes it, returning a list
	 * of {@link Frequency}s.
	 * 
	 * This method expects a list of lowercase alphanumeric strings.
	 * If the input list is null, an empty list is returned.
	 * 
	 * There is one frequency in the output list for every 
	 * unique word in the original list. The frequency of each word
	 * is equal to the number of times that word occurs in the original list. 
	 * 
	 * The returned list is ordered by decreasing frequency, with tied words sorted
	 * alphabetically.
	 * 
	 * The original list is not modified.
	 * 
	 * Example:
	 * 
	 * Given the input list of strings 
	 * ["this", "sentence", "repeats", "the", "word", "sentence"]
	 * 
	 * The output list of frequencies should be 
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 *  
	 * @param words A list of words.
	 * @return A list of word frequencies, ordered by decreasing frequency.
	 */
	public static List<Frequency> computeWordFrequencies(List<String> words) {
		// TODO Write body!
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		for (String w: words){
			if (!map.containsKey(w)){
				map.put(w, 1);
			}else {
				map.put(w, map.get(w)+1);
			}
		}
		
		ArrayList<Frequency> fs = new ArrayList<Frequency>();
		for (String w: words){
			if (map.get(w) != 0){
				fs.add(new Frequency(w, map.get(w)));
				map.put(w, 0);
			}
			
		}
		
		return fs;
	}
	
	/**
	 * Runs the word frequency counter. The input should be the path to a text file.
	 * 
	 * @param args The first element should contain the path to a text file.
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("src/one/d/analysis.txt");
		List<String> words = Utilities.tokenizeFile(file);
		List<Frequency> frequencies = computeWordFrequencies(words);
		Utilities.printFrequencies(frequencies);
	}
}


/* Total item count: 15
Unique item count: 13

please    	1
place     	1
your      	2
analysis  	1
of        	2
the       	1
runtime   	1
complexity	1
palindrome	1
algorithm 	1
in        	1
this      	1
file      	1

*/

