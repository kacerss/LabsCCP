public class CCPBST<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public Node<T> add(T element) {
        root = add(root, element);
        // Return the reference to the node where element was added.
        return find(element);
    }

    private Node<T> add(Node<T> root, T element) {
        if (root == null) {
            size++;
            return new Node<>(element);
        }
        int cmp = element.compareTo(root.data);
        if (cmp == 0) {
            return root; // Duplicate, do not add.
        } else if (cmp < 0) {
            root.left = add(root.left, element);
        } else {
            root.right = add(root.right, element);
        }
        return root;
    }

    public Node<T> find(T element) {
        return find(root, element);
    }

    public Node<T> find(Node<T> node, T element) {
        if (node == null) {
            return null;
        }

        int cmp = element.compareTo(node.data);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return find(node.left, element);
        } else {
            return find(node.right, element);
        }

    }

    private static class Node<T> {
        T data;
        Node<T> left, right;

        public Node(T element) {
            this.data = element;
            right = null;
            left = null;
        }
    }
}
