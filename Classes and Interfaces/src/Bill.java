import java.io.*;
import java.util.*;

/**
 * The Bill class represents a financial bill with an amount, due date, and originator.
 * It implements Comparable for comparing Bill objects, Cloneable for cloning,
 * and Serializable for object serialization.
 *
 * By: Veer Saini
 */
public class Bill implements Comparable, Cloneable, Serializable {
	private Money amount = new Money();
	private Date dueDate = new Date();
	private Date paidDate = new Date();
	private String originator;

	/**
	 * Default constructor initializes the Bill object with zero amount, default due date, and a default originator.
	 */
	public Bill() {
		this.amount.setMoney(0, 0);
		this.dueDate.setDate(1, 1, 2024);
		this.originator = "Originator";
	}

	/**
	 * Constructor initializes the Bill object with the specified amount, due date, and originator.
	 *
	 * @param am   The amount.
	 * @param due  The due date.
	 * @param orig The originator.
	 */
	public Bill(Money am, Date due, String orig) {
		this.amount.setMoney(am.getDollars(), am.getCents());
		this.dueDate.setDate(due.getMonth(), due.getDay(), due.getYear());
		this.originator = orig;
	}

	/**
	 * Copy constructor creates a new Bill object with the same values as the provided Bill object.
	 *
	 * @param other The Bill object to be copied.
	 */
	public Bill(Bill other) {
		this.amount.setMoney(other.getAmount().getDollars(), other.getAmount().getCents());
		this.dueDate.setDate(other.getDueDate().getMonth(), other.getDueDate().getDay(), other.getDueDate().getYear());
		this.originator = other.getOriginator();
	}

	/**
	 * Gets the amount of the Bill object.
	 *
	 * @return The amount.
	 */
	public Money getAmount() {
		return this.amount;
	}

	/**
	 * Gets the due date of the Bill object.
	 *
	 * @return The due date.
	 */
	public Date getDueDate() {
		return this.dueDate;
	}

	/**
	 * Gets the originator of the Bill object.
	 *
	 * @return The originator.
	 */
	public String getOriginator() {
		return this.originator;
	}

	/**
	 * Checks if the bill has been paid.
	 *
	 * @return True if the bill has been paid, false otherwise.
	 */
	public boolean isPaid() {
		return this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0;
	}

	/**
	 * Sets the bill as paid on the specified date.
	 *
	 * @param datePaid The date the bill was paid.
	 * @return True if the bill was successfully set as paid, false otherwise.
	 */
	public boolean setPaid(Date datePaid) {
		if (this.isPaid() || datePaid.getYear() > this.dueDate.getYear() ||
				datePaid.getMonth() > this.dueDate.getMonth() && datePaid.getYear() >= this.dueDate.getYear() ||
				datePaid.getDay() > this.dueDate.getDay() && datePaid.getYear() >= this.dueDate.getYear() && datePaid.getMonth() >= this.dueDate.getMonth()) {
			return false;
		} else {
			this.paidDate = datePaid;
			return true;
		}
	}

	/**
	 * Sets the due date of the bill.
	 *
	 * @param date The new due date.
	 * @return True if the due date was successfully set, false otherwise.
	 */
	public boolean setDueDate(Date date) {
		if (this.isPaid() || this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0) {
			return false;
		} else {
			this.dueDate = date;
			return true;
		}
	}

	/**
	 * Sets the amount of the bill.
	 *
	 * @param money The new amount.
	 * @return True if the amount was successfully set, false otherwise.
	 */
	public boolean setAmount(Money money) {
		if (this.isPaid() || this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0) {
			return false;
		} else {
			this.amount = money;
			return true;
		}
	}

	/**
	 * Sets the originator of the bill.
	 *
	 * @param str The new originator.
	 */
	public void setOriginator(String str) {
		this.originator = str;
	}

	/**
	 * Provides a string representation of the Bill object.
	 *
	 * @return A formatted string representing the Bill object.
	 */
	public String toString() {
		if (this.isPaid()) {
			return "Amount due: " + this.amount.toString() + ", on " + this.dueDate.toString() + ", by " + this.originator + "; was paid on: " + this.paidDate;
		} else {
			return "Amount due: " + this.amount.toString() + ", on " + this.dueDate.toString() + ", by " + this.originator + "; there is still money due.";
		}
	}

	/**
	 * Checks if another Bill object is equal to this Bill object.
	 *
	 * @param other The Bill object to be compared.
	 * @return True if the objects are equal, false otherwise.
	 */
	public boolean equals(Bill other) {
		return this.amount.equals(other.getAmount()) && this.dueDate.equals(other.getDueDate()) &&
				Objects.equals(this.originator, other.getOriginator()) && this.paidDate.equals(other.paidDate);
	}

	/**
	 * Compares this Bill object to another object.
	 *
	 * @param obj The object to be compared.
	 * @return A negative integer, zero, or a positive integer as this object is less than, equal to,
	 * or greater than the specified object.
	 * @throws IllegalArgumentException If the input is not of type Bill.
	 */
	public int compareTo(Object obj) {
		if (obj.getClass() != this.getClass()) {
			throw new IllegalArgumentException("Invalid Input");
		} else {
			Bill other = (Bill) obj;
			if (this.getDueDate().compareTo(other.getDueDate()) != 0) {
				return this.getDueDate().compareTo(other.getDueDate());
			} else if (this.getAmount().compareTo(other.getAmount()) != 0) {
				return this.getAmount().compareTo(other.getAmount());
			} else {
				return this.getOriginator().compareTo(other.getOriginator());
			}
		}
	}

	/**
	 * Creates and returns a copy of this Bill object.
	 *
	 * @return A cloned Bill object.
	 */
	public Bill clone() {
		try {
			Bill clone = (Bill) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		try {
			return new Bill(this.amount.clone(), this.dueDate.clone(), this.originator);
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Deserializes a Bill object from a file and prints information about it.
	 *
	 * @throws IOException            If an I/O error occurs.
	 * @throws ClassNotFoundException If the Bill class is missing during deserialization.
	 */
	public final void readObject() throws IOException, ClassNotFoundException {
		Bill temp = null;
		try {
			FileInputStream f = new FileInputStream(this.getOriginator() + "." + this.amount.getDollars() + this.amount.getCents() + ".ser");
			ObjectInputStream o = new ObjectInputStream(f);
			temp = (Bill) o.readObject();
			o.close();
			f.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Not Found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized Bill...");
		System.out.println("Originator: " + temp.getOriginator());
		System.out.println("Amount: " + temp.getAmount());
		System.out.println("Due Date: " + temp.getDueDate());
	}

	/**
	 * Serializes the Bill object and saves it to a file.
	 *
	 * @throws IOException If an I/O error occurs.
	 */
	public final void writeObject() throws IOException {
		try {
			FileOutputStream f = new FileOutputStream(this.getOriginator() + "." + this.amount.getDollars() + this.amount.getCents() + ".ser");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(this);
			o.close();
			f.close();
			System.out.println("Serialized data is saved in " + this.getOriginator() + "." + this.amount.getDollars() + this.amount.getCents() + ".ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
