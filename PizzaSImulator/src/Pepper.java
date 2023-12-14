import java.awt.Color;

/**
 * This class represents a Pepper, which is a specific type of Vegetable.
 * It extends the Vegetable class and provides constructors for creating instances of Pepper.
 *
 * @author Veer Saini
 */
public class Pepper extends Vegetable {

	/**
	 * Default constructor for creating a Pepper with default values.
	 */
	public Pepper() {
		super();
	}

	/**
	 * Constructor for creating a Pepper with a specified description, cost, and calories.
	 *
	 * @param description The description of the Pepper.
	 * @param cost        The cost of the Pepper.
	 * @param calories    The calorie content of the Pepper.
	 */
	public Pepper(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * Constructor for creating a Pepper with a specified description, cost, calories, and color.
	 *
	 * @param description The description of the Pepper.
	 * @param cost        The cost of the Pepper.
	 * @param calories    The calorie content of the Pepper.
	 * @param color       The color of the Pepper.
	 */
	public Pepper(String description, Money cost, int calories, Color color) {
		super(description, cost, calories, color);
	}

	/**
	 * Main method for testing the Pepper class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Pepper nothing = new Pepper();
		Pepper pepper1 = new Pepper("pepper1", new Money(2), 300, Color.red);
		Pepper pepper2 = new Pepper("pepper2", new Money(2), 300, Color.green);
		System.out.println(nothing.toString() + "\n" + pepper1.toString() + "\n" + pepper2.toString() + "\n");
		System.out.println(nothing.equals(pepper1) + "\n" + pepper1.equals(pepper2));
	}
}
