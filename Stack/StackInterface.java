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


    public boolean isFull();

    public boolean isEmpty();

    public int size();

    public T getData(int idx);

    public void displayStack();
}
