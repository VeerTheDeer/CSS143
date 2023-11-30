import java.io.*;

/**
 * The Date class represents a date with month, day, and year.
 * It implements Comparable for comparing Date objects, Cloneable for cloning,
 * and Serializable for object serialization.
 *
 * By: Veer Saini
 */
public class Date implements Comparable<Date>, Cloneable, Serializable {
	private int month;
	private int day;
	private int year;

	/**
	 * Default constructor initializes the Date object with zero values for month, day, and year.
	 */
	public Date() {
		this.month = 0;
		this.day = 0;
		this.year = 0;
	}

	/**
	 * Constructor initializes the Date object with the specified month, day, and year.
	 *
	 * @param mo The month.
	 * @param da The day.
	 * @param yr The year.
	 */
	public Date(int mo, int da, int yr) {
		this.setDate(mo, da, yr);
	}

	/**
	 * Copy constructor creates a new Date object with the same values as the provided Date object.
	 *
	 * @param b The Date object to be copied.
	 */
	public Date(Date b) {
		this.setDate(b.month, b.day, b.year);
	}

	/**
	 * Sets the month, day, and year for the Date object.
	 *
	 * @param month The month.
	 * @param day   The day.
	 * @param year  The year.
	 */
	public void setDate(int month, int day, int year) {
		if (month < 1 || month > 12) {
			System.out.println("Invalid month");
			System.exit(0);
		}
		if (day < 1 || day > 31) {
			System.out.println("Invalid day for month");
			System.exit(0);
		}
		if (year < 2014 || year > 2024) {
			System.out.println("Invalid Year");
			System.exit(0);
		}

		this.month = month;
		this.day = day;
		this.year = year;
	}

	/**
	 * Sets the month for the Date object.
	 *
	 * @param month The new month.
	 */
	public void setMonth(int month) {
		if (month < 1 || month > 12) {
			System.out.println("Invalid month");
			System.exit(0);
		}
		this.month = month;
	}

	/**
	 * Sets the day for the Date object.
	 *
	 * @param day The new day.
	 */
	public void setDay(int day) {
		if (day < 1 || day > 31) {
			System.out.println("Invalid day for month");
			System.exit(0);
		}
		this.day = day;
	}

	/**
	 * Sets the year for the Date object.
	 *
	 * @param year The new year.
	 */
	public void setYear(int year) {
		if (year < 2014 || year > 2024) {
			System.out.println("Invalid Year");
			System.exit(0);
		}
		this.year = year;
	}

	/**
	 * Gets a string representation of the Date object.
	 *
	 * @return A string representation of the Date object.
	 */
	public String getDate() {
		return this.toString();
	}

	/**
	 * Gets the month of the Date object.
	 *
	 * @return The month.
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * Gets the day of the Date object.
	 *
	 * @return The day.
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * Gets the year of the Date object.
	 *
	 * @return The year.
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Provides a string representation of the Date object.
	 *
	 * @return A formatted string representing the Date object.
	 */
	@Override
	public String toString() {
		String retStr = "";
		if (this.getMonth() < 10) {
			retStr += "0" + this.getMonth();
		} else {
			retStr += this.getMonth();
		}

		if (this.day < 10) {
			retStr += "/0" + this.getDay();
		} else {
			retStr += "/" + this.getDay();
		}

		retStr += "/" + this.getYear();
		return retStr;
	}

	/**
	 * Checks if another Date object is equal to this Date object.
	 *
	 * @param other The Date object to be compared.
	 * @return True if the objects are equal, false otherwise.
	 */
	public boolean equals(Date other) {
		return this.getMonth() == other.getMonth() && this.getDay() == other.getDay() && this.getYear() == other.getYear();
	}

	/**
	 * Checks if this Date object is after another Date object.
	 *
	 * @param other The Date object to compare against.
	 * @return True if this Date is after the other, false otherwise.
	 */
	public boolean isAfter(Date other) {
		return (this.getYear() > other.getYear()) ||
				(this.getYear() == other.getYear() && this.getMonth() > other.getMonth()) ||
				(this.getYear() == other.getYear() && this.getMonth() == other.getMonth() && this.getDay() > other.getDay());
	}

	/**
	 * Compares this Date object to another Date object.
	 *
	 * @param other The Date object to be compared.
	 * @return 0 if the objects are equal, 1 if this is greater, -1 if other is greater.
	 * @throws IllegalArgumentException If the input is not of type Date.
	 */
	public int compareTo(Date other) {
		if (this.getDate().equals(other.getDate())) {
			return 0;
		}

		if (this.getClass() != (other.getClass())) {
			throw new IllegalArgumentException(this.getClass() + "compareTo( " + other.getClass() + " ); Invalid input.");
		}

		if ((this.getYear() > other.getYear()) ||
				(this.getYear() == other.getYear() && this.getMonth() > other.getMonth()) ||
				(this.getYear() == other.getYear() && this.getMonth() == other.getMonth() && this.getDay() > other.getDay())) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Creates and returns a copy of this Date object.
	 *
	 * @return A cloned Date object.
	 */
	public Date clone() {
		return new Date(this.getMonth(), this.getDay(), this.getYear());
	}

	/**
	 * Serializes the Date object and saves it to a file.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public final void writeObject() throws IOException {
		try {
			FileOutputStream f = new FileOutputStream(this.getMonth() + this.getDay() + this.getYear() + ".ser");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(this);
			o.close();
			f.close();
			System.out.println("Serialized data is saved in " + this.getMonth() + this.getDay() + this.getYear() + ".ser");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deserializes a Date object from a file and prints information about it.
	 *
	 * @throws IOException            If an I/O error occurs.
	 * @throws ClassNotFoundException If the Date class is missing during deserialization.
	 */
	public final void readObject() throws IOException, ClassNotFoundException {
		Date d = null;
		try {
			FileInputStream f = new FileInputStream(this.getMonth() + this.getDay() + this.getYear() + ".ser");
			ObjectInputStream o = new ObjectInputStream(f);
			d = (Date) o.readObject();
			o.close();
			f.close();

		} catch (IOException exception) {
			exception.printStackTrace();
			return;

		} catch (ClassNotFoundException exception) {
			System.out.println("Date class not found");
			exception.printStackTrace();
			return;

		}

		System.out.println("Deserialized Date...");
		System.out.println("Month: " + d.getMonth());
		System.out.println("Day: " + d.getDay());
		System.out.println("Year: " + d.getYear());
		System.out.println("Date: " + d.getDate());
	}

}
