public class DebugMe {

	public static void main(String[] args) {
		if (args.length > 0) {
			printSums(args);
			compareBoxes();
		} else {
			System.out.println("Please provide an argument.");
		}
	}

	public static void printSums(String[] args) {
		try {
			int count = Integer.parseInt(args[0]);

			for (int i = 1; i <= count; i++) {
				int sum = 0;
				for (int j = 1; j <= i; j++) {
					sum += j;
				}
				System.out.println("The sum of the first " + i + " numbers is " + sum + ".");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please provide a valid number as an argument.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide an argument.");
		}
	}

	public static void compareBoxes() {
		// Your existing code for comparing boxes remains the same
		// ...
	}
}
