public class MergeSort {
    public static void execute(int[] arr, Metrics metrics) {
        sort(arr, 0, arr.length - 1, metrics);
    }
    private static void sort(int[] arr, int left, int right, Metrics metrics) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid, metrics);
            sort(arr, mid + 1, right, metrics);
            merge(arr, left, mid, right, metrics);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right, Metrics metrics) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];


        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }


        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            metrics.incrementComparisons();
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
