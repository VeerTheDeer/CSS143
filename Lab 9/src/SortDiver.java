public class SortDiver {
   public static void main(String[] args) {
        
        MyArrayList array = new MyArrayList();
        MyArrayList other = new MyArrayList();
        
        System.out.print("Object instance lists: \n");
        for(int i = 0; i < array.intList.length; i++) {
            System.out.print(array.intList[i] + "|");
        }
        System.out.println();

          for(int i = 0; i < array.charList.length; i++) {
           System.out.print(array.charList[i] + "|");
        }
        System.out.println();

        for(int i = 0; i < array.stringList.length; i++) {
            System.out.print(array.stringList[i] + "|");
        }
        System.out.println();

        // testing bubble sort for ints
        array.intBubbleSort();
        System.out.print("\n\nSorted int array: \n" );
        for(int i = 0; i < array.intList.length; i++) {
           System.out.print(array.intList[i] + "|");
        }
        // testing bubble sort for chars
        array.charBubbleSort();
        System.out.print("\n\nSorted char array: \n" );
        for(int i = 0; i < array.charList.length; i++) {
           System.out.print(array.charList[i] + "|");
        }

        // testing bubble sort for strings
        array.stringBubbleSort();
        System.out.print("\n\nSorted String array: \n" );
        for(int i = 0; i < array.stringList.length; i++) {
           System.out.print(array.stringList[i] + "|");
        } 
        
        // NOTE: You must comment out previous calls for int sort methods, 
        //       at this point the arrays are already sorted!
        array.selectionSort();
        System.out.print("\n\nSorted int array using selectionSort(): \n" );
        for(int i = 0; i < array.intList.length; i++) {
           System.out.print(array.intList[i] + "|");
        } 
        
        // NOTE: You must comment out previous calls for String sort methods, 
        //       at this point the arrays are already sorted!
        array.stringSelectionSort();
        System.out.print("\n\nSorted String array using stringSelectionSort(): \n" );
        for(int i = 0; i < array.stringList.length; i++) {
           System.out.print(array.stringList[i] + "|");
        }
//        System.out.println();
//        // lets see what is in other object first
//        System.out.println("\nOther object's intList[] has: " );
//        for(int i = 0; i < other.intList.length; i++) {
//            System.out.print(other.intList[i] + "|");
//        }
//        System.out.println();
//
//        array.compareTo(other);

       // NOTE: You must comment out previous calls for int sort methods,
       //       at this point the arrays are already sorted!
       array.insertionSort();
       System.out.print("\n\nSorted int array using insertionSort(): \n" );
       for(int i = 0; i < array.intList.length; i++) {
           System.out.print(array.intList[i] + "|");
       }



   }
}

    

