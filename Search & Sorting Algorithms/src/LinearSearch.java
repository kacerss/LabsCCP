public class LinearSearch {
    public static int search(int[] arr, int target, Metrics metrics) {
        for (int i = 0; i < arr.length; i++) {
            metrics.incrementComparisons();
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
