package week3.T;

import java.util.Random;
public class Bag<T> implements BagInterface<T>{
    T[] bag;

    public Bag() {
        bag = (T[]) new Object[0];
    }

    public Bag(T[] bag) {
        this.bag = bag;
    }

    public int getCurrentSize(){
        return bag.length;
    }

    public boolean isEmpty(){
        return bag.length == 0;
    }

    public boolean add(T newItem){
        T[] temp = (T[]) new Object[getCurrentSize() + 1];
        for (int i = 0; i < getCurrentSize(); i++) temp[i] = bag[i];
        temp[getCurrentSize()] = newItem;
        bag = temp;
        return true;
    }

    public T remove(){
        Random rand = new Random();
        if(!isEmpty()){
            T toRemove = bag[rand.nextInt(getCurrentSize())];

            T[] temp = (T[]) new Object[getCurrentSize()-1];
            for(int i=0,j=0; i<getCurrentSize(); i++)
                if(bag[i]!=toRemove) temp[j++] = bag[i];

            bag = temp;
            return toRemove;
        }else return null;
    }

    public boolean remove(T toRemove){
        if(!isEmpty()){
            T[] temp = (T[]) new Object[getCurrentSize()-1];
            for(int i=0,j=0; i<getCurrentSize(); i++)
                if(bag[i]!=toRemove) temp[j++] = bag[i];

            bag = temp;
            return true;
        }else return false;
    }

    public void clear() {
        bag = (T[]) new Object[0];
    }

    public int getFrequencyOf(T item){
        if(!isEmpty()){
            int count = 0;
            for(T items:bag)
                if(items.equals(item)) count++;

            return count;
        }else return 0;
    }

    public boolean contains(T item){
        if(!isEmpty())
            for (T items : bag)
                if(items.equals(item)) return true;

        return false; //if not found
    }

    public T[] toArray(){
        return bag;
    }
}
