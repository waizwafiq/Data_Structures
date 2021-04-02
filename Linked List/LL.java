public class LL<E> implements LinkedListInterface<E> {

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

    public LL() {
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (head == null) // if the head is empty (list is empty)
            head = tail = newNode; // the head is the tail and is the new node.
        else {
            newNode.next = head; // the node after the new one is the initial head
            head = newNode; // now the head is the new node
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) { // if the tail is empty (list is empty)
            head = tail = newNode; // the tail is the head and is the new node.
        } else {
            tail.next = newNode; // the node after the initial tail is the new node
            tail = newNode; // now the new node is the tail.
        }
        size++;
    }

    public void add(int index, E e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index is not possible!");
        } else if (index == 0) {
            addFirst(e);
        } else if (index >= size - 1) {
            addLast(e);
        } else {
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
            tail.next = null;
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
        if(size != 0) {
            Node<E> current = head;
            while(current != null){
                if(current.element.equals(e))
                    return true;
                
                current = current.next;
            }
        }
        return false;
    }

    public E get(int index) {
        if (size == 0 || index < 0 || index >= size)
            return null;
        else {
            Node<E> current = head;

            for (int i = 0; i < index; i++) //traverse until the index
                current = current.next;

            return current.element;
        }
    }

    public E getFirst() {
        return head.element;
    }

    public E getMiddle() {
        return get((int) size / 2);
    }

    public E getLast() {
        return tail.element;
    }

    public int indexOf(E e) {
        Node<E> current = head; // starting from the head

        for (int i = 0; i < size - 1; i++) {
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

        for (int i = 0; i < size - 1; i++) {
            if (current.element.equals(e))
                idx = i;
            current = current.next;
        }
        return idx;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            E temp = current.element;
            current.element = e;

            return temp;
        }
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void print() {
        Node<E> current = head;
        while (current.next != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.println(tail.element);
    }

    public void reverse() {
        /*
         * The concept: null -> 1 -> 2 -> 3 -> null Starting from the head (1), its next
         * node will become the head's previous node (null), so: 1 -> null Then the
         * head/previous will be the current node (1).
         *
         * Moving on to the next node (2), its next node will become the previous node
         * (1), so: 2 -> 1 -> null Then, as before, the head/previous will be the
         * current node (2)
         *
         * Moving on to the next node (3), its next node will become the previous node
         * (2), so: 3 -> 2 -> 1 -> null Then, the head/previous will be the current node
         * (3)
         *
         * The next node is null, so break the iterative loop. Voila! There you go: a
         * reversed singly linked list!
         */

        Node<E> next = head;
        tail = head;
        Node<E> previous = null, current = null;

        while (next != null) {
            current = next;
            next = current.next;

            // REVERSE THE LINK
            current.next = previous;
            previous = current;
            head = current;
        }
    }
}
