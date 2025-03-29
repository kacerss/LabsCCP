public class InsertionSort {
    public static void sort(int[] arr, Metrics metrics) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0) {
                metrics.incrementComparisons();
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1, metrics);
                } else {
                    break;
                }
                j--;
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
