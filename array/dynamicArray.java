/*AUTHOR: Waiz Wafiq*/

/*DYNAMIC ARRAY IN JAVA:
* Methods:
* .add()
* .remove()
* .sort()
* .merge()
* */

public class arrM {
    public static void main(String[] args) {
        //TESTING
        int[] a = {1,2,3,4};
        int[] b = {5,6,7,8,9};
        int[] c = {10,11};
        int[][] d = {a,b,c};

        for(int i:merge(d))
            System.out.print(i+" ");
    }

/* ------------------.add() method------------------
 * Adding element in into array arr at position pos
 * .add(arr, in, pos)
 * */
    /*Add integer*/
    public static int[] add(int[] arr, int in){
        int[] newArr = new int[arr.length+1];

        for(int i=0; i<arr.length; i++) newArr[i] = arr[i]; //copy arr elements into newArr
        newArr[arr.length] = in;

        return newArr;
    }

    public static int[] add(int[] arr, int in, int pos){
        int[] newArr = new int[arr.length+1];

        for(int i=0; i<pos; i++) newArr[i] = arr[i];
        newArr[pos] = in;
        for(int i=pos+1; i<newArr.length; i++) newArr[i] = arr[i-1];

        return newArr;
    }

    /*Add String*/
    public static String[] add(String[] arr, String in){
        String[] newArr = new String[arr.length+1];

        for(int i=0; i<arr.length; i++) newArr[i] = arr[i]; //copy arr elements into newArr
        newArr[arr.length] = in;

        return newArr;
    }

    public static String[] add(String[] arr, String in, int pos){
        String[] newArr = new String[arr.length+1];

        for(int i=0; i<pos; i++) newArr[i] = arr[i];
        newArr[pos] = in;
        for(int i=pos+1; i<newArr.length; i++) newArr[i] = arr[i-1];

        return newArr;
    }

    /*Add double*/
    public static double[] add(double[] arr, double in){
        double[] newArr = new double[arr.length+1];

        for(int i=0; i<arr.length; i++) newArr[i] = arr[i]; //copy arr elements into newArr
        newArr[arr.length] = in;

        return newArr;
    }

    public static double[] add(double[] arr, double in, int pos){
        double[] newArr = new double[arr.length+1];

        for(int i=0; i<pos; i++) newArr[i] = arr[i];
        newArr[pos] = in;
        for(int i=pos+1; i<newArr.length; i++) newArr[i] = arr[i-1];

        return newArr;
    }

    /*Add boolean*/
    public static boolean[] add(boolean[] arr, boolean in){
        boolean[] newArr = new boolean[arr.length+1];

        for(int i=0; i<arr.length; i++) newArr[i] = arr[i]; //copy arr elements into newArr
        newArr[arr.length] = in;

        return newArr;
    }

    public static boolean[] add(boolean[] arr, boolean in, int pos){
        boolean[] newArr = new boolean[arr.length+1];

        for(int i=0; i<pos; i++) newArr[i] = arr[i];
        newArr[pos] = in;
        for(int i=pos+1; i<newArr.length; i++) newArr[i] = arr[i-1];

        return newArr;
    }

    /*Add char*/
    public static char[] add(char[] arr, char in){
        char[] newArr = new char[arr.length+1];

        for(int i=0; i<arr.length; i++) newArr[i] = arr[i]; //copy arr elements into newArr
        newArr[arr.length] = in;

        return newArr;
    }

    public static char[] add(char[] arr, char in, int pos){
        char[] newArr = new char[arr.length+1];

        for(int i=0; i<pos; i++) newArr[i] = arr[i];
        newArr[pos] = in;
        for(int i=pos+1; i<newArr.length; i++) newArr[i] = arr[i-1];

        return newArr;
    }

/* ------------------.remove() ------------------
* Removing element out from array arr
*       .remove(arr,out)
* */
    /*Remove integer*/
    public static int[] remove(int[] arr, int out){
        int[] newArr = new int[arr.length-1];

        for(int i=0,j=0; i<arr.length; i++)
            if (arr[i]!=out) newArr[j++] = arr[i];

        return newArr;
    }

    /*Remove String*/
    public static String[] remove(String[] arr, String out){
        String[] newArr = new String[arr.length-1];

        for(int i=0,j=0; i<arr.length; i++)
            if (!arr[i].equals(out)) newArr[j++] = arr[i];

        return newArr;
    }

