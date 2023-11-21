/**
 * LinkedList implementation with basic operations such as insert, remove, size, toString, isEmpty, indexOf, and append.
 * This class utilizes a private inner class, Node, to represent elements in the linked list.
 *
 * By: Veer Saini
 */
public class List {

    /**
     * Inner class representing a node in the linked list.
     */
    private class Node {
        public Object data;
        public Node next;

        private Node(Object obj, Node next) {
            data = obj;
            this.next = next;
        }
    }

    private Node head = null;

    /**
     * Inserts a new element at the specified index in the linked list.
     *
     * @param next  the data to be inserted
     * @param index the index at which the data should be inserted
     * @throws LinkedListException if the index is invalid or the list is empty when inserting at an index other than 0
     */
    public void insert(Object next, int index) throws LinkedListException {
        if (index != 0 && isEmpty()) {
            throw new LinkedListException("Invalid index/empty list.");
        } else if (head == null) {
            head = new Node(next, head);
            return;
        } else if (index > 1 && size() == 1) {
            throw new LinkedListException("List only has one index. Add to the first index.");
        } else if (index == 0 && size() == 1) {
            Node otherHead = head;
            head = new Node(next, otherHead);
            return;
        } else if (index == 1 && size() == 1) {
            head.next = new Node(next, null);
            return;
        } else if (index > size()) {
            throw new LinkedListException("Invalid index: " + index + ", max index is: " + (size() - 1));
        } else if (index == 0) {
            Node otherHead = head;
            head = new Node(next, otherHead);
            return;
        } else {
            Node updatedNode = moveNode(index);
            Node nextNode = updatedNode.next;
            updatedNode.next = new Node(next, nextNode);
        }
    }

    /**
     * Removes the element at the specified index in the linked list.
     *
     * @param index the index of the element to be removed
     * @return the removed element
     * @throws LinkedListException if the index is invalid or the list is empty
     */
    public Object remove(int index) throws LinkedListException {
        Object object;
        if (isEmpty()) {
            throw new LinkedListException("Can't remove from an empty list.");
        } else if (index > 0 && size() == 1) {
            throw new LinkedListException("Invalid index.");
        } else if (index == 0 && size() == 1) {
            object = head.data;
            head = null;
            return object;
        } else if (index == 0) {
            object = head.data;
            head = head.next;
            return object;
        } else {
            if (index > size()) {
                throw new LinkedListException("Invalid index: " + index + ", max index is: " + (size() - 1));
            }

            Node updatedNode = moveNode(index);
            Node nextNode = updatedNode.next;
            updatedNode.next = nextNode.next;
            nextNode.next = null;
            return nextNode;
        }
    }

    /**
     * Returns the size of the linked list.
     *
     * @return the size of the linked list
     */
    public int size() {
        if (head == null)
            return 0;

        int size = 1;
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            size++;
        }
        return size;
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return a string representation of the linked list
     */
    @Override
    public String toString() {
        StringBuilder retStr = new StringBuilder();
        Node tempNode = head;
        for (int i = 0; i < size(); i++) {
            retStr.append(tempNode.data).append(", ");
            tempNode = tempNode.next;
        }
        return retStr.toString();
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the linked list.
     *
     * @param target the element to search for
     * @return the index of the element, or -1 if the element is not found
     */
    public int indexOf(Object target) {
        Node tempNode = head;
        for (int i = 0; i < size(); i++) {
            if (head.data == null) {
                return -1;
            }

            if (tempNode.data.equals(target)) {
                return i;
            } else if (tempNode.next == null) {
                return -1;
            } else {
                tempNode = tempNode.next;
            }
        }

        return -1;
    }

    /**
     * Appends the specified element to the end of the linked list.
     *
     * @param obj the element to be appended
     * @throws LinkedListException if there is an issue with the append operation
     */
    public void append(Object obj) throws LinkedListException {
        insert(obj, size());
    }

    /**
     * Helper method to move to a specific node in the linked list.
     *
     * @param i the index of the desired node
     * @return the node at the specified index
     */
    private Node moveNode(int i) {
        Node tempNode = head;
        for (int j = 1; j < i; j++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /**
     * Main method for testing the LinkedList implementation.
     *
     * @param args command-line arguments (not used in this example)
     * @throws LinkedListException if there is an issue with the LinkedList operations in the test
     */
    public static void main(String[] args) throws LinkedListException {
        List empty = new List();
        List one = new List();
        List multiple = new List();

        one.append("hi");
        multiple.append(10);
        multiple.append(20);
        multiple.append(30);

        System.out.println(multiple.size());

        System.out.println("Empty:" + empty);
        System.out.println("One:" + one);
        System.out.println("Multiple:" + multiple);

        one.remove(0);
        multiple.remove(1);
        System.out.println("One (upon remove):" + one);
        System.out.println("Multiple (upon remove):" + multiple);

        one.append(600);
        multiple.append(400);
        System.out.println("One (on append):" + one);
        System.out.println("Multiple(on append):" + multiple);

        // empty.remove(0); //Can't remove from an empty list.
        // multiple.remove(999); //max size is 2, throws LL error.

        System.out.println(multiple.indexOf(400));
        System.out.println(empty.isEmpty());
    }
}