public class SelectionSort {
    public static void sort(int[] arr, Metrics metrics) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                metrics.incrementComparisons();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex, metrics);
            }
        }
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        metrics.incrementSwaps();
    }
}
