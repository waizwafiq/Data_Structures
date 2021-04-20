public class ArrayQueue<E> implements QueueInterface<E> {

    private E[] array;
    private int queueSize = 25;
    private int currentSize;

    public ArrayQueue() {
        this.array = (E[]) new Object[queueSize];
    }

    public ArrayQueue(int queueSize) {
        this.array = (E[]) new Object[queueSize];
        this.queueSize = queueSize;
    }

    @Override
    public void enqueue(E e) {
        if (currentSize >= queueSize) {
            System.out.println("Queue is full!");
        } else {
            array[currentSize++] = e;
        }
    }

    @Override
    public E dequeue() {
        if (!isEmpty()) {
            E[] temp = (E[]) new Object[queueSize];

            for (int i = 1; i < queueSize; i++)
                temp[i - 1] = array[i];

            currentSize--;

            E removed = array[0];
            array = temp;
            return removed;
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }

    public E getElement(int index) {
        return array[index];
    }

    public E peek() {
        return array[0];
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    public boolean contains(E e) {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                if (array[i].equals(e))
                    return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public String toString() {
        String out = "| ";
        for (int i = currentSize - 1; i >= 0; i--)
            out += array[i] + " | ";
        return out;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public void reverse() {
        E[] temp = (E[]) new Object[currentSize];

        for(int i=currentSize, j=0; i<currentSize; i++,j--)
            temp[j] = array[i];

        array = temp; 
    }
}
