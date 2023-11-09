/**
 * The LinearSearch class extends SearchAlgorithm and provides methods for linear search algorithm.
 * Implements search functionality by traversing through an array sequentially to find a specific word.
 * Author: Veer Saini
 */
public class LinearSearch extends SearchAlgorithm {

    /**
     * Searches for a target word within an array of words using the linear search algorithm.
     *
     * @param words      The array of words to be searched.
     * @param targetWord The word to be found within the array.
     * @return The index of the target word if found; otherwise, throws ItemNotFoundException.
     * @throws ItemNotFoundException If the target word is not present in the array.
     */
    @Override
    public int search(String[] words, String targetWord) throws ItemNotFoundException {
        for (String word : words) {
            this.incrementCount();

            if (targetWord.equals(word)) {
                return this.getCount() - 1;
            }
        }

        throw new ItemNotFoundException();
    }

    /**
     * Invokes the search method to perform a linear search.
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
