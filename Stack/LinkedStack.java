import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {

    private LL<T> list;

    public LinkedStack() {
        list = new LL<>();
    }

    @Override
    public void push(T data) {
        list.addFirst(data);
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T popped = list.getFirst();
        list.removeFirst();

        return popped;
    }

    @Override
    public T peek() {
        return list.getFirst();
    }
    
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public boolean search(T o) {
        return list.contains(o);
    }
}
