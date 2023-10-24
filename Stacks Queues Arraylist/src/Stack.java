/**
 * The Stack class represents a basic stack data structure
 * implemented using an array, allowing you to push and pop
 * objects onto and from the stack.
 *
 * By Veer Saini
 */
public class Stack extends ArrayBasedDataStructuresDriver{

    private Object[] stack = new Object[10000000];
    private Object stackTop;
    private int elements;

    /**
     * Pushes an object onto the top of the stack.
     *
     * @param obj The object to be pushed onto the stack.
     */
    public void push(Object obj){
        elements++;
        stackTop = obj;

        for(int i = 0; i < elements; i++){
            Object temp = stack[elements-i-1];
            stack[elements-i] = temp;
        }
        stack[0] = obj;
    }

    /**
     * Pops the object from the top of the stack.
     *
     * @return The object popped from the stack.
     */
    public Object pop(){
        stackTop = stack[0];
        for(int i = 0; i < elements; i++){
            stack[i] = stack[i+1];
        }
        if(elements == 0)
            stack[0] = null;
        elements--;
        return stackTop;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size(){
        return elements;
    }

    /**
     * Generates a string representation of the stack.
     *
     * @return A string representation of the stack.
     */
    public String toString(){
        String retVal = "";
        for(int i = 0; i < elements; i++){
            retVal += stack[i] + " ";
        }
        return retVal;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty(){
        return elements == 0;
    }

    /**
     * Indicates whether some other object is "equal to" this stack.
     * Two stacks are considered equal if they have the same elements in the
     * same order.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this stack is equal to the provided object;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayList))
            return false;

        Stack objectArray = (Stack) obj;



        for (int i = 0; i < elements; i++) {
            if ((this.stack[i]).equals(objectArray.stack[i]))
                continue;
            else
                return false;
        }
        if (this.size() != ((Stack) obj).size())
            return false;
        return true;
    }

    public Object get(int index){
        return stack[index];
    }
}
