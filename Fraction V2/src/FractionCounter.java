/**
 * Veer Saini
 *
 * This is the FractionCounter class
 * The purpose of this class is to hold a fraction
 * object and counter next to it
 * This is a way to store a fraction and the number of
 * occurrences that happen associated with that fraction.
 */
public class FractionCounter {
    private Fraction fraction;
    private int counter;

    /**
     * This is the constructor method of FractionCounter
     * This method stores a Fraction object and sets the counter to 1
     *
     * @param fraction
     */
    public FractionCounter(Fraction fraction) {
        this.fraction = fraction;
        this.counter = 1;
    }

    /**
     * compareAndIncrement method returns a boolean and takes
     * a Fraction type as a parameter.
     * This method takes the parameter and compares it to
     * the object that the method is called with.
     * if the fractions are equal, the counter associated
     * with that object are incremented by one.
     * if not, the method simply returns false.
     *
     * @param newFraction
     * @return
     */
    public boolean compareAndIncrement(Fraction newFraction) {
        if(this.fraction.equals(newFraction)) {
            counter++;
            return true;
        }
        return false;
    }

    /**
     * This is a basic getFraction method that returns the
     * fraction that the FractionCounter object has stored
     *
     * @return
     */
    public Fraction getFraction() {
        return fraction;
    }

    /**
     * This is the toString method that overrides the default toString method
     * This method will be called whenever the method is called,
     * or when System.out.println, and anything related to string are called
     * This method will return the Fraction and the counter next to it
     *
     * Ex. "2/1 has a count of 2"
     *
     * @return
     */
    @Override
    public String toString() {
        return this.fraction.toString() + " has a count of " + this.counter;
    }

    /**
     * This is the equals method that compares the Fraction that is stored
     * within the FractionCounter Object and with the Fraction parameter
     * This method calls onto the equals method that is the Fraction class.
     *
     * @param other
     * @return
     */
    public boolean equals(Fraction other) {
        return this.fraction.equals(other);
    }
}
