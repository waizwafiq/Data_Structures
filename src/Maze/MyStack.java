package Maze;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T>{

    private ArrayList<T> list;

    public MyStack() {
        list = new ArrayList<>();
    }


    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T popped = list.get(getSize() - 1);
        list.remove(popped);

        return popped;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return list.get(getSize() - 1);
    }

    public T get(int index) {
        return list.get(index);
    }


    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("The Path: ");
        for (Object e : list.toArray())
            out.append(e).append(" -> ");

        return out.toString();
    }

    public boolean search(T o) {
        return list.contains(o);
    }

    public void reverse() {
        ArrayList<T> temp = new ArrayList<>();

        for (int i = 0; i < getSize(); i++)
            temp.add(list.get(i));

        list = temp;
    }
}