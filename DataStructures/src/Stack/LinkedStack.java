package Stack;

import java.util.EmptyStackException;

import LinkedList.LL;

public class LinkedStack<T> {

    private LL<T> list;

    public LinkedStack() {
        list = new LL<>();
    }


    public void push(T data) {
        list.addFirst(data);
    }


    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T popped = list.getFirst();
        list.removeFirst();

        return popped;
    }


    public T peek() {
        return list.getFirst();
    }

    public T get(int index) {
        return list.get(index);
    }


    public int getSize() {
        return list.getSize();
    }


    public boolean isEmpty() {
        return getSize() == 0;
    }


    public boolean search(T o) {
        return list.contains(o);
    }
}
