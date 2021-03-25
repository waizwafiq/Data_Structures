/**
 * This is the interface for the dynamic array.
 * <p>
 * <p>
 * Reference: 
 * 
 * <p>
 * NOTE: I may make some corrections for this source code.
 * 
 * @author Waiz Wafiq
 */

public interface DynamicArrayInterface<T> {

    /**
     * Get the number of items in the dynamic array.
     * 
     * @return: The size of the dynamic array.
     */
    public int getCurrentSize();
  
    /**
     * Check if the dynamic array is empty.
     *
     * @return true : The dynamic array is empty
     */
    public boolean isEmpty();
  
    /**
     * Add an item into the dynamic array.
     *
     * @param newItem : the item to be added into the dynamic array
     * @return true : Adding successful
     */
    public boolean add(T newItem);

    /**
     * Add an item into the dynamic array, given a specified index.
     * @return true if successful
     */
    public boolean add(T newItem, int idx);
  
    /**
     * Remove a random item from the dynamic array
     *
     * @return: The item removed from the dynamic array
     */
    public T remove();
  
    /**
     * Removes a specified item from the dynamic array
     *
     * @param item : the item to be removed from the dynamic array
     * @return: true: item removal successful
     */
    public boolean remove(T item);
  
    /** Removes all of the items from the dynamic array */
    public void clear();
  
    /**
     * Get the number of occurrences of the item in the dynamic array
     *
     * @param item : The specified item in the dynamic array
     * @return The number of occurences of the item in the dynamic array
     */
    public int getFrequencyOf(T item);

    /**
     * Get the number of index of the specified element. (-1 if not found)
     * @param item The specified element
     * @return The index number
     */
    public int getIndexOf(T item);
  
    /**
     * Determine if the specified item is in the dynamic array.
     *
     * @param item : The specified item
     * @return true : The specified item is in the dynamic array
     */
    public boolean contains(T item);
  
    /**
     * Retrieves all of the items in the form of array
     *
     * @return The array of the items in the dynamic array
     */
    public T[] toArray();
  
    /**
     * The union of two arrays. Combines the elements inside two arrayss:
     * Array A : {1,2,3,4}
     * Array B : {5,6,7} 
     * union : {1,2,3,4,5,6,7}
     *
     * @param anotherArray Another dynamic array.
     * @return The class of the united arrays.
     */
    public DynamicArrayInterface<T> union(DynamicArrayInterface<T> anotherArray);
  
    /**
     * The intersection of two arrays. 
     * A new dynamic array that has the common elements of those two arrays. 
     * Array A: {1,2,3,4} Array B: {2,4,5,6} 
     * Array A intersection Array B: {2,4}
     *
     * @param anotherArray Another dynamic array.
     * @return The class of the dynamic array with common elements.
     */
    public DynamicArrayInterface<T> intersection(DynamicArrayInterface<T> anotherArray);
  
    /**
     * The difference of two arrays. 
     * A new dynamic array that has the differences of those two arrays. 
     * Array A: {1,2,3,4} Array B: {3,4,5} 
     * Array A difference Array B: {1,2}
     *
     * @param anotherArray Another dynamic array
     * @return The dynamic array class with the differences of the two arrays.
     */
    public DynamicArrayInterface<T> difference(DynamicArrayInterface<T> anotherArray);
  
  }
