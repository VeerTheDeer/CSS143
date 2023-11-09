/**
 * The LinearSearch class extends SearchAlgorithm and provides methods for the linear search algorithm.
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
     * Recursively searches for a target word within an array of words.
     *
     * @param words      The array of words to be searched.
     * @param targetWord The word to be found within the array.
     * @return The index of the target word if found; otherwise, throws ItemNotFoundException.
     * @throws ItemNotFoundException If the target word is not present in the array.
     */
    @Override
    public int recSearch(String[] words, String targetWord) throws ItemNotFoundException {
        incrementCount();
        if (words[0].equals(targetWord)) {
            return 1;
        } else {
            String[] tempArr = new String[words.length - 1];
            for (int i = 0; i < words.length - 1; i++) {
                tempArr[i] = words[i + 1];
            }
            return 1 + recSearch(tempArr, targetWord);
        }
    }
    /*
     * There is a stackoverflow error sent because of this being a linear search using recursion
     * Since its linear search, the search is going line by line, and when using recursion this is a problem.
     * This is because you can only have a limited amount of recursions and go down a limited amount of levels
     * Since you are going line by line, and the file is huge, you are bound to reach the limit called
     * "Stack Overflow."
     */
}
