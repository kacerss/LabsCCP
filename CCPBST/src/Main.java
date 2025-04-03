public class Main {
    public static void main(String[] args) {
        CCPBST<Integer> tree = new CCPBST<>();
        int[] nums = {10, 15, 5, 40, 0, 50, 70};

        for (int num : nums) {
            tree.add(num);
        }

        tree.inOrder();

        tree.find(5);

        System.out.println();

        System.out.println(tree.depth());

        System.out.println(tree.size());

    }
}
