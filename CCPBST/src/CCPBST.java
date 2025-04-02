public class CCPBST<T extends Comparable<T>> {
    public Node<T> root;
    int size;

    public Node<T> add(T element) {
        root = add(root, element);
        // Optionally, return the reference to the node where element was added.
        return find(element);
    }

    private Node<T> add(Node<T> node, T element) {
        if (node == null) {
            size++;
            return new Node<>(element);
        }
        int cmp = element.compareTo(node.data);
        if (cmp == 0) {
            return node; // Duplicate, do not add.
        } else if (cmp < 0) {
            node.left = add(node.left, element);
        } else {
            node.right = add(node.right, element);
        }
        return node;
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
