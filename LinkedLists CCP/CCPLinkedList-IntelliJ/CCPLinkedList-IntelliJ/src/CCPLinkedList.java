import java.util.Iterator;
import java.util.NoSuchElementException;

public class CCPLinkedList<T extends Comparable<T>> implements Iterable<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    /**
     * Constructor function.
     */
    public CCPLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * @return - Returns the number of elements in this list.
     */
    public int size() {
        return this.size;
    }


    /**
     * Appends the specified element to the end of this list.
     * @param element - The element to be added.
     */
    public void add(T element) {
        // TODO.
        // Create a new node
        Node<T> newNode = new Node<T>(element);
        // If the Linked List is empty, make the new
        // node as the head and return
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index - The index where the new element should be added.
     * @param element - The element to be added.
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    public void add(int index, T element) throws IndexOutOfBoundsException {
        // TODO.
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> newNode = new Node<>(element);

        // If inserting at the beginning, update head
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (size == 0) { // If the list was empty, also update tail
                tail = newNode;
            }
        } else {
            // Find the previous node
            Node<T> curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;

            // If inserting at the last position, update the tail
            if (newNode.next == null) {
                tail = newNode;
            }
        }

        size++;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        // TODO.
        head = null;
        tail = null;
        size = 0;

    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - The index of the element to be retreived.
     * @return The element found at the specified index.
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> curr = head;
        int pointer = 0;

        while (curr != null){
            if (pointer == index){
                break;
            }
            curr = curr.next;
            pointer++;
        }

        return curr.data;
//        throw new UnsupportedOperationException("DELETE WHEN DONE");
    }

    /**
     * @return True if the list has no elements. Otherwise false.
     */
    public boolean isEmpty() {
        // TODO.
        return head == null;
    }

    /**
     * Removes the first element in this list and returns it.
     * @return The element that was removed from the list.
     * @throws IndexOutOfBoundsException - if the list is empty.
     */
    public T remove() throws IndexOutOfBoundsException {
        // TODO.
        if (head == null){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<T> temp = head;
        head = temp.next;
        size--;
        if (head == null) { // List became empty
            tail = null;
        }
        return temp.data;

    }

    /**
     * Removes the element at the specified position in this list and returns it.
     * @param index - The index of the element to be removed.
     * @return The element that was removed from the list.
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> curr = head;

        //Remove at the beginning
        if (index == 0){
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return curr.data;
        }

        Node<T> prev = null;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Bypass the node at index
        prev.next = curr.next;
        // If the removed node was the tail, update tail
        if (curr.next == null){
            tail = prev;
        }

        size--;
        return curr.data;

    }


    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index - The index of the element to be set.
     * @param element - The element that should be set.
     * @return The element that was replaced.
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public T set(int index, T element) throws IndexOutOfBoundsException {
        // TODO.
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }

        T oldValue = curr.data;
        curr.data = element;
        return oldValue;

    }

    // Allow you to use an enhanced for loop on the structure.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null && !isEmpty();
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    T value = current.data;
                    current = current.next;
                    return value;
                }
                throw new NoSuchElementException("No element");
            }

        };
    }

    private class Node<T> {
        public Node<T> next = null;
        public T data;

        public Node(T value, Node<T> next) {
            this.next = next;
            this.data = value;
        }

        public Node(T value) {
            this.data = value;
        }
    }
}
