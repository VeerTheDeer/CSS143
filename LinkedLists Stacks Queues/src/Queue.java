/**
 * A Queue implementation that extends the List class, providing queue-specific operations.
 * This class represents a first-in, first-out (FIFO) data structure.
 *
 * By: Veer Saini
 */
public class Queue extends List {

    /**
     * Constructs an empty queue.
     */
    public Queue() {
        super();
    }

    /**
     * Inserts an element into the queue, effectively enqueuing it.
     *
     * @param next  the data to be enqueued
     * @param index the index at which the data should be enqueued (not used in a queue)
     * @throws LinkedListException if there is an issue with the enqueue operation
     */
    @Override
    public void insert(Object next, int index) throws LinkedListException {
        enqueue(next);
    }

    /**
     * Removes an element from the queue, effectively dequeuing it.
     *
     * @param index the index from which the data should be dequeued (not used in a queue)
     * @return the dequeued element
     * @throws LinkedListException if there is an issue with the dequeue operation
     */
    @Override
    public Object remove(int index) throws LinkedListException {
        return dequeue();
    }

    /**
     * Enqueues an element into the queue.
     *
     * @param obj the element to be enqueued
     * @throws LinkedListException if there is an issue with the enqueue operation
     */
    public void enqueue(Object obj) throws LinkedListException {
        super.insert(obj, super.size());
    }

    /**
     * Dequeues an element from the queue.
     *
     * @return the dequeued element
     * @throws LinkedListException if there is an issue with the dequeue operation
     */
    public Object dequeue() throws LinkedListException {
        return super.remove(0);
    }

    /**
     * Main method for testing the Queue implementation.
     *
     * @param args command-line arguments (not used in this example)
     * @throws LinkedListException if there is an issue with the LinkedList operations in the test
     */
    public static void main(String[] args) throws LinkedListException {
        Queue q = new Queue();
        // q.dequeue(); Throws a LinkedListException
        q.enqueue("oats");
        q.enqueue("eggs");
        q.enqueue("broccoli");
        System.out.println(q);
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println(q);
        q.enqueue("nuts");
        System.out.println(q);
        Queue same = new Queue();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            same.enqueue(q.dequeue());
        }
        System.out.println("Same thing: " + same);
    }
}