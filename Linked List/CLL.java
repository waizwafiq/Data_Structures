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
        Node<E> newNode = new Node<>(e);

        if (head == null) {
            head = tail = newNode;
            tail.next = head; // update the tail's next node
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode; // update the tail's next node
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) {
            head = tail = newNode;
            tail.next = head; // update the tail's next node
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // update the tail's next node
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Negative index is not possible!");
        else if (index == 0)
            addFirst(e);
        else if (index == size - 1)
            addLast(e);
        else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) // traverse and stop before the requested index
                current = current.next;

            Node<E> temp = current.next; // temporary for disconnection

            current.next = new Node<>(e);
            current.next.next = temp;
            size++;
        }
    }

    @Override
    public void add(E e) {
        if (size == 0)
            addFirst(e);
        else
            addLast(e);
    }

    @Override
    public E removeFirst() {
        if (size == 0)
            return null;
        else {
            Node<E> temp = head;

            head = head.next;
            tail.next = head; // update the tail's next node

            size--;
            return temp.element;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0)
            return null;
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size--;
            return temp.element;
        } else {
            Node<E> temp = tail;
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) // traverse until the node before the tail
                current = current.next;

            tail = current;
            tail.next = head;
            size--;

            return temp.element;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;
        else if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();
        else {
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) // traverse and stop before the requested index
                current = current.next;

            Node<E> temp = current.next;
            current.next = temp.next;
            size--;

            return temp.element;
        }
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
