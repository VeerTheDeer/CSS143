/**
 * The PizzaException class is a custom exception that can be thrown to indicate exceptional conditions specific to pizzas.
 * It extends the standard Exception class and provides constructors for creating instances of the exception with or without a message.
 *
 * @author Veer Saini
 */
public class PizzaException extends Exception {

	/**
	 * Constructs a new PizzaException with no specified detail message.
	 */
	public PizzaException() {
		super();
	}

	/**
	 * Constructs a new PizzaException with the specified detail message.
	 *
	 * @param message The detail message (which is saved for later retrieval by the getMessage() method).
	 */
	public PizzaException(String message) {
		super(message);
	}
}
