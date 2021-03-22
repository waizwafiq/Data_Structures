import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {
    private T[] stack;
    private int size, idx = 0;

    public Stack(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
    }

    public void push(T data) {
        if (isFull())
            throw new StackOverflowError("Stack is full!");

        stack[idx++] = data;
    }

    public void pop() {
        if (isEmpty())
            throw new EmptyStackException();
        --idx;
    }

    public boolean isFull() {
        return idx == size;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public int size() {
        return idx;
    }

    public T getData(int idx) {
        return stack[idx];
    }

    public void displayStack() {
        for (int i = idx - 1; i >= 0; i--)
            System.out.println(getData(i));
    }
}
