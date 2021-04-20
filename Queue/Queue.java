import java.util.ArrayList;

public class Queue<T> implements QueueInterface<T> {

    private ArrayList<T> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public Queue(E[] e) {
        list = new ArrayList<>();

        for (E elem : e)
            enqueue(elem);
    }

    @Override
    public void enqueue(T e) {
        list.add(e);
    }

    @Override
    public T dequeue() {
        T dequeued = list.get(0);
        list.remove(0);

        return dequeued;
    }

    public E getElement(int index) {
        return list.get(index);
    }

    public E peek() {
        return list.get(0);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    @Override
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
        ArrayList<T> temp = new ArrayList<>();
        for (int i = getSize() - 1; i >= 0; i--)
            temp.add(list.get(i));

        list = temp;
    }
}
