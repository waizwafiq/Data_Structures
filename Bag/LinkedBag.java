/**
 * The {@code LinkedBag} class represents a bag (or multiset) of generic items.
 * It supports insertion and iterating over the items in arbitrary order.
 *
 * @author Waiz Wafiq
 */

public final class LinkedBag<T> implements BagInterface<T> {

    /**
     * The Node class (a private inner class)
     */
    private class Node {
        Node next; // reference to the next node
        T data; // data carried by this node

        public Node(T data) {
            next = null;
            this.data = data;
        }

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isFull() {
        // Never full.
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean add(T newItem) {

        if (firstNode == null) //if the first node is empty
            firstNode = new Node(newItem);

        Node temp = new Node(newItem);
        Node current = firstNode;

        if(current != null) {
            //traverse until it reaches an empty node
            while(current.getNext() != null) 
                current = current.getNext();
            
            current.setNext(temp);
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(T item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFrequencyOf(T item) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        // TODO Auto-generated method stub
        return null;
    }

}
