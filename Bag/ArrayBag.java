import java.util.Random;

public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private static final int MAX_CAPACITY = 1000;

    public ArrayBag() {
        bag = (T[]) new Object[0];
    }

    public ArrayBag(T[] bag) {
        if (bag.length <= MAX_CAPACITY)
            this.bag = bag;
        else
            throw new ExceptionInInitializerError("The bag reached its maximum capacity.");
    }

    public int getCurrentSize() {
        return bag.length;
    }

    public boolean isEmpty() {
        return bag.length == 0;
    }

    public boolean add(T newItem) {
        if (bag.length <= MAX_CAPACITY) {
            T[] temp = (T[]) new Object[getCurrentSize() + 1];
            for (int i = 0; i < getCurrentSize(); i++)
                temp[i] = bag[i];
            temp[getCurrentSize()] = newItem;
            bag = temp;
            return true;
        } else
            return false;

    }

    public T remove() {
        if (!isEmpty()) {
            T toRemove = bag[new Random().nextInt(getCurrentSize())];

            T[] temp = (T[]) new Object[getCurrentSize() - 1];
            for (int i = 0, j = 0; i < getCurrentSize(); i++)
                if (bag[i] != toRemove)
                    temp[j++] = bag[i];

            bag = temp;
            return toRemove;
        } else
            return null;
    }

    public boolean remove(T toRemove) {
        if (!isEmpty() && contains(toRemove)) {
            T[] temp = (T[]) new Object[getCurrentSize() - 1];
            for (int i = 0, j = 0; i < getCurrentSize(); i++)
                if (bag[i] != toRemove)
                    temp[j++] = bag[i];

            bag = temp;
            return true;
        } else
            return false;
    }

    public void clear() {
        bag = (T[]) new Object[0];
    }

    public int getFrequencyOf(T item) {
        if (!isEmpty() && contains(item)) {
            int count = 0;
            for (T items : bag)
                if (items.equals(item))
                    count++;

            return count;
        } else
            return 0;
    }

    public boolean contains(T item) {
        if (!isEmpty())
            for (T items : bag)
                if (items.equals(item))
                    return true;

        return false; // if not found

        // alternative: return (!isEmpty() && getIndexOf(item) != -1);
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        int len = getCurrentSize() + anotherBag.getCurrentSize();

        if (len <= MAX_CAPACITY) {
            ArrayBag<T> newBag = new ArrayBag<>();
            for (T item : bag)
                newBag.add(item);
            for (T item : anotherBag.toArray())
                newBag.add(item);

            return newBag;
        } else
            throw new ExceptionInInitializerError("Union bag reached maximum capacity.");
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        if (!this.isEmpty() && !anotherBag.isEmpty()) {
            ArrayBag<T> newBag = new ArrayBag<>();
            for (T item1 : bag)
                for (T item2 : anotherBag.toArray())
                    if (item1.equals(item2))
                        newBag.add(item1);

            return newBag;
        } else
            return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        if (!this.isEmpty() && !anotherBag.isEmpty()) {
            ArrayBag<T> newBag = new ArrayBag<>();

            for (int i = 0; i < getCurrentSize(); i++) 
                for (int j = 0; j < anotherBag.getCurrentSize(); j++) 
                    if(bag[i].equals(anotherBag.toArray()[j]))
                        break;
                    else if (j == anotherBag.getCurrentSize() - 1) 
                        newBag.add(bag[i]);

            return newBag;
        } else if (!this.isEmpty() && anotherBag.isEmpty())
            return this;
        else
            return null;
    }

    public T[] toArray() {
        return bag;
    }
}
