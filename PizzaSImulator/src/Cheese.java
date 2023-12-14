/**
 * This class represents a cheese ingredient and extends the Ingredient class.
 * It includes constructors for creating Cheese objects with different parameters
 * and a main method for testing purposes.
 *
 * @author Veer Saini
 */
public class Cheese extends Ingredient {

	/**
	 * Default constructor for creating a Cheese object with default values.
	 */
	public Cheese() {
		super();
	}

	/**
	 * Constructor for creating a Cheese object with specified description, cost, and calories.
	 *
	 * @param description The description of the cheese ingredient.
	 * @param cost        The cost of the cheese ingredient represented as a Money object.
	 * @param calories    The number of calories in the cheese ingredient.
	 */
	public Cheese(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * The main method for testing the Cheese class. It creates Cheese objects with different
	 * parameters and prints their string representations. It also checks the equality of two
	 * Cheese objects using the equals method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Cheese nothing = new Cheese();
		Cheese cheese1 = new Cheese("cheese1", new Money(2, 25), 300);
		Cheese cheese2 = new Cheese("cheese2", new Money(2, 25), 300);

		System.out.println(nothing.toString() + "\n" + cheese1.toString() + "\n" + cheese2.toString() + "\n");
		System.out.println(nothing.equals(cheese1) + "\n" + cheese1.equals(cheese2));
	}
}
