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

    private Node<T> find(Node<T> node, T element) {
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

    public int depth() {
        return depth(root);
    }

    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        //Add 1 to account for root, and look for higher depth between right and left
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    public int size() {
        return size;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> node) {
        if (node == null) {return;}
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
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
