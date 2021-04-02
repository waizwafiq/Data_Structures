public class CLL<E> implements LinkedListInterface<E> {

    private class Node<T> {
        private Node<T> next;
        private T element;

        public Node(T element) {
            this.next = null;
            this.element = element;
        }
    }

    private Node<E> head, tail;
    private int size;

    public CLL() {
    }

    @Override
    public void addFirst(E e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addLast(E e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(int index, E e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(E e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E removeFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getMiddle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(E e) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public E set(int index, E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reverse() {
        // TODO Auto-generated method stub
        
    }   
}
