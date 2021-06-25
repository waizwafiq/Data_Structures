package Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;

/** USING ARRAYLIST TO IMPLEMENT STACK DATA STRUCTURE */

public class Stack<T> {

    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    
    public void push(T data) {
        list.add(data);
    }

    
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T popped = list.get(size() - 1);
        list.remove(popped);

        return popped;
    }

    
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return list.get(size() - 1);
    }
    
    public T get(int index) {
        return list.get(index);
    }

    
    public int size() {
        return list.size();
    }

    
    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("The temp.Stack:\n");
        for (Object elems : list.toArray())
            out.append(elems).append("\n");

        return out.toString();
    }

    public boolean search(T o) {
        return list.contains(o);
    }
    
    public void reverse(){
        ArrayList<T> temp = new ArrayList<>();

        for (int i = 0; i < size(); i++)
            temp.add(list.get(i));
        
        list = temp;
    }
}
