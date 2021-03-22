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
     */
    public void pop();

    /**Checks if the stack is full.
     * 
     * @return true if full
     */
    public boolean isFull();

    /**Checks if the stack is empty.
     * 
     * @return true if empty
     */
    public boolean isEmpty();

    /**Gets the current size of the stack.
     * 
     * @return The size of the stack.
     */
    public int size();

    /**Gets the data from the stack with a specified index.
     * 
     * @param idx The specified index
     * @return The value of the data from the stack
     */
    public T getData(int idx);

    /**Displays the data in the stack.
     */
    public void displayStack();
}
