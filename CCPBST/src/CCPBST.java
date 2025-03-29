public class CCPBST<T extends Comparable<T>>{
    Node root;
    int size;

    public void add(T element){
        if (this.size == 0){
            this.root.data = element;
        }
        if (element.compareTo(root.data) > 0){
            Node curr = traverse(root.right);
            if (element.compareTo(curr.data) > 0){
                curr.right.data = element;
            }
        }


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
