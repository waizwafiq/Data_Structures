/**This is the interface for the Bag Data Structure.
  *The idea is simple:
  *Imagine there's a bag (the structure), we can put anything inside the bag, which we call as the items (data).
  *The order of the items is insignificant and it is possible to have more than one similar item.
  *Therefore, the structure is not a set. However, I assumed that the bag is in a form of array.
  *Below are the 'features' needed for the bag data structure.
  *Reference: https://algs4.cs.princeton.edu/13stacks/
  
  NOTE: I may make some corrections for this source code.
*/

public interface BagInterface <T>{

    /**Get the number of items in the bag.
     * @return: The size of the bag.
    */
    public int getCurrentSize();

    /**Check if the bag is empty.
     *
     * @return:
     * true : The bag is empty
     * false: The bag is not empty,
     */
    public boolean isEmpty();

    /**Add an item into the bag.
     * 
     * @param newItem : the item to be added into the bag
     * @return: 
     * true : Adding successful
     * false: Adding failed   
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
     * @return: The item removed from the bag
    */
    public boolean remove(T item);

    /**Removes all of the items from the bag*/
    public void clear();

    /**Get the number of occurrences of the item in the bag
     * 
     * @param item : The specified item in the bag
     * @return : The number of occurences of the item in the bag
     */
    public int getFrequencyOf(T item);

    /**Determine if the specified item is in the bag.
     * 
     * @param item : The specified item
     * @return:
     * true : The specified item is in the bag
     * false: The specified item is not in the bag
     */
    public boolean contains(T item);

    /**Retrieves all of the items in the form of array
     * 
     * @return: The array of the items in the bag
    */
    public T[] toArray();

}
