import java.util.*;

/**
 * The ArrayList class represents a simple dynamic array that can store objects.
 * It implements the Iterable interface to support iteration over its elements.
 *
 * By: Veer Saini
 */
public class ArrayList implements Iterable<Object> {
	Object[] arr = new Object[0];

	/**
	 * Inserts a character at the specified index in the array.
	 *
	 * @param c The character to be inserted.
	 * @param i The index at which the character is to be inserted.
	 */
	public void insert(char c, int i) {
		if (i > this.size()) {
			System.out.println("Index is outside of list size");
			System.exit(0);
		}
		int count = 0;
		try {
			Object[] temp = new Object[this.arr.length + 1];
			if (i == 0) {
				temp[0] = c;
				for (int j = 1; j < temp.length; j++) {
					temp[j] = this.arr[j - 1];
				}
				this.arr = temp;

			} else {
				for (int j = 0; j < i; j++) {
					temp[j] = this.arr[j];
				}
				temp[i] = c;

				for (int k = i + 1; k < temp.length; k++) {
					temp[k] = this.arr[k - 1];
				}
				this.arr = temp;

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
	 * Inserts an object at the specified index in the array.
	 *
	 * @param object The object to be inserted.
	 * @param index  The index at which the object is to be inserted.
	 */
	void insert(Object object, int index) {
		if (index > this.size()) {
			System.out.println("Index is outside of list size");
			System.exit(0);
		}
		int count = 0;
		try {
			Object[] temp = new Object[this.arr.length + 1];
			if (index == 0) {
				temp[0] = object;
				for (int j = 1; j < temp.length; j++) {
					temp[j] = this.arr[j - 1];
				}
				this.arr = temp;

			} else {
				for (int j = 0; j < index; j++) {
					temp[j] = this.arr[j];
				}

				temp[index] = object;
				for (int k = index + 1; k < temp.length; k++) {
					temp[k] = this.arr[k - 1];
				}
				this.arr = temp;

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
	 * Adds an object to the end of the array.
	 *
	 * @param object The object to be added.
	 */
	void add(Object object) {
		int count = 0;
		try {
			Object[] other = new Object[this.arr.length + 1];
			for (int j = 0; j < this.arr.length; j++) {
				other[j] = this.arr[j];
			}
			other[this.arr.length] = object;
			this.arr = other;

		} catch (ArrayIndexOutOfBoundsException exception) {
			largerArray();
			if (++count == 2) {
				System.out.println("Error");
				System.exit(0);
			}

		}
	}

	/**
	 * Removes the object at the specified index in the array.
	 *
	 * @param index The index at which the object is to be removed.
	 * @return The removed object.
	 */
	Object remove(int index) {
		if (index > this.size()) {
			System.out.println("Index is outside of list size");
			System.exit(0);
		}
		Object temp = this.arr[index];
		int count = 0;
		try {
			Object[] objArr = new Object[this.arr.length - 1];
			if (index == 0) {
				objArr[0] = this.arr[1];
				for (int j = 1; j < objArr.length; j++) {
					objArr[j] = this.arr[j + 1];
				}
				this.arr = objArr;

			} else {
				for (int j = 0; j < index; j++) {
					objArr[j] = this.arr[j];
				}
				for (int k = index; k < objArr.length; k++) {
					objArr[k] = this.arr[k + 1];
				}

				this.arr = objArr;
			}

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
	 * Doubles the size of the array to accommodate more elements.
	 */
	public void largerArray() {
		Object[] temp = new Object[this.arr.length * 2];
		System.arraycopy(this.arr, 0, temp, 0, this.arr.length);
		this.arr = temp;
	}

	/**
	 * Checks if the array is empty.
	 *
	 * @return True if the array is empty, false otherwise.
	 */
	public boolean isEmpty() {
		boolean retVal = true;

		for (Object element : this.arr) {
			if (element != null) {
				retVal = false;
				break;
			} else {
				retVal = true;
				break;
			}

		}

		return retVal;
	}

	/**
	 * Returns the number of elements in the array.
	 *
	 * @return The size of the array.
	 */
	public int size() {
		int retVal = 0;
		for (Object o : this.arr) {
			if (o == null) {
				break;
			} else {
				retVal++;
			}

		}

		return retVal;
	}

	/**
	 * Returns a string representation of the array.
	 *
	 * @return A string containing the elements of the array.
	 */
	public String toString() {
		StringBuilder retStr = new StringBuilder();
		for (int i = 0; i < this.size(); i++) {
			if (i < this.size() - 1) {
				retStr.append(this.arr[i]).append(", ");
			} else {
				retStr.append(this.arr[i]);
			}

		}

		return retStr.toString();
	}

	/**
	 * Returns the index of the first occurrence of the specified object in the array.
	 *
	 * @param o The object to search for.
	 * @return The index of the object, or -1 if not found.
	 */
	int indexOf(Object o) {
		int idx = -1;
		for (int i = 0; i < this.arr.length; i++) {
			if (this.arr[i] == (o)) {
				idx = i;
			}
		}
		return idx;
	}

	/**
	 * Checks if this ArrayList is equal to another ArrayList.
	 *
	 * @param list The ArrayList to compare.
	 * @return True if the ArrayLists are equal, false otherwise.
	 */
	public boolean equals(ArrayList list) {
		boolean retVal = false;
		int arrL = this.arr.length;
		int listL = list.arr.length;

		if (arrL > listL) {
			for (int i = 0; i < this.arr.length; i++) {
				if (this.arr[i] == list.arr[i]) {
					retVal = true;
				} else {
					retVal = false;
					break;
				}
			}
		} else {
			for (int i = 0; i < list.arr.length; i++) {
				if (this.arr[i] == list.arr[i]) {
					retVal = true;
				} else {
					retVal = false;
					break;
				}
			}
		}
		return retVal;
	}

	/**
	 * Returns the object at the specified index in the array.
	 *
	 * @param index The index of the object to retrieve.
	 * @return The object at the specified index.
	 */
	Object get(int index) {
		return this.arr[index];
	}

	/**
	 * Returns an iterator over the elements in the array.
	 *
	 * @return An iterator.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new MyIterator<Object>(this.arr);
	}
}
