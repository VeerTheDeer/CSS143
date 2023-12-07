import java.util.Random;

public class MyArrayList implements Comparable<Object> {

    protected int[] intList;
    protected char[] charList;
    protected String[] stringList;

    public MyArrayList() {
        this.intList = new int[10];
        this.charList = new char[10];
        this.stringList = new String[]{"joe", "mark", "abbey", "tony", "kevin"};

        initializeIntArray();
        initializeCharArray();
    }

    private void initializeIntArray() {
        for (int i = 0; i < intList.length; i++) {
            intList[i] = (int) (Math.random() * 52);
        }
    }

    private void initializeCharArray() {
        Random random = new Random();
        for (int i = 0; i < charList.length; i++) {
            charList[i] = (char) (random.nextInt(26) + 'a');
        }
    }

    public void intBubbleSort() {
        boolean check;

        for (int i = 0; i < intList.length - 1; i++) {
            check = false;

            for (int j = 0; j < intList.length - i - 1; j++) {
                if (intList[j] > intList[j + 1]) {
                    swapInts(intList, j);
                    check = true;
                }
            }

            if (!check) break;
        }
    }

    public void charBubbleSort() {
        for (int i = 0; i < charList.length - 1; i++) {
            for (int j = 0; j < charList.length - i - 1; j++) {
                if (charList[j] > charList[j + 1]) swapChars(charList, j);
            }
        }
    }

    public void stringBubbleSort() {
        for (int i = 0; i < stringList.length - 1; i++) {
            for (int j = 0; j < stringList.length - i - 1; j++) {
                if (stringList[j].compareTo(stringList[j + 1]) > 0) swapStrings(stringList, j);
            }
        }
    }

    private void swapInts(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

    private void swapChars(char[] array, int j) {
        char temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

    private void swapStrings(String[] array, int j) {
        String temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

    public void selectionSort() {
        int n = intList.length;

        for (int i = 0; i < n - 1; i++) {
            int s = i;
            int l = i;

            for (int j = i + 1; j < n; j++) {
                if (intList[j] < intList[s]) s = j;
                else if (intList[j] > intList[l]) l = j;
            }

            swapSelection(intList, i, s);

            if (l == i) l = s;

            swapSelection(intList, n - 1, l);
        }
    }

    private void swapSelection(int[] array, int i, int nextMin) {
        int temp = array[i];
        array[i] = array[nextMin];
        array[nextMin] = temp;
    }

    public void stringSelectionSort() {
        int n = stringList.length;

        for (int i = 0; i < n - 1; i++) {
            int s = findSmallestString(stringList, i, n);
            swapSelectionStrings(stringList, i, s);
        }
    }

    private int findSmallestString(String[] array, int begin, int end) {
        int minIndex = begin;
        for (int i = begin + 1; i < end; i++) {
            if (array[i].compareTo(array[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void swapSelectionStrings(String[] array, int i, int next) {
        String temp = array[i];
        array[i] = array[next];
        array[next] = temp;
    }

    public void insertionSort() {
        for (int i = 0; i < intList.length - 1; i++) {
            int current = intList[i];
            int hole = i;

            while (i > 0 && intList[i - 1] > current) {
                intList[hole] = intList[hole - 1];
                hole--;
            }
            intList[hole] = current;
        }
    }

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof MyArrayList) {
            MyArrayList other = (MyArrayList) obj;

            if (this.intList[0] < other.intList[0]) return -1;
            else if (this.intList[0] > other.intList[0]) return 1;
            else return 0;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
