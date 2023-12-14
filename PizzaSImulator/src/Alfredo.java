/**
 * This class represents an Alfredo dish and extends the Base class.
 * It includes constructors for creating Alfredo objects with different parameters
 * and a main method for testing purposes.
 *
 * @author Veer Saini
 */
public class Alfredo extends Base {

	/**
	 * Default constructor for creating an Alfredo object with default values.
	 */
	public Alfredo() {
		super();
	}

	/**
	 * Constructor for creating an Alfredo object with specified description, cost, and calories.
	 *
	 * @param description The description of the Alfredo dish.
	 * @param cost        The cost of the Alfredo dish represented as a Money object.
	 * @param calories    The number of calories in the Alfredo dish.
	 */
	public Alfredo(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * The main method for testing the Alfredo class. It creates Alfredo objects with different
	 * parameters and prints their string representations. It also checks the equality of two
	 * Alfredo objects using the equals method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Alfredo nothing = new Alfredo();
		Alfredo alf1 = new Alfredo("alf1", new Money(2, 50), 300);
		Alfredo alf2 = new Alfredo("alf2", new Money(2, 50), 300);

		System.out.println(nothing.toString() + "\n" + alf1.toString() + "\n" + alf2.toString() + "\n");
		System.out.println(nothing.equals(alf1) + "\n" + alf1.equals(alf2));
	}
}
