/**
 * SearchAlgorithm is an abstract class providing a framework to delegate various search strategies.
 * Author: Veer Saini
 */
public abstract class SearchAlgorithm {

	/**
	 * Method search: an abstract method used to implement a specific search strategy over the given array looking for the target word.
	 *
	 * @param words      An array of strings to be searched.
	 * @param wordToFind The word to be found within the array.
	 * @return The index of the target word if found.
	 * @throws ItemNotFoundException If the target word is not present in the array.
	 */
	public abstract int search(String[] words, String wordToFind) throws ItemNotFoundException;

	/**
	 * Method recSearch: an abstract method to perform a recursive search for a specific word within the given array.
	 *
	 * @param words      An array of strings to be searched.
	 * @param wordToFind The word to be found within the array.
	 * @return The index of the word to find if found.
	 * @throws ItemNotFoundException If the word to find is not present in the array.
	 */
	public abstract int recSearch(String[] words, String wordToFind) throws ItemNotFoundException;

	/**
	 * Utility Features: This class is capable of tracking the number of search comparisons.
	 */
	private int count = 0;

	/**
	 * Increment the count of comparisons performed during searches.
	 */
	public void incrementCount() {
		count++;
	}

	/**
	 * Retrieve the count of comparisons performed during searches.
	 *
	 * @return The count of comparisons performed.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Reset the count of comparisons to zero.
	 */
	public void resetCount() {
		count = 0;
	}
}
