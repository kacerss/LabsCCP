public class CCPBST<T extends Comparable<T>>{
    public Node root;
    int size;

    public Node add(Node root, T element){

        if(root == null){
            root = new Node(element);
            size++;
        }
        if (root.data == element){
            return root;
        }

        if (element.compareTo(root.data) < 0){
            root.left = add(root.left, element);
            size++;
        } else {
            root.right = add(root.right, element);
            size++;
        }

        return root;
    }

    public class Node{
        T data;
        Node right;
        Node left;

        public Node(T element){
            this.data = element;
            right = null;
            left = null;
        }
    }
}
