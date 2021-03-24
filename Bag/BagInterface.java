/**This is the interface for the Bag Data Structure.
 *<p>Imagine there's a bag (the structure), we can put anything inside the bag, which we call as the items (data).
 *The order of the items is insignificant and it is possible to have more than one similar item.
 *Therefore, the structure is not a set. However, I assumed that the bag is in a form of array.
 *<p>Reference: https://algs4.cs.princeton.edu/13stacks/

 <p>NOTE: I may make some corrections for this source code.

 @author Waiz Wafiq
 */

public interface BagInterface <T>{

    /**Get the number of items in the bag.
     * @return: The size of the bag.
     */
    public int getCurrentSize();

    /**Check if the bag is full
     * @return true if the bag is full, or false if not
     */
    public boolean isFull();

    /**Check if the bag is empty.
     *
     * @return true : The bag is empty
     */
    public boolean isEmpty();

    /**Add an item into the bag.
     *
     * @param newItem : the item to be added into the bag
     * @return true : Adding successful
     */
    public boolean add(T newItem);

    /**Remove a random item from the bag
     *
     * @return: The item removed from the bag
     */
    public T remove();

    /**Removes a specified item from the bag
     *
     * @param item : the item to be removed from the bag
     * @return: true: item removal successful
     */
    public boolean remove(T item);

    /**Removes all of the items from the bag*/
    public void clear();

    /**Get the number of occurrences of the item in the bag
     *
     * @param item : The specified item in the bag
     * @return The number of occurences of the item in the bag
     */
    public int getFrequencyOf(T item);

    /**Determine if the specified item is in the bag.
     *
     * @param item : The specified item
     * @return true : The specified item is in the bag
     */
    public boolean contains(T item);

    /**Retrieves all of the items in the form of array
     *
     * @return The array of the items in the bag
     */
    public T[] toArray();

    /**The union of two bags.
     * Combines the items inside two bags:
     * Bag A : {1,2,3,4}
     * Bag B : {5,6,7}
     * Bag A union Bag B : {1,2,3,4,5,6,7}
     *
     * @param anotherBag Another bag.
     * @return The class of the united bags.
     */
    public BagInterface<T> union(BagInterface<T> anotherBag);

    /**The intersection of two bags.
     * A new bag that has the common items of those two bags.
     * Bag A: {1,2,3,4}
     * Bag B: {2,4,5,6}
     * Bag A intersection Bag B: {2,4}
     *
     * @param anotherBag Another bag.
     * @return The class of the bag with common items.
     */
    public BagInterface<T> intersection(BagInterface<T> anotherBag);

    /**The difference of two bags.
     * A new bag that has the differences of those two bags.
     * Bag A: {1,2,3,4}
     * Bag B: {3,4,5}
     * Bag A difference Bag B: {1,2}
     *
     * @param anotherBag Another bag
     * @return The bag class with the differences of the two bags.
     */
    public BagInterface<T> difference(BagInterface<T> anotherBag);

}
