package week3.T;

public interface BagInterface <T>{

    /**Get the number of items in the bag.**/
    public int getCurrentSize();

    /**Check if the bag is empty.
    * true : the bag is empty
    * false: the bag is not empty,**/
    public boolean isEmpty();

    /**Add an item into the bag.
    * true : adding successful
    * false: adding failed   **/
    public boolean add(T newItem);

    /**Remove a random item from the bag**/
    public T remove();

    /**Removes a specified item from the bag**/
    public boolean remove(T item);

    /**Removes all of the items from the bag**/
    public void clear();

    /**Get the number of occurrences of the item in the bag**/
    public int getFrequencyOf(T item);

    /**Check if the specified item is in the bag**/
    public boolean contains(T item);

    /**Retrieves all of the items in the form of array**/
    public T[] toArray();

}
