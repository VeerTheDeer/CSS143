/**
 * This class represents a type of cheese, specifically Feta cheese,
 * and extends the Cheese class.
 *
 * @author Veer Saini
 */
public class Feta extends Cheese {

    /**
     * Default constructor for creating a Feta object with default values.
     */
    public Feta() {
        super();
    }

    /**
     * Constructor for creating a Feta object with specified description, cost, and calories.
     *
     * @param description The description of the Feta cheese.
     * @param cost        The cost of the Feta cheese represented as a Money object.
     * @param calories    The number of calories in the Feta cheese.
     */
    public Feta(String description, Money cost, int calories) {
        super(description, cost, calories);
    }

    /**
     * The main method for testing the Feta class. It creates Feta objects with different
     * parameters and prints their string representations. It also checks the equality of two
     * Feta objects using the equals method.
     *
     * @param args The command-line arguments (not used in this context).
     */
    public static void main(String args[]) {
        Feta nothing = new Feta();
        Feta feta1 = new Feta("Feta1", new Money(2, 0), 300);
        Feta feta2 = new Feta("Feta2", new Money(2, 0), 300);

        System.out.println(nothing.toString() + "\n" + feta1.toString() + "\n" + feta2.toString() + "\n");
        System.out.println(nothing.equals(feta1) + "\n" + feta1.equals(feta2));
    }
}
