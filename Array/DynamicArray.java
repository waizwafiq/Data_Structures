import java.util.Random;

public class DynamicArray<T> implements DynamicArrayInterface<T> {

    private T[] arr;
    private int len;

    public DynamicArray() {
        this.arr = (T[]) new Object[0];
        len = 0;
    }

    public DynamicArray(T[] arr) {
        this.arr = arr;
        len = arr.length;
    }

    // COPY METHOD 1
    public DynamicArray(DynamicArray<T> anotherArray) {
        this.arr = anotherArray.toArray();
        this.len = arr.length;
    }

    // COPY METHOD 2
    public DynamicArray(DynamicArrayInterface<T> anotherArray) {
        this.arr = anotherArray.toArray();
        this.len = arr.length;
    }

    @Override
    public int getCurrentSize() {
        return len;
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public boolean add(T newItem) {
        T[] temp = (T[]) new Object[getCurrentSize() + 1];

        for (int i = 0; i < getCurrentSize(); i++)
            temp[i] = this.arr[i];
        temp[getCurrentSize()] = newItem;
        this.arr = temp;
        this.len++;
        return true;
    }

    @Override
    public boolean add(T newItem, int idx) {
        if (idx >= getCurrentSize() + 1)
            return false;
        else {
            T[] temp = (T[]) new Object[getCurrentSize() + 1];
            for (int i = 0; i < idx; i++)
                temp[i] = arr[i];
            temp[idx] = newItem;
            for (int i = idx + 1; i < getCurrentSize(); i++)
                temp[i] = arr[i];

            this.arr = temp;
            this.len++;
            return true;
        }
    }

    @Override
    public T remove() {
        if (!isEmpty()) {
            T toRemove = arr[new Random().nextInt(getCurrentSize())];

            T[] temp = (T[]) new Object[getCurrentSize() - 1];
            for (int i = 0, j = 0; i < getCurrentSize(); i++)
                if (arr[i] != toRemove)
                    temp[j++] = arr[i];

            this.arr = temp;
            this.len = temp.length;
            return toRemove;
        } else
            return null;
    }

    @Override
    public boolean remove(T toRemove) {
        if (!isEmpty() && contains(toRemove)) {

            boolean removed = false;
            T[] temp = (T[]) new Object[getCurrentSize() - 1];

            for (int i = 0, j = 0; i < getCurrentSize(); i++)
                if (!arr[i].equals(toRemove) || removed)
                    temp[j++] = arr[i];
                else if (arr[i].equals(toRemove))
                    removed = true; // to avoid multiple removal

            this.arr = temp;
            this.len--;
            return true;

        } else
            return false;
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[0];
        len = 0;
    }

    @Override
    public int getFrequencyOf(T item) {
        if (!isEmpty() && contains(item)) {
            int count = 0;
            for (T items : arr)
                if (items.equals(item))
                    count++;

            return count;
        } else
            return 0;
    }

    @Override
    public int getIndexOf(T item) {
        if (!isEmpty() && contains(item))
            for (int i = 0; i < getCurrentSize(); i++)
                if (arr[i].equals(item))
                    return i;

        return -1;
    }

    @Override
    public boolean contains(T item) {
        if (!isEmpty()) {
            for (T items : arr)
                if (items.equals(item))
                    return true;
        }
        return false; // if not found
    }

    @Override
    public T[] toArray() {
        return arr;
    }

    @Override
    public DynamicArrayInterface<T> union(DynamicArrayInterface<T> anotherArray) {
        DynamicArrayInterface<T> newArr = new DynamicArray<>();
        for (T item : arr) {
            newArr.add(item);
        }
        for (T item : anotherArray.toArray())
            newArr.add(item);

        return newArr;
    }

    @Override
    public DynamicArrayInterface<T> intersection(DynamicArrayInterface<T> anotherArray) {
        if (!this.isEmpty() && !anotherArray.isEmpty()) {
            DynamicArrayInterface<T> temp1 = new DynamicArray<>(this);
            DynamicArrayInterface<T> temp2 = new DynamicArray<>(anotherArray);

            DynamicArray<T> newArr = new DynamicArray<>();

            for (T item1 : temp1.toArray())
                for (T item2 : temp2.toArray()) {
                    if (item1.equals(item2)) {
                        temp1.remove(item1);
                        temp2.remove(item2);
                        newArr.add(item1);
                        break;
                    }
                }
            return newArr;
        } else
            return null;
    }

    @Override
    public DynamicArrayInterface<T> difference(DynamicArrayInterface<T> anotherArray) {
        if (!this.isEmpty() && !anotherArray.isEmpty()) {
            DynamicArrayInterface<T> temp1 = new DynamicArray<>(this);
            DynamicArrayInterface<T> temp2 = new DynamicArray<>(anotherArray);
            for (T item1 : temp1.toArray())
                for (T item2 : temp2.toArray()) {
                    if (item1.equals(item2)) {
                        temp1.remove(item1);
                        temp2.remove(item2);
                        break;
                    }
                }
            return temp1;
        } else if (!this.isEmpty() && anotherArray.isEmpty())
            return this;
        else
            return null;
    }

    public void display() {
        System.out.println("test" + getCurrentSize());
        if (getCurrentSize() != 0) {
            System.out.print("[");
            for (int i = 0; i < getCurrentSize() - 1; i++)
                System.out.print(arr[i] + ", ");
            System.out.println(arr[len - 1] + "]");
        } else
            System.out.println("[ ]");
    }
}
