public class CCPBST<T extends Comparable<T>> {
    public Node<T> root;
    int size;

    public Node<T> add(Node<T> root, T element) {

        if (root == null) {
            size++;
            Node currRoot = new Node(element);
            return currRoot;
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

    public class Node<T> {
        T data;
        Node<T> right;
        Node<T> left;

        public Node(T element) {
            this.data = element;
            right = null;
            left = null;
        }
    }
}
