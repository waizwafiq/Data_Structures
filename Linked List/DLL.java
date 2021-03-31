public class DLL<E> {

    private class Node<T> {
        Node<T> next, previous;
        T element;

        public Node(T element) {
            this.next = null;
            this.previous = null;
            this.element = element;
        }

        public Node(Node next, T element) {
            this.next = null;
            this.previous = null;
            this.element = element;
        }

        public Node(Node next, Node previous, T element) {
            this.next = next;
            this.previous = previous;
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
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
        }else if(index == 0){
            addFirst(e);
        }else if(index == size-1){
            addLast(e);
        }
    }

    public void print() {
        Node<E> current = head;
        while (current.next != null) {
            System.out.print(current.element + " <-> ");
            current = current.next;
        }
        System.out.println(tail.element);
    }

    public static void main(String[] args) {
        DLL<Integer> list = new DLL<>();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.print();
    }

}
