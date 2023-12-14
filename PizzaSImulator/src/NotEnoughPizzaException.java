/**
 * This class represents a custom exception for the case when there is not enough pizza.
 * It extends the Exception class and provides constructors for creating instances of the exception.
 *
 * @author Veer Saini
 */
public class NotEnoughPizzaException extends Exception {

	/**
	 * Default constructor for creating a NotEnoughPizzaException with no specific message.
	 */
	public NotEnoughPizzaException() {
		super();
	}

	/**
	 * Constructor for creating a NotEnoughPizzaException with a specific error message.
	 *
	 * @param message The error message associated with the exception.
	 */
	public NotEnoughPizzaException(String message) {
		super(message);
	}
}
