import java.util.Random;

public class DynamicArray<T> implements DynamicArrayInterface<T> {

    private T[] arr;
    private int len;

    public DynamicArray(){
        this.arr = (T[]) new Object[0];
        len = 0;
    }

    public DynamicArray(T[] arr){
        this.arr = arr;
        len = arr.length;
    }

    //COPY METHOD 1
    public DynamicArray(ArrayBag<T> anotherArray){
        this.arr = anotherArray.toArray();
        this.len = arr.length;
    }

    //COPY METHOD 2
    public DynamicArray(BagInterface<T> anotherArray){
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
                    removed = true; //to avoid multiple removal

            this.arr = temp;
            this.len = temp.length;
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getIndexOf(T item) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(T item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DynamicArrayInterface<T> union(DynamicArrayInterface<T> anotherArray) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DynamicArrayInterface<T> intersection(DynamicArrayInterface<T> anotherArray) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DynamicArrayInterface<T> difference(DynamicArrayInterface<T> anotherArray) {
        // TODO Auto-generated method stub
        return null;
    }

}
