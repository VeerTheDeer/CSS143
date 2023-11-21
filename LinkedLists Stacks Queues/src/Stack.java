/**
 * A Stack implementation that extends the List class, providing stack-specific operations.
 * This class represents a last-in, first-out (LIFO) data structure.
 *
 * By: Veer Saini
 */
public class Stack extends List {

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        super();
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param obj the element to be pushed onto the stack
     * @throws LinkedListException if there is an issue with the push operation
     */
    public void push(Object obj) throws LinkedListException {
        super.insert(obj, 0);
    }

    /**
     * Pops an element from the stack.
     *
     * @return the popped element
     * @throws LinkedListException if there is an issue with the pop operation (e.g., popping from an empty stack)
     */
    public Object pop() throws LinkedListException {
        return super.remove(0);
    }

    /**
     * Inserts an element into the stack, effectively pushing it.
     *
     * @param next  the data to be pushed onto the stack
     * @param index the index at which the data should be pushed onto the stack (always 0 in a stack)
     * @throws LinkedListException if there is an issue with the push operation
     */
    @Override
    public void insert(Object next, int index) throws LinkedListException {
        push(next);
    }

    /**
     * Removes an element from the stack, effectively popping it.
     *
     * @param index the index from which the data should be popped (always 0 in a stack)
     * @return the popped element
     * @throws LinkedListException if there is an issue with the pop operation (e.g., popping from an empty stack)
     */
    @Override
    public Object remove(int index) throws LinkedListException {
        return pop();
    }

    /**
     * Main method for testing the Stack implementation.
     *
     * @param args command-line arguments (not used in this example)
     * @throws LinkedListException if there is an issue with the LinkedList operations in the test
     */
    public static void main(String[] args) throws LinkedListException {
        Stack books = new Stack();
        // books.pop(); throws LinkedListException.
        books.push("Absolute Java");
        books.push("The Holy Bible");
        books.push("The Dictionary");
        System.out.println(books);
        System.out.println(books.size());
        books.pop();
        System.out.println("After popping once: " + books);
        Stack reversed = new Stack();
        books.push("The Dictionary");
        int size = books.size();
        while (!books.isEmpty())
            reversed.push(books.pop());
        System.out.println("Original List Reversed :" + reversed);
    }
}