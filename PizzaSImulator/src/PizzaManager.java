import java.util.Scanner;

/**
 * The PizzaManager class manages a collection of pizzas, allowing users to add, eat, and sort pizzas interactively.
 * It provides a simple command-line interface for users to perform various operations on a list of pizzas.
 *
 * @author Veer Saini
 */
public class PizzaManager {
	private ArrayList totalPizzas = new ArrayList();
	private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

	/**
	 * Starts the PizzaManager application, allowing users to interactively manage a collection of pizzas.
	 */
	public void start() {
		char userInput = 'q';

		Scanner foo = new Scanner(System.in);

		int count = 0;
		while (true) {
			if (count > 0) {
				displayAllPizzas();
			}

			count++;
			displayInstructions();
			userInput = foo.next().charAt(0);

			switch (userInput) {
				case 'A':
				case 'a':
					System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
					addRandomPizza();
					break;
				case 'H':
				case 'h':
					System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
					for (int i = 0; i < 100; i++) {
						addRandomPizza();
					}
					break;
				case 'E':
				case 'e':
					System.out.println("Eating a fraction of a pizza. How much? (a/b)");
					eatSomePizza(foo);
					break;
				case 'P':
				case 'p':
					System.out.println("Sorting pizzas by (P)rice");
					sortByPrice();
					break;
				case 'S':
				case 's':
					System.out.println("Sorting pizzas by (S)ize");
					sortBySize();
					break;
				case 'C':
				case 'c':
					System.out.println("Sorting pizzas by (C)alories");
					sortByCalories();
					break;
				case 'B':
				case 'b':
					System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
					try {
						if (totalPizzas.isEmpty()) {
							throw new PizzaException();
						}

						int calories = foo.nextInt();
						System.out.println("Found a pizza with " + calories + " calories at position " + binarySearchByCalories(calories));
					} catch (PizzaException ignored) {
					}

					break;
				case 'Q':
				case 'q':
					System.out.println("(Q)uitting!");
					System.exit(0);
				default:
					System.out.println("Unrecognized input - try again");
			}
		}
	}

	/**
	 * Simulates eating a fraction of a pizza based on user input.
	 *
	 * @param keys Scanner object for user input.
	 */
	private void eatSomePizza(Scanner keys) {
		try {
			if (totalPizzas.isEmpty()) {
				throw new PizzaException();
			}
			try {
				String input = keys.next();
				if (input.length() < 2) {
					throw new PizzaException();
				}

				String[] temp = input.split("/", 2);
				int numerator = Integer.parseInt(temp[0]);
				int denominator = Integer.parseInt(temp[1]);
				System.out.println("which index");
				int index = keys.nextInt();
				((Pizza) totalPizzas.get(index)).eatSomePizza(new Fraction(numerator, denominator));

				if (((Pizza) totalPizzas.get(index)).getRemainingArea() == 0) {
					if (totalPizzas.size() == 1) {
						totalPizzas = new ArrayList();
					} else {
						totalPizzas.remove(index);
					}

				}

			} catch (PizzaException e) {
				System.out.println("wrong input");
			}

		} catch (PizzaException e) {
		}
	}

	/**
	 * Adds a random pizza to the collection.
	 */
	private void addRandomPizza() {
		totalPizzas.add(new Pizza());
	}

	/**
	 * Performs a binary search for pizzas based on calorie count.
	 *
	 * @param calories The calorie count to search for.
	 * @return The index of the pizza with the specified calorie count, or -1 if not found.
	 */
	private int binarySearchByCalories(int calories) {
		this.sortByCalories();
		int lIdx = 0;
		int hIdx = totalPizzas.size() - 1;
		int mIdx = hIdx / 2;
		return recursiveCalories(calories, lIdx, hIdx, mIdx);
	}

