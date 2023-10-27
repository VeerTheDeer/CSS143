/**
 * Represents a monetary value in dollars and cents.
 * By Veer Saini
 * 10/27/23
 */
public class Money {

    private int dollars;
    private int cents;

    /**
     * Constructs a Money object with dollars only.
     *
     * @param dollar The dollar amount.
     */
    public Money(int dollar) {
        this.dollars = dollar;
        this.cents = 0;
        isValid();
    }

    /**
     * Constructs a Money object with dollars and cents.
     *
     * @param dollar The dollar amount.
     * @param cent   The cent amount.
     */
    public Money(int dollar, int cent) {
        this.dollars = dollar;
        this.cents = cent;
        isValid();
    }

    /**
     * Constructs a Money object using the values from another Money object.
     *
     * @param other Another Money object.
     */
    public Money(Money other) {
        this.dollars = other.dollars;
        this.cents = other.cents;
        isValid();
    }

    /**
     * Retrieves the dollar amount.
     *
     * @return The dollar amount.
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * Retrieves the cent amount.
     *
     * @return The cent amount.
     */
    public int getCents() {
        return cents;
    }

    /**
     * Sets the Money object with the provided dollar and cent values.
     *
     * @param dollar The dollar amount.
     * @param cent   The cent amount.
     */
    public void setMoney(int dollar, int cent) {
        this.dollars = dollar;
        this.cents = cent;
        isValid();
    }

    /**
     * Retrieves the total monetary value as a double.
     *
     * @return The total monetary value.
     */
    public double getMoney() {
        return Double.parseDouble(dollars + "." + cents);
    }

    /**
     * Adds a specific dollar amount to the current Money object.
     *
     * @param dollar The dollar amount to be added.
     */
    public void add(int dollar) {
        this.dollars += dollar;
    }

    /**
     * Adds a specific dollar and cent amount to the current Money object.
     *
     * @param dollar The dollar amount to be added.
     * @param cent   The cent amount to be added.
     */
    public void add(int dollar, int cent) {
        this.dollars += dollar;
        this.cents += cent;
        isValid();
    }

    /**
     * Adds another Money object's value to the current Money object.
     *
     * @param other Another Money object.
     */
    public void add(Money other) {
        dollars += other.dollars;
        cents += other.cents;
        isValid();
    }

    /**
     * Checks if this Money object is equal to another object.
     *
     * @param o The object to compare.
     * @return True if the objects are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object o) {
        if ((o == null) || !(o instanceof Money)) {
            return false;
        }
        return this.dollars == ((Money) o).dollars && this.cents == ((Money) o).cents;
    }

    /**
     * Ensures that the monetary value is valid without negative amounts or excess cents.
     */
    private void isValid() {
        if (this.cents > 99) {
            this.dollars += this.cents / 100;
            this.cents = this.cents % 100;
        }
        if (this.dollars < 0 || this.cents < 0) {
            System.out.println("You cannot have negative money.");
        }
    }

    /**
     * Returns the Money object as a formatted string.
     *
     * @return A string representation of the Money object.
     */
    public String toString() {
        isValid();
        if (cents < 10)
            return "$" + dollars + ".0" + cents;
        else {
            return "$" + dollars + "." + cents;
        }
    }
}
