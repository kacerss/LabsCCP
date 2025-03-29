public class Metrics {
    public long comparisons;
    public long swaps;

    public Metrics() {
        comparisons = 0;
        swaps = 0;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }
}
