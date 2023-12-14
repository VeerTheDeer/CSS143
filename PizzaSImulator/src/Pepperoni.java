/**
 * This class represents a Pepperoni, which is a specific type of Meat.
 * It extends the Meat class and provides constructors for creating instances of Pepperoni.
 *
 * @author Veer Saini
 */
public class Pepperoni extends Meat {

	/**
	 * Default constructor for creating a Pepperoni with default values.
	 */
	public Pepperoni() {
		super();
	}

	/**
	 * Constructor for creating a Pepperoni with a specified description, cost, and calories.
	 *
	 * @param description The description of the Pepperoni.
	 * @param cost        The cost of the Pepperoni.
	 * @param calories    The calorie content of the Pepperoni.
	 */
	public Pepperoni(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * Main method for testing the Pepperoni class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Pepperoni nothing = new Pepperoni();
		Pepperoni pepperoni1 = new Pepperoni("pepperoni1", new Money(1, 1), 300);
		Pepperoni pepperoni2 = new Pepperoni("pepperoni2", new Money(1, 1), 300);
		System.out.println(nothing.toString() + "\n" + pepperoni1.toString() + "\n" + pepperoni2.toString() + "\n");
		System.out.println(nothing.equals(pepperoni1) + "\n" + pepperoni1.equals(pepperoni2));
	}
}
