/**
 * The PizzaComparable interface extends the standard Comparable interface and defines additional comparison methods
 * specific to pizza objects based on size (area) and calorie content.
 *
 * @author Veer Saini
 */
public interface PizzaComparable extends Comparable {

	/**
	 * Compares two pizza objects based on their general properties.
	 *
	 * @param o The pizza object to compare with.
	 * @return A negative integer, zero, or a positive integer as this pizza is less than, equal to, or greater than the other pizza.
	 */
	@Override
	public int compareTo(Object o);

	/**
	 * Compares two pizza objects based on their sizes (areas).
	 *
	 * @param o The pizza object to compare with.
	 * @return A negative integer, zero, or a positive integer as this pizza is smaller than, equal to, or greater than the other pizza.
	 */
	public int compareToBySize(Object o);

	/**
	 * Compares two pizza objects based on their calorie content.
	 *
	 * @param o The pizza object to compare with.
	 * @return A negative integer, zero, or a positive integer as this pizza has fewer calories than, equal to, or more calories than the other pizza.
	 */
	public int compareToByCalories(Object o);
}
