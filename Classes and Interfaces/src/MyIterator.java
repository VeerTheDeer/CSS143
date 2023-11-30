import java.util.*;

/**
 * The `MyIterator` class implements the Iterator interface and provides a custom iterator
 * for iterating over an array of objects.
 *
 * By Veer Saini
 *
 * @param <T> The type of objects stored in the iterator.
 */
public class MyIterator<T> implements Iterator<Object> {
	private Object[] objArr;
	private int idx;

	/**
	 * Constructs a new MyIterator with the specified array of objects.
	 *
	 * @param arr The array of objects to be iterated over.
	 */
	public MyIterator(Object[] arr) {
		this.objArr = new Object[arr.length];
		System.arraycopy(arr, 0, this.objArr, 0, this.objArr.length);
		this.idx = 0;
	}

	/**
	 * Returns the next object in the iteration.
	 *
	 * @return The next object in the iteration.
	 */
	@Override
	public Object next() {
		this.idx++;
		return this.objArr[idx - 1];
	}

	/**
	 * Checks if there are more objects to iterate over.
	 *
	 * @return true if there are more objects, false otherwise.
	 */
	@Override
	public boolean hasNext() {
		return this.idx < this.objArr.length;
	}
}
