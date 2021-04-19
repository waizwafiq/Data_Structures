//BINARY SEARCH TREE
public class BST<T extends Comparable<T>> {

    private class Node<E> {
        private Node<E> left, right;
        private E element;

        public Node(E element) {
            this.element = element;
            left = right = null;
        }
    }

    private Node<T> root;

    public BST(){
        root = null;
    }
    
        public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSize(root);
    }

    public int getSize(Node<T> current){
        if (current == null)
            return 0;
        else
            return getSize(current.left) + getSize(current.right);
    }

    public boolean contains(T e){
        return find(root, e);
    }

    public boolean find(Node<T> current, T e){
        if (current == null)
            return false;
        else if (e.compareTo(current.element) < 0)
            return find(current.left, e); //go to the left child
        else if (e.compareTo(current.element) > 0)
            return find(current.right, e); //go to the right child
        else
            return true;
    }
}
