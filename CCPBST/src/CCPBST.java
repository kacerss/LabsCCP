public class CCPBST<T extends Comparable<T>>{
    Node root;
    int size;

    public Node add(Node root, T element){
        if (this.size == 0){
            return new Node(element);
        }
        if (root.data == element){
            return root;
        }

        if (element.compareTo(root.data) < 0){
            root.left = add(root.left, element);
        } else {
            root.right = add(root.right, element);
        }

        return root;

    }

    public Node traverse(Node root){
        if (root.left != null){
            traverse(root.left);
        }
        if (root.right != null){
            traverse(root.right);
        }
        return root;
    }
    public class Node{
        T data;
        Node right;
        Node left;

        Node(T element){
            this.data = element;
            right = null;
            left = null;
        }
    }
}
