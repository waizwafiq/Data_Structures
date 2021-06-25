package Queue;

import LinkedList.LL;
public class LinkedQueue<E>{

    private LL<E> list;

    public LinkedQueue() {
        list = new LL<>();
    }

    public LinkedQueue(E[] e) {
        list = new LL<>();

        for (E elem : e)
            enqueue(elem);
    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        E dequeued = list.getFirst();
        list.removeFirst();
        return dequeued;
    }

    public E getElement(int index) {
        return list.get(index);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    public String toString() {
        String out = "| ";
        for (int i = getSize() - 1; i >= 0; i--)
            out += list.get(i) + " | ";
        return out;
    }

    public void display() {
        System.out.println(toString());
    }

    public void reverse() {
        list.reverse();
    }
}
