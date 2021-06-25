package Queue;

public class ArrayQueue<E> {

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

    public void enqueue(E e) {
        if (currentSize >= queueSize) {
            System.out.println("temp.Queue is full!");
        } else {
            array[currentSize++] = e;
        }
    }

    public E dequeue() {
        if (!isEmpty()) {
            E[] temp = (E[]) new Object[queueSize];

            if (queueSize - 1 >= 0) System.arraycopy(array, 1, temp, 0, queueSize - 1);

            currentSize--;

            E removed = array[0];
            array = temp;
            return removed;
        } else {
            System.out.println("temp.Queue is empty!");
            return null;
        }
    }

    public E getElement(int index) {
        return array[index];
    }

    public E peek() {
        return array[0];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean contains(E e) {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                if (array[i].equals(e))
                    return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public String toString() {
        String out = "| ";
        for (int i = currentSize - 1; i >= 0; i--)
            out += array[i] + " | ";
        return out;
    }

    public void display() {
        System.out.println(toString());
    }

    public void reverse() {
        E[] temp = (E[]) new Object[currentSize];

        for (int i = 0, j = currentSize - 1; i < currentSize; i++, j--)
            temp[i] = array[j];

        array = temp;
    }
}
