import java.util.*;

/**
 * The `ExpenseAccount` class represents a collection of bills. It extends the ArrayList class
 * to store and manage instances of the Bill class.
 *
 * By: Veer Saini
 */
public class ExpenseAccount extends ArrayList {

	/**
	 * Adds a Bill object to the expense account.
	 *
	 * @param obj The Bill object to be added to the expense account.
	 */
	public void add(Bill obj) {
		super.add((Bill) obj);
	}

	/**
	 * Retrieves the Bill object at the specified index in the expense account.
	 *
	 * @param idx The index of the Bill object to retrieve.
	 * @return The Bill object at the specified index.
	 */
	public Bill get(int idx) {
		return (Bill) super.get(idx);
	}

	/**
	 * Inserts a Bill object at the specified position in the expense account.
	 *
	 * @param temp The Bill object to be inserted.
	 * @param i    The index at which the Bill object is to be inserted.
	 */
	public void insert(Bill temp, int i) {
		super.insert((Bill) temp, i);
	}
}