import java.util.Arrays;
import java.util.Random;

public class Deck<T extends Comparable<T>> {
    private T[] items;
    private int topIndex = 0;

    public Deck(T[] items) {
        this.items = items;
    }

    public void reset() {
        this.topIndex = 0;
        this.shuffle();
    }

    public boolean hasItems() {
        return this.topIndex < this.items.length;
    }


    public void shuffle() {
        Random rand = new Random();
        for (int i = this.items.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            T temp = this.items[i];
            this.items[i] = this.items[j];
            this.items[j] = temp;
        }
    }

    public void sort() {
        for (int i = 1; i < items.length; i++) {
            T object = items[i];
            int j = i - 1;
            while (j >= 0 && items[j].compareTo(object) > 0) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = object;
        }
    }

    @Override
    public String toString() {
        return "Deck" +
                "items = " + Arrays.toString(items);
    }
}