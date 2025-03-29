public class FindMin {
    public static int findMin(int[] arr, Metrics metrics) {

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            metrics.incrementComparisons();
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
