/**
 * Veer Saini
 *
 * This is the ObjectList Class
 * This class is made to store any type of object.
 * This class is used to store an array of Fraction and
 * FractionCounter Objects
 */

public class ObjectList {   //or IntList, caps at 100 elements with no bullet-proofing or bounds checks, etc.
    private int numElements = 0;
    private Object[] myObjects = new Object[10000];

    /**
     * This is the getLength method
     * The main usecase for this method is to return the length of
     * myObjects that are used
     * Since numElements has that information, we can just return
     * that int.
     *
     * @return
     */
    public int getLength() {
        return numElements;
    }

    /**
     * This is the add method that allows you to add elements into the array
     * The numElements here is useful as a placeholder and information about
     * how full your array is and the actual size of the array that has
     * information inserted
     *
     * @param nx
     */
    public void add(Object nx) {
        myObjects[numElements++] = nx;
    }

    /**
     * This is the toString method that overrides the default toString method
     * The loop inside the method is there to make sure that all the
     * elements that are in myObjects are all printed out
     *
     * An example of myObjects that hold FractionCounter objects are
     * "2/1 has a count of 3
     * 5/9 has a count of 1
     * 8/9 has a count of 2"
     *
     * @return
     */
    public String toString() {
        String retVal = "";
        for(int i = 0; i < numElements; i++) {
            retVal += myObjects[i].toString() + "\n";
        }
        return retVal;
    }

    /**
     * This is the getFraction method that returns fractions that are in myElements
     * This method was created to compliment code that is used in Driver.java
     * In the case that ObjectList has all Fraction, you can use this
     * method to get fractions that are in that object
     *
     * @param index
     * @return
     */
    public Fraction getFraction(int index) {
        return (Fraction) myObjects[index];
    }

    /**
     * This is similar to the method above, except this returns the
     * FractionCounter object instead of the Fraction object
     * This method was created to compliment code that is used in Driver.java
     * In the case that ObjectList has all FractionCounter objects,
     * you can use this method to get fractionsCounters that are in that object
     *
     * @param index
     * @return
     */
    public FractionCounter getFractionCounter(int index) {
        return (FractionCounter) myObjects[index];
    }

    /**
     * This method is called hasFraction
     * This method was created to check if the ObjectList has a Fraction
     * within the Array associated with that ObjectList obj.
     * This method was created to compliment some code that is in Driver.java
     *
     * @param fraction
     * @return
     */
    public boolean hasFraction(Fraction fraction) {
        for(int i = 0; i < numElements; i++) {
            if(myObjects[i].equals(fraction)) {
                return true;
            }
        }
        return false;
    }
}