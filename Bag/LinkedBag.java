/**
 * The {@code LinkedBag} class represents a bag (or multiset) of generic items.
 * It supports insertion and iterating over the items in arbitrary order.
 *
 * @author Waiz Wafiq
 */

import java.util.Random;
public class LinkedBag<T> implements BagInterface<T> {

    private CDLL<T> list;

    public LinkedBag() {
        list = new CDLL<>();
    }

    @Override
    public int getCurrentSize() {
        return list.getSize();
    }

    @Override
    public boolean isFull() {
        // Never full.
        return false;
    }

    @Override
    public boolean isEmpty() {
        return getCurrentSize() == 0;
    }

    @Override
    public boolean add(T newItem) {
        
        list.add(newItem);
        return true;
    }

    @Override
    public T remove() {
        Random rand = new Random();
        int removedIdx = rand.nextInt(getCurrentSize());

        T removed = list.get(removedIdx);
        list.remove(removedIdx);
        
        return removed;
    }

    @Override
    public boolean remove(T item) {
        if(list.contains(item)){
            list.remove(list.indexOf(item));
            return true;
        }else
            return false;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int getFrequencyOf(T item) {
        // TODO Auto-generated method stub
        /*  Initialize count = 0
            While going through the nodes starting from the head
                Get the data held by the node
                if the data = the item, increase count
            return count
        */ 
        return 0;
    }

    @Override
    public boolean contains(T item) {
        // TODO Auto-generated method stub
        /* While going through the nodes starting from the head
                Get the data held by the node
                if the data = the item, return true
            return false (not found)
        */ 
        return false;
    }

    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
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
