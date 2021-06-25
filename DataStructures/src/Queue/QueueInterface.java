package Queue;
public interface QueueInterface<E> {

    public void enqueue(E e);

    public E dequeue();

    public E getElement(int index);

    public E peek();
    
    public int getSize();

    public boolean contains(E e);

    public boolean isEmpty();

    public String toString();

    public void reverse();
}
