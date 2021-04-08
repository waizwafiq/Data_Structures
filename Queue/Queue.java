import java.util.ArrayList;

public class Queue<T> implements QueueInterface<T> {

    private ArrayList<T> list;

    public Queue() {
        list = new ArrayList<>();
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

    @Override
    public int getSize() {
        return list.size();
    }
}
