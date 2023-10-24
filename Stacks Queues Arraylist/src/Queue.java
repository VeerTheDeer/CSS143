/**
 * The Queue class represents a basic queue data structure implemented using an array.
 * It allows you to enqueue (add) and dequeue (remove) objects from the queue.
 *
 * by Veer Saini
 */
public class Queue {
    private Object[] queue = new Object[10000000];
    private Object front;
    private int elements = 0;

    /**
     * Enqueues an object at the back of the queue.
     *
     * @param obj The object to be enqueued.
     */
    public void enqueue(Object obj) {
        elements++;
        queue[elements - 1] = obj;
        front = queue[0];
    }

    /**
     * Dequeues an object from the front of the queue.
     *
     * @return The object dequeued from the front of the queue.
     */
    public Object dequeue() {
        front = queue[0];
        for (int i = 0; i < elements; i++) {
            queue[i] = queue[i + 1];
        }
        elements--;
        return front;
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return elements;
    }

    /**
     * Generates a string representation of the queue.
     *
     * @return A string representation of the queue.
     */
    public String toString() {
        String retVal = "";
        for (int i = 0; i < elements; i++) {
            retVal += queue[i] + " ";
        }
        return retVal;
    }

    /**
     * Indicates whether some other object is "equal to" this queue.
     * Two queues are considered equal if they have the same elements in the
     * same order.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this queue is equal to the provided object;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayList))
            return false;

        Queue objectArray = (Queue) obj;

        for (int i = 0; i < elements; i++) {
            if ((this.queue[i]).equals(objectArray.queue[i]))
                continue;
            else
                return false;
        }
        if (this.size() != ((Queue) obj).size())
            return false;
        return true;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return queue[0] == null;
    }

    /**
     * Retrieves the object at the specified index in the queue.
     *
     * @param index The index of the object to retrieve.
     * @return The object at the specified index in the queue.
     */
    public Object get(int index) {
        return queue[index];
    }
}
