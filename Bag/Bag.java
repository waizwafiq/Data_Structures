import java.util.Random;

public class Bag<T> implements BagInterface<T> {
    private T[] bag;
    private static final int MAX_CAPACITY = 1000;

    public Bag() {
        bag = (T[]) new Object[0];
    }

    public Bag(T[] bag) {
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

    public T[] toArray() {
        return bag;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        // TODO Auto-generated method stub
        return null;
    }
}
