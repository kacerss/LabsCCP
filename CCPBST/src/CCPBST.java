public class CCPBST<T extends Comparable<T>> {
    public Node root;
    int size;

    public Node add(Node root, T element) {
        if (root == null) {
            size++;
            return new Node(element);
        }

        // Use compareTo for equality check
        int cmp = element.compareTo(root.data);
        if (cmp == 0) {
            return root;
        }

        if (cmp < 0) {
            root.left = add(root.left, element);
        } else {
            root.right = add(root.right, element);
        }

        return root;
    }

    public class Node {
        T data;
        Node right;
        Node left;

        public Node(T element) {
            this.data = element;
            right = null;
            left = null;
        }
    }
}
