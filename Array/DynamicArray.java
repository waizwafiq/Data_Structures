import java.util.Random;

public class DynamicArray<T> implements DynamicArrayInterface<T> {

    private T[] arr;

    public DynamicArray(T[] arr) {
        this.arr = arr;
    }

    public boolean isEmpty() {
        return arr.length == 0;
    }

    public void display() {
        System.out.print("[ ");
        for (T elems : arr)
            System.out.print(elems + " ");
        System.out.println("]");
    }

    public boolean contains(T key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(key))
                return true;
        return false;
    }

    public void add(T in) {
        T[] temp = (T[]) new Object[arr.length+ 1];

        for (int i = 0; i < arr.length; i++)
            temp[i] = this.arr[i];
        temp[arr.length] = in;
        this.arr = temp;
    }

    public boolean add(T in, int idx) {
        if (idx >= arr.length+ 1)
            return false;
        else {
            T[] temp = (T[]) new Object[arr.length+ 1];
            for (int i = 0; i < idx; i++)
                temp[i] = arr[i];
            temp[idx] = in;
            for (int i = idx + 1; i < arr.length; i++)
                temp[i] = arr[i];

            this.arr = temp;
            return true;
        }
    }

    public boolean remove() {
        if (!isEmpty()) {
            int randIdx = new Random().nextInt(arr.length); // get a random index

            T[] temp = (T[]) new Object[arr.length- 1];

            for (int i = 0, j = 0; i < arr.length; i++)
                if (!arr[i].equals(arr[randIdx]))
                    temp[j++] = arr[i];

            this.arr = temp;
            return true;
        } else
            return false;
    }

    public boolean remove(T toRemove) {
        if (!isEmpty() && contains(toRemove)) {
            T[] temp = (T[]) new Object[arr.length- 1];

            for (int i = 0, j = 0; i < arr.length; i++)
                if (!arr[i].equals(toRemove))
                    temp[j++] = arr[i];
            this.arr = temp;
            return true;
        } else
            return false;
    }

}

class test {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>(new Integer[] { 1, 2, 3, 4, 5 });
        arr.add(10);
        arr.display();
        arr.remove(3);
        arr.display();
    }
}
