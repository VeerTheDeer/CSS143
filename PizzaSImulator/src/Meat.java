/**
 * This class represents a type of ingredient, specifically Meat,
 * and extends the Ingredient class.
 *
 * @author Veer Saini
 */
public class Meat extends Ingredient {

	/**
	 * Default constructor for creating a Meat object with default values.
	 */
	public Meat() {
		super();
	}

	/**
	 * Constructor for creating a Meat object with specified description, cost, and calories.
	 *
	 * @param description The description of the meat.
	 * @param cost        The cost of the meat represented as a Money object.
	 * @param calories    The number of calories in the meat.
	 */
	public Meat(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * The main method for testing the Meat class. It creates Meat objects with different
	 * parameters and prints their string representations. It also checks the equality of two
	 * Meat objects using the equals method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Meat nothing = new Meat();
		Meat meat1 = new Meat("meat1", new Money(5, 75), 300);
		Meat meat2 = new Meat("meat2", new Money(5, 75), 300);

		System.out.println(nothing.toString() + "\n" + meat1.toString() + "\n" + meat2.toString() + "\n");
		System.out.println(nothing.equals(meat1) + "\n" + meat1.equals(meat2));
	}
}
