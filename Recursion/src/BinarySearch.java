
public class BinarySearch extends SearchAlgorithm{

    @Override
    public int search(String[] words, String targetWord) throws ItemNotFoundException {
        int lowIDX = 0, highIDX = words.length-1, midIDX = highIDX/2;


        return recSearch(words, targetWord, lowIDX, highIDX, midIDX);
    }

    int recSearch(String[] words, String targetWord, int lowIDX, int highIDX, int midIDX) throws ItemNotFoundException{
        while(lowIDX <= highIDX){
            this.incrementCount();

            if(targetWord.equals(words[midIDX])) {
                return midIDX;
            }

            if(targetWord.compareTo(words[midIDX])<0) {
                return recSearch(words, targetWord, lowIDX, midIDX - 1, lowIDX + ((midIDX - 1 - lowIDX) / 2));
            } else {
                return recSearch(words, targetWord, midIDX + 1, highIDX, (midIDX + 1) + ((highIDX - midIDX) / 2));
            }

        }

        throw new ItemNotFoundException();
    }

    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return search(words, wordToFind);
    }
}