import java.util.ArrayList;
import MyQueue;

public class BST<E extends Comparable<E>> {
    private static class TreeNode<T> {
        private TreeNode<T> left, right;
        private T element;

        public TreeNode(T element) {
            this.element = element;
            left = right = null;
        }

        public T getElement() {
            return element;
        }
    }

    private TreeNode<E> root;
    private MyQueue<E> Q;

    public BST() {
        root = null;
        Q = new MyQueue<>();
    }

    public BST(ArrayList<E> nodes) {
        Q = new MyQueue<>();
        for (E node : nodes)
            insert(node);
    }

    public boolean search(E e) {
        return search(root, e);
    }

    public boolean search(TreeNode<E> current, E e) {
        if (current == null)
            return false;
        else if (e.compareTo(current.element) < 0)
            return search(current.left, e); // go to the left child
        else if (e.compareTo(current.element) > 0)
            return search(current.right, e); // go to the right child
        else
            return true;
    }

    public void insert(E e) {
        root = insert(root, e);
    }

    public TreeNode<E> insert(TreeNode<E> current, E e) {
        if (current == null)
            current = new TreeNode<>(e);
        else if (e.compareTo(current.element) <= 0)
            current.left = insert(current.left, e);
        else
            current.right = insert(current.right, e);

        return current;
    }

    private boolean found;

    public boolean delete(E e) {
        root = delete(root, e);
        return found;
    }

    public TreeNode<E> delete(TreeNode<E> current, E e) {
        if (current == null)
            found = false;
        else if (e.compareTo(current.element) < 0)
            current.left = delete(current.left, e);
        else if (e.compareTo(current.element) > 0)
            current.right = delete(current.right, e);
        else {
            current = delete(current);
            found = true;
        }
        return current;
    }

    private TreeNode<E> delete(TreeNode<E> node) {
        if (node.left == null)
            return node.right;
        else if (node.right == null)
            return node.left;
        else {
            E e = getPredecessor(node.left);
            node.element = e;
            node.left = delete(node.left, e);
            return node;
        }
    }

    public E getPredecessor(TreeNode<E> current) {
        while (current.right != null)
            current = current.right;

        return current.element;
    }

    public boolean clear() {
        if (root == null)
            return false;

        root = root.right = root.left = null;
        return true;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSize(root);
    }

    public int getSize(TreeNode<E> current) {
        if (current == null)
            return 0;
        else
            return getSize(current.left) + getSize(current.right) + 1;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public E minValue() {
        return minValue(root);
    }

    public E minValue(TreeNode<E> node) {
        if (node == null)
            return null;

        E current = node.element;
        E leftMost = minValue(node.left);
        E rightMost = minValue(node.right);

        if (leftMost.compareTo(current) > 0)
            current = leftMost;
        if (rightMost.compareTo(current) > 0)
            current = rightMost;
        return current;
    }

    public E maxValue() {
        return maxValue(root);
    }

    public E maxValue(TreeNode<E> node) {
        if (node == null)
            return null;

        E current = node.element;
        E leftMost = maxValue(node.left);
        E rightMost = maxValue(node.right);

        if (leftMost.compareTo(current) < 0)
            current = leftMost;
        if (rightMost.compareTo(current) < 0)
            current = rightMost;
        return current;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        /*
        The height of a tree is the length of the path from the root to
        the deepest node in the tree.
        A (rooted) tree with only a node (the root) has a height of zero.
         */
        if (node == null)
            return -1;

        int leftMost = height(node.left);
        int rightMost = height(node.right);

        if (leftMost > rightMost)
            return leftMost + 1;
        else
            return rightMost + 1;
    }

    public E getElement(E e) {
        return getElement(root, e);
    }

    public E getElement(TreeNode<E> current, E e) {
        if (current == null)
            return null;
        else if (e.compareTo(current.element) < 0)
            return getElement(current.left, e); // go to the left child
        else if (e.compareTo(current.element) > 0)
            return getElement(current.right, e); // go to the right child
        else
            return current.element;
    }

    public void inOrder() {
        Q.clear();
        inOrder(root);
        Q.reverse();
        Q.display();
    }

    public void inOrder(TreeNode<E> a) {
        if (a != null) {
            inOrder(a.left);
            Q.enqueue(a.element);
            inOrder(a.right);
        }
    }

    public void preOrder() {
        Q.clear();
        preOrder(root);
        Q.reverse();
        Q.display();
    }

    public void preOrder(TreeNode<E> a) {
        if (a != null) {
            Q.enqueue(a.element);
            preOrder(a.left);
            preOrder(a.right);
        }
    }

    public void postOrder() {
        Q.clear();
        postOrder(root);
        Q.reverse();
        Q.display();
    }

    public void postOrder(TreeNode<E> a) {
        if (a != null) {
            postOrder(a.left);
            postOrder(a.right);
            Q.enqueue(a.element);
        }
    }
}
