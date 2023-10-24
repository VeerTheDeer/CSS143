/**
 * The ArrayList class is a simple implementation of an array-based list
 * with dynamic sizing, allowing you to store and manipulate a collection
 * of objects.
 *
 * By Veer Saini
 */
public class ArrayList {

    private Object[] arrayList = new Object[100000000];
    private int elements = 0;

    /**
     * Adds an object to the end of the ArrayList.
     *
     * @param obj The object to be added to the ArrayList.
     */
    public void add(Object obj){
        arrayList[elements] = obj;
        elements++;
    }

    /**
     * Inserts an object at the specified index, shifting the existing
     * elements to make room for the new object.
     *
     * @param obj   The object to be inserted.
     * @param index The index at which to insert the object.
     */
    public void insert(Object obj, int index){
        elements++;

        Object temp = obj;
        Object temp2 = arrayList[index];

        for(int i = 0; i < elements; i++){
            arrayList[index+i] = temp;
            temp = temp2;
            temp2 = arrayList[index+i+1];
        }
    }

    /**
     * Removes the object at the specified index and shifts the remaining
     * elements to fill the gap.
     *
     * @param index The index of the object to be removed.
     * @return The removed object.
     */
    public Object remove(int index){
        Object objAtIndex = arrayList[index];

        for(int i = 0; i < elements; i++){
            if(elements > index)
                arrayList[index+i] = arrayList[index+i+1];
        }
        elements--;
        return objAtIndex;
    }

    /**
     * Returns the number of elements currently in the ArrayList.
     *
     * @return The number of elements.
     */
    public int size(){
        return elements;
    }

    /**
     * Generates a string representation of the ArrayList.
     *
     * @return A string representation of the ArrayList.
     */
    public String toString(){
        String retVal = "";
        for(int i = 0; i < elements; i++){
            retVal += arrayList[i] + " ";
        }
        return retVal;
    }

    /**
     * Indicates whether some other object is "equal to" this stack.
     * Two ArrayLists are considered equal if they have the same elements in the
     * same order.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this stack is equal to the provided object;
     *         {@code false} otherwise.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayList))
            return false;

        ArrayList objectArray = (ArrayList) obj;
        for (int i = 0; i < elements; i++) {
            if ((this.arrayList[i]).equals(objectArray.arrayList[i]))
                continue;
            else
                return false;
        }
        if (this.size() != ((ArrayList) obj).size())
            return false;
        return true;
    }

    /**
     * Checks if the ArrayList is empty.
     *
     * @return true if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty(){
        return elements == 0;
    }

    /**
     * Finds the index of the first occurrence of the specified object
     * in the ArrayList.
     *
     * @param obj The object to search for.
     * @return The index of the object, or -1 if not found.
     */
    public int indexOf(Object obj){
        for(int i = 0; i < elements; i++){
            Object temp = arrayList[i];
            if(temp.equals(obj))
                return i;
        }
        return -1;
    }

    /**
     * Retrieves the object at the specified index in the ArrayList.
     *
     * @param index The index of the object to retrieve.
     * @return The object at the specified index.
     */
    public Object get(int index){
        return arrayList[index];

    }
}
