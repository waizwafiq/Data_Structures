/**This is the interface for the Stack Data Structure.
  *<p>
  
  <p>NOTE: I may make some corrections for this source code.

  @author Waiz Wafiq
*/

public interface StackInterface<T> {
    
    public void push(T data);

    public void pop();

    public boolean isFull();

    public boolean isEmpty();

    public int size();

    public T getData(int idx);

    public void displayStack();
}
