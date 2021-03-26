/**
 * The implementation of a fixed-size Bag (Array Bag).
 * 
 * @author Waiz Wafiq
 */

import java.util.Random;

public final class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        bag = (T[]) new Object[0];
        numberOfEntries = 0;
    }

    //COPY METHOD 1
    public ArrayBag(ArrayBag<T> anotherBag) {
        this.bag = anotherBag.toArray();
        this.numberOfEntries = bag.length;
    }

    //COPY METHOD 2
    public ArrayBag(BagInterface<T> anotherBag) {
        this.bag = anotherBag.toArray();
        this.numberOfEntries = bag.length;
    }

    public ArrayBag(T[] bag) {
        if (bag.length <= DEFAULT_CAPACITY) {
            this.bag = bag;
            numberOfEntries = bag.length;
        } else
            throw new ExceptionInInitializerError("The bag reached its maximum capacity.");
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == DEFAULT_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newItem) {
        if (bag.length <= DEFAULT_CAPACITY) {
            T[] temp = (T[]) new Object[getCurrentSize() + 1];
            for (int i = 0; i < getCurrentSize(); i++)
                temp[i] = bag[i];
            temp[getCurrentSize()] = newItem;
            bag = temp;
            numberOfEntries = temp.length;
            return true;
        } else
            return false;

    }

    @Override
    public T remove() {
        if (!isEmpty()) {
            T toRemove = bag[new Random().nextInt(getCurrentSize())];

            T[] temp = (T[]) new Object[getCurrentSize() - 1];
            for (int i = 0, j = 0; i < getCurrentSize(); i++)
                if (bag[i] != toRemove)
                    temp[j++] = bag[i];

            bag = temp;
            numberOfEntries = temp.length;
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
                if (!bag[i].equals(toRemove) || removed)
                    temp[j++] = bag[i];
                else if (bag[i].equals(toRemove))
                    removed = true; //to avoid multiple removal

            bag = temp;
            numberOfEntries = temp.length;
            return true;

        } else
            return false;
    }

    @Override
    public void clear() {
        bag = (T[]) new Object[0];
        numberOfEntries = 0;
    }

    @Override
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

    @Override
    public boolean contains(T item) {
        if (!isEmpty()) {
            for (T items : bag)
                if (items.equals(item))
                    return true;
        }
        return false; // if not found

        // alternative: return (!isEmpty() && getIndexOf(item) != -1);
    }

    @Override
    public T[] toArray() {
        return bag;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        int len = getCurrentSize() + anotherBag.getCurrentSize();

        if (len <= DEFAULT_CAPACITY) {
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
            BagInterface<T> temp1 = new ArrayBag<>(this);
            BagInterface<T> temp2 = new ArrayBag<>(anotherBag);

            ArrayBag<T> newBag = new ArrayBag<>();

            for (T item1 : temp1.toArray())
                for (T item2 : temp2.toArray()) {
                    if (item1.equals(item2)) {
                        temp1.remove(item1);
                        temp2.remove(item2);
                        newBag.add(item1);
                        break;
                    }
                }
            return newBag;
        } else
            return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        if (!this.isEmpty() && !anotherBag.isEmpty()) {
            BagInterface<T> temp1 = new ArrayBag<>(this);
            BagInterface<T> temp2 = new ArrayBag<>(anotherBag);

            for(T item1: temp1.toArray())
                for(T item2: temp2.toArray()) {
                    if (item1.equals(item2)) {
                        temp1.remove(item1);
                        temp2.remove(item2);
                        break;
                    }
                }
            return temp1;
        } else if (!this.isEmpty() && anotherBag.isEmpty())
            return this;
        else
            return null;
    }
}
