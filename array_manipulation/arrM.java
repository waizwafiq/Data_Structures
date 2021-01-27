/*ARRAY MANIPULATION IN JAVA:
* Methods:
* 1) Adding elements into array at position n
* .addInt(arr, n, pos)    :
* .addString(arr, n, pos) :
* .addDouble(arr, n, pos) :
* .addBoolean(arr, n, pos):
* .addChar(arr, n, pos)   :
* ----------------------------------------------
* 2)
*
* */

public class arrM {

    public static int[] addInt(int[] arr, int in){
        int[] out = new int[arr.length+1];

        for(int i=0; i<arr.length; i++) out[i] = arr[i]; //copy arr elements into out
        out[arr.length] = in;

        return out;
    }

    public static int[] addInt(int[] arr, int in, int pos){
        int[] out = new int[arr.length+1];

        for(int i=0; i<pos; i++) out[i] = arr[i];
        out[pos] = in;
        for(int i=pos+1; i<out.length; i++) out[i] = arr[i-1];

        return out;
    }

}
