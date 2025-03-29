import java.util.NoSuchElementException;

public interface CCPQueue<T> {

    /**
     * Adds the specified element to the end of this queue.
     * @param element - The element to be added.
     * @return returning true upon success.
     */
    public boolean enqueue(T element);

    /**
     * Removes the element that is in the front of the queue.to the end of this queue.
     * @return The removed element.
     * @throws NoSuchElementException - if this queue is empty.
     */
    public T dequeue();

    /**
     * @return - Returns the number of elements in this queue.
     */
    public int size();

    /**
     * Return a reference to the element at the front of the queue without removing it.
     * @return the head of this queue, or null if this queue is empty.
     */
    public T peek();

    /**
     * Take all the elements of another queue and add them to this one.
     * Since they may be different types, you will use the dequeue method to
     * remove them from the other queue before adding them to the current one.
     * This is an iterative process. This will remove all elements from the other queue!
     * @param otherQ - The other queue to take elements from.
     */
    public void combine(CCPQueue<T> otherQ);
}
