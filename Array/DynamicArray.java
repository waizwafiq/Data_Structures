public class DynamicArray<T> implements DynamicArrayInterface<T>{
    
    private T[] arr;
    private int len;

    public DynamicArray(T[] arr){
        this.arr = arr;
        this.len = arr.length;
    }

    public boolean isEmpty(){
        return arr.length == 0;
    }

    public void display(){
        System.out.print("[ ");
        for(T elems: arr) System.out.print(elems+" ");
        System.out.print("]");
    }
    
    public boolean search(T key){
        for(int i=0; i<len; i++)
            if(arr[i].equals(key)) return true;
        return false;
    }
    
    public void add(T in){
        T[] temp = (T[]) new Object[len+1];
        
        for(int i=0; i<len; i++) temp[i] = this.arr[i];
        temp[len] = in;
        this.arr = temp;
    }

    public boolean remove(T toRemove){
        if(!isEmpty() && search(toRemove)){
            T[] temp = (T[]) new Object[len - 1];

            for(int i=0,j=0; i<len; i++)
                if (!arr[i].equals(toRemove)) temp[j++] = arr[i];
            arr = temp;
            return true;
        }else return false;
    }

    

}

class test{
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>(new Integer[] {3,2,3,4,5});
        
        arr.add(3);


        arr.display();



    }
}
