/**This is the interface for the Stack Data Structure.
  *<p>
  
  <p>NOTE: I may make some corrections for this source code.

  @author Waiz Wafiq
*/

public interface StackInterface<T> {
    
    /**Pushes the data onto the stack.
     * The pushed data must be on the top of the stack.
     * 
     * @param data The data to be pushed onto the stack.
     */
    public void push(T data);

    /**Popping out the data from the stack. 
     * The popped data must be the one at the top of the stack to obey
     * the Last-In-First-Out (LIFO) concept.
     * @return the popped data.
     */
    public T pop();

    /**Get the top element in the stack.
     * 
     * @return The top element of the stack.
     */
    public T peek();

    /**Gets the current size of the stack.
     * 
     * @return The size of the stack.
     */
    public int getSize();

    /**Checks if the stack is empty.
     * 
     * @return true if empty
     */
    public boolean isEmpty();

    /**Displays the elements in the stack.
     * 
     * @return The stack.
     */
    public String toString();

    /**Determine if the object is in the stack
     * 
     * @param o : the specified object
     * @return : true if found, false if not found.
     */
    public boolean search(T o);
}
