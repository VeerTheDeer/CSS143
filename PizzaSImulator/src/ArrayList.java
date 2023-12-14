import java.util.Iterator;

/**
 * This class represents a generic ArrayList implementation with dynamic sizing.
 * It provides methods for inserting, adding, removing elements, and other basic
 * operations on the list. The class also supports generic elements and implements
 * the Iterable interface for enhanced iteration capabilities.
 *
 * @param <T> The type of elements stored in the ArrayList.
 * @author Veer Saini
 */
public class ArrayList<T> implements Iterable<Object> {

	private Object[] array = new Object[0];

	/**
	 * Inserts an element at the specified index in the ArrayList.
	 *
	 * @param element The element to be inserted.
	 * @param index   The index at which to insert the element.
	 */
	public void insert(T element, int index) {
		if (index > this.size()) {
			System.out.println("Index is outside of the list");
			System.exit(0);
		}

		int count = 0;
		try {
			Object[] temp = new Object[this.array.length + 1];
			if (index == 0) {
				temp[0] = element;
				System.arraycopy(this.array, 0, temp, 1, temp.length - 1);
				this.array = temp;
			} else {
				System.arraycopy(this.array, 0, temp, 0, index);
				temp[index] = element;
				System.arraycopy(this.array, index, temp, index + 1, temp.length - index - 1);
				this.array = temp;
			}
		} catch (ArrayIndexOutOfBoundsException exception) {
			largerArray();
			if (++count == 2) {
				System.out.println("Error");
				System.exit(0);
			}
		}
	}

	/**
	 * Adds an element to the end of the ArrayList.
	 *
	 * @param element The element to be added.
	 */
	void add(T element) {
		int count = 0;
		try {
			Object[] temp = new Object[this.array.length + 1];
			System.arraycopy(this.array, 0, temp, 0, this.array.length);
			temp[this.array.length] = element;
			this.array = temp;
		} catch (ArrayIndexOutOfBoundsException exception) {
			largerArray();
			if (++count == 2) {
				System.out.println("Error");
				System.exit(0);
			}
		}
	}

	/**
	 * Removes the element at the specified index from the ArrayList.
	 *
	 * @param index The index of the element to be removed.
	 * @return The removed element.
	 */
	T remove(int index) {
		if (index >= this.size()) {
			System.out.println("Index is outside of the list");
			System.exit(0);
		}

		T temp = (T) this.array[index];
		int count = 0;
		try {
			Object[] tempArr = new Object[this.array.length - 1];
			if (index == 0) {
				System.arraycopy(this.array, 1, tempArr, 0, tempArr.length);
			} else {
				System.arraycopy(this.array, 0, tempArr, 0, index);
				System.arraycopy(this.array, index + 1, tempArr, index, tempArr.length - index);
			}
			this.array = tempArr;
		} catch (ArrayIndexOutOfBoundsException exception) {
			largerArray();
			if (++count == 2) {
				System.out.println("Error");
				System.exit(0);
			}
		}

		return temp;
	}

	/**
	 * Checks if the ArrayList is empty.
	 *
	 * @return true if the ArrayList is empty, false otherwise.
	 */
	public boolean isEmpty() {
		for (Object element : this.array) {
			if (element != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the size of the ArrayList.
	 *
	 * @return The number of elements in the ArrayList.
	 */
	public int size() {
		int count = 0;
		for (Object o : this.array) {
			if (o == null) {
				break;
			} else {
				count++;
			}
		}
		return count;
	}

	/**
	 * Increases the size of the array when it is full.
	 */
	public void largerArray() {
		Object[] other = new Object[this.array.length * 2];
		System.arraycopy(this.array, 0, other, 0, this.array.length);
		this.array = other;
	}

	/**
	 * Checks if two ArrayLists are equal.
	 *
	 * @param other The ArrayList to compare with.
	 * @return true if the ArrayLists are equal, false otherwise.
	 */
	public boolean equals(ArrayList<T> other) {
		int arrL = this.array.length;
		int objL = other.array.length;

		if (arrL != objL) {
			return false;
		}

		for (int i = 0; i < this.array.length; i++) {
			if (!this.array[i].equals(other.array[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a string representation of the ArrayList.
	 *
	 * @return A string representation of the elements in the ArrayList.
	 */
	public String toString() {
		StringBuilder retStr = new StringBuilder();
		for (int i = 0; i < this.size(); i++) {
			if (i < this.size() - 1) {
				retStr.append(this.array[i]).append(", ");
			} else {
				retStr.append(this.array[i]);
			}
		}
		return retStr.toString();
	}

	/**
	 * Finds the index of the first occurrence of the specified element in the ArrayList.
	 *
	 * @param element The element to search for.
	 * @return The index of the element, or -1 if the element is not found.
	 */
	int indexOf(T element) {
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the element at the specified index in the ArrayList.
	 *
	 * @param index The index of the element to retrieve.
	 * @return The element at the specified index.
	 */
	T get(int index) {
		return (T) this.array[index];
	}

	/**
	 * Returns an iterator over the elements in the ArrayList.
	 *
	 * @return An iterator over the elements in the ArrayList.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new MyIterator<>(this.array);
	}

	/**
	 * Swaps the elements at two specified indices in the ArrayList.
	 *
	 * @param idx1 The index of the first element to swap.
	 * @param idx2 The index of the second element to swap.
	 */
	public void swap(int idx1, int idx2) {
		T swap = this.get(idx1);
		this.insert(this.get(idx2), idx1);
		this.remove(idx1 + 1);
		this.insert(swap, idx2);
		this.remove(idx2 + 1);
	}
}
