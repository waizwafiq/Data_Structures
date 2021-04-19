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
}
