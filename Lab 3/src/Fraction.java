/**
 * The Fraction class represents a fraction with a numerator and a denominator.
 * Fractions are immutable, and arithmetic operations return new Fraction instances.
 */
public class Fraction {
    /** The numerator of the fraction. */
    public final int numerator;

    /** The denominator of the fraction. */
    public final int denominator;

    /**
     * Constructs a new Fraction with the given numerator and denominator.
     *
     * @param numerator   The numerator of the fraction.
     * @param denominator The denominator of the fraction.
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Copy constructor that creates a new Fraction identical to an existing one.
     *
     * @param newFraction The Fraction to copy.
     */
    public Fraction(Fraction newFraction) {
        this.numerator = newFraction.numerator;
        this.denominator = newFraction.denominator;
    }

    /**
     * Adds this fraction to another Fraction and returns the result as a new Fraction.
     *
     * @param other The Fraction to add to this Fraction.
     * @return A new Fraction representing the result of the addition.
     */
    public Fraction add(Fraction other) {
        int newDenom = this.denominator * other.denominator;
        int newNum = (this.numerator * other.denominator) + (other.numerator * this.denominator);

        return new Fraction(newNum, newDenom);
    }

    /**
     * Checks if this Fraction is equal to another Object.
     *
     * @param object The Object to compare to this Fraction.
     * @return True if the Object is a Fraction and has the same numerator and denominator, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Fraction other)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }
}
