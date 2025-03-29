import java.util.NoSuchElementException;

/**
 * Circular Array List Based Queue Implementation.
 */
public class CCPALQ<T> implements CCPQueue<T>{
    private final int initialCapacity = 4;
    T[] data = (T[]) new Object[initialCapacity];
    private int rear;
    private int front;
    private int count;



    @Override
    public boolean enqueue(T element) {
        if (count == data.length){
            resize();
        }
        data[rear] = element;
        rear = (rear + 1) % data.length;
        count++;
        return true;
    }

    @Override
    public T dequeue() {
        if (count == 0){
            throw new NoSuchElementException("Queue is empty.");
        }
        T removedElement = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        count--;
        return removedElement;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public T peek() {
        if (count == 0){
            return null;
        }
        return data[front];
    }

    @Override
    public void combine(CCPQueue<T> otherQ) {
        while(otherQ.size() > 0) {
            this.enqueue(otherQ.dequeue());
        }
    }

    public void resize(){
        int newCapacity = data.length * 2;
        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < count; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        this.rear = count;
        this.front = 0;

    }

}
