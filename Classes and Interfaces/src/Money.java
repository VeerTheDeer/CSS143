import java.io.*;

/**
 * The Money class represents a monetary amount in dollars and cents.
 * It implements Comparable for comparing Money objects, Cloneable for cloning,
 * and Serializable for object serialization.
 *
 * By: Veer Saini
 */
public class Money implements Comparable<Money>, Cloneable, Serializable {
	private int dollars;
	private int cents;

	/**
	 * Default constructor initializes the Money object with zero dollars and zero cents.
	 */
	public Money() {
		this.dollars = 0;
		this.cents = 0;
	}

	/**
	 * Constructor initializes the Money object with the specified dollar amount and zero cents.
	 *
	 * @param dollar The dollar amount.
	 */
	public Money(int dollar) {
		this.setMoney(dollar, 0);
	}

	/**
	 * Constructor initializes the Money object with the specified dollar and cent amounts.
	 *
	 * @param dollar The dollar amount.
	 * @param cent   The cent amount.
	 */
	public Money(int dollar, int cent) {
		this.setMoney(dollar, cent);
	}

	/**
	 * Copy constructor creates a new Money object with the same values as the provided Money object.
	 *
	 * @param other The Money object to be copied.
	 */
	public Money(Money other) {
		this.setMoney(other.getDollars(), other.getCents());
	}

	/**
	 * Gets the dollar amount of the Money object.
	 *
	 * @return The dollar amount.
	 */
	public int getDollars() {
		return this.dollars;
	}

	/**
	 * Gets the cent amount of the Money object.
	 *
	 * @return The cent amount.
	 */
	public int getCents() {
		return this.cents;
	}

	/**
	 * Sets the dollar and cent amounts for the Money object.
	 *
	 * @param dollar The new dollar amount.
	 * @param cent   The new cent amount.
	 */
	public void setMoney(int dollar, int cent) {
		this.dollars = dollar;
		this.cents = cent;
	}

	/**
	 * Gets the total monetary value in dollars and cents as a double.
	 *
	 * @return The total monetary value.
	 */
	public double getMoney() {
		return this.dollars + ((double) this.cents / 100);
	}

	/**
	 * Adds the monetary values of another Money object to this Money object.
	 *
	 * @param other The Money object to be added.
	 */
	public void add(Money other) {
		int tempD = getDollars() + other.dollars;
		int tempC = getCents() + other.cents;

		if (tempC > 100) {
			tempC -= 100;
			tempD += 1;
		}
		this.setMoney(tempD, tempC);
	}

	/**
	 * Adds a specified dollar amount to the Money object.
	 *
	 * @param dollar The dollar amount to be added.
	 */
	public void add(int dollar) {
		this.setMoney(this.getDollars() + dollar, this.getCents());
	}

	/**
	 * Adds specified dollar and cent amounts to the Money object.
	 *
	 * @param dollar The dollar amount to be added.
	 * @param cent   The cent amount to be added.
	 */
	public void add(int dollar, int cent) {
		int tempD = this.getDollars() + dollar;
		int tempC = this.getCents() + cent;

		if (tempC > 100) {
			tempC -= 100;
			tempD += 1;
		}
		this.setMoney(tempD, tempC);
	}

	/**
	 * Returns a string representation of the Money object.
	 *
	 * @return A string representation of the Money object.
	 */
	public String toString() {
		if (this.cents < 0) {
			return "$" + this.dollars + "." + "0" + this.cents;
		} else {
			return "$" + this.dollars + "." + this.cents;
		}
	}

	/**
	 * Checks if another Money object is equal to this Money object.
	 *
	 * @param other The Money object to be compared.
	 * @return True if the objects are equal, false otherwise.
	 */
	public boolean equals(Money other) {
		return this.dollars == other.dollars && this.cents == other.cents;
	}

	/**
	 * Compares this Money object to another Money object.
	 *
	 * @param other The Money object to be compared.
	 * @return 0 if the objects are equal, 1 if this is greater, -1 if other is greater.
	 * @throws IllegalArgumentException If the input is not of type Money.
	 */
	public int compareTo(Money other) {
		if (this.getClass() != (other.getClass())) {
			throw new IllegalArgumentException("Invalid input");
		}

		if ((this.getDollars() == other.getDollars()) && (this.getCents() == other.getCents())) {
			return 0;
		}

		if (this.getMoney() > other.getMoney()) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Creates and returns a copy of this Money object.
	 *
	 * @return A cloned Money object.
	 * @throws CloneNotSupportedException If cloning is not supported.
	 */
	public Money clone() throws CloneNotSupportedException {
		Money clone = (Money) super.clone();
		return new Money(this.dollars, this.cents);
	}

	/**
	 * Serializes the Money object and saves it to a file.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public final void writeObject() throws IOException {
		try {
			FileOutputStream f = new FileOutputStream(this.getDollars() + "." + this.getCents() + ".ser");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(this);
			o.close();
			f.close();
			System.out.println("Serialized data is saved in " + this.getDollars() + "." + this.getCents() + ".ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deserializes a Money object from a file and prints information about it.
	 *
	 * @throws IOException            If an I/O error occurs.
	 * @throws ClassNotFoundException If the Money class is missing during deserialization.
	 */
	public final void readObject() throws IOException, ClassNotFoundException {
		Money m = null;
		try {
			FileInputStream f = new FileInputStream(this.getDollars() + "." + this.getCents() + ".ser");
			ObjectInputStream o = new ObjectInputStream(f);
			m = (Money) o.readObject();
			o.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			return;
		} catch (ClassNotFoundException exception) {
			System.out.println("Money class is missing");
			exception.printStackTrace();
			return;
		}

		System.out.println("Deserialized Money...");
		System.out.println("Money: " + m.getMoney());
		System.out.println("Dollars: " + m.getDollars());
		System.out.println("Cents: " + m.getCents());
		System.out.println("String: " + m.toString());
	}
}
