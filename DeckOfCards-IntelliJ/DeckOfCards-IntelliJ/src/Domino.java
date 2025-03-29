public class Domino implements Comparable<Domino> {
    private int leftValue;
    private int rightValue;

    public Domino(int leftValue, int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    @Override
    public int compareTo(Domino other) {
        // Compare based on left value first (rank)
        int leftComparison = Integer.compare(this.leftValue, other.leftValue);
        if (leftComparison != 0) {
            return leftComparison;
        }
        // If left values are the same, compare based on right value
        return Integer.compare(this.rightValue, other.rightValue);
    }

    @Override
    public String toString() {
        return leftValue + "|" + rightValue;
    }

    public static Domino[] makeSet() {
        Domino[] dominos = new Domino[28];
        int index = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= i; j++) {
                dominos[index] = new Domino(i, j);
                index++;
            }
        }
        return dominos;
    }
}
