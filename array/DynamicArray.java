//package List;
//
//public class DynamicArray<T> {
//    private T[] arr;
//
//    public DynamicArray(T[] arr) {
//        this.arr = arr;
//    }
//
//    /* ------------------.add() method------------------
// * Adding element in into array arr at position pos
// * .add(arr, in, pos)
// * */
//    public void add(T in){
//        T[] newArr = new T[arr.length+1];
//        for(int i=0; i<arr.length; i++) newArr[i] = arr[i];
//        newArr[arr.length] = in;
//        arr = newArr;
//    }
//
//    public void add(Object in, int idx){
//        Object[] newArr = new Object[arr.length+1];
//        for(int i=0; i<idx; i++) newArr[i] = arr[i];
//        newArr[idx] = in;
//        for(int i=idx+1; i<arr.length+1; i++) newArr[i] = arr[i-1];
//        arr = newArr;
//    }
//
///* ------------------.remove() ------------------
// * Removing element out from array arr
// *       .remove(arr,out)
// * */
//    public void remove(Object out){
//        Object[] newArr = new Object[arr.length-1];
//        for(int i=0, j=0; i<arr.length; i++)
//            if(arr[i]!=out) newArr[j++] = arr[i];
//        arr = newArr;
//    }
//
//    public void remove(int idx){
//        Object[] newArr = new Object[arr.length-1];
//        for(int i=0; i<idx; i++) newArr[i] = arr[i];
//        for(int i=idx; i<arr.length-1; i++)
//            newArr[i] = arr[i+1];
//        arr = newArr;
//    }
//
//}

public class DynamicArray<T>{
    
    private T[] arr;
    private int length;

    public DynamicArray(T[] arr){
        this.arr = arr;
        this.length = arr.length;
    }

    public boolean isEmpty(){
        /**Checks if the dynamic array is empty.
         * return:
         *  true  -> dynamic array is empty
         *  false -> dynamic array is not empty
         */
        return arr.length == 0;
    }
    
    /* display all elements in the dynamic array */
    public void display(){
        System.out.print("[ ");
        for(T elems: arr) System.out.print(elems+" ");
        System.out.print("]");
    }
    
    /* Method to add element */
    public void add(T in){
        T[] temp = (T[]) new Object[length+1];
        
        for(int i=0; i<arr.length; i++) temp[i] = this.arr[i];
        temp[arr.length] = in;
        this.arr = temp;
    }

    /* Method to remove element */

    

}

class test{
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>(new Integer[] {3,2,3,4,5});
        arr.add(3);
        arr.display();
    }
}
