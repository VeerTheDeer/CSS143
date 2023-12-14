import java.awt.Color;

/**
 * This class represents an Olive, which is a specific type of Vegetable.
 * It extends the Vegetable class and provides constructors for creating instances of Olive.
 *
 * @author Veer Saini
 */
public class Olive extends Vegetable {

	/**
	 * Default constructor for creating an Olive with default values.
	 */
	public Olive() {
		super();
	}

	/**
	 * Constructor for creating an Olive with a specified description, cost, and calories.
	 *
	 * @param description The description of the Olive.
	 * @param cost        The cost of the Olive.
	 * @param calories    The calorie content of the Olive.
	 */
	public Olive(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * Constructor for creating an Olive with a specified description, cost, calories, and color.
	 *
	 * @param description The description of the Olive.
	 * @param cost        The cost of the Olive.
	 * @param calories    The calorie content of the Olive.
	 * @param color       The color of the Olive.
	 */
	public Olive(String description, Money cost, int calories, Color color) {
		super(description, cost, calories, color);
	}

	/**
	 * Main method for testing the Olive class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Olive nothing = new Olive();
		Olive olive1 = new Olive("olive1", new Money(0, 50), 300);
		Olive olive2 = new Olive("olive2", new Money(0, 50), 300);
		System.out.println(nothing.toString() + "\n" + olive1.toString() + "\n" + olive2.toString() + "\n");
		System.out.println(nothing.equals(olive1) + "\n" + olive1.equals(olive2));
	}
}
