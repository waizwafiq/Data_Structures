import java.util.Random;

public class DynamicArray<T> implements DynamicArrayInterface<T> {

    private T[] arr;
    private int len;

    public DynamicArray(T[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    public boolean isEmpty() {
        return arr.length == 0;
    }

    public void display() {
        System.out.print("[ ");
        for (T elems : arr)
            System.out.print(elems + " ");
        System.out.print("]");
    }

    public boolean search(T key) {
        for (int i = 0; i < len; i++)
            if (arr[i].equals(key))
                return true;
        return false;
    }

    public void add(T in) {
        T[] temp = (T[]) new Object[len + 1];

        for (int i = 0; i < len; i++)
            temp[i] = this.arr[i];
        temp[len] = in;
        this.arr = temp;
    }

    public boolean add(T in, int idx) {
        if (idx >= len + 1)
            return false;
        else {
            T[] temp = (T[]) new Object[len + 1];
            for (int i = 0; i < idx; i++)
                temp[i] = arr[i];
            temp[idx] = in;
            for (int i = idx + 1; i < len; i++)
                temp[i] = arr[i];

            this.arr = temp;
            return true;
        }
    }

    public boolean remove() {
        if (!isEmpty()) {
            int randIdx = new Random().nextInt(len); // get a random index

            T[] temp = (T[]) new Object[len - 1];

            for (int i = 0, j = 0; i < len; i++)
                if (!arr[i].equals(arr[randIdx]))
                    temp[j++] = arr[i];

            this.arr = temp;
            return true;
        } else
            return false;
    }

    public boolean remove(T toRemove) {
        if (!isEmpty() && search(toRemove)) {
            T[] temp = (T[]) new Object[len - 1];

            for (int i = 0, j = 0; i < len; i++)
                if (!arr[i].equals(toRemove))
                    temp[j++] = arr[i];
            this.arr = temp;
            return true;
        } else
            return false;
    }

}
