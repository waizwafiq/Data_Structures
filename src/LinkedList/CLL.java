package LinkedList;

public class CLL<E> {

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

    public int getSize() {
        return size;
    }

    
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

    
    public void add(E e) {
        if (size == 0)
            addFirst(e);
        else
            addLast(e);
    }

    
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

    
    public boolean contains(E e) {
        if (size != 0) {
            Node<E> current = head;

            if (tail.element.equals(e)) //the loop will skip when current node reaches the tail node. (need improvement here if possible)
                return true;
            while (current != tail) {
                if (current.element.equals(e))
                    return true;

                current = current.next;
            }
        }
        return false;
    }

    
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;
        else {
            Node<E> current = head;

            for (int i = 0; i < index; i++)
                current = current.next;

            return current.element;
        }
    }

    
    public E getFirst() {
        return head.element;
    }

    
    public E getMiddle() {
        return get(size / 2);
    }

    
    public E getLast() {
        return tail.element;
    }

    
    public int indexOf(E e) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return i;

            current = current.next;
        }

        return -1;
    }

    
    public int lastIndexOf(E e) {
        /*
         * note: I'm still looking for a better to do this method. Singly linked list
         * cannot be traversed backwards, it can only go forward. This is a major
         * disadvantage to get the lastIndexOf() since we cannot start from the tail of
         * the linked list, then traverse it backwards.
         */

        Node<E> current = head;
        int idx = -1;

        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                idx = i;
            current = current.next;
        }
        return idx;
    }

    
    public E set(int index, E e) {
        if (index < 0 || index >= size)
            return null;
        else {
            Node<E> current = head;

            for (int i = 0; i < index; i++)
                current = current.next;

            Node<E> temp = current;
            current.element = e;

            return temp.element;
        }
    }

    
    public void clear() {
        head = tail = null;
        size = 0;
    }

    
    public void print() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node<E> current = head;

        System.out.print("-> ");
        while (current != tail) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.println(tail.element + " -> ");
        /*System.out.println("Head: " + head.element + "\nTail: " + tail.element);
        System.out.println("Element after tail: " + tail.next.element);*/
    }

    
    public void reverse() {
        Node<E> next = head;
        tail = head;
        Node<E> previous = null, current;

        do {
            current = next;
            next = current.next;

            // REVERSE THE LINK
            current.next = previous;
            previous = current;
        } while (next != head);

        head = current;
        tail.next = head; //update tail's next node (which is the head node)
    }
}
