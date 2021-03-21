public interface DynamicArrayInterface<T> {

    /**Check if the dynamic array is empty
     * 
     * @return :
     *  true : dynamic array is empty
     *  false: dynamic array is not empty
     */
    public boolean isEmpty();

    /**Display the elements of the dynamic array */
    public void display();

    /**Determine if the specified element is inside the dynamic array
     * 
     * @param key : The element to be searched
     * @return:
     *  true  : Element is found in the dynamic array
     *  false : Element is not found in the dynamic array
     */
    public boolean contains(T key);

    /**Adding an element into the dynamic array
     * 
     * @param in : The element to be added
     */
    public void add(T in);

    /**Adding an element into the specified index of the dynamic array
     * 
     * @param in  : The element to be added
     * @param idx : The index to add the element
     * @return:
     *  true  : Element adding successful!
     *  false : Element adding failed
     */
    public boolean add(T in, int idx);
    
    /**Remove a random element from the dynamic array
     * 
     * @return:
     *  true  : Element successfully removed
     *  false : Element failed to be removed
     */
    public boolean remove();
    
    /**Remove a specified element from the dynamic array
     * 
     * @param toRemove : The element to be removed
     * @return :
     *  true  : Element successfully removed
     *  false : Element failed to be removed
     */
    public boolean remove(T toRemove);

}
