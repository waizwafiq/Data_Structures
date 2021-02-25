package Stack;

import java.util.EmptyStackException;

public class Stack {
    private Object[] stack;
    private int size;
    private int idx = 0;

    public Stack(int size) {
        this.size = size;
        stack = new Object[size];
    }

    public void push(Object data){
        if(isFull())
            throw new StackOverflowError("Stack is full!");

        stack[idx++] = data;
    }

    public Object pop(){
        if(isEmpty()) throw new EmptyStackException();
        return stack[--idx];
    }

    public boolean isFull(){
        return idx == size;
    }

    public boolean isEmpty(){
        return idx == 0;
    }

    public int size(){
        return idx;
    }
}
