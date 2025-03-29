import java.util.Iterator;
import java.util.NoSuchElementException;

public class CCPArrayList<T> implements Iterable<T> {
    T[] data;
    int size = 0;

    /**
     * Constructor function.
     */
    @SuppressWarnings("unchecked")
    public CCPArrayList() {
        this.data = (T[]) new Object[4];
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
        if (size == data.length) {
            resize();
        }
        data[size] = element;
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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == data.length) {
            resize();
        }

        T[] Copy = (T[]) new Object[data.length];

        for (int i = 0; i < index; i++){
            Copy[i] = data[i];
        }

        Copy[index] = element;

        for (int i = index; i < this.size; i++){
            Copy[i + 1] = data[i];
        }

        this.data = Copy;
        this.size++;
    }

    /**
     * Removes all of the elements from this list.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        // TODO
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        this.data = (T[]) new Object[4];
        this.size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - The index of the element to be retreived.
     * @return The element found at the specified index.
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO.
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];

    }

    /**
     * @return True if the list has no elements. Otherwise false.
     */
    public boolean isEmpty() {
        // TODO.
        return size == 0;

    }

    /**
     * Removes the element at the specified position in this list and returns it.
     * @param index - The index of the element to be removed.
     * @return The element that was removed from the list.
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO.
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T removedElement = data[index];

        T[] Copy = (T[]) new Object[data.length];

        for (int i = 0; i < index; i++){
            Copy[i] = data[i];
        }

        Copy[index] = null;

        for (int i = index; i < this.size; i++){
            Copy[i] = data[i + 1];
        }

        this.data = Copy;
        size--;
        return removedElement;

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
        T setElement = data[index];

        data[index] = element;

        return setElement;

    }

    /**
     * Make an array that is double the size of the number of elements (size).
     * Copy the data from the current backing array to the new one and then
     * reset the refernece.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        if (this.size() == 0) {
            return;
        }
        T[] larger = (T[]) new Object[this.size * 2];
        // TODO. Copy the data over.
        for (int i = 0; i < data.length; i++) {
            larger[i] = this.data[i];
        }
        this.data = larger;

    }

    /**
     * This is only here for testing. In a real project this method would not exist.
     * @return The size of the backing array.
     */
    public int getRealSize() {
        return this.data.length;
    }

    // Allow you to use an enhanced for loop on the structure.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    return get(this.currentIndex++);
                }
                throw new NoSuchElementException("No element");
            }

        };
    }
}
