import java.io.*;
import java.util.*;

/**
 * The `Driver` class contains the main method to execute tests for Date, Money, Bill, and ExpenseAccount classes.
 * It performs tests on various functionalities, such as compareTo, clone, serialization, and more.
 *
 * By: Veer Saini
 */
public class Driver {

	/**
	 * Main method to execute tests for Date, Money, Bill, and ExpenseAccount classes.
	 *
	 * @param args The command-line arguments (not used in this program).
	 */
	public static void main(String args[]) {
		dateTest();
		moneyTest();
		billTest();
	}

	/**
	 * Conducts tests on the Date class, including compareTo, clone, and serialization.
	 */
	public static void dateTest() {
		//Tests are conducted on compareTo, clone, and serializable
		Money m = new Money();
		Date eD = new Date(1,1,2017);
		Date eD2 = new Date(1,2,2017);
		Date eD3 = new Date(2,1,2017);
		Date lD = new Date(1,1,2018);
		Date lD2 = new Date(1,2,2018);
		Date lD3 = new Date(2,1,2018);
		Date eD2Clone = eD2.clone();
		Date eDClone = eD.clone();

		//System.out.println(eD.compareTo(m)); // Won't work. Doesn't Compile.
		System.out.println("Date");
		if(
				eD.compareTo(eD) == 0 &&
						eD.compareTo(eD2) == -1 &&
						eD.compareTo(eD3) == -1 &&
						eD.compareTo(lD) == -1 &&
						eD.compareTo(lD2) == -1 &&
						eD.compareTo(lD3) == -1 &&
						lD.compareTo(eD) == 1 &&
						lD.compareTo(eD2) == 1 &&
						lD.compareTo(eD3) == 1 &&
						lD.compareTo(lD) == 0 &&
						lD.compareTo(lD2) == -1 &&
						lD.compareTo(lD3) == -1 &&
						lD3.compareTo(eD) == 1 &&
						lD3.compareTo(eD2) == 1 &&
						lD3.compareTo(eD3) == 1 &&
						lD3.compareTo(lD) == 1 &&
						lD3.compareTo(lD2) == 1 &&
						lD3.compareTo(lD3) == 0 &&
						eDClone.compareTo(eD) == 0 &&
						eDClone.compareTo(eD2) == -1 &&
						eDClone.compareTo(eD3) == -1 &&
						eDClone.compareTo(lD) == -1 &&
						eDClone.compareTo(lD2) == -1 &&
						eDClone.compareTo(lD3) == -1 &&
						eD2Clone.compareTo(eD) == 1 &&
						eD2Clone.compareTo(eD2) == 0 &&
						eD2Clone.compareTo(eD3) == -1 &&
						eD2Clone.compareTo(lD) == -1 &&
						eD2Clone.compareTo(lD2) == -1 &&
						eD2Clone.compareTo(lD3) == -1
		)
			System.out.println("works");
		else
			System.out.println("no good");
		try{
			eD.writeObject();
			eD2.writeObject();
			eD.readObject();
			eD2.readObject();
		} catch(IOException | ClassNotFoundException ignored) {
		}

	}

	/**
	 * Conducts tests on the Money class, including compareTo, clone, and serialization.
	 */
	public static void moneyTest() {
		Money m1 = new Money(1, 50);
		Money m2 = new Money(2, 50);
		Money m3 = new Money(3, 50);
		Money m3Clone = null;
		try {
			m3Clone = m3.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Money");

		if(
				m1.compareTo(m2) == -1 &&
						m1.compareTo(m3) == -1 &&
						m1.compareTo(m3Clone) == -1 &&
						m3.compareTo(m1) == 1 &&
						m3.compareTo(m2) == 1 &&
						m3.compareTo(m3Clone) == 0
		) {
			System.out.println("works");
		} else {
			System.out.println("no good");
		}

		try {
			m1.writeObject();
			m2.writeObject();
			m1.readObject();
			m2.readObject();
		} catch(IOException | ClassNotFoundException ignored) {
		}
	}

	/**
	 * Conducts tests on the Bill class, including compareTo, clone, and serialization.
	 */
	public static void billTest() {
		Date dE = new Date(1,1,2017);
		Date dM = new Date(1,1,2018);
		Date dL = new Date(1,1,2019);

		Money m1 = new Money(1,50);
		Money m2 = new Money(2,50);
		Money m3 = new Money(3,50);

		Bill b1 = new Bill(m1, dE, "one");
		Bill b2 = new Bill(m2, dM, "two");
		Bill b3 = new Bill(m3, dL, "three");
		Bill b4 = b3.clone();

		System.out.println("Bill");
		if(
				b1.compareTo(b2) == -1 &&
						b1.getAmount().compareTo(b2.getAmount()) == -1 &&
						b1.getDueDate().compareTo(b2.getDueDate()) == -1 &&
						b1.compareTo(b4) == -1 &&
						b1.getAmount().compareTo(b4.getAmount()) == -1 &&
						b1.getDueDate().compareTo(b4.getDueDate()) == -1 &&
						b4.compareTo(b1) == 1 &&
						b4.getAmount().compareTo(b1.getAmount()) == 1 &&
						b4.getDueDate().compareTo(b1.getDueDate()) == 1 &&
						b4.compareTo(b3) == 0 &&
						b4.getAmount().compareTo(b3.getAmount()) == 0 &&
						b4.getDueDate().compareTo(b3.getDueDate()) == 0
		) {
			System.out.println("works");
		} else {
			System.out.println("no good");
		}

		try {
			b1.writeObject();
			b2.writeObject();
			b1.readObject();
			b2.readObject();
		} catch(IOException | ClassNotFoundException ignored) {
		}


		//Expense Account Tests
		System.out.println("ExpenseAccount");
		ExpenseAccount batch = new ExpenseAccount();
		System.out.println(batch.isEmpty());

		batch.add(b1);
		batch.insert(b2,0);
		batch.insert(b3,0);
		batch.add(b4);
		batch.insert(new Bill(new Money(2,50), new Date(1,1,2020),"Last entry, at pos 1"), 1);
		System.out.println(batch.isEmpty());
		for(int i = 0; i < batch.size(); i++) {
			System.out.println(batch.get(i));
		}

		batch.remove(1);
		System.out.println("Removed position 1");
		System.out.println("Serializing");
		for(int i = 0; i < batch.size(); i++) {
			System.out.println(batch.get(i));
			try {
				batch.get(i).writeObject();
			} catch (IOException e) {
			}

		}
		System.out.println("Deserializing");
		for(int i = 0; i < batch.size(); i++) {
			try {
				batch.get(i).readObject();
			} catch (IOException | ClassNotFoundException ignored) {
			}
			System.out.println(batch.get(i));

		}
		System.out.println("Iterator");

		//Iterator Tests.
		Iterator<?> iter = batch.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
