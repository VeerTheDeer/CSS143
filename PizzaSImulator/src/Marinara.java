/**
 * This class represents a type of base ingredient, specifically Marinara sauce,
 * and extends the Base class.
 *
 * @author Veer Saini
 */
public class Marinara extends Base {

	/**
	 * Default constructor for creating a Marinara object with default values.
	 */
	public Marinara() {
		super();
	}

	/**
	 * Constructor for creating a Marinara object with specified description, cost, and calories.
	 *
	 * @param description The description of the Marinara sauce.
	 * @param cost        The cost of the Marinara sauce represented as a Money object.
	 * @param calories    The number of calories in the Marinara sauce.
	 */
	public Marinara(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * The main method for testing the Marinara class. It creates Marinara objects with different
	 * parameters and prints their string representations. It also checks the equality of two
	 * Marinara objects using the equals method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Marinara nothing = new Marinara();
		Marinara marinara1 = new Marinara("notEmpty", new Money(1, 50), 300);
		Marinara marinara2 = new Marinara("notEmpty", new Money(1, 50), 300);

		System.out.println(nothing.toString() + "\n" + marinara1.toString() + "\n" + marinara2.toString() + "\n");
		System.out.println(nothing.equals(marinara1) + "\n" + marinara1.equals(marinara2));
	}
}
