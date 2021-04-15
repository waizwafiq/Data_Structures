public class LinkedQueue<E> implements QueueInterface<E> {

    private LL<E> list;

    public LinkedQueue() {
        list = new LL<>();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        E dequeued = list.getFirst();
        list.removeFirst();
        return dequeued;
    }

    @Override
    public int getSize() {
        return list.getSize();
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
        list.reverse();
    }
}
