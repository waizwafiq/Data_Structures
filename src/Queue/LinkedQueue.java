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
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("| ");
        for (int i = getSize() - 1; i >= 0; i--)
            out.append(list.get(i)).append(" | ");
        return out.toString();
    }

    public void display() {
        System.out.println(this);
    }

    public void reverse() {
        list.reverse();
    }
}
