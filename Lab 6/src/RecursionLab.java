/**
 * RecursionLab class demonstrates various recursive algorithms and their behaviors.
 * The class includes methods for calculating factorial, exponentiation, Fibonacci series, binomial coefficient, summation, and visualization of recursive calls.
 * Author: Veer Saini
 */
import java.awt.Dimension;
import javax.swing.*;

public class RecursionLab {

	private static JTextArea myArea = new JTextArea();
	private static int count = 0;

	/**
	 * The main method executes different recursive algorithms to demonstrate their behaviors.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String args[]) {
		int solution = iterativeSum(20);
		// int solution = recursiveSum(20);
		System.out.println(factorial(4));
		System.out.println(fib(7));

		// GUI details
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane(myArea);
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600, 300));
		JOptionPane.showMessageDialog(null, myPane);

		// Good form to include an exit call when using GUI in Java
		System.exit(0);
	}

	/**
	 * Calculates the binomial coefficient.
	 *
	 * @param n The value of 'n' in nCr
	 * @param r The value of 'r' in nCr
	 * @return The binomial coefficient value
	 */
	public static int choose(int n, int r) {
		int numerator = factorial(n);
		int denominator = factorial(r) * factorial(n - r);
		return numerator / denominator;
	}

	/**
	 * Calculates the factorial of a number using recursion.
	 *
	 * @param factor The number for which factorial needs to be calculated
	 * @return The factorial of the given number
	 */
	public static int factorial(int factor) {
		if (factor == 0) {
			return 1;
		} else {
			return factorial(factor - 1) * factor;
		}
	}

	/**
	 * Calculates the exponentiation of a number.
	 *
	 * @param base     The base number
	 * @param exponent The exponent to raise the base to
	 * @return The result of the exponentiation
	 */
	public static int exponent1(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else if (exponent > 0) {
			return base * exponent1(base, exponent - 1);
		}
		return 0;
	}

	/**
	 * Calculates the exponentiation of a number using an optimized approach.
	 *
	 * @param base     The base number
	 * @param exponent The exponent to raise the base to
	 * @return The result of the exponentiation
	 */
	public static int exponent2(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else if (exponent % 2 == 0) {
			return exponent2(base, exponent / 2) * exponent2(base, exponent / 2);
		} else if (exponent % 2 == 1) {
			return base * exponent2(base, (exponent - 1) / 2) * exponent2(base, (exponent - 1) / 2);
		}
		return 0;
	}

	/**
	 * Calculates the nth Fibonacci number.
	 *
	 * @param n The position of the Fibonacci number to be calculated
	 * @return The Fibonacci number at position n
	 */
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n > 1) {
			return fib(n - 1) + fib(n - 2);
		}
		return 0;
	}

	/**
	 * Recursively computes the sum of natural numbers from 1 to n.
	 *
	 * @param n The number up to which the sum needs to be calculated
	 * @return The sum of natural numbers up to n
	 */
	public static int recursiveSum(int n) {
		updateRecursiveDisplay(n);
		if (n == 1)
			return 1;
		else
			return (n + recursiveSum(n - 1));
	}

	/**
	 * Computes the sum of natural numbers from 1 to n using iteration.
	 *
	 * @param i The number up to which the sum needs to be calculated
	 * @return The sum of natural numbers up to i
	 */
	public static int iterativeSum(int i) {
		int total = 0;

		for (int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}

	/**
	 * Provides visualization of each recursive call for the recursiveSum method.
	 *
	 * @param n The current value of n in the recursiveSum method
	 */
	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();

		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n + " ). Total += " + n;
		text += "\n***************************************************************************/";

		myArea.setText(text);
	}

	/**
	 * Displays the recursive calls and their behavior in the recursiveSum method.
	 *
	 * @param n The current value of n in the recursiveSum method
	 */
	public static void updateRecursiveDisplay(int n) {

		count++;
		String text = myArea.getText();

		if (count == 1) {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";

		text += "\n Calling recursiveSum( int n = " + n + " ). ";
		text += "\n The return statement from this function will resolve in " + (n - 1) + " more recursive method calls...";

		if (n != 1) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( " + (n - 1) + " ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText(text);
	}
}
