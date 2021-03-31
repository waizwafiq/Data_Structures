public class LL<T> {

    private Node<T> head, tail;
    private int size;

    private class Node<T> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.next = null;
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

    public LL() {
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null)
            tail = head;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null)
            head = tail = newNode;
        else {
            tail.next = newNode; // insert newNode into the new tail
            tail = tail.next; // update tail value
        }
        size++;
    }

    public void add(int idx, T data) {
        if (idx == 0)
            addFirst(data);
        else if (idx >= size)
            addLast(data);
        else {
            Node<T> current = head;

            for (int i = 1; i < idx; i++) // traverse and stop before requested idx
                current = current.next;

            Node<T> temp = current.next; // the node at idx
            current.next = new Node<>(data); // place node between current & temp
            (current.next).next = temp; // place the temp (node at idx before) to the next newNode
            size++;
        }
    }

    public T removeFirst() {
        if (size == 0)
            return null;
        else {
            Node<T> temp = head;
            head = head.next; // replace head with the next node (2nd node)
            size--;
            if (head == null)
                tail = null;

            return temp.data;
        }
    }

    public T removeLast() {
        if(size == 0)
            return null;
        else if (size == 1){
            Node<T> temp = head;
            head = tail = null;
            size = 0;

            return temp.data;
        }else{
            Node<T> current = head;
            
            for(int i=0; i<size-2; i++)
                current = current.next;

            Node<T> temp = tail;
            tail = current;
            tail.next = null;
            size--;

            return temp.data;
        }
    }

    public T remove(int idx){
        if(idx < 0 || idx >= size) return null;
        else if(idx == 0) return removeFirst();
        else if(idx == size-1) return removeLast();
        else {
            Node<T> previous = head; //to get the node before the specified idx
            
            for(int i=1; i<idx; i++ )
                previous = previous.next;

            Node<T> temp = previous.next; //the node to be removed
            previous.next = temp.next;
            size--;

            return temp.data;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
