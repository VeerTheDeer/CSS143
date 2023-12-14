import java.awt.Color;

/**
 * Pizza class represents a pizza with various properties such as shape, ingredients, cost, calories, and remaining fraction.
 * This class implements the PizzaComparable interface to enable comparison of pizza objects based on different criteria.
 *
 * @author Veer Saini
 */
public class Pizza implements PizzaComparable {
	protected ArrayList ingredients = new ArrayList();
	protected Shape pizzaShape;
	protected Money cost = new Money(0,0);
	protected int calories = 0;
	protected Fraction remaining = new Fraction(1,1);

	/**
	 * Default constructor for Pizza class. Generates a random pizza with random shape, ingredients, and initializes properties.
	 */
	public Pizza() {
		int randomChoice = (int) (Math.random() * 2);

		if (randomChoice == 0) {
			this.setShape(new Square(1, 1, getRandInt()));
		} else {
			this.setShape(new Circle(1, 1, getRandInt()));
		}

		int ingredientsNum = getRandInt() / 10;
		for (int i = 0; i < ingredientsNum; i++) {
			addIngredients();
		}
	}

	/**
	 * Adds a randomly selected ingredient to the pizza based on a switch statement.
	 * The ingredient is determined by a random integer between 0 and 7.
	 * Each case corresponds to a specific type of ingredient with varying properties.
	 */
	private void addIngredients() {
		switch((int)(Math.random() * 8)) {
		case 0: 	addIngredient(new Sausage("Sausage", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 1: 	addIngredient(new Pepper("Pepper", new Money(getRandInt(),getRandInt()), getRandInt(), getRandColor()));
					break;
		case 2: 	addIngredient(new Marinara("Marinara Sauce", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 3: 	addIngredient(new Alfredo("Alfredo Sauce", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 4: 	addIngredient(new Feta("Feta Cheese", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 5: 	addIngredient(new Pepperoni("Pepperoni", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 6: 	addIngredient(new Olive("Olive", new Money(getRandInt(),getRandInt()), getRandInt(), getRandColor()));
					break;				
		case 7: 	addIngredient(new Mozzarella("Mozzarella Cheese", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		}
	}

	/**
	 * Generates a random Color object for pizza ingredients.
	 *
	 * @return A randomly chosen Color object.
	 */
	public Color getRandColor() {
		Color retVal = null;
        int i = (int) (Math.random() * 4);
        if (i == 0) {
            retVal = Color.BLUE;
        } else if (i == 1) {
            retVal = Color.GREEN;
        } else if (i == 2) {
            retVal = Color.RED;
        } else if (i == 3) {
            retVal = Color.YELLOW;
        }
	return retVal;
	}

	/**
	 * Sets the shape of the pizza.
	 *
	 * @param shape The shape object to set for the pizza.
	 */
	public void setShape(Shape shape) {
		this.pizzaShape = shape.clone();
	}

	/**
	 * Gets a clone of the pizza's shape.
	 *
	 * @return A clone of the pizza's shape.
	 */
	public Shape getShape() {
		return this.pizzaShape.clone();
	}

	/**
	 * Sets the remaining fraction of the pizza.
	 *
	 * @param fraction The fraction to set as remaining for the pizza.
	 */
	public void setRemaining(Fraction fraction){
		Fraction finalFrac = new Fraction((int) (((double) this.remaining.getNumerator() * (double)fraction.getDenominator()) -
				((double)this.remaining.getDenominator() * (double)fraction.getNumerator())),
				this.remaining.getDenominator() * fraction.getDenominator());

		String finalStr = finalFrac.reduceFraction(finalFrac.getNumerator(), finalFrac.getDenominator());
		String[] tempArr = finalStr.split("/", 2);

		int numerator = Integer.parseInt(tempArr[0]);
		int denominator = Integer.parseInt(tempArr[1]);
		this.remaining = new Fraction(numerator,denominator);
	}

	/**
	 * Calculates and returns the cost of the pizza based on the remaining fraction.
	 *
	 * @return The cost of the remaining pizza.
	 */
	public Money getCost(){
		double temp = this.cost.getMoney();
		double finalD = (temp * this.getRemaining().getNumerator()) / this.getRemaining().getDenominator();
		int dollar = (int) finalD;

		double cents = Math.floor((finalD - dollar) * 100) / 100;
		int cent = (int) ((cents) * 100);
		return new Money(dollar, cent);
	}

	/**
	 * Gets the total calories of the pizza.
	 *
	 * @return The total calories of the pizza.
	 */
	public int getCalories(){
		return this.calories;
	}

	/**
	 * Compares the cost of the current pizza with another pizza.
	 *
	 * @param other The pizza object to compare with.
	 * @return A negative integer, zero, or a positive integer as this pizza is less than, equal to, or greater than the other pizza.
	 */
	public int compareTo(Object other) {
		return this.getCost().compareTo(((Pizza) other).getCost());
	}

	/**
	 * Compares two pizzas based on their sizes (areas).
	 *
	 * @param o The pizza object to compare with.
	 * @return A negative integer, zero, or a positive integer as this pizza is smaller than, equal to, or greater than the other pizza.
	 */
	@Override
	public int compareToBySize(Object o) {
		return Double.compare(this.getShape().getArea(), ((Pizza) o).getShape().getArea());
	}

	/**
	 * Compares two pizzas based on their calorie content.
	 *
	 * @param o The pizza object to compare with.
	 * @return A negative integer, zero, or a positive integer as this pizza has fewer calories than, equal to, or more calories than the other pizza.
	 */
	@Override
	public int compareToByCalories(Object o) {
		return Integer.compare(this.getCalories(), ((Pizza) o).getCalories());
	}

	/**
	 * Adds an ingredient to the pizza, updating calories and cost.
	 *
	 * @param ingredient The ingredient to add to the pizza.
	 */
	public void addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
		this.calories += ingredient.getCalories();
		this.cost.add(ingredient.getCost());
	}

	/**
	 * Simulates eating a fraction of the pizza and updates the remaining fraction accordingly.
	 *
	 * @param fraction The fraction of the pizza to eat.
	 */
	public void eatSomePizza(Fraction fraction){
		//double attemptToEat = (fraction.getNumerator() / fraction.getDenominator()) * pizzaShape.getArea();
		try {
			if(this.getRemaining().compareTo(fraction) < 0) {
				throw new NotEnoughPizzaException();
			}
			
			try {
				if(this.getRemaining().compareTo(fraction) == 0) {
					this.setRemaining(fraction);
					throw new PizzaException();
				} else {
					this.setRemaining(fraction);
				}

			} catch(PizzaException e) {
				System.out.println("Pizza is finished");
				this.setRemaining(new Fraction(0,1));
			}
		} catch(NotEnoughPizzaException e) {
			System.out.println("There is no pizza");
		}
	}

	/**
	 * Generates a String representation of the pizza, including cost, calories, remaining fraction, remaining area, and shape.
	 *
	 * @return A String representation of the pizza.
	 */
	public String toString(){
		return  ("This pizza costs: "
				+this.getCost().toString()+" and has this many calories: "
				+this.getCalories()+", this is the fraction of pizza remaining: "
				+this.getRemaining()+" with area remaining: "
				+this.getRemainingArea()+" of shape: "
				+this.getShape().nameString());
	}

	/**
	 * Generates a random integer for various purposes.
	 *
	 * @return A random integer.
	 */
	public int getRandInt() {
		return ((int) (Math.random() * 200));
	}

	/**
	 * Gets the remaining fraction of the pizza.
	 *
	 * @return The remaining fraction of the pizza.
	 */
	public Fraction getRemaining(){
		return this.remaining;
	}

	/**
	 * Calculates and returns the remaining area of the pizza based on the remaining fraction.
	 *
	 * @return The remaining area of the pizza.
	 */
	public double getRemainingArea(){
		return 	Math.floor(this.getShape().getArea() * ((double)this.remaining.getNumerator() / (double)this.remaining.getDenominator()) * 100) / 100;
	}

	/**
	 * Main method for testing Pizza class functionality.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]){
		System.out.println("A:");
		Pizza a = new Pizza();
		System.out.println(a.toString());
		System.out.println("adding meat on pizza");
		a.addIngredient(new Meat("Meat", new Money(15,25), 1200));
		System.out.println(a.toString());
		a.eatSomePizza(new Fraction(1,2));
		System.out.println("eating half of the pizza");
		System.out.println(a.toString());
		System.out.println("eating a third of the pizza");
		a.eatSomePizza(new Fraction(1,3));
		System.out.println(a.toString());
		System.out.println("eating half of the pizza");
		a.eatSomePizza(new Fraction(1,2));
		System.out.println("eating a sixth of the pizza");
		a.eatSomePizza(new Fraction(1,6));
		System.out.println(a.toString());
		
		System.out.println("B:");
		Pizza b = new Pizza();
		System.out.println(b.toString());
		System.out.println(b.toString());
		System.out.println(b.toString());
		
		System.out.println("C:");
		Pizza c = new Pizza();
		System.out.println(c.toString());
		
		System.out.println("b compared to c: " + b.compareTo(c));
		System.out.println("c compared to b: " + c.compareTo(b));
	}
}
