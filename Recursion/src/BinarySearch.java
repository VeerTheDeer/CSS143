/**
 * The BinarySearch class extends SearchAlgorithm and provides methods for binary search algorithm.
 * Implements search functionality using a recursive binary search algorithm.
 * Author: Veer Saini
 */
public class BinarySearch extends SearchAlgorithm {

    /**
     * Searches for a target word within an array of words using a recursive binary search algorithm.
     *
     * @param words      The array of words to be searched.
     * @param targetWord The word to be found within the array.
     * @return The index of the target word if found; otherwise, throws ItemNotFoundException.
     * @throws ItemNotFoundException If the target word is not present in the array.
     */
    @Override
    public int search(String[] words, String targetWord) throws ItemNotFoundException {
        int lowIDX = 0, highIDX = words.length - 1, midIDX = highIDX / 2;

        return recSearch(words, targetWord, lowIDX, highIDX, midIDX);
    }

    /**
     * Helper method for performing the recursive binary search.
     *
     * @param words   The array of words to be searched.
     * @param targetWord The word to be found within the array.
     * @param lowIDX  The lowest index in the current search range.
     * @param highIDX The highest index in the current search range.
     * @param midIDX  The middle index in the current search range.
     * @return The index of the target word if found; otherwise, throws ItemNotFoundException.
     * @throws ItemNotFoundException If the target word is not present in the array.
     */
    int recSearch(String[] words, String targetWord, int lowIDX, int highIDX, int midIDX) throws ItemNotFoundException {
        while (lowIDX <= highIDX) {
            this.incrementCount();

            if (targetWord.equals(words[midIDX])) {
                return midIDX;
            }

            if (targetWord.compareTo(words[midIDX]) < 0) {
                return recSearch(words, targetWord, lowIDX, midIDX - 1, lowIDX + ((midIDX - 1 - lowIDX) / 2));
            } else {
                return recSearch(words, targetWord, midIDX + 1, highIDX, (midIDX + 1) + ((highIDX - midIDX) / 2));
            }
        }

        throw new ItemNotFoundException();
    }

    /**
     * Invokes the search method to perform a recursive search.
     *
     * @param words      The array of words to be searched.
     * @param wordToFind The word to be found within the array.
     * @return The index of the word to find if found; otherwise, throws ItemNotFoundException.
     * @throws ItemNotFoundException If the word to find is not present in the array.
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return search(words, wordToFind);
    }
}
