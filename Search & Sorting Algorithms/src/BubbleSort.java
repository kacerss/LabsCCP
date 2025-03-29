public class BubbleSort {
    public static void sort(int[] arr, Metrics metrics) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                metrics.incrementComparisons();
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i, metrics);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        metrics.incrementSwaps();
    }
}
