package BST;

import java.util.ArrayList;

public class BST<E extends Comparable<E>> {
    public static class TreeNode<T> {
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
    private ArrayList<E> visited;

    public BST() {
        root = null;
        visited = new ArrayList<>();
    }

    public BST(E[] nodes) {
        visited = new ArrayList<>();
        for (E node : nodes)
            insert(node);
    }

    public BST(ArrayList<E> nodes) {
        visited = new ArrayList<>();
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
        else if (e.compareTo(current.element) < 0)
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
        //the leftmost node in BST is the minimum

        if (node == null)
            return null;

        while (node.left != null)
            node = node.left;

        return node.element;
    }

    public E maxValue() {
        return maxValue(root);
    }

    public E maxValue(TreeNode<E> node) {
        //the rightmost node in BST is the maximum

        if (node == null)
            return null;

        while (node.right != null)
            node = node.right;

        return node.element;
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
        visited.clear();
        inOrder(root);
        System.out.println(visited.toString());
    }

    public void inOrder(TreeNode<E> a) {
        if (a == null)
            return;

        inOrder(a.left);
        visited.add(a.element);
        inOrder(a.right);
    }

    public void preOrder() {
        visited.clear();
        preOrder(root);
        System.out.println(visited.toString());
    }

    public void preOrder(TreeNode<E> a) {
        if (a == null)
            return;

        visited.add(a.element);
        preOrder(a.left);
        preOrder(a.right);
    }

    public void postOrder() {
        visited.clear();
        postOrder(root);
        System.out.println(visited.toString());
    }

    public void postOrder(TreeNode<E> a) {
        if (a == null)
            return;

        postOrder(a.left);
        postOrder(a.right);
        visited.add(a.element);
    }

}