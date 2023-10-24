/**
 * Veer Saini
 *
 * This class is the fraction class, that will be used
 * throughout the whole program.
 * takes in numerator and denominator and stores the numbers
 * in its simplest integer form
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {

    }

    /**
     * This is the constructor
     * This constructor takes in two doubles.
     * the process of simplification and turning the
     * numerator and denominator happens here.
     * First we multiply the double by 10 so that there
     * are no decimals left
     * We call the GCD method to simplify the numerator and
     * the denominator.
     *
     * @param numerator
     * @param denominator
     */
    public Fraction(double numerator, double denominator) {
        double tempNum = numerator;
        double tempDenom = denominator;

        while(numerator % 1 > 0 || denominator % 1 > 0) {
            numerator *= 10;
            denominator *= 10;
        }
        this.numerator = (int) tempNum;
        this.denominator = (int) tempDenom;
        int GCD = getGCD(this.numerator, this.denominator);

        this.numerator /= GCD;
        this.denominator /= GCD;
    }

    /**
     * This is another constructor
     * this one takes in integers instead of doubles
     * in this case, you do not need to multiply by 10 because of the
     * numbers being integers in the first place.
     * We call the getGCD method and simplify and store
     * the numerator and denominator.
     *
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        this.denominator = denominator/getGCD(numerator, denominator);
        this.numerator = numerator/getGCD(numerator, denominator);
    }

    /**
     * this is a basic getter class for numerator
     *
     * @return
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * this is a basic getter class for denominator
     *
     * @return
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * This is a setter for the Fraction class
     * This setter is the same as the constructor
     * The same steps are taken to make sure that the doubles
     * are converted into the simplest integer form
     *
     * @param numerator
     * @param denominator
     */
    public void setFraction(double numerator, double denominator) {
        double tempNum = numerator;
        double tempDenom = denominator;

        while(numerator % 1 > 0 || denominator % 1 > 0) {
            numerator *= 10;
            denominator *= 10;
        }
        this.numerator = (int) tempNum;
        this.denominator = (int) tempDenom;
        int GCD = getGCD(this.numerator, this.denominator);

        this.numerator /= GCD;
        this.denominator /= GCD;
    }

    /**
     * This is the same code as the constructor that takes in 2 integers
     * It once again calls the GCD method and stores the simplest integer form
     *
     * @param numerator
     * @param denominator
     */
    public void setFraction(int numerator, int denominator) {
        this.denominator = denominator/getGCD(numerator, denominator);
        this.numerator = numerator/getGCD(numerator, denominator);
    }

    /**
     * This is the equals method
     * This method checks if two Fraction objects are equal to each other by checking
     * if the numerators and denominators are equal
     *
     * @param other
     * @return
     */
    public boolean equals(Fraction other) {
        return (this.numerator == other.numerator && this.denominator == other.denominator);
    }

    /**
     * This is the toString method
     * This method overrides the default toString method.
     * Whenever this method is called or when an object is used with a
     * System.out.println command or other commands related to strings,
     * this method will return the numerator and denominator separated with a "/"
     *
     * Ex. "3/2"
     *
     * @return
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * This is the GCD method
     * This method takes the numerator and the denominator
     * and finds the GCD between them
     * The basic algorithm that was described was from a khan academy post
     *
     * https://www.khanacademy.org/computing/computer-science/cryptography/
     * modarithmetic/a/the-euclidean-algorithm#
     * :~:text=The%20Algorithm,%3D%20B⋅Q%20%2B%20R
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public static int getGCD(int numerator, int denominator) {
        while(denominator != 0 && numerator != 0) {
            int remainder = numerator % denominator;
            numerator = denominator;
            denominator = remainder;
        }
        if(numerator != 0) {
            return numerator;
        }
        return denominator;
    }
}
