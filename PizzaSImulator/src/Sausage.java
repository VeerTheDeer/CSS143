/**
 * The Sausage class represents a type of meat used as an ingredient in pizzas.
 * It extends the Meat class and provides additional functionality.
 *
 * @author Veer Saini
 */
public class Sausage extends Meat {

	/**
	 * Constructs a default with no specified description, cost, or calories.
	 */
	public Sausage() {
		super();
	}

	/**
	 * Constructs a Sausage with the specified description, cost, and calories.
	 *
	 * @param description The description of the sausage.
	 * @param cost        The cost of the sausage.
	 * @param calories    The calorie count of the sausage.
	 */
	public Sausage(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * The main method for testing the Sausage class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Sausage nothing = new Sausage();
		Sausage sausage1 = new Sausage("sausage1", new Money(1, 1), 300);
		Sausage sausage2 = new Sausage("sausage2", new Money(1, 1), 300);
		System.out.println(nothing.toString() + "\n" + sausage1.toString() + "\n" + sausage2.toString() + "\n");
		System.out.println(nothing.equals(sausage1) + "\n" + sausage1.equals(sausage2));
	}
}
