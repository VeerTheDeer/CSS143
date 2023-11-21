/**
 * Custom exception class for LinkedList-related errors.
 * This exception is used to indicate issues specific to LinkedList operations.
 *
 * By: Veer Saini
 */
public class LinkedListException extends Exception {

    /**
     * Constructs a new LinkedListException with no detail message
     */
    public LinkedListException() {
        super();
    }

    /**
     * Constructs a new LinkedListException with the specified detail message
     *
     * @param error a detailed error message explaining the reason for the exception
     */
    public LinkedListException(String error) {
        super(error);
    }
}