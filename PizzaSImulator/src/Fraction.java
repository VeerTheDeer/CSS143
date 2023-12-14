/**
 * This class represents a Fraction and implements the Comparable interface.
 * It provides methods for creating and manipulating fractions, including comparison.
 * Fractions are always stored in reduced form.
 *
 * @author Veer Saini
 */
public class Fraction implements Comparable<Fraction> {

	private final int numerator;
	private final int denominator;

	/**
	 * Empty main method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String[] args) {
	}

	/**
	 * Default constructor for creating a Fraction object with the value 0/1.
	 */
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;
	}

	/**
	 * Constructor for creating a Fraction object with a specified numerator and denominator.
	 *
	 * @param numerator   The numerator of the fraction.
	 * @param denominator The denominator of the fraction.
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * Checks if this fraction is equal to another fraction.
	 *
	 * @param other The fraction to compare with.
	 * @return true if the fractions are equal, false otherwise.
	 */
	public boolean equals(Fraction other) {
		return reduceFraction(this.numerator, this.denominator).equals(reduceFraction(other.numerator, other.denominator));
	}

	/**
	 * Reduces the given fraction to its simplest form.
	 *
	 * @param numerator   The numerator of the fraction.
	 * @param denominator The denominator of the fraction.
	 * @return The simplified fraction as a string in the form "numerator/denominator".
	 */
	public String reduceFraction(int numerator, int denominator) {
		int gcm = this.gcm(numerator, denominator);
		return (numerator / gcm) + "/" + (denominator / gcm);
	}

	/**
	 * Calculates the greatest common divisor (GCD) of two numbers using recursion.
	 *
	 * @param num The first number.
	 * @param den The second number.
	 * @return The GCD of the two numbers.
	 */
	private int gcm(int num, int den) {
		if (den != 0) {
			return gcm(den, num % den);
		} else {
			return num;
		}
	}

	/**
	 * Returns a string representation of the Fraction object.
	 *
	 * @return The string representation of the fraction in reduced form.
	 */
	@Override
	public String toString() {
		return reduceFraction(numerator, denominator);
	}

	/**
	 * Gets the numerator of the fraction.
	 *
	 * @return The numerator of the fraction.
	 */
	int getNumerator() {
		return this.numerator;
	}

	/**
	 * Gets the denominator of the fraction.
	 *
	 * @return The denominator of the fraction.
	 */
	int getDenominator() {
		return this.denominator;
	}

	/**
	 * Compares this fraction with another fraction.
	 *
	 * @param other The fraction to compare with.
	 * @return A negative integer, zero, or a positive integer as this fraction is less than, equal to, or greater than the specified fraction.
	 */
	@Override
	public int compareTo(Fraction other) {
		return Double.compare((double) this.getNumerator() / (double) this.getDenominator(),
				(double) other.getNumerator() / (double) other.getDenominator());
	}
}
