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
