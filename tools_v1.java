/*LIBRARIES*/
import java.util.*;
import java.io.*;

/*NOTE:
* s1.compareTo(s2):   (USED TO SORT STRINGS)
*   if s1 > s2  (returns negative)
*   if s1 < s2  (returns positive)
*   if s1 == s2 (returns 0)
* */

public class tools_v1 {
    //TESTER METHOD
    public static void main(String[] args) {

    }

//THIS IS A BUBBLE SORT ALGORITHM
    public static int[] bubbleSort(int[] arr){
        int len = arr.length;

        for(int i=0; i<len; i++){
            for(int j=0; j<len-i-1; j++){
                if(arr[j] > arr[j+1]){ //'>': ascending || '<': descending
                    //SWAPPING
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

//THIS IS A SELECTION SORT ALGORITHM
    public static int[] selectionSort(int[] arr){
        int len = arr.length;

        for(int i=0; i<len-1; i++){

            //FIND THE MINIMUM ELEMENT IN UNSORTED ARRAY
            int minimum_idx = i;
            for(int j=i+1; j<len; j++) {
                if (arr[j] < arr[minimum_idx]) //'<': ascending || '>': descending
                    minimum_idx = j;
            }

            //SWAPPING
            int temp = arr[minimum_idx];
            arr[minimum_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

//BINARY SEARCH
    public static int binarySearch(int[] arr, int search){
        //return: found index
        //return -1 if not found
        int first = 0, last = arr.length-1, middle;

        do{
            middle = (first+last)/2;

            if(arr[middle] < search){
                first = middle+1;
            }else if(arr[middle] == search){
                System.out.println("Found at index: "+middle);
                return middle;
            }else{
                last = middle-1;
            }

        }while(first <= last);

        System.out.println("Element not found!");
        return -1; //not found
    }

//APPENDING AN ELEMENT INTO ARRAY
    public static String[] appendElem(String[] arr, String toAdd){
        int len = arr.length;
        String[] output = new String[len+1];

        //copy arr elements into output array
        for(int i=0; i<len; i++) output[i] = arr[i];

        //append element at the end of output array
        output[len] = toAdd;
        return output;
    }

//REMOVING AN ELEMENT FROM ARRAY
    public static String[] removeElem(String[] arr, String toRemove){
        int len = arr.length;
        String[] output = new String[len-1];

        for(int i=0,j=0; i<len; i++) {
            if (!arr[i].equals(toRemove))
                output[j++] = arr[i];
        }
        return output;
    }

//WRITE INTO BINARY FILE
    public static void writeBinaryFile(){
        String path = "path.dat"; //insert path here

        try{
            //BELOW CREATES THE BINARY FILE
            ObjectOutputStream outText = new ObjectOutputStream(new FileOutputStream(path));
            /*
            INSERT THINGS TO WRITE INTO THE FILE:
            writeInt : integers
            writeDouble : double/floating-point numbers
            writeChar : characters
            writeBoolean : boolean
            writeUTF : Strings
             */
            outText.writeUTF("insert here");
            outText.close(); //TO SAVE
        }catch(IOException e){
            System.out.println("FAILED!");
        }
    }

//READ BINARY FILE
    public static void readBinaryFile(){
        String path = "path.dat";

        try{
            ObjectInputStream inputText = new ObjectInputStream(new FileInputStream(path));
            while(true){
            /*
                INSERT THINGS TO WRITE INTO THE FILE:
                readInt : integers
                readDouble : double/floating-point numbers
                readChar : characters
                readBoolean : boolean
                readUTF : Strings
             */
                String example = inputText.readUTF();
            }

        } catch(FileNotFoundException e){
            System.out.println("File not found!");
        } catch(EOFException e){
            System.out.println("END OF FILE!");
        } catch(IOException e){
            System.out.println("Problem!");
        }
    }

//FIND THE NUMBER WITH n OCCURENCES
    public static int nOccurences(int[] arr, int n){
        int len = arr.length, max = 0;

        //FIND MAXIMUM NUMBER
        for(int i:arr)
            if(i>=max) max = i;

        int[] counter = new int[max+1];

        //GET THE COUNTER FOR ALL NUMBERS
        for(int i=0; i<counter.length; i++)
            for(int j=0; j<len; j++)
                if(arr[j]==i) counter[i]++;

        //FIND NUMBER WITH n OCCURENCES
        for(int i=0; i<counter.length; i++)
            if(counter[i]==n) return i;

        //IF NOT FOUND
        System.out.println("Not found!");
        return -1;
    }

//REVERSE STRING WHILE IGNORING EXTRA WHITESPACE
    public static String reverse(String str){
        str = str.replaceAll("\\s+"," "); //replace extra whitespace with space
        String[] arr = str.split(" "), out = new String[arr.length];

        for(int i=arr.length-1,j=0; i>=0; i--,j++)
            out[i] = arr[j];

        return String.join(" ",out); //STRING ARRAYS TO A STRING
    }

//DETERMINE IF TWO STRINGS ARE ANAGRAMS
    public static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        int len = str1.length();
        char[] charA = new char[len], charB = new char[len];

        //Insert letters in string into char array
        for(int i=0; i<len; i++){
            charA[i] = str1.charAt(i);
            charB[i] = str2.charAt(i);
        }

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(charA[i] == charB[j]){
                    charB[j] = ' ';
                    break;
                }
            }
        }

        boolean out=true;
        for(int i=0; i<len; i++)
            if(charB[i] != ' ') {
                out = false;
                break;
            }
        return out;
    }

//ADD TWO BINARY STRINGS
    public static String addBinary(String b1, String b2) {
        int dec1 = 0, dec2 = 0;

        //convert binary b1 to decimal dec1
        for (int i = 0; i < b1.length(); i++) {
            if ((int) b1.charAt(i) - '0' == 1)
                dec1 += Math.pow(2, b1.length() - 1 - i);
        }

        //convert binary b2 to decimal dec2
        for (int i = 0; i < b2.length(); i++) {
            if ((int) b2.charAt(i) - '0' == 1)
                dec2 += Math.pow(2, b2.length() - 1 - i);
        }

        //add the decimals
        int sum = dec1 + dec2;
        int tempSum = sum, numBits = 0;

        //get number of bits of binary from the sum
        while (tempSum > 0) {
            tempSum /= 2;
            numBits++;
        }

        //character bits array
        char[] outBits = new char[numBits];
        for (int i = numBits - 1; i >= 0; i--) {
            if ((sum % 2) == 1) outBits[i] = '1';
            else if ((sum % 2) == 0) outBits[i] = '0';

            sum /= 2;
        }
        //char array to String
        return new String(outBits);
    }

//MULTIPLY TWO BINARY STRINGS
    public static String multiplyBinary(String b1, String b2){
        int dec1=0, dec2=0;

        //convert binary b1 to decimal dec1
        for(int i=0; i<b1.length(); i++){
            if((int)b1.charAt(i)-'0'==1)
                dec1+=Math.pow(2,b1.length()-1-i);
        }

        //convert binary b2 to decimal dec2
        for(int i=0; i<b2.length(); i++){
            if((int)b2.charAt(i)-'0'==1)
                dec2+=Math.pow(2,b2.length()-1-i);
        }

        //multiply the decimals
        int product = dec1 * dec2;
        int tempProd = product, numBits = 0;

        //get number of bits of binary from the sum
        while(tempProd>0){
            tempProd/=2;
            numBits++;
        }

        //character bits array
        char[] outBits = new char[numBits];
        for(int i=numBits-1; i>=0; i--){
            if((product%2) == 1)      outBits[i] = '1';
            else if((product%2) == 0) outBits[i] = '0';

            product/=2;
        }
        //char array to String
        return new String(outBits);
    }

//CHECK IF THE NUMBER IS PRIME
    public static boolean isPrime(int n){
        boolean prime = true;
        for(int i=2; i<=n/2; i++){
            if(n%i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }

//CHECK IF THE NUMBER IS A PALINDROME
    public static boolean isPalindrome(int n){
        int ori = n, reverse = 0;
        while(n!=0){
            int r = n%10; //r:remainder
            reverse = reverse*10 + r;
            n/=10;
        }
        return reverse == ori;
    }

//ROTATE A SQUARE MATRIX BY 90 DEGREES CLOCKWISE
    public static double[][] rotatePos90(double[][] mat){
        //T is the transpose matrix
        int N = mat.length;
        double T[][] = new double[N][N];

        System.out.println("Initial matrix");
        for(int i=0; i<N; i++){
            for(int j=0; j<mat[i].length;j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }

        //TRANSPOSE
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                T[i][j] = mat[j][i];
        }

        //REVERSE COLUMNS IN EACH ROW
        for(int i=0; i<N; i++){
            for(int j=N-1,k=0; j>=0; j--,k++)
                mat[i][k]=T[i][j];
        }

        return mat;
    }
}
