package Queue;
import java.util.ArrayList;

public class Queue<E> {

    private ArrayList<E> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public Queue(E[] e) {
        list = new ArrayList<>();

        for (E elem : e)
            enqueue(elem);
    }
    
    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        E dequeued = list.get(0);
        list.remove(0);

        return dequeued;
    }

    public E getElement(int index) {
        return list.get(index);
    }

    public E peek() {
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("| ");
        for (int i = size() - 1; i >= 0; i--)
            out.append(list.get(i)).append(" | ");
        return out.toString();
    }

    public void display() {
        System.out.println(toString());
    }

    public void reverse() {
        ArrayList<E> temp = new ArrayList<>();
        for (int i = size() - 1; i >= 0; i--)
            temp.add(list.get(i));

        list = temp;
    }
}
