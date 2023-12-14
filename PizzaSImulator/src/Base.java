/**
 * This class represents a base ingredient and extends the Ingredient class.
 * It includes constructors for creating Base objects with different parameters
 * and a main method for testing purposes.
 *
 * @author Veer Saini
 */
public class Base extends Ingredient {

	/**
	 * Default constructor for creating a Base object with default values.
	 */
	public Base() {
		super();
	}

	/**
	 * Constructor for creating a Base object with specified description, cost, and calories.
	 *
	 * @param description The description of the base ingredient.
	 * @param cost        The cost of the base ingredient represented as a Money object.
	 * @param calories    The number of calories in the base ingredient.
	 */
	public Base(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * The main method for testing the Base class. It creates Base objects with different
	 * parameters and prints their string representations. It also checks the equality of two
	 * Base objects using the equals method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Base nothing = new Base();
		Base base1 = new Base("base1", new Money(3, 0), 300);
		Base base2 = new Base("base2", new Money(3, 0), 300);

		System.out.println(nothing.toString() + "\n" + base1.toString() + "\n" + base2.toString() + "\n");
		System.out.println(nothing.equals(base1) + "\n" + base1.equals(base2));
	}
}
