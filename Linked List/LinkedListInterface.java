public interface LinkedListInterface<E> {

    public void addFirst(E e);

    public void addLast(E e);

    public void add(int index, E e);

    public void add(E e);

    public E removeFirst();

    public E removeLast();

    public E remove(int index);

    public boolean contains(E e);

    public E get(int index);

    public E getFirst();

    public E getMiddle();

    public E getLast();

    public int indexOf(E e);

    public int lastIndexOf(E e);

    public E set(int index, E e);

    public void clear();

    public void print();

    public void reverse();

}
