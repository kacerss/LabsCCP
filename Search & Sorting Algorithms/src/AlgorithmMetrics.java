import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AlgorithmMetrics {

    private static final int ARRAY_SIZE = 100_000;
    private static final int NUM_RUNS = 100;
    private static final int RANDOM_BOUND = 1_000_000;

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("metrics.csv")) {
            writer.write(runFindMin());
            writer.write("\n");
            writer.write(runLinearSearch());
            writer.write("\n");
            writer.write(runSelectionSort());
            writer.write("\n");
            writer.write(runInsertionSort());
            writer.write("\n");
            writer.write(runBubbleSort());
            writer.write("\n");
            writer.write(runMergeSort());
            writer.write("\n");
            writer.write(runQuickSort());
            writer.write("\n");

            System.out.println("Metrics written to metrics.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String runFindMin() {
        StringBuilder sb = new StringBuilder();
        sb.append("FindMin");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            FindMin.findMin(arr, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }

    private static String runLinearSearch() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinearSearch");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            LinearSearch.search(arr, -1, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }


    private static String runSelectionSort() {
        StringBuilder sb = new StringBuilder();
        sb.append("SelectionSort");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            SelectionSort.sort(arr, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }


    private static String runInsertionSort() {
        StringBuilder sb = new StringBuilder();
        sb.append("InsertionSort");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            InsertionSort.sort(arr, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }


    private static String runBubbleSort() {
        StringBuilder sb = new StringBuilder();
        sb.append("BubbleSort");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            BubbleSort.sort(arr, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }


    private static String runMergeSort() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergeSort");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            MergeSort.execute(arr, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }


    private static String runQuickSort() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuickSort");
        Random rand = new Random();
        for (int run = 0; run < NUM_RUNS; run++) {
            int[] arr = generateRandomArray(rand);
            Metrics metrics = new Metrics();
            QuickSort.execute(arr, metrics);
            long operations = metrics.comparisons + metrics.swaps;
            sb.append(",").append(operations);
        }
        return sb.toString();
    }

    private static int[] generateRandomArray(Random rand) {
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = rand.nextInt(RANDOM_BOUND + 1);
        }
        return arr;
    }
}
