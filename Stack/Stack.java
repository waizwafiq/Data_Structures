import java.util.ArrayList;
import java.util.EmptyStackException;

/** USING ARRAYLIST TO IMPLEMENT STACK DATA STRUCTURE */

public class Stack<T> implements StackInterface<T> {

    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T data) {
        list.add(data);
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T popped = list.get(getSize() - 1);
        list.remove(popped);

        return popped;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return list.get(getSize() - 1);
    }
    
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String toString() {
        String out = "The Stack:\n";
        for (Object elems : list.toArray())
            out += elems + "\n";

        return out;
    }

    public boolean search(T o) {
        return list.contains(o);
    }
    
    public void reverse(){
        ArrayList<T> temp = new ArrayList<>();

        for (int i = 0; i < getSize(); i++) 
            temp.add(list.get(i));
        
        list = temp;
    }
}
