public class MaxHeap<T extends Comparable<T>> {
    T[] heap;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {

        this.maxSize = maxSize;
        this.size = 0;
        heap = (T[]) new Comparable[maxSize];
    }

    // Parent position
    private int parent(int position) {
        return (position - 1) / 2;
    }

    private int leftChild(int position) {
        return 2 * position + 1;
    }

    private int rightChild(int position) {
        return 2 * position + 2;
    }

    private boolean isLeaf(int position) {
        return position > (size / 2) && position <= size;
    }

    private void swap(int position1, int position2) {
        T temp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = temp;
    }

    private void maxHeapify(int position) {
        if (isLeaf(position)) {
            return;
        }
        if (heap[position].compareTo(heap[leftChild(position)]) < 0
        || heap[position].compareTo(heap[rightChild(position)]) < 0) {

            if (heap[leftChild(position)].compareTo(heap[rightChild(position)]) > 0) {
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            } else {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }

        }
    }

    public void insert(T element) {
        heap[size] = element;

        int curr = size;
        while(heap[curr].compareTo(heap[parent(curr)]) > 0) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
        size++;
    }

    public T extractMax() {
        if (size == 0) {
            return null;
        }
        T max = heap[0];
        heap[0] = heap[size - 1];
        maxHeapify(0);
        return max;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}

