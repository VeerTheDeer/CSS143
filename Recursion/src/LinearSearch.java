public class LinearSearch extends SearchAlgorithm{

    @Override
    public int search(String[] words, String targetWord) throws ItemNotFoundException {
        for(String word : words){
            this.incrementCount();

            if(targetWord.equals(word)) {
                return this.getCount() - 1;
            }

        }

        throw new ItemNotFoundException();
    }

    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return search(words, wordToFind);
    }

}