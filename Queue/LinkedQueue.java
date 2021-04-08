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

}
