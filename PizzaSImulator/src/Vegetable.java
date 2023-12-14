import java.awt.Color;

/**
 * The {@code Vegetable} class represents a vegetable ingredient, extending the {@code Ingredient} class.
 * It provides functionality to set and get the color of the vegetable.
 *
 * @author Veer Saini
 */
public class Vegetable extends Ingredient {

	protected Color color = Color.GREEN;

	/**
	 * Constructs a default {@code Vegetable} with no specified attributes.
	 */
	public Vegetable() {
		super();
	}

	/**
	 * Constructs a {@code Vegetable} with the specified description, cost, and calories.
	 *
	 * @param description The description of the vegetable.
	 * @param cost        The cost of the vegetable.
	 * @param calories    The calories in the vegetable.
	 */
	public Vegetable(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

	/**
	 * Constructs a {@code Vegetable} with the specified description, cost, calories, and color.
	 *
	 * @param description The description of the vegetable.
	 * @param cost        The cost of the vegetable.
	 * @param calories    The calories in the vegetable.
	 * @param color       The color of the vegetable.
	 */
	public Vegetable(String description, Money cost, int calories, Color color) {
		super(description, cost, calories);
		setColor(color);
	}

	/**
	 * Sets the color of the vegetable.
	 *
	 * @param color The color to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Gets the color of the vegetable.
	 *
	 * @return The color of the vegetable.
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Returns a string representation of the vegetable, including its color.
	 *
	 * @return A string representation of the vegetable.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Color: " + this.getColor();
	}

	/**
	 * Checks if this vegetable is equal to another vegetable, considering both description and color.
	 *
	 * @param other The other vegetable to compare.
	 * @return {@code true} if the vegetables are equal, {@code false} otherwise.
	 */
	public boolean equals(Vegetable other) {
		return super.equals(other) && this.getColor().equals(other.getColor());
	}

	/**
	 * The main method for testing the {@code Vegetable} class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Vegetable nothing = new Vegetable();
		Vegetable vegetable1 = new Vegetable("vegetable1", new Money(1, 1), 300);
		Vegetable colorVegetable1 = new Vegetable("colorVegetable1", new Money(4, 125), 900, Color.BLUE);
		Vegetable colorVegetable2 = new Vegetable("colorVegetable2", new Money(4, 125), 900, Color.LIGHT_GRAY);
		System.out.println(nothing.toString() + "\n" + vegetable1.toString() + "\n" + colorVegetable1 + "\n");
		nothing.setColor(Color.ORANGE);
		System.out.println(nothing.toString() + "\n" + vegetable1.toString() + "\n" + colorVegetable1.toString() + "\n");
		System.out.println(nothing.getColor() + ", " + vegetable1.getColor() + ", " + colorVegetable1.getColor() + "\n");
		System.out.println(nothing.equals(vegetable1) + "\n" + colorVegetable1.equals(colorVegetable2));
	}
}
