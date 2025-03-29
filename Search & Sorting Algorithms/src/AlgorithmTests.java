import static org.junit.Assert.*;
import org.junit.Test;

public class AlgorithmTests {

    // --- Tests for Search Algorithms ---

    @Test
    public void testFindMin() {
        int[] arr = {5, 3, 8, 1, 4};
        Metrics metrics = new Metrics();
        int min = FindMin.findMin(arr, metrics);
        assertEquals(1, min);
    }

    @Test
    public void testLinearSearch() {
        int[] arr = {5, 3, 8, 1, 4};
        Metrics metrics = new Metrics();
        int index = LinearSearch.search(arr, 8, metrics);
        assertEquals(2, index);
    }

    // --- Tests for Sorting Algorithms ---

    @Test
    public void testSelectionSort() {
        int[] arr = {5, 3, 8, 1, 4};
        Metrics metrics = new Metrics();
        SelectionSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 4, 5, 8}, arr);
    }

    @Test
    public void testInsertionSort() {
        int[] arr = {8, 5, 4, 3, 1};
        Metrics metrics = new Metrics();
        InsertionSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 4, 5, 8}, arr);
    }

    @Test
    public void testBubbleSort() {
        int[] arr = {8, 5, 4, 3, 1};
        Metrics metrics = new Metrics();
        BubbleSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 4, 5, 8}, arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {8, 5, 4, 3, 1};
        Metrics metrics = new Metrics();
        MergeSort.execute(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 4, 5, 8}, arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {8, 5, 4, 3, 1};
        Metrics metrics = new Metrics();
        QuickSort.execute(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 4, 5, 8}, arr);
    }
}
