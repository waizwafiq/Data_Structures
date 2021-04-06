public class DLL<E> implements LinkedListInterface<E> {

    private class Node<T> {
        Node<T> next, previous;
        T element;

        public Node(T element) {
            this.next = null;
            this.previous = null;
            this.element = element;
        }
    }

    private Node<E> head, tail;
    private int size;

    public int getSize() {
        return size;
    }

    public DLL() {
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (head == null) {
            head = tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
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
        } else if (index <= size / 2) {
            Node<E> newNode = new Node<>(e);

            // Add element at the left part of the list (starting from head)
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) // traverse and stop before the requested index
                current = current.next;

            Node<E> temp = current.next; // temporary for disconnection

            current.next = newNode;
            newNode.next = temp;
            newNode.previous = current;
            size++;
        } else {
            Node<E> newNode = new Node<>(e);

            // Add element at the right part of the list (starting from the tail)
            Node<E> current = tail;

            for (int i = 0; i < size - index; i++) 
                current = current.previous;

            Node<E> temp = current.next;

            current.next = newNode;
            newNode.next = temp;
            newNode.previous = current;
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
            head.previous = null;
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
            size = 0;
            return temp.element;
        } else {
            Node<E> temp = tail;
            tail.previous.next = null;
            tail = tail.previous;

            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Negative index is not possible!");
        else if (index == 0)
            removeFirst();
        else if (index >= size - 1)
            removeLast();
        else if (index <= size / 2) {
            // Remove node at the left side (start from head)
            Node<E> current = head;

            for (int i = 0; i < index - 1; i++)
                current = current.next;

            Node<E> temp = current.next;
            current.next = temp.next;
            current.next.previous = current;
            size--;

            return temp.element;
        } else {
            // Remove node at the right side (start from tail)
            Node<E> current = tail;

            for (int i = 0; i < size - index - 1; i++) // traverse until the node before index
                current = current.previous;

            Node<E> temp = current.next;
            current.next = temp.next;
            current.next.previous = current;
            size--;

            return temp.element;
        }
        return null;
    }
    
    public E get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        } else if (index <= size / 2) {
            // get the node at the left side of the list (starting from head)
            Node<E> current = head;

            for (int i = 0; i < index; i++)
                current = current.next;

            return current.element;
        } else {
            // get the node at the right side of the list (starting from tail)
            Node<E> current = tail;

            for (int i = 0; i < size - index - 1; i++)
                current = current.previous;

            return current.element;
        }
    }

    public E getFirst() {
        return head.element;
    }

    public E getMiddle() {
        return get(size/2);
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
        Node<E> current = tail;

        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(e))
                return i;

            current = current.previous;
        }

        return -1;
    }
    
    public E set(int index, E e) {
        if (index < 0 || index >= size)
            return null;
        else if (index <= size / 2) {
            // set the node at the left part (starting from head)
            Node<E> current = head;

            for (int i = 0; i < index; i++)
                current = current.next;

            E temp = current.element;
            current.element = e;

            return temp;
        } else {
            // set the node at the right part (starting from tail)
            Node<E> current = tail;

            for (int i = 0; i < size - index - 1; i++)
                current = current.previous;

            E temp = current.element;
            current.element = e;

            return temp;
        }
    }
    
    public void clear(){
        head = tail = null;
        size = 0;
    }

    public void print() {
        Node<E> current = head;
        while (current.next != null) {
            System.out.print(current.element + " <-> ");
            current = current.next;
        }
        System.out.println(tail.element);
    }
    
    public void reverse() {
        /*Another idea to optimize time complexity:
        * ->Swap head and tail and traverse forward and backward respectively
        * ->Swap the previous and next nodes of each node
        * ->If size is odd, the middle node stays in the same position, 
        *   but the prev and next nodes are swapped.
        * Illustration:
        *     a <-> b <-> c <-> d <-> e  Start!
        *     e <-> b <-> c <-> d <-> a
        *     e <-> d <-> c <-> b <-> a  Done!
        * 
        *     Time complexity: f(n) = n/2
        *     Worst case     : O(n)?
        */

        if(head != null){
            Node<E> current1 = head, current2 = tail;
            Node<E> temp = null;

            tail = current1;
            head = current2;
            for(int i=0; i<getSize()/2; i++){
                //swap next and prev nodes for current1
                temp = current1.previous;
                current1.previous = current1.next;
                current1.next = temp;

                //swap next and prev nodes for current1
                temp = current2.previous;
                current2.previous = current2.next;
                current2.next = temp;

                current1 = current1.previous;
                current2 = current2.next;
            }
            if(getSize()%2 != 0){
                Node<E> middle = current1;
                middle.next = current2.previous;
                middle.previous = current1.next;
            }
        }

        
        /* Old algorithm:
        30% slower if the size of the list is very big.
        If the size is small, there's no significant difference.
        
        Node<E> previous = null;
        Node<E> current = head;

        while (current != null) {
            previous = current.previous;

            // swap previous and next nodes of the current node
            current.previous = current.next;
            current.next = previous;

            current = current.previous; // go to the 'next' node (which is now the previous node)
        }
        tail = head;
        head = previous.previous; */
    }
}