	/**
	 * Performs a recursive binary search to find the index of a pizza with a specific calorie count in the sorted collection.
	 *
	 * @param calories The calorie count to search for.
	 * @param lIdx     The lower index of the search range.
	 * @param hIdx     The higher index of the search range.
	 * @param mIdx     The middle index of the search range.
	 * @return The index of the pizza with the specified calorie count, or -1 if not found.
	 */
	private int recursiveCalories(int calories, int lIdx, int hIdx, int mIdx) {
		while (lIdx <= hIdx) {
			if (calories == ((Pizza) totalPizzas.get(mIdx)).getCalories()) {
				return mIdx;
			} else if (calories < ((Pizza) totalPizzas.get(mIdx)).getCalories()) {
				return recursiveCalories(calories, lIdx, mIdx - 1, lIdx + ((mIdx - 1 - lIdx) / 2));
			} else {
				return recursiveCalories(calories, mIdx + 1, hIdx, (mIdx + 1) + ((hIdx - mIdx) / 2));
			}

		}
		return -1;
	}

	/**
	 * Displays all pizzas in the collection.
	 */
	private void displayAllPizzas() {
		try {
			if (totalPizzas.isEmpty()) {
				throw new PizzaException();
			}
			for (Object pizza : totalPizzas) {
				System.out.println(((Pizza) pizza).toString());
			}
		} catch (PizzaException e) {
			System.out.println("there are no pizzas");
		}
	}

	/**
	 * Sorts pizzas in the collection by price.
	 */
	private void sortByPrice() {
		if (totalPizzas.isEmpty()) {
			return;
		}

		for (int i = 1; i < totalPizzas.size(); i++) {
			Pizza current = ((Pizza) totalPizzas.get(i));
			int j = i - 1;

			while ((j > -1) && (((Pizza) totalPizzas.get(j))).compareTo(current) > 0) {
				Pizza temp = (Pizza) totalPizzas.get(j);
				totalPizzas.remove(j);
				totalPizzas.insert(temp, j + 1);
				j--;
			}
		}
	}

	/**
	 * Sorts pizzas in the collection by size.
	 */
	private void sortBySize() {
		if (totalPizzas.isEmpty()) {
			return;
		}

		for (int i = 1; i < totalPizzas.size(); i++) {
			Pizza current = ((Pizza) totalPizzas.get(i));
			int j = i - 1;

			while ((j > -1) && (((Pizza) totalPizzas.get(j)).getRemainingArea() > current.getRemainingArea())) {
				Pizza temp = (Pizza) totalPizzas.get(j);
				totalPizzas.remove(j);
				totalPizzas.insert(temp, j + 1);
				j--;
			}
		}
	}

	/**
	 * Sorts pizzas in the collection by calories.
	 */
	private void sortByCalories() {
		if (totalPizzas.isEmpty()) {
			return;
		}

		for (int i = 0; i < totalPizzas.size() - 1; i++) {
			int idx = findSmallestClrs(i, totalPizzas.size());
			for (int j = i + 1; j < totalPizzas.size(); j++) {
				if (((Pizza) totalPizzas.get(j)).getCalories() < ((Pizza) totalPizzas.get(idx)).getCalories()) {
					idx = j;
				}
			}
			totalPizzas.swap(idx, i);
		}

		if (((Pizza) totalPizzas.get(0)).getCalories() > ((Pizza) totalPizzas.get(0)).getCalories()) {
			sortByCalories();
		} else if (((Pizza) totalPizzas.get(totalPizzas.size() - 1)).getCalories() < ((Pizza) totalPizzas.get(totalPizzas.size() - 2)).getCalories()) {
			sortByCalories();
		}
	}

	/**
	 * Finds the index of the pizza with the smallest calories within a specified range.
	 *
	 * @param start The starting index of the range.
	 * @param end   The ending index of the range.
	 * @return The index of the pizza with the smallest calories within the specified range.
	 */
	private int findSmallestClrs(int start, int end) {
		int minIndex = start;
		for (int i = start + 1; i < end; i++) {
			if (((Pizza) totalPizzas.get(i)).getCalories() > ((Pizza) totalPizzas.get(start)).getCalories()) {
				minIndex = start;
			} else {
				minIndex = i;
			}

		}
		return minIndex;
	}

	/**
	 * Displays instructions for user interaction.
	 */
	private void displayInstructions() {
		System.out.println(instructions);
	}

	/**
	 * The main method to run the PizzaManager application.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		new PizzaManager().start();
	}
}
