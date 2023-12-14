import java.util.*;

/**
 * This class represents a custom iterator for iterating over an array of objects.
 * It implements the Iterator interface and provides methods to iterate over the array.
 *
 * @param <T> The type of objects in the array.
 * @author Veer Saini
 */
public class MyIterator<T> implements Iterator<Object> {
	private Object[] objArr;
	private int idx;

	/**
	 * Constructor for creating a MyIterator object with the specified array.
	 *
	 * @param arr The array of objects to iterate over.
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
	 * Checks if there are more objects in the iteration.
	 *
	 * @return True if there are more objects, false otherwise.
	 */
	@Override
	public boolean hasNext() {
		return this.idx < this.objArr.length;
	}
}