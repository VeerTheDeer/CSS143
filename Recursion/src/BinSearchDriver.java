/**
 * The BinSearchDriver class executes both linear and binary searches on an array of strings to find specific targets.
 * Implements the binary search and linear search algorithms, comparing their performances.
 * Author: Veer Saini
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinSearchDriver {

	// The path to the file to be read
	public final static String FILE_AND_PATH = "longwords.txt";
	/*
	 * TODO: Be sure to change the FILE_AND_PATH to point to your local
	 * copy of longwords.txt or a FileNotFoundException will result
	 */

	// The main method to execute searches
	// Note: Deals with Java's Catch-or-Declare rule by declaring potential exceptions that might occur
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(FILE_AND_PATH));
		int wordCount = 0;
		ArrayList<String> theWords = new ArrayList<String>();

		// Read in words and count them
		while (input.hasNext()) {
			theWords.add(input.next());
			wordCount++;
		}

		// Make a standard array from an ArrayList
		String[] wordsToSearch = new String[theWords.size()];
		theWords.toArray(wordsToSearch);

		// Start with the linear searches
		tryLinearSearch(wordsToSearch, "DISCIPLINES");
		tryLinearSearch(wordsToSearch, "TRANSURANIUM");
		tryLinearSearch(wordsToSearch, "HEURISTICALLY");
		tryLinearSearch(wordsToSearch, "FOO");

		// Compare these results to the binary searches
		tryBinarySearch(wordsToSearch, "DISCIPLINES");
		tryBinarySearch(wordsToSearch, "TRANSURANIUM");
		tryBinarySearch(wordsToSearch, "HEURISTICALLY");
		tryBinarySearch(wordsToSearch, "FOO");
	}

	/**
	 * Tries to execute a binary search on the given array of words to find the target string.
	 *
	 * @param wordsToSearch An array of strings to perform the search on.
	 * @param target        The target string to search for.
	 */
	private static void tryBinarySearch(String[] wordsToSearch, String target) {
		SearchAlgorithm bs = new BinarySearch();

		try {
			System.out.print(target + " found at index: " + bs.search(wordsToSearch, target));
			System.out.println(" taking " + bs.getCount() + " comparisons.");
		} catch (ItemNotFoundException e) {
			System.out.println(target + ":" + e.getMessage());
		}
	}

	/**
	 * Tries to execute a linear search on the given array of words to find the target string.
	 *
	 * @param wordsToSearch An array of strings to perform the search on.
	 * @param target        The target string to search for.
	 */
	private static void tryLinearSearch(String[] wordsToSearch, String target) {
		SearchAlgorithm bs = new LinearSearch();

		try {
			System.out.print(target + " found at index: " + bs.search(wordsToSearch, target));
			System.out.println(" taking " + bs.getCount() + " comparisons.");

		} catch (ItemNotFoundException e) {
			System.out.println(target + ":" + e.getMessage());
		}
	}
}
