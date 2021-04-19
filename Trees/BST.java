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

    public BST() {
        root = null;
    }

    public BST(T e) {
        root.element = e;
    }

    public void add(T e) {
        root = add(root, e);
    }

    public Node<T> add(Node<T> current, T e) {
        if (current == null)
            current = new Node<>(e);
        else if (e.compareTo(current.element) <= 0)
            current.left = add(current.left, e);
        else
            current.right = add(current.right, e);

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSize(root);
    }

    public int getSize(Node<T> current) {
        if (current == null)
            return 0;
        else
            return getSize(current.left) + getSize(current.right) + 1;
    }

    public boolean contains(T e) {
        return find(root, e);
    }

    public boolean find(Node<T> current, T e) {
        if (current == null)
            return false;
        else if (e.compareTo(current.element) < 0)
            return find(current.left, e); // go to the left child
        else if (e.compareTo(current.element) > 0)
            return find(current.right, e); // go to the right child
        else
            return true;
    }

    public T getElement(T e) {
        return getElement(root, e);
    }

    public T getElement(Node<T> current, T e) {
        if (current == null)
            return null;
        else if (e.compareTo(current.element) < 0)
            return getElement(current.left, e); // go to the left child
        else if (e.compareTo(current.element) > 0)
            return getElement(current.right, e); // go to the right child
        else
            return current.element;
    }
}
