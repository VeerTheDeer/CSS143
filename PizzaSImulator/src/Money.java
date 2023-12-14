import java.io.*;

/**
 * This class represents a monetary value with dollars and cents. It implements Comparable,
 * Cloneable, and Serializable interfaces.
 *
 * @author Veer Saini
 */
public class Money implements Comparable<Money>, Cloneable, Serializable {
	private int dollars;
	private int cents;

	/**
	 * Default constructor for creating a Money object with zero dollars and zero cents.
	 */
	public Money() {
		this.dollars = 0;
		this.cents = 0;
	}

	/**
	 * Constructor for creating a Money object with the specified number of dollars and zero cents.
	 *
	 * @param dollar The number of dollars.
	 */
	public Money(int dollar) {
		this.setMoney(dollar, 0);
	}

	/**
	 * Constructor for creating a Money object with the specified number of dollars and cents.
	 *
	 * @param dollar The number of dollars.
	 * @param cent   The number of cents.
	 */
	public Money(int dollar, int cent) {
		this.setMoney(dollar, cent);
	}

	/**
	 * Copy constructor for creating a Money object based on another Money object.
	 *
	 * @param other Another Money object to copy values from.
	 */
	public Money(Money other) {
		this.setMoney(other.getDollars(), other.getCents());
	}

	/**
	 * Gets the number of dollars.
	 *
	 * @return The number of dollars.
	 */
	public int getDollars() {
		return this.dollars;
	}

	/**
	 * Gets the number of cents.
	 *
	 * @return The number of cents.
	 */
	public int getCents() {
		return this.cents;
	}

	/**
	 * Sets the money value with the specified number of dollars and cents.
	 *
	 * @param dollar The number of dollars.
	 * @param cent   The number of cents.
	 */
	public void setMoney(int dollar, int cent) {
		this.dollars = dollar;
		this.cents = cent;
	}

	/**
	 * Gets the money value as a double.
	 *
	 * @return The money value as a double.
	 */
	public double getMoney() {
		return this.dollars + ((double) this.cents / 100);
	}

	/**
	 * Adds another Money object to this Money object.
	 *
	 * @param other Another Money object to add.
	 */
	public void add(Money other) {
		int tempDollars = this.dollars + other.dollars;
		int tempCents = this.cents + other.cents;

		if (tempCents > 100) {
			tempCents -= 100;
			tempDollars += 1;
		}
		this.setMoney(tempDollars, tempCents);
	}

	/**
	 * Adds a specified number of dollars to this Money object.
	 *
	 * @param dollar The number of dollars to add.
	 */
	public void add(int dollar) {
		this.setMoney(this.getDollars() + dollar, this.getCents());
	}

	/**
	 * Adds a specified number of dollars and cents to this Money object.
	 *
	 * @param dollar The number of dollars to add.
	 * @param cent   The number of cents to add.
	 */
	public void add(int dollar, int cent) {
		int tempDollars = this.getDollars() + dollar;
		int tempCents = this.getCents() + cent;

		if (tempCents > 100) {
			tempCents -= 100;
			tempDollars += 1;
		}
		this.setMoney(tempDollars, tempCents);
	}

	/**
	 * Converts the Money object to its string representation.
	 *
	 * @return The string representation of the Money object.
	 */
	public String toString() {
		while (this.cents >= 100) {
			this.cents -= 100;
			this.dollars += 1;
		}

		if (this.cents < 10) {
			return this.getDollars() + "." + "0" + this.getCents();
		} else {
			return this.getDollars() + "." + this.getCents();
		}
	}

	/**
	 * Checks if another Money object is equal to this Money object.
	 *
	 * @param other Another Money object to compare.
	 * @return True if the Money objects are equal, false otherwise.
	 */
	public boolean equals(Money other) {
		return this.getDollars() == other.getDollars() && this.getCents() == other.getCents();
	}

	/**
	 * Compares this Money object to another Money object.
	 *
	 * @param other Another Money object to compare.
	 * @return 0 if the Money objects are equal, 1 if this is greater, -1 if this is smaller.
	 * @throws IllegalArgumentException If the class of the compared objects is different.
	 */
	public int compareTo(Money other) {
		if (this.getClass() != other.getClass()) {
			throw new IllegalArgumentException("Invalid input");
		}

		if (this.getDollars() == other.getDollars() && this.getCents() == other.getCents()) {
			return 0;
		}

		if (this.getMoney() > other.getMoney()) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Clones the Money object.
	 *
	 * @return A new Money object with the same values as this object.
	 */
	public Money clone() {
		return new Money(this.getDollars(), this.getCents());
	}

	/**
	 * Writes the Money object to a serialized file.
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
			System.out.println("Data is saved in " + this.getDollars() + "." + this.getCents() + ".ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the Money object from a serialized file.
	 *
	 * @throws IOException            If an I/O error occurs.
	 * @throws ClassNotFoundException If the class of the serialized object cannot be found.
	 */
	public final void readObject() throws IOException, ClassNotFoundException {
		Money temp = null;
		try {
			FileInputStream f = new FileInputStream(this.getDollars() + "." + this.getCents() + ".ser");
			ObjectInputStream o = new ObjectInputStream(f);
			temp = (Money) o.readObject();
			o.close();
			f.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Error");
			c.printStackTrace();
			return;
		}

		System.out.println("Money: " + temp.getMoney());
		System.out.println("Dollars: " + temp.getDollars());
		System.out.println("Cents: " + temp.getCents());
		System.out.println("String: " + temp.toString());
	}
}