    /*Remove double*/
    public static double[] remove(double[] arr, double out){
        double[] newArr = new double[arr.length-1];

        for(int i=0,j=0; i<arr.length; i++)
            if (arr[i]!=out) newArr[j++] = arr[i];

        return newArr;
    }

    /*remove boolean*/
    public static boolean[] remove(boolean[] arr, boolean out){
        boolean[] newArr = new boolean[arr.length-1];

        for(int i=0,j=0; i<arr.length; i++)
            if (arr[i]!=out) newArr[j++] = arr[i];

        return newArr;
    }

    /*remove char*/
    public static char[] remove(char[] arr, char out){
        char[] newArr = new char[arr.length-1];

        for(int i=0,j=0; i<arr.length; i++)
            if (arr[i]!=out) newArr[j++] = arr[i];

        return newArr;
    }

/* ------------------.sort() method------------------
 * Sorting the elements in the array arr
 * key:
 *      0 = ascending
 *      1 = descending
 * .sort(arr, key)
 * */
    /*Sort integers*/
    public static int[] sort(int[] arr, int key){

        for(int i=0; i<arr.length; i++){
            if(key==0) {
                boolean isSwapped = false;
                for(int j=0; j<arr.length-1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        //SWAP
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSwapped = true;
                    }
                    if (!isSwapped) break;
                }
            }else if(key==1) {  //descending
                for (int j = 0; j < arr.length-i-1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        //SWAP
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /*Sort strings*/
    public static String[] sort(String[] arr, int key){

        for(int i=0; i<arr.length; i++){
            if(key==0) {
                boolean isSwapped = false;
                for(int j=0; j<arr.length-1; j++) {
                    if (arr[j].compareTo(arr[j + 1]) > 0) {
                        //SWAP
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSwapped = true;
                    }
                    if (!isSwapped) break;
                }
            }else if(key==1) {  //descending
                for (int j = 0; j < arr.length-i-1; j++) {
                    if (arr[j].compareTo(arr[j + 1]) < 0) {
                        //SWAP
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /*Sort double*/
    public static double[] sort(double[] arr, int key){

        for(int i=0; i<arr.length; i++){
            if(key==0) {
                boolean isSwapped = false;
                for(int j=0; j<arr.length-1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        //SWAP
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSwapped = true;
                    }
                    if (!isSwapped) break;
                }
            }else if(key==1) {  //descending
                for (int j = 0; j < arr.length-i-1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        //SWAP
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /*Sort char*/
    public static char[] sort(char[] arr, int key){

        for(int i=0; i<arr.length; i++){
            if(key==0) {
                boolean isSwapped = false;
                for(int j=0; j<arr.length-1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        //SWAP
                        char temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSwapped = true;
                    }
                    if (!isSwapped) break;
                }
            }else if(key==1) {  //descending
                for (int j = 0; j < arr.length-i-1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        //SWAP
                        char temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

/* ------------------.merge() method------------------
 * Merge arrays into one
 * .merge(arr1, arr2)
 * */
    /*Merge integers*/
    public static int[] merge(int[][] arr){
        int temp = 0;
        int numElems = 0;
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) numElems++;

        int[] newArr = new int[numElems];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) newArr[temp++] = arr[i][j];

        return newArr;
    }

    /*Merge String*/
    public static String[] merge(String[][] arr){
        int temp = 0;
        int numElems = 0;
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) numElems++;

        String[] newArr = new String[numElems];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) newArr[temp++] = arr[i][j];

        return newArr;
    }

    /*Merge double*/
    public static double[] merge(double[][] arr){
        int temp = 0;
        int numElems = 0;
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) numElems++;

        double[] newArr = new double[numElems];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) newArr[temp++] = arr[i][j];

        return newArr;
    }

    /*Merge boolean*/
    public static boolean[] merge(boolean[][] arr){
        int temp = 0;
        int numElems = 0;
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) numElems++;

        boolean[] newArr = new boolean[numElems];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) newArr[temp++] = arr[i][j];

        return newArr;
    }

    /*Merge char*/
    public static char[] merge(char[][] arr){
        int temp = 0;
        int numElems = 0;
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) numElems++;

        char[] newArr = new char[numElems];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[i].length; j++) newArr[temp++] = arr[i][j];

        return newArr;
    }   
}
