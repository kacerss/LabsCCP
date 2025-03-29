public class CCPBST<T extends Comparable<T>>{
    Node root;
    int size;

    public void add(T element){
        if (this.size == 0){
            this.root.data = element;
        }

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
