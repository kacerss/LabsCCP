public class MaxHeap<T extends Comparable<T>> {
    T[] heap;
    int size;
    int maxSize;

    // Initialize an empty max heap with a given max capacity.
    public MaxHeap(int maxSize) {

        this.maxSize = maxSize;
        this.size = 0;
        heap = (T[]) new Comparable[maxSize];
    }

    // Parent position
    private int parent(int position) {
        return (position - 1) / 2;
    }

    // leftChild position
    private int leftChild(int position) {
        return 2 * position + 1;
    }

    // rightChild position.
    private int rightChild(int position) {
        return 2 * position + 2;
    }

    // returns true if given element is a leaf
    private boolean isLeaf(int position) {
        return position >= (size / 2) && position < size;
    }

    //helper method to swap elements
    private void swap(int position1, int position2) {
        T temp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = temp;
    }

    // recursive method to max heapify given a position or subtree.
    private void maxHeapify(int position) {
        //check if the position is a leaf, if true return.
        if (isLeaf(position)) {
            return;
        }

        // Assume the node at position is already the largest.
        int largest = position;
        // Check if leftChild or rightChild are bigger than the current position.
        if (leftChild(position) < size && heap[leftChild(position)].compareTo(heap[largest]) > 0) {
            largest = leftChild(position);
        }
        if (rightChild(position) < size && heap[rightChild(position)].compareTo(heap[largest]) > 0) {
            largest = rightChild(position);
        }
        // If largest isn't the given position anymore, swap it with the new largest and recursively call the method.
        if (largest != position) {
            swap(position, largest);
            maxHeapify(largest);
        }
    }

    // inserts a new element to maxHeap
    public void insert(T element) {
        if (size == maxSize) {
            T[] newHeap = (T[]) new Comparable[maxSize * 2];
            for (int i = 0; i < maxSize; i++) {
                newHeap[i] = heap[i];
            }
            this.maxSize = newHeap.length;
            heap = newHeap;
        }

        if (size == 0){
            heap[0] = element;
        } else {
            heap[size] = element;
            int curr = size;
            while(curr > 0 && heap[curr].compareTo(heap[parent(curr)]) > 0) {
                swap(curr, parent(curr));
                curr = parent(curr);
            }
        } size++;
    }

    // extracts or dequeues the max element in the heap.
    public T extractMax() {
        if (size == 0) {
            return null;
        }
        T max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return max;
    }

    // print method
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}

