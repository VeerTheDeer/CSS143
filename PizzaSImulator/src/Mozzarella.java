/**
 * This class represents a Mozzarella ingredient, extending the Cheese class.
 * It provides methods to create Mozzarella objects and compare them.
 *
 * @author Veer Saini
 */
public class Mozzarella extends Cheese {

	/**
	 * Default constructor for creating a Mozzarella object with default values.
	 */
	public Mozzarella() {
		super();
	}

	/**
	 * Constructor for creating a Mozzarella object with the specified description, cost, and calories.
	 *
	 * @param description The description of the Mozzarella.
	 * @param cost        The cost of the Mozzarella.
	 * @param calories    The calories in the Mozzarella.
	 */
	public Mozzarella(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * Main method for testing Mozzarella class functionality.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String args[]) {
		Mozzarella nothing = new Mozzarella();
		Mozzarella mozzarella1 = new Mozzarella("mozzarella1", new Money(1, 50), 300);
		Mozzarella mozzarella2 = new Mozzarella("mozzarella2", new Money(1, 50), 300);

		System.out.println(nothing.toString() + "\n" + mozzarella1.toString() + "\n" + mozzarella2.toString() + "\n");
		System.out.println(nothing.equals(mozzarella1) + "\n" + mozzarella1.equals(mozzarella2));
	}
}
