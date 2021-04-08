public interface QueueInterface<E> {

    public void enqueue(E e);

    public E dequeue();

    public int getSize();
}
