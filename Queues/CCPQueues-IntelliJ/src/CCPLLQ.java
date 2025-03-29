import java.util.NoSuchElementException;

/**
 * Linked List Based Queue Implementation.
 */
public class CCPLLQ<T> implements CCPQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean enqueue(T element) {
        // TODO Auto-generated method stub
        Node<T> newNode = new Node<>(element);
        if (size == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty!");
        }
        T result = head.data;
        head = head.next;
        size--;
        if (size == 0){
            tail = null;
        }
        return result;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T peek() {
        if (size == 0){
            return null;
        }
        return head.data;
    }

    @Override
    public void combine(CCPQueue<T> otherQ) {
        while (otherQ.size() > 0){
            this.enqueue(otherQ.dequeue());
        }
    }

}
