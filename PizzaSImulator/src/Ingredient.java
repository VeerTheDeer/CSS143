import java.awt.*;

/**
 * This abstract class represents an Ingredient and implements the Comparable interface.
 * It serves as a base class for different types of ingredients used in a recipe.
 * Ingredients have a description, cost, and calorie information.
 * The class provides methods for comparison and displaying information about ingredients.
 *
 * @author Veer Saini
 */
public abstract class Ingredient implements Comparable<Ingredient> {

	private String description;
	private Money cost;
	private int calories;

	/**
	 * Default constructor for creating an Ingredient object with default values.
	 */
	public Ingredient() {
		this.setDescription("None");
		this.setCost(new Money(0, 0));
		this.setCalories(0);
	}

	/**
	 * Constructor for creating an Ingredient object with specified description, cost, and calories.
	 *
	 * @param description The description of the ingredient.
	 * @param cost        The cost of the ingredient represented as a Money object.
	 * @param calories    The number of calories in the ingredient.
	 */
	public Ingredient(String description, Money cost, int calories) {
		this.setDescription(description);
		this.setCost(cost);
		this.setCalories(calories);
	}

	/**
	 * Returns a string representation of the Ingredient object.
	 *
	 * @return A string containing the description, cost, and calories of the ingredient.
	 */
	public String toString() {
		return this.description + ", " + this.cost + "; " + this.calories + " calories.";
	}

	/**
	 * Checks if this ingredient is equal to another ingredient.
	 *
	 * @param other The ingredient to compare with.
	 * @return true if the ingredients are equal, false otherwise.
	 */
	public boolean equals(Ingredient other) {
		return (this.getDescription().equals(other.getDescription())
				&& this.getCost().equals(other.getCost())
				&& this.getCalories() == other.getCalories());
	}

	/**
	 * Compares this ingredient with another ingredient based on cost.
	 *
	 * @param other The ingredient to compare with.
	 * @return A negative integer, zero, or a positive integer as this ingredient is less than, equal to, or greater than the specified ingredient.
	 */
	@Override
	public int compareTo(Ingredient other) {
		return this.getCost().compareTo(other.getCost());
	}

	/**
	 * Sets the description of the ingredient.
	 *
	 * @param description The description of the ingredient.
	 */
	private void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the cost of the ingredient.
	 *
	 * @param cost The cost of the ingredient represented as a Money object.
	 */
	private void setCost(Money cost) {
		this.cost = cost;
	}

	/**
	 * Sets the calories of the ingredient.
	 *
	 * @param calories The number of calories in the ingredient.
	 */
	private void setCalories(int calories) {
		this.calories = calories;
	}

	/**
	 * Gets the description of the ingredient.
	 *
	 * @return The description of the ingredient.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the cost of the ingredient.
	 *
	 * @return The cost of the ingredient represented as a Money object.
	 */
	public Money getCost() {
		return this.cost;
	}

	/**
	 * Gets the calories of the ingredient.
	 *
	 * @return The number of calories in the ingredient.
	 */
	public int getCalories() {
		return this.calories;
	}

	/**
	 * Main method for testing the Ingredient class. It creates an array of various ingredients,
	 * sets their properties, and prints information about each ingredient. It also tests the
	 * equals and compareTo methods.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Ingredient[] totalIng = new Ingredient[15];
		totalIng[0] = new Meat();
		totalIng[0].setDescription("meat1");
		totalIng[0].setCost(new Money(10,25));
		totalIng[0].setCalories(25);
		totalIng[1] = new Meat("meat2",new Money(25,19), 65);
		totalIng[2]= new Base("base", new Money(10,10), 100);
		totalIng[3]= new Marinara("marinara", new Money(10,20), 200);
		totalIng[4]= new Alfredo("alfredo", new Money(10,30), 300);
		totalIng[5]= new Cheese("cheese", new Money(10,40), 400);
		totalIng[6]= new Feta("feta", new Money(10,50), 500);
		totalIng[7]= new Mozzarella("mozzarella", new Money(10,60), 600);
		totalIng[8]= new Meat("meat3", new Money(10,70), 700);
		totalIng[9]= new Sausage("sausage", new Money(10,80), 800);
		totalIng[10]= new Pepperoni("pepperoni", new Money(10,90), 900);
		totalIng[11]= new Vegetable("veggie", new Money(11,00), 1000, Color.BLUE);
		totalIng[12]= new Pepper("bell pepper", new Money(10,20), 1100, Color.RED);
		totalIng[13]= new Olive("black olive", new Money(10,30), 1200, Color.BLACK);
		totalIng[14]= new Olive("green olive", new Money(10,30), 1200, Color.GREEN);

		for(Ingredient indIng : totalIng){
			System.out.println(indIng.toString());
			System.out.println(indIng.getDescription());
			System.out.println(indIng.getCalories());
			System.out.println(indIng.getCost());
		}

		System.out.println(totalIng[0].equals(totalIng[14]) + " False");
		System.out.println(totalIng[13].equals(totalIng[14]) + " True");
		System.out.println(totalIng[13].compareTo(totalIng[14]) + " 0");
		System.out.println(totalIng[0].compareTo(totalIng[14]) + " -1");
		System.out.println(totalIng[14].compareTo(totalIng[0]) + " 1");
	}
}