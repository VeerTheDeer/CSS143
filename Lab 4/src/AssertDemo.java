import java.util.ArrayList;
import java.util.Scanner;

public class AssertDemo {

	public static void main(String[] args) {
		assert true;
		assert false;

		warmUpAsserts();

		assertWithPrimitives();

		assertWithObjects();

		homeworkRelatedAsserts();
	}

	private static void warmUpAsserts() {
		assert 5 > 1;
		int a = 30;
		assert a != 0;

		assert null == null;
		assert true == true;

		assert false; // TODO: The assert statement that crashes the program.
		assert true;  // TODO: Another assert statement that crashes the program.
	}

	private static void assertWithPrimitives() {
		Scanner keys = new Scanner(System.in);
		System.out.println("Enter an integer numerator:");
		int num = keys.nextInt();

		System.out.println("Enter an int denominator, not 0:");
		int denom = keys.nextInt();

		assert denom != 0;

		ArrayList<String> emptyList = new ArrayList<String>();
		assert emptyList.size() == 0;

		assert false; // TODO: The assert statement that crashes the program.
		assert true;  // TODO: Another assert statement that crashes the program.
	}

	private static void assertWithObjects() {
		AssertDemo ad = new AssertDemo();
		ad.checkAddress(ad);
		assert ad.equals(ad);

		// TODO: Create objects from previous labs and test them with assert.
		// Example: Create two Point objects at the origin and assert they are equal.
		// Point p1 = new Point(0, 0);
		// Point p2 = new Point(0, 0);
		// assert p1.equals(p2); // Example

		// TODO: Two new assert statements for testing objects.
		assert false; // This assert statement will crash the program.
		assert true;  // This assert statement will crash the program.
	}

	public void checkAddress(Object input) {
		System.out.println("Address of this: " + this);
		System.out.println("Address of input: " + input);
		assert this == input;
	}

	private static void homeworkRelatedAsserts() {
		Object paidDate = new Object();
		assert paidDate != null;

		int cents = 0;
		assert cents >= 0 && cents <= 99;

		// TODO: Two new assert statements related to your homework.
		assert false; // This assert statement will crash the program.
		assert true;  // This assert statement will crash the program.
	}
}